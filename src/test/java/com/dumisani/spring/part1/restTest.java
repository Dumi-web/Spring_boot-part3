package com.dumisani.spring.part1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class restTest {
    @LocalServerPort
    private int port;
    @Autowired
    public TestRestTemplate template;
    @Autowired
    public UserServices userServices;

    private URL base;

    @BeforeEach
    public void urlLink()throws Exception{
        this.base =  new URL("http://localhost:" + port);
    }
    @Test
    public void cacheUser(){
        userServices.addUser(1,"Dumisani","Ngobeni");
        String newName = userServices.getUser(1);
        String newName1 = userServices.getUser(1);
        String newName2 = userServices.getUser(1);
        String newName3 = userServices.getUser(1);
        System.out.println(newName+"\n"+newName1+"\n"+newName2+"\n"+newName3);
    }
    @Test
    public void givenAuthRequestOnPrivateService_shouldSucceedWith200()throws Exception{
        ResponseEntity<String> response = template.withBasicAuth("dumisani", "password")
                .getForEntity(base.toString(), String.class);
    }
}
