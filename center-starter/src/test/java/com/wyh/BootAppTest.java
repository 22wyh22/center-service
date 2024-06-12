package com.wyh;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import com.wyh.factory.RedisTemplateFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.File;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

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

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void test02() throws Exception{
        Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\wuyuhan\\Desktop\\全国大学信息数据2021.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String sql = "insert into global_school_info(pk_id, province," +
                "name," +
                "major_type," +
                "type," +
                "school_type," +
                "is_985," +
                "is_211," +
                "is_first," +
                "city," +
                "subjection," +
                "address," +
                "longitude," +
                "latitude)" +
                "values";
        List<String> list = new ArrayList<>();
        for (Row row : sheet) {
            if(row.getRowNum() == 0){
                continue;
            }
            StringBuilder builder = new StringBuilder("(");
            builder.append("'");
            builder.append(UUID.randomUUID().toString());
            builder.append("'");
            builder.append(",");
            short lastCellNum = row.getLastCellNum();
            for (int i = 0; i < lastCellNum; i++) {
                builder.append("'");
                builder.append(new DataFormatter().formatCellValue(row.getCell(i)));
                builder.append("'");
                if(i < lastCellNum -1){
                    builder.append(",");
                }
            }
            builder.append(")");
            list.add(builder.toString());
        }
        sql = sql + list.stream().collect(Collectors.joining(","));
        System.out.println(sql);
        PreparedStatement statement = sqlSession.getConnection().prepareStatement(sql);
        statement.execute();
    }
}
