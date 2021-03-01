package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.dto.ContestantDto;
import com.example.demo.serviceimpl.ContestantServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class ContestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ContestantServiceImpl contestantServiceImpl;

	ContestantDto mockContestant1 = new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678");
	
	String example = "{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"}";

	List<ContestantDto> list = Arrays.asList(
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"),
			new ContestantDto(1, "MartinBingel", "martin.s2017@gmail.com", "Dance", "12345678"));

	String exampleJson = "[{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"},"
			+ "{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"},"
			+ "{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"},"
			+ "{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"}]";
	

	@Test
	public void getAllContestants() throws Exception {

		Mockito.when(contestantServiceImpl.getAllContestants()).thenReturn(list);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/contest").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("result string" + result.getResponse().getContentAsString());

		JSONAssert.assertEquals(exampleJson, result.getResponse().getContentAsString(), false);
	}

	
	 @Test public void createContestant() throws Exception {
	  Mockito.when(contestantServiceImpl.createContestant(Mockito.any(ContestantDto.class))) .thenReturn(mockContestant1); 
	  RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/contest/add").accept(MediaType.APPLICATION_JSON).content(example).contentType( MediaType.APPLICATION_JSON);
	  
	 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	  
	  MockHttpServletResponse response = result.getResponse();
	 
	  assertEquals(200, response.getStatus());
	
	  }
	 

	 @Test
	 public void updateContestant() throws Exception {
		 String upadatedData = "{\"id\":1,\"name\":\"MartinBingel\",\"emailId\":\"martin.s2017@gmail.com\",\"contestName\":\"Dance\",\"phoneNo\":\"12345678\"}";
		 Mockito.when(contestantServiceImpl.createContestant(Mockito.any(ContestantDto.class))) .thenReturn(mockContestant1); 
		 RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/contest/1").accept(MediaType.APPLICATION_JSON).content(upadatedData).contentType( MediaType.APPLICATION_JSON);
		 MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		  
		  MockHttpServletResponse response = result.getResponse();
		 
		  assertEquals(200, response.getStatus());
		 
	 }
	 
	 
}
