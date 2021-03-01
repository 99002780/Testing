package com.example.demo.serviceimpl;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ContestantRepository;
import com.example.demo.dto.ContestantDto;
import com.example.demo.model.Contestant;
import com.example.demo.service.ContestantService;




@Service
public class ContestantServiceImpl implements ContestantService {
 @Autowired
 ContestantRepository contestRepo;
	@Override
	public ContestantDto createContestant(ContestantDto contestantDto) {
	
		Contestant contestant = new Contestant();
		BeanUtils.copyProperties(contestantDto, contestant);
		contestant = contestRepo.save(contestant) ;
		BeanUtils.copyProperties(contestant, contestantDto);
		return contestantDto;
	}
	
	public ContestantDto UpdateContestant( ContestantDto contestantDto,long id ) {
		Contestant contestant = new Contestant();
		BeanUtils.copyProperties(contestantDto, contestant);
		contestant = contestRepo.save(contestant) ;
		BeanUtils.copyProperties(contestant, contestantDto);
		return contestantDto;
	}
	
	@Override
    public void delete(Long id) {
		contestRepo.deleteById(id);
       
       
    }
	@Override
	public List<ContestantDto> getAllContestants() {
		// TODO Auto-generated method stub
		ModelMapper modelMapper = new ModelMapper();
		List<Contestant> contest = (List<Contestant>) contestRepo.findAll();
        Type listType = new TypeToken<List<ContestantDto>>(){}.getType();
        List<ContestantDto> contestantDTOList  = modelMapper.map(contest, listType);
		return contestantDTOList;
		
	}


	
}
