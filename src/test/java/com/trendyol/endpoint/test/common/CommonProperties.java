package com.trendyol.endpoint.test.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Getter
@Component
public class CommonProperties {


    @Value("${target.application.baseUrl}")
    private String baseUrl;
}
