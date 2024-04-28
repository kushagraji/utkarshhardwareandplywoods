package com.utkarshhardwareandplywood.springboot.website.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utkarshhardwareandplywood.springboot.website.models.User;

public interface Repo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);

	

}
