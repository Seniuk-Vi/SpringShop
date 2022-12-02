package com.epam.springshop.controller;

import com.epam.springshop.api.RestTemplateApi;
import com.epam.springshop.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/template")
public class RestTemplateController implements RestTemplateApi {

    RestTemplate restTemplate;

    @Autowired
    public RestTemplateController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.restTemplate.setErrorHandler(new RestTemplateErrorHandler());
    }

    public String getProducts() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/products", HttpMethod.GET, entity, String.class).getBody();
    }

    public JSONObject getProduct(Long productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/products/product/" + productId, HttpMethod.GET, entity, JSONObject.class).getBody();
    }

    public JSONObject createProduct(@RequestBody ProductDto productDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProductDto> entity = new HttpEntity<>(productDto, headers);
        return restTemplate.exchange(
                "http://localhost:8080/admin/products/product", HttpMethod.POST, entity, JSONObject.class).getBody();
    }

    public JSONObject updateProduct(long productId, @RequestBody ProductDto productDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProductDto> entity = new HttpEntity<>(productDto, headers);
        return restTemplate.exchange(
                "http://localhost:8080/admin/products/product/" + productId, HttpMethod.PUT, entity, JSONObject.class).getBody();
    }

    public JSONObject deleteProduct(Long productId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<ProductDto> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                "http://localhost:8080/admin/products/product/" + productId, HttpMethod.DELETE, entity, JSONObject.class).getBody();
    }
}
