package com.jgcolab.mymenu.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "menu_id")
	private Long id;
	private String description;
	private MealType mealType;
	private Weekday weekday;
	@JoinColumn (name = "ingredients_id")
	@OneToMany(targetEntity=Ingredients.class, cascade=CascadeType.PERSIST)
	private List<Ingredients> ingredients;

	public Menu(){}
	public Menu(String description, MealType mealType, Weekday weekday, List<Ingredients> ingredients) {
		this.description = description;
		this.mealType = mealType;
		this.weekday = weekday;
		this.ingredients = ingredients;
	}
}
