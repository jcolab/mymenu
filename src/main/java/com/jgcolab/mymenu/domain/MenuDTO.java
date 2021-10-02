package com.jgcolab.mymenu.domain;

import lombok.*;

import java.util.List;

@Getter @Setter
public class MenuDTO {
    private Long id;
    private String description;
    private MealType mealType;
    private Weekday weekday;
    private List<Ingredients> ingredients;
}
