package com.angualr.StatisticSaver.Service;

import com.angualr.StatisticSaver.DTO.UserDTO;
import com.angualr.StatisticSaver.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    private UserDTO userDTO;


    @Transactional
    public Optional<List<User>> getAll(){
        return Optional.ofNullable(userDTO.findAll());
    }

    @Transactional
    public Optional<User> getById(Long id){
        return Optional.ofNullable(userDTO.findUserById(id));
    }

    public Optional<User> updateUser(User user){
        User existingUser = userDTO.findUserById(user.getId());
        if (existingUser != null){
            existingUser.setUserName(user.getUserName());
            existingUser.setUserSurname(user.getUserSurname());
            existingUser.setEmail(user.getEmail());
            existingUser.setContactPhone(user.getContactPhone());
            userDTO.save(existingUser);
        }
        return Optional.ofNullable(existingUser);
    }

    public Optional<User> deleteUserAccount(User user){
        User existingUser = userDTO.findUserById(user.getId());
        if (existingUser != null){
            userDTO.delete(user.getId());
        }
        return Optional.ofNullable(existingUser);
    }

}
