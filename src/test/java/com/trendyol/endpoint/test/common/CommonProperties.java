package com.trendyol.endpoint.test.common;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Bulut Cakan (179997) on
 * Hour :15:54
 * Day: Monday
 * Month:January
 * Year:2021
 */
@Getter
@Component
public class CommonProperties {


    @Value("${target.application.baseUrl}")
    private String baseUrl;
}
