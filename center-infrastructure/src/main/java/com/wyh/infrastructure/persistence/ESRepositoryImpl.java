package com.wyh.infrastructure.persistence;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.alibaba.fastjson.JSONObject;
import com.wyh.application.repository.ESAppRepository;
import com.wyh.common.exception.EsErrorCode;
import com.wyh.common.util.AssertUtil;
import com.wyh.domain.global.SpringContextUtil;
import lombok.SneakyThrows;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.nio.charset.StandardCharsets;

@Repository
public class ESRepositoryImpl implements ESAppRepository {

    private RestClient restClient;

    private ElasticsearchClient elasticsearchClient;


    public ESRepositoryImpl(RestClient restClient, ElasticsearchClient elasticsearchClient) {
        this.restClient = restClient;
        this.elasticsearchClient = elasticsearchClient;
    }

    @SneakyThrows
    @Override
    public String createIndex(String index) {
        String format = "classpath:/META-INF/index/%s.json";
        Resource resource = SpringContextUtil.getApplicationContext().getResource(String.format(format, index));
        AssertUtil.asTrue(resource.exists(), EsErrorCode.ES_INDEX_INFO_NOT_EXISTS);
        Request request = new Request("PUT", index);
        String json = JSONObject.parseObject(resource.getInputStream(), StandardCharsets.UTF_8, String.class);
        request.setJsonEntity(json);
        Response response = restClient.performRequest(request);
        return EntityUtils.toString(response.getEntity());
    }
}
