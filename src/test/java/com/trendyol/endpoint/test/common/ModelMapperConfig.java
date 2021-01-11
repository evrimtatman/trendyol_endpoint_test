package com.trendyol.endpoint.test.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :15:22
 * Day: Monday
 * Month:January
 * Year:2021
 */
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
