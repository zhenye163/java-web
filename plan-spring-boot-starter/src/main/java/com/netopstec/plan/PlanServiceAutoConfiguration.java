package com.netopstec.plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhenye 2020/4/11
 */
@Configuration
@EnableConfigurationProperties(PlanProperties.class)
@ConditionalOnClass(PlanService.class)
@ConditionalOnProperty(prefix = "spring.plan", value = "enabled", matchIfMissing = true)
public class PlanServiceAutoConfiguration {
    @Autowired
    private PlanProperties properties;

    @Bean
    @ConditionalOnMissingBean(PlanService.class)
    public PlanService planService(){
        PlanService planService = new PlanService(properties);
        return planService;
    }
}
