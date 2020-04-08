package com.dumisani.spring.part1;

public interface FakeRepoInterFace {
    void insertUser(int Id, String name, String surname);
    int findById(int Id);
    int deleteUser(int Id);
}
