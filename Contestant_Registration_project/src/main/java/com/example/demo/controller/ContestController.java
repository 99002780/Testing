package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContestantDto;
import com.example.demo.serviceimpl.ContestantServiceImpl;




@RestController
public class ContestController {

	
	@Autowired
	ContestantServiceImpl contestantServiceImpl;

	
	@GetMapping("/contest")
	public List<ContestantDto> getAllContestants(){
		 
		return contestantServiceImpl.getAllContestants();
	}	

	 @PostMapping("/contest/add")
	 public ResponseEntity<ContestantDto> createContestant(@RequestBody ContestantDto contestantDto) 
	 {
		ContestantDto contest = contestantServiceImpl.createContestant(contestantDto);
		 return ResponseEntity.ok(contest); 
	 }
	 @PutMapping("/contest/{id}")
	    public ResponseEntity <ContestantDto> updateMovie(@RequestBody ContestantDto contestantDto,@PathVariable Long id) {
	      ContestantDto contest = contestantServiceImpl.UpdateContestant(contestantDto,id);
	      return ResponseEntity.status(HttpStatus.OK).body(contest);
	        
	    }
	 @DeleteMapping("/contest/{id}")
	    private String deleteContestant(@PathVariable Long id) {
	        contestantServiceImpl.delete(id);
			return "Deleted Successfully";
	    }
}
	  
	
	
	
