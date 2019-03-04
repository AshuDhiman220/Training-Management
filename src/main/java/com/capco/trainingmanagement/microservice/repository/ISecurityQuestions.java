package com.capco.trainingmanagement.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capco.trainingmanagement.microservice.entity.SecurityQaEntity;

@Repository
public interface ISecurityQuestions extends JpaRepository<SecurityQaEntity, Integer> {

}
