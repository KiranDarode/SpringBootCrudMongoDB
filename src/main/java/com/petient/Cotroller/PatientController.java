package com.petient.Cotroller;





import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.petient.MongoRepo.MongoRepo;
import com.petient.Sequencegerator.SequenceGeneratorService;
import com.petient.entits.Patient;

@RestController
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private MongoRepo repo;

 
	@Autowired
   SequenceGeneratorService sequenceGeneratorService;


	
	@PostMapping("/")
	public Patient addPatient(@RequestBody Patient patient) {
       patient.setPatientId(sequenceGeneratorService.generateSequence(patient));
		return this.repo.save(patient);
	}

	// dispaly data
	@GetMapping("/")
	public List<Patient> getPateint() {
		return repo.findAll();
	}

	// delete
	@DeleteMapping("/{id}")
	public void deletePateint(@PathVariable int id) {

		this.repo.deleteById(id);

		System.out.println("data is deleted succsessfully" + id);

	}

	@PutMapping("/{id}")
	public void updatePateint(@PathVariable int id, @RequestBody Patient pateint) {
		Optional<Patient> findbyid = repo.findById(id);

		if (findbyid.isPresent()) {
			Patient entity = findbyid.get();
			System.out.println(entity);
			entity.setPatientName(pateint.getPatientName());
			entity.setPatientContactNo(pateint.getPatientContactNo());
			repo.save(entity);
			System.out.println("update done");

		} else {
			

			System.out.println("this id data is not present , plese check id ");
		}
	}

}

