package com.amzur.registration.practice.p2;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amzur.registration.practice.p1.Register;

public interface RegRepository extends JpaRepository<Register, Long>{
	 public Register findByEmail(String email);

	  public Optional<Register> findByEmailAndPassword(String email, String password);
}
