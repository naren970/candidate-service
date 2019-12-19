package com.shortlist.models.controllers;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shortlist.models.Candidate;
import com.shortlist.models.Employer;
import com.shortlist.models.repository.CandidateRepository;

@RestController
public class CandidateController {

	@Autowired
	CandidateRepository candidateRepo;
	RestTemplate restTemplate = new RestTemplate();
	
	
	
	@PostMapping("/candidate")
	public String createCandidate(@RequestBody Candidate candidateDetails) {

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		 Employer employerDeatils = candidateDetails.getEmployerDetails();
		 final String uri = "http://employer-service/employer/";
		 ResponseEntity<Employer> resu = restTemplate.postForEntity(uri, employerDeatils,  Employer.class);
			System.out.println("Result "+resu.getBody());
			System.out.println("The Result form API");

		 candidateRepo.save(candidateDetails);
		return "";
	}
	
	@GetMapping("/candidate/{id}")
	public String getCandidate(@PathVariable int id) {
		final String uri = "http://employer-service/employer/"+id;
		
		String res = restTemplate.getForObject(uri, String.class);
		ResponseEntity<String> resu = restTemplate.getForEntity(uri, String.class, 200);
		System.out.println(resu.getBody());
		System.out.println("The Result form API");
		
		return res;
	}
	
}
