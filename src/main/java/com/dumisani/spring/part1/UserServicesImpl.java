package com.dumisani.spring.part1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices {
    @Autowired
    static FakeRepo fakeRepo;

    @Override
    public String addUser(long Id, String name, String surname) {
        fakeRepo = new FakeRepo();
        return fakeRepo.insertUser(1,name,surname);
    }
    @Override
    //@Cacheable("name")
    public String getUser(long Id) {
        fakeRepo = new FakeRepo();
       /* try
        {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/
        return fakeRepo.findUserById(1);
    }

    @Override
    public String removeUser(long Id) {
        fakeRepo = new FakeRepo();
        return fakeRepo.deleteUser(1);
    }
}
