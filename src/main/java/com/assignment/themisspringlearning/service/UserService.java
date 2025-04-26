package com.assignment.themisspringlearning.service;


import com.assignment.themisspringlearning.model.UserEntity;
import com.assignment.themisspringlearning.repo.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserEntity saveUser(String name) {

        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        return userRepo.save(userEntity);
    }


    public UserEntity getUser(Long id) {
        return userRepo.findById(id).orElse(null);
    }
}
