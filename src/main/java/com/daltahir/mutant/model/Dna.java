package com.daltahir.mutant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dna {
@JsonProperty("dna")
private String[] dna;

public String[] getDna() {
	return dna;
}

public void setDna(String[] dna) {
	this.dna = dna;
}

}
