package com.trendyol.endpoint.test.service.impl;

import com.trendyol.endpoint.test.ApiTestApplication;
import com.trendyol.endpoint.test.common.CommonProperties;
import com.trendyol.endpoint.test.model.Book;
import com.trendyol.endpoint.test.service.RequestService;
import lombok.Getter;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Ignore
@Getter
public class RequestServiceImpl implements RequestService {


    @Autowired
    CommonProperties commonProperties;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    protected RestTemplate restTemplate;

    @Override
    public ResponseEntity executeGet() {
        return executeGet(null);
    }

    @Override
    public ResponseEntity executeGet(String url) {

        if (!StringUtils.hasText(url))
            url = commonProperties.getBaseUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);
    }

    @Override
    public ResponseEntity executeGetById(int id) {
        return executeGet(commonProperties.getBaseUrl() + "/" + id);
    }


   @Override
    public ResponseEntity executePut(Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
        ResponseEntity<Object> exchange = null;
        try {
            exchange = restTemplate.exchange(commonProperties.getBaseUrl(), HttpMethod.PUT, entity, Object.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders())
                    .body(e.getResponseBodyAsString());        }
        return exchange;
    }
}
