package com.bpjstk.JSReport.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean(name = "taskExecutor")
    public Executor asyncTaskExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        String corePoolSize = System.getProperty("corePoolSize", "5");
        threadPoolTaskExecutor.setCorePoolSize(Integer.parseInt(corePoolSize));
        String maxPoolSize = System.getProperty("maxPoolSize", "5");
        threadPoolTaskExecutor.setMaxPoolSize(Integer.parseInt(maxPoolSize));
        String queueCapacity = System.getProperty("queueCapacity", "10");
        threadPoolTaskExecutor.setQueueCapacity(Integer.parseInt(queueCapacity));
        threadPoolTaskExecutor.setThreadNamePrefix("async-task-");
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }
}
