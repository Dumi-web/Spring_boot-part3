package com.dumisani.spring.part1;

public interface FakeRepoInterFace {
    String insertUser(long Id, String name, String surname);
    String findUserById(long Id);
    String deleteUser(long Id);
}
