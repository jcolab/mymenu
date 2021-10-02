package com.jgcolab.mymenu.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
    @Enumerated (EnumType.STRING) private MealType mealType;
    @Enumerated (EnumType.STRING) private Weekday weekday;
	@OneToMany(targetEntity= Ingredients.class, cascade=CascadeType.ALL, orphanRemoval = true)
	private List<Ingredients> ingredients;

	public Menu(String description, MealType mealType, Weekday weekday, List<Ingredients> ingredients) {
		this.description = description;
		this.mealType = mealType;
		this.weekday = weekday;
		this.ingredients = ingredients;
	}
	public Menu(String description, MealType mealType, Weekday weekday) {
		this.description = description;
		this.mealType = mealType;
		this.weekday = weekday;
	}
}
