package com.plazza.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plazza.model.CoolStuffs;

@Repository
public interface CoolStuffsRepo extends JpaRepository<CoolStuffs, Integer> {
		
	 List<CoolStuffs> findByCategory(String category);
	    //Optional<CoolStuffs> findById(int Id);
}
