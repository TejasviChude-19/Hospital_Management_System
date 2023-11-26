package com.project.hospital_management_system_dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system_dto.Address;
import com.project.hospital_management_system_dto.Branch;
import com.project.hospital_management_system_dto.Hospital;
import com.project.hospital_management_system_repo.BranchRepo;
@Repository
public class BranchDao {
		@Autowired
		private BranchRepo repo;
		@Autowired
		private HospitalDao dao;
		@Autowired
		private AddressDao addressDao;

		public Branch saveBranch(Branch branch, int hid, int aid) {
			Hospital hospital = dao.getHospitalById(hid);
			branch.setHospital(hospital);
			Address address = addressDao.getAddressById(aid);
			branch.setAddress(address);
			return repo.save(branch);
		
		}

		public Branch updateBranch(int id, Branch branch) {
			Branch dbBranch = (Branch) repo.findById(id).get();
			if (dbBranch != null) {
				branch.setId(id);
				branch.setHospital(dbBranch.getHospital());
				branch.setAddress(dbBranch.getAddress());
				return repo.save(branch);
			} else {
				return null;
			}
		}

		public Branch deleteBranch(int id) {
			if (repo.findById(id).isPresent()) {
				Branch branch = (Branch) repo.findById(id).get();
				repo.deleteById(id);
				return branch;
			} else {
				return null;
			}
		}

		public Branch getBranchById(int id) {
			if (repo.findById(id).isPresent()) {
				return (Branch) repo.findById(id).get();
			} else {
				return null;
			}
		}

		public List<Branch> getBranchByHospitalId(int hid) {
			Hospital hospital = dao.getHospitalById(hid);
			return repo.findBranchByHospital(hospital);
		}


	}

