package com.daltahir.mutant.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daltahir.mutant.entity.Brain;



public interface IBrainDao extends CrudRepository<Brain, Long>  {
List<Brain> findBydna(String dna);

	int countByisMutant(boolean isMutant);
}
