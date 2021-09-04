package com.student.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.registration.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
