package com.plazza.model;

import java.math.BigDecimal;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="foodstuffs")
@Getter
@Setter
@NoArgsConstructor
public class CoolStuffs {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int Id;
	private String Name;
	private String Image;
	private String Label;
	private BigDecimal Price;
	private String Description;
	private String category;

}
