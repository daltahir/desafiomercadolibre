package com.daltahir.mutant.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stats {
	@JsonProperty("count_mutant_dna")
	private long countMutant;
	@JsonProperty("count_human_dna")
	private long countHuman;
	@JsonProperty("ratio")
	private double ratioMutant;
	public long getCountMutant() {
		return countMutant;
	}
	public void setCountMutant(long countMutant) {
		this.countMutant = countMutant;
	}
	public long getCountHuman() {
		return countHuman;
	}
	public void setCountHuman(long countHuman) {
		this.countHuman = countHuman;
	}
	public double getRatioMutant() {
		return ratioMutant;
	}
	public void setRatioMutant(double ratioMutant) {
		this.ratioMutant = ratioMutant;
	}
	
}
