package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dao.ContestantRepository;
import com.example.demo.dto.ContestantDto;
import com.example.demo.model.Contestant;
import com.example.demo.serviceimpl.ContestantServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest

class ContestantServiceImplTest {
 
	@Autowired
	ContestantServiceImpl contestantServiceImpl;
	 
	@MockBean
	ContestantRepository contestantRepository;
	
	ContestantDto mockContestant1 = new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678");
	
	List<ContestantDto> list = Arrays.asList(
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"));
	
	List<Contestant> list1 = Arrays.asList(
			new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"));
	
	@Test
	 public void createContestant() throws Exception{
		
		Contestant contestant= new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678");
		Contestant contestant1= new Contestant();
		BeanUtils.copyProperties(mockContestant1,contestant);
		Mockito.when(contestantRepository.save(Mockito.any(Contestant.class))) .thenReturn(contestant);
		ContestantDto dto = contestantServiceImpl.createContestant(mockContestant1);
		BeanUtils.copyProperties(dto, contestant1);
		assertEquals(contestant1.toString(),contestant.toString());
		
	}
	
	@Test
	 public void updateContestant() throws Exception{
		Contestant contestant= new Contestant(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678");
		Contestant contestant1= new Contestant();
		BeanUtils.copyProperties(mockContestant1,contestant);
		Mockito.when(contestantRepository.save(Mockito.any(Contestant.class))) .thenReturn(contestant);
		ContestantDto dto = contestantServiceImpl.UpdateContestant(mockContestant1, 1);
		BeanUtils.copyProperties(dto, contestant1);
		assertEquals(contestant1.toString(),contestant.toString());
		
	}
	
	 @Test public void getAllContestants() throws Exception {
//	 List<Contestant> contestant1;
//	  BeanUtils.copyProperties(list,list1);
//	  Mockito.when(contestantRepository.findAll()).thenReturn(list1);
//	  System.out.println(list1);
//	 List<ContestantDto> dto = contestantServiceImpl.getAllContestants();
//	 BeanUtils.copyProperties(dto, contestant1);
//	 System.out.println(dto);
//	 assertEquals(contestant1.toString(),list1.toString());
		 Mockito.when(contestantRepository.findAll()).thenReturn(list1);
		 List<ContestantDto> dto = contestantServiceImpl.getAllContestants();
		 System.out.println(dto);
		 List<Contestant> contestant1 =Arrays.asList(
					new Contestant(),
					new Contestant(),
					new Contestant(),
					new Contestant());
		 BeanUtils.copyProperties(dto, contestant1);
		 System.out.println("map result: "+contestant1);
		 
	  }
	 
	
	
}

