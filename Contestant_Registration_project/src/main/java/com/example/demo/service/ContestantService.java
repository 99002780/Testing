package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContestantDto;

public interface ContestantService {
	List<ContestantDto> getAllContestants();
	ContestantDto createContestant(ContestantDto contestantDto);
	ContestantDto UpdateContestant(ContestantDto contestantDto,long id);
	void delete(Long id);
	
	
}
