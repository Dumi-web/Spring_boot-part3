package com.dumisani.spring.part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FakeRepo implements FakeRepoInterFace {
    @Autowired
    public static User [] newUser;

    @Override
    public void insertUser(int Id, String name, String surname) {
        for (int i = 0; i <newUser.length ; i++) {
            if(newUser[i] == null){
                newUser [0] = new User(1,"Dumisani","Ngobeni");
                newUser [1] = new User(2,"Cassey","Muronga");
                newUser [2] = new User(3,"Thuso","White");
                newUser [3] = new User(4,"Puma","WinterBottom");
                newUser [4] = new User(5,"Clive","Glover");
            }
        }
    }

    @Override
    public int findById(int Id) {
        for (int i = 0; i <newUser.length ; i++) {

        }

    }

    @Override
    public int deleteUser(int Id) {

    }
}
