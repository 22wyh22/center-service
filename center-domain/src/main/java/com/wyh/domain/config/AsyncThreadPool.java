package com.wyh.domain.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncThreadPool implements AsyncConfigurer {

    @Value("${thread.pool.async.maxCore:3}")
    private int maxCore;

    @Bean("asyncExecutor")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(maxCore);
        executor.setMaxPoolSize(maxCore);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(10);
        executor.initialize();
        return executor;
    }
}
