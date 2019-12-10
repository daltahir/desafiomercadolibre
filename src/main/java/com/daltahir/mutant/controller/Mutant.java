package com.daltahir.mutant.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daltahir.mutant.model.Dna;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




@RestController
@RequestMapping("/api/v1")
public class Mutant {
	  @PostMapping(path="/mutant", 
			  consumes= {MediaType.APPLICATION_JSON_VALUE,
					  MediaType.TEXT_PLAIN_VALUE
			  },
			  produces= {
					  MediaType.APPLICATION_XML_VALUE,
					  MediaType.APPLICATION_JSON_VALUE
			  })
	  public ResponseEntity<String> validMutant(
			 @RequestBody Dna dna) {

		 String retorno="OK";
		  if(dna.getDna()==null)
		  {
			  retorno="Cadena no es válida, no puede ser nula";
			  return new ResponseEntity<String>(retorno,HttpStatus.FORBIDDEN);
		  }
		  if(!isDNAValid(dna.getDna()))
		  {
			  retorno="Cadena no es válida, sólo se permiten secuencias [A,C,G,T]";
			  return new ResponseEntity<String>(retorno,HttpStatus.FORBIDDEN);
		  }
		  if(isMutant(dna.getDna())) {
			  return new ResponseEntity<String>(retorno,HttpStatus.OK);
		  }
		  else
		  {
			  retorno ="No es mutante ";
			  return new ResponseEntity<String>(retorno,HttpStatus.FORBIDDEN);  
		  }
	  }
	  static boolean isDNAValid(String[] dna){
			for(String cadena:dna){
				Pattern patron =Pattern.compile("[^ACGT]");
				Matcher encaja=patron.matcher(cadena);
				if(encaja.find()){
					return false;
				}
			
			}
			return true;
			}
	  static boolean isMutant(String[] dna) {
			String[] dnaT= new String[dna.length];
			String[] dnaO= new String[dna.length*2-1];
			String[] dnaV= new String[dna.length*2-1];
		for(int x=0;x <dna.length;x++){ //Recorremos vertical
			for(int i=0;i< dna[x].length();i++){ //Recorremos horizontal (palabra)
				//Inicializamos arreglos
				if(dnaT[i]==null){
					dnaT[i]="";
				}
				//Transponemos
				dnaT[i]+=dna[x].charAt(i);
			}
		}
		//Proceso de diagonales de izquierda a derecha de abajo hacia arriba
		int n=dna.length-1;

		for(int x=0;x<=n;x++){
			int i=0;
			int j=n*2;
			for(int y=0;y+x <= n;y++){
				if(dnaO[i+x]==null){
					dnaO[i+x]="";
				}
				if(dnaO[j-x]==null){
					dnaO[j-x]="";
				}
				//Proceso de diagonales de izquierda a derecha de arriba hacia abajo
				dnaO[i+x]+=dna[n-x].charAt(y);
				if(i+x!=j-x)
					dnaO[j-x]+=dna[y].charAt(n-x);
				
				if(dnaV[i+x]==null){
					dnaV[i+x]="";
				}
				if(dnaV[j-x]==null){
					dnaV[j-x]="";
				}
				dnaV[i+x]+=dna[x].charAt(y);
				if(i+x!=j-x)
				dnaV[j-x]+=dna[n-x].charAt(n-y);
				
				i++;
				j--;
			}
		}
		String aes="AAAA";
		String tes="TTTT";
		String ces="CCCC";
		String ges="GGGG";
		int cantMutaciones=0;
		//revisamos matrices 
		for(int x=0;x<dna.length;x++){
			if( dna[x].contains(aes)||
				dna[x].contains(tes)||
				dna[x].contains(ces)||
				dna[x].contains(ges)){
				cantMutaciones ++;
			}
			if(cantMutaciones>1)
			{
				return true;
			}
			if( dnaT[x].contains(aes)||
				dnaT[x].contains(tes)||
				dnaT[x].contains(ces)||
				dnaT[x].contains(ges)){
					cantMutaciones ++;
				}
				if(cantMutaciones>1)
				{
					return true;
				}
			
		}
		//revisamos diagonales
		for(int x=0;x<dnaO.length;x++){
			if( dnaO[x].contains(aes)||
				dnaO[x].contains(tes)||
				dnaO[x].contains(ces)||
				dnaO[x].contains(ges)){
					cantMutaciones ++;
				}
				if(cantMutaciones>1)
				{
					return true;
				}
				if( dnaO[x].contains(aes)||
					dnaO[x].contains(tes)||
					dnaO[x].contains(ces)||
					dnaO[x].contains(ges)){
						cantMutaciones ++;
					}
					if(cantMutaciones>1)
					{
						return true;
					}
		}

			return false;
		}
}
