package com.project.hospital_management_system_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system_dto.MedOrder;

public interface MedOrderRepo extends JpaRepository<MedOrderRepo, Integer>{

	MedOrder save(MedOrder medOrder);

	
	

}
