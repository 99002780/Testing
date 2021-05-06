package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Contestant;
import net.javaguides.springboot.repository.ContestantRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ContestController {

	@Autowired
	private ContestantRepository contestantRepository;
	
	// get all employees
	@GetMapping("/contestants")
	public List<Contestant> getAllContestants(){
		return contestantRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/contestants")
	public Contestant createContestant(@RequestBody Contestant contestant) {
		return contestantRepository.save(contestant);
	}
	
	// get employee by id rest api
	@GetMapping("/contestants/{id}")
	public ResponseEntity<Contestant> getContestantById(@PathVariable Long id) {
		Contestant contestant= contestantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contestant not exist with id :" + id));
		return ResponseEntity.ok(contestant);
	}
	
	// update employee rest api
	
	@PutMapping("/contestants/{id}")
	public ResponseEntity<Contestant> updateContestant(@PathVariable Long id, @RequestBody Contestant contestantDetails){
		Contestant contestant = contestantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contestant not exist with id :" + id));
		
		contestant.setName(contestantDetails.getName());
		contestant.setEmailId(contestantDetails.getEmailId());
		contestant.setContestName(contestantDetails.getContestName());
		contestant.setPhoneNo(contestantDetails.getPhoneNo());
		
		Contestant updatedContestant = contestantRepository.save(contestant);
		return ResponseEntity.ok(updatedContestant);
	}
	
	// delete employee rest api
	@DeleteMapping("/contestants/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteContestant(@PathVariable Long id){
		Contestant Contestant = contestantRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Contestant not exist with id :" + id));
		
		contestantRepository.delete(Contestant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}