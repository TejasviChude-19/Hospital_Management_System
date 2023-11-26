package com.project.hospital_management_system_repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.hospital_management_system_dto.Branch;
import com.project.hospital_management_system_dto.Hospital;

public interface BranchRepo extends JpaRepository<BranchRepo, Integer> {
	@Query("SELECT b FROM Branch b WHERE b.hospital=?1")
	public List<Branch> findBranchByHospital(Hospital hospital);
	public Branch save(Branch branch); 
}
