package com.trendyol.endpoint.test.configuration;

import com.trendyol.endpoint.test.ApiTestApplication;
import com.trendyol.endpoint.test.model.Book;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Ignore
public class CommonHttpMethods {

    @Autowired
    protected RestTemplate restTemplate;

    public ResponseEntity executeGet(String url) {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, Object.class);

    }

    public ResponseEntity executeGetById(String url, int id) {
        return executeGet(url + "/" + id);
    }

    public ResponseEntity executePut(String url, Book book) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Book> entity = new HttpEntity<Book>(book, headers);
        return restTemplate.exchange(url, HttpMethod.PUT, entity,Object.class);
    }
}

