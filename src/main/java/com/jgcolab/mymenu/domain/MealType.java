package com.jgcolab.mymenu.domain;

import lombok.*;

import javax.persistence.*;

@Entity @Getter @Setter @NoArgsConstructor
public class MealType {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String mealType;

	public MealType(String mealType) {this.mealType = mealType;}
}
