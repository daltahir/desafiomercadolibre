package com.daltahir.mutant.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brain")
public class Brain implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7856825763546251397L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dna", nullable = false)
	private String dna;
	
	 
	 @Column(name = "ismutant", nullable = false)
	private boolean isMutant;
	public String getDna() {
		return dna;
	}
	public void setDna(String dna) {
		this.dna = dna;
	}
	public boolean isMutant() {
		return isMutant;
	}
	public void setMutant(boolean isMutant) {
		this.isMutant = isMutant;
	}

}
