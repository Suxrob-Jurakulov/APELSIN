package com.company;

import com.company.dto.CompanyDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootTest
class ApelsinApplicationTests {
    @Autowired
    private RestTemplate restTemplate;
    @Test
    void contextLoads() {
        String response = restTemplate.getForObject("http://10.10.3.140:8080/api/v1/company/pagination", String.class);
        System.out.println(response);
    }

    @Test
    void getStringArray() {
        RestTemplate restTemplate = new RestTemplate();
        CompanyDTO[] response = restTemplate.getForObject("http://10.10.3.140:8080/api/v1/company/pagination", CompanyDTO[].class);
        System.out.println(Arrays.toString(response));
    }
    @Test
    void getById() {
        String id = "123123";
        RestTemplate restTemplate = new RestTemplate();
        CompanyDTO response = restTemplate.getForObject("http://10.10.3.140:8080/api/v1/company/" + id, CompanyDTO.class);
        System.out.println(response);
    }

    @Test
    void getById1() {
        String id = "2c950081823571320182357151900000";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CompanyDTO> response = restTemplate.getForEntity("http://10.10.3.140:8080/api/v1/company/" + id, CompanyDTO.class);
        System.out.println(response);
    }

    @Test
    void get4() {
        RestTemplate restTemplate = new RestTemplate();

        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setName("nimadir ");
        companyDTO.setContact("dasda");
        companyDTO.setAddress("dasda");
        companyDTO.setRole("PAYMENT");
        companyDTO.setUsername("Company 5");
        companyDTO.setPassword("asdasd");

        HttpEntity<CompanyDTO> request = new HttpEntity<>(companyDTO);

        Void response = restTemplate.postForObject(
                "http://localhost:8080/api/v1/company/create", request, Void.class);

        System.out.println(response);
    }
}
