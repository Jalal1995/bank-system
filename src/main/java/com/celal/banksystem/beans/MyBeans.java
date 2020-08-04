package com.celal.banksystem.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeans {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
