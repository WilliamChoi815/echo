package com.example.hiApi

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class HiRestTemplateConfiguration {
    @Bean
    fun restTemplate():RestTemplate{
        return RestTemplate()
    }
}