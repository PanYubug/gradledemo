package com.panyu.restful;

import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/*
  Spring RestTemplate 推荐方法
 */
public class HttpTemplate {

    public static void main(String[] args) {

        HttpTemplate.httpGet("http://localhost:8080/test");
        System.out.println(HttpTemplate.httpPost("http://localhost:8080/testPost1", "ming"));
    }

    public static String httpGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.exchange(url, HttpMethod.GET, null, String.class).getBody();
        return result;
    }

    public static String httpPost(String url, String name){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(url, name , String.class).getBody();
    }
}
