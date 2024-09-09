package com.example.demo.respositories;

import com.example.demo.models.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Long> {
    
}
