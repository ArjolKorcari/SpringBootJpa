package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Alien;
// ky eshte nje inteface qe na lejon ne te perdorim metodat e nje repository 
@Repository
public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
	List<Alien> findByTech(String tech );// kto jan metoda qe i mer ne menyr automatike pa ber asgje
	List<Alien> findByAidGreaterThan(int aid);// dhe kjo
	
	
	
	// nese duam qe te bejm metoda te tjera qe ky nuk  i mer dot perdorim nje anotatiom @Query
	
	@Query("from Alien where tech=?1 order by aname ")
	List<Alien> findByTechSorted(String tech);
	
	

}
