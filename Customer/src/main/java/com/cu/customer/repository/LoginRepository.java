package com.cu.customer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cu.customer.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {
	Optional<Login> findById(String id);
}
