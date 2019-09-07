package com.fbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fbapi.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
