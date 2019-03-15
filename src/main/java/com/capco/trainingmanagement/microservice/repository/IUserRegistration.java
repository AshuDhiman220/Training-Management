package com.capco.trainingmanagement.microservice.repository;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;

@Repository
public interface IUserRegistration extends JpaRepository<EmployeeEntity,Integer>{

	EmployeeEntity findByEmail(String email);

	EmployeeEntity findByDob(Date dob);
	
	@Modifying
	@Transactional
	@Query(value="update employee set password=:password where email=:email", nativeQuery=true)
	public void resetPassword(@Param("password") String password, @Param("email") String email);
}
