package com.petient.entits;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Patient {
	@Id
	private long patientId;
	private String patientName;
	private String patientContactNo;

	
	

	public Patient(String patientName, String patientContactNo) {
		super();
		this.patientName = patientName;
		this.patientContactNo = patientContactNo;
	}

	public Patient(long patientId, String patientName, String patientContactNo) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientContactNo = patientContactNo;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return this.patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientContactNo() {
		return patientContactNo;
	}

	public void setPatientContactNo(String patientContactNo) {
		this.patientContactNo = patientContactNo;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientContactNo="
				+ patientContactNo + "]";
	}

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
