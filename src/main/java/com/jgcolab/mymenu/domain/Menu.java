package com.jgcolab.mymenu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private MealType mealType;
	private Weekday weekday;
	//private Ingredients ingredients;

	public Menu(){}
	public Menu(String description, MealType mealType, Weekday weekday, Ingredients ingredients) {
		this.description = description;
		this.mealType = mealType;
		this.weekday = weekday;
		//this.ingredients = ingredients;
	}
}
