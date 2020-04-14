package com.dumisani.spring.part1;

public class UserServicesImpl implements UserServices {
    static FakeRepo repo = new FakeRepo();
    @Override
    public String addUser(String name, String surname) {
        return repo.insertUser(1,name,surname);
    }
    @Override
    public String getUser(long Id) {
        return repo.findUserById(1);
    }

    @Override
    public String removeUser(long Id) {
        return repo.deleteUser(1);
    }


}
