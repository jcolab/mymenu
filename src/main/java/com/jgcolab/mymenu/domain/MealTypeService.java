package com.jgcolab.mymenu.domain;

import com.jgcolab.mymenu.repository.MealTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealTypeService {

    private MealTypeRepository mealTypeRepository;

    MealTypeService (MealTypeRepository mealTypeRepository) { this.mealTypeRepository = mealTypeRepository;}

    public List<MealType> getMealTypes() {
        return mealTypeRepository.findAll();
    }
}
