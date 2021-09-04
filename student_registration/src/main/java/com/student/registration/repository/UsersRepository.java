package com.student.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.registration.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
