package com.project.hospital_management_system_dto;

	import java.sql.Date;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;
	import javax.validation.constraints.NotBlank;

	import org.hibernate.annotations.CreationTimestamp;

	import lombok.Data;

	@Entity
	@Data
	public class MedOrder {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@CreationTimestamp
		private Date date;
		@NotBlank(message = "doctor can't be blank")
		private String doctor;
		@ManyToOne
		private Encounter encounter;

	}

