package com.project.hospital_management_system_dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.hospital_management_system_dto.Encounter;
import com.project.hospital_management_system_dto.MedOrder;
import com.project.hospital_management_system_repo.MedOrderRepo;

@Repository
public class MedOrderDao {

		@Autowired
		private MedOrderRepo repo;
		@Autowired
		private EncounterDao dao;

		public MedOrder saveMedOrder(MedOrder medOrder, int eid) {
			Encounter encounter = dao.getEncounterById(eid);
			medOrder.setEncounter(encounter);
			return repo.save(medOrder);
		}

		public MedOrder updateMedOrder(int id, MedOrder medOrder) {
			if (repo.findById(id).isPresent()) {
				medOrder.setId(id);
				return repo.save(medOrder);
			} else {
				return null;
			}
		}

		public MedOrder getMedOrderById(int id) {
			return (MedOrder) repo.findById(id).get();
		}

		public MedOrder deleteMedOrder(int id) {
			if (repo.findById(id).isPresent()) {
				MedOrder medOrder = (MedOrder) repo.findById(id).get();
				repo.deleteById(id);
				return medOrder;
			} else {
				return null;
			}
		}

	}


