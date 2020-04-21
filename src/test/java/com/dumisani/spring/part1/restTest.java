package com.dumisani.spring.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class restTest {
    @LocalServerPort
    private int port;
    @Autowired
    TestRestTemplate template;
    @Autowired
    UserServicesImpl user;

    private URL base;

    @BeforeEach
    public void setUp()throws Exception{
        String
        this.base =  new URL("http://localhost: " + port);
    }
    @Test
    public void addUser(){
       String newName = user.addUser(1,"Dumisani","Ngobeni");
        System.out.println(newName);
    }
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200()throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("dumisani", "password")
                .getForEntity(base.toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
