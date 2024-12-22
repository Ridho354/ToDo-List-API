package com.enigma.ToDo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enigma.ToDo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

    User findByUsernameAndPassword(String username, String password);

}
