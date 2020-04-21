package com.dumisani.spring.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class restTest {
    @LocalServerPort
    private int port;
    @Autowired
    public TestRestTemplate template;
    @Autowired
    public UserServices user;

    private URL base;

    @BeforeEach
    public void setUp()throws Exception{
        this.base =  new URL("http://localhost:" + port);
    }
    @Test
    public void addUser(){
        String name = user.addUser(1,"Dumisani","Ngobeni");
        String newName = user.getUser(1);
        System.out.println(name+"\n"+newName);
    }
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200()throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("dumisani", "password")
                .getForEntity(base.toString(), String.class);
    }
}
