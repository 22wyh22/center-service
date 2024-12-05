package com.wyh;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import com.alibaba.fastjson.JSONObject;
import com.wyh.application.server.ESAppService;
import com.wyh.common.model.ApiResult;
import com.wyh.domain.global.SpringContextUtil;
import com.wyh.factory.RedisTemplateFactory;
import com.wyh.infrastructure.repository.GlobalSchoolInfoPORepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.IOException;
import java.util.*;

@SpringBootTest(classes = BootApp.class)
public class BootAppTest {

    @Autowired
    private RedisTemplateFactory redisTemplateFactory;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    void test00(){
        ESAppService bean = SpringContextUtil.getApplicationContext().getBean(ESAppService.class);
        ApiResult<Object> info = bean.createIndex("company_reg_info");
        System.out.println(info);
    }

    @Test
    void test01() {
        RedisTemplate<String, String> template = redisTemplateFactory.getRedisTemplate(0, String.class);
        Set<String> keys = template.keys("*");
        System.out.println(keys);
    }

    @Autowired
    private GlobalSchoolInfoPORepository globalSchoolInfoPORepository;

    @Test
    void test02() throws Exception {
        List<Map<String, Object>> maps = globalSchoolInfoPORepository.queryList();

        List<BulkOperation> list = new ArrayList<>();
        for (int i = 0; i < maps.size(); i++) {
            Map<String, Object> map = new HashMap<>();
            maps.get(i).forEach((key, value) -> {
                map.put(key.toUpperCase(), value);
            });
            JSONObject object = new JSONObject();
            object.put("lon", map.get("LONGITUDE"));
            object.put("lat", map.get("LATITUDE"));
            map.put("LOCATION", object);
            map.remove("LONGITUDE");
            map.remove("LATITUDE");
            list.add(new BulkOperation.Builder().index(x -> x.document(map)).build());
        }
        BulkRequest.Builder bulk = new BulkRequest.Builder();
        bulk.index("global_school_info");
        bulk.operations(list);
        BulkRequest build = bulk.build();
        BulkResponse response = elasticsearchClient.bulk(build);
    }

    @Test
    void test03() throws IOException {
    }
}