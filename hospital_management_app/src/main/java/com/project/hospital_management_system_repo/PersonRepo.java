package com.project.hospital_management_system_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system_dto.Person;

public interface PersonRepo extends JpaRepository<Person, Integer> {

}
