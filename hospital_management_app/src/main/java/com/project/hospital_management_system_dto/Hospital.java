package com.project.hospital_management_system_dto;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.validation.constraints.NotBlank;

	import lombok.Data;

	@Entity
	@Data
	public class Hospital {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@NotBlank(message = "name can't be null")
		private String name;
		@NotBlank(message = "email is mandatory")
		private String email;
		@NotBlank(message = "gst is mandatory")
		private String gst;

	}


