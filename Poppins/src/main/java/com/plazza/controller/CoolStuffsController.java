package com.plazza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.plazza.model.CoolStuffs;
import com.plazza.repository.CoolStuffsRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/foodstuffs")
public class CoolStuffsController {
		
		@Autowired
		private CoolStuffsRepo coolStuffsRepo;
		
		//get all food stuffs
		@GetMapping
		public List <CoolStuffs> getAllFoodstuffs(){
			return coolStuffsRepo.findAll();
		}
		
		//create foodstuffs
		@PostMapping
		public CoolStuffs createFoodstuffs(@RequestBody CoolStuffs coolStuffs) {
			return coolStuffsRepo.save(coolStuffs);
		}
		
		//get by id
		@GetMapping("/{id}")
		public ResponseEntity<CoolStuffs> getFoodstuffsById(@PathVariable int id){
			CoolStuffs coolStuffs = coolStuffsRepo.findById(id)
					.orElseThrow();
			return ResponseEntity.ok(coolStuffs);
		}
		
		
		@GetMapping("/category/{category}")
		public ResponseEntity<List<CoolStuffs>> getFoodstuffsByCategory(@PathVariable String category){
			List <CoolStuffs> coolStuffs = coolStuffsRepo.findByCategory(category);
			
			return new ResponseEntity<List<CoolStuffs>>((HttpStatusCode) coolStuffs);
		}

}
