package com.project.hospital_management_system_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system_dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital, Integer> {
	public Hospital findByEmail(String email);
}
