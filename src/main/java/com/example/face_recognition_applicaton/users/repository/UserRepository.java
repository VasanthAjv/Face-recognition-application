package com.example.face_recognition_applicaton.users.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.face_recognition_applicaton.users.model.Users;

public interface UserRepository extends JpaRepository<Users,Long>{
	
	Optional<Users> findByEmail(String email);


}
