package com.pr.anyLogicServer.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.pr.anyLogicServer.repositories")
public class JPAConfig {
}