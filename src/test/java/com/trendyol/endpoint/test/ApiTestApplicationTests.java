package com.trendyol.endpoint.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
@SpringBootTest(classes = ApiTestApplication.class)
public class ApiTestApplicationTests {


}
