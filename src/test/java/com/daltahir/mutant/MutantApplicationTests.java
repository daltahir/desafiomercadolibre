package com.daltahir.mutant;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.daltahir.mutant.controller.Mutant;
import com.daltahir.mutant.model.Dna;
import com.daltahir.mutant.model.Stats;

@SpringBootTest
class MutantApplicationTests {


	@Autowired
	private Mutant mutantservice;


	@Test
	void contextLoads() {
	}
	@Test
	public void testGetStats() {
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Stats> response = mutantservice.status();

	assertNotNull(response.getBody());
	}

	@Test
	public void testIsMutant() {
		HttpHeaders headers = new HttpHeaders();
		Dna dna = new Dna();
		String[] sdna ={"ATGCGA", "CAGTGC", "TTATTT", "AGACGG", "GCGTCA","TCAGTG"};
		dna.setDna(sdna);
		
		ResponseEntity<String> response = mutantservice.validMutant(dna);

	assertNotNull(response.getBody());
	assertEquals(response.getStatusCode(), HttpStatus.FORBIDDEN);
	
	}
	
	
}
