package com.hiruni.bumblebee.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void addNewUsers(Users users) {
        usersRepository.save(users);
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

}
