package com.capco.trainingmanagement.microservice.repository;

import javax.management.relation.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.trainingmanagement.microservice.entity.EmployeeEntity;
import com.capco.trainingmanagement.microservice.entity.RoleEntity;

@Repository
public interface IRoleRepository extends JpaRepository<RoleEntity, Integer> {

	RoleEntity findByRoleType(String roleType);

	
}
