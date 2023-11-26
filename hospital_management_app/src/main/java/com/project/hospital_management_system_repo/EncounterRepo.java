package com.project.hospital_management_system_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system_dto.Encounter;

public interface EncounterRepo extends JpaRepository<Encounter, Integer>{

}
