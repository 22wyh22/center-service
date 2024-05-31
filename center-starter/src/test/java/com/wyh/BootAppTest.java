package com.wyh;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.cat.IndicesResponse;
import co.elastic.clients.elasticsearch.cat.indices.IndicesRecord;
import com.wyh.factory.RedisTemplateFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

@SpringBootTest(classes = BootApp.class)
public class BootAppTest {

    @Autowired
    private RedisTemplateFactory redisTemplateFactory;

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    @Test
    void test01(){
        RedisTemplate<String, String> template = redisTemplateFactory.getRedisTemplate(0, String.class);
        Set<String> keys = template.keys("*");
        System.out.println(keys);
    }

    @Test
    void test02() throws Exception{
        IndicesResponse response = elasticsearchClient.cat().indices();
        List<IndicesRecord> records = response.valueBody();
        for (IndicesRecord record : records) {
            System.out.println(record.index());
        }
    }
}
