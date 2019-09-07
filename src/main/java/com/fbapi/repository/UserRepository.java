package com.fbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
