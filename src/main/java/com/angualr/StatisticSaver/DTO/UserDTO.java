package com.angualr.StatisticSaver.DTO;

import com.angualr.StatisticSaver.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDTO extends JpaRepository<User, Long> {

    List<User> findAll();

    User findUserById(Long id);

    List<User> findByUserName(String name);

    void delete (Long id);
}
