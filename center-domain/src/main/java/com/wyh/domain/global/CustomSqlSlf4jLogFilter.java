package com.wyh.domain.global;

import com.alibaba.druid.DbType;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.proxy.jdbc.JdbcParameter;
import com.alibaba.druid.proxy.jdbc.StatementProxy;
import com.alibaba.druid.sql.SQLUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Component
@Slf4j
public class CustomSqlSlf4jLogFilter extends Slf4jLogFilter {
    private SQLUtils.FormatOption formatOption = new SQLUtils.FormatOption(false, true);
    private Pattern pattern = Pattern.compile("\\s+");

    @Override
    protected void statementExecuteBefore(StatementProxy statement, String sql) {
        statement.setLastExecuteTimeNano(System.nanoTime());
    }

    @Override
    protected void statementExecuteAfter(StatementProxy statement, String sql, boolean firstResult) {
        if(log.isInfoEnabled()){
            long ms = this.getLastExecTimeMs(statement);
            log.info("exec sql cost:{} ms:{}", ms, this.getFormatSql(statement, sql));
        }
    }

    private long getLastExecTimeMs(StatementProxy statement){
        long ms = System.nanoTime() - statement.getLastExecuteTimeNano();
        return (long)((double)ms / 1000000.0D);
    }

    private String getFormatSql(StatementProxy statement, String sql){
        int parametersSize = statement.getParametersSize();
        if(parametersSize == 0){
            return this.pattern.matcher(sql).replaceAll(" ");
        }else {
            List<Object> params = new ArrayList<>(parametersSize);

            for (int i = 0; i < parametersSize; i++) {
                JdbcParameter jdbcParameter = statement.getParameter(i);
                params.add(jdbcParameter != null?jdbcParameter.getValue():null);
            }
            String dbType = statement.getConnectionProxy().getDirectDataSource().getDbType();
            String formatSql = SQLUtils.format(sql, DbType.of(dbType), params, this.formatOption);
            return this.pattern.matcher(formatSql).replaceAll(" ");
        }
    }
}
