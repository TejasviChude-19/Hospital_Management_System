package com.project.hospital_management_system_repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.hospital_management_system_dto.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}
