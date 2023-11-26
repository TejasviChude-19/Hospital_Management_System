package com.project.hospital_management_system_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.hospital_management_system_Exception.IdNotFoundException;
import com.project.hospital_management_system_dao.HospitalDao;
import com.project.hospital_management_system_dto.Hospital;
import com.project.hospital_management_system_util.ResponseStructure;

@Service
public class HospitalService {
	

		@Autowired
		private HospitalDao dao;

		public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital) {
			ResponseStructure<Hospital> structure = new ResponseStructure<>();
			structure.setMessage("Successfully Saved");
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setData(dao.saveHospital(hospital));
			return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
		}

		public ResponseEntity<ResponseStructure<Hospital>> updateHospital(int id, Hospital hospital) {
			Hospital dbHospital = dao.updateHospital(id, hospital);
			if (dbHospital != null) {
				ResponseStructure<Hospital> structure = new ResponseStructure<>();
				structure.setMessage("Successfully Updated");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(dbHospital);
				return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
			} else {
				throw new IdNotFoundException("Id not found for Hospital");
			}
		}

		public ResponseEntity<ResponseStructure<Hospital>> deleteHospital(int id) {
			Hospital hospital = dao.deleteHospital(id);
			if (hospital != null) {
				ResponseStructure<Hospital> structure = new ResponseStructure<>();
				structure.setMessage("Successfully Deleted");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(hospital);
				return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
			} else {
				throw new IdNotFoundException("Id not found for Hospital");
			}
		}

		public ResponseEntity<ResponseStructure<Hospital>> getHospitalById(int id) {
			Hospital hospital = dao.getHospitalById(id);
			if (hospital != null) {
				ResponseStructure<Hospital> structure = new ResponseStructure<>();
				structure.setMessage("Successfully Found");
				structure.setStatus(HttpStatus.OK.value());
				structure.setData(hospital);
				return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
			} else {
				throw new IdNotFoundException("Id not found for Hospital");
			}
		}

	}


