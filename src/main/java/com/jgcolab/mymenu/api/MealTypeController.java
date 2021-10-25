package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.MealType;
import com.jgcolab.mymenu.domain.MealTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (produces = "application/json")
public class MealTypeController {

    private MealTypeService mealTypeService;

    public MealTypeController (MealTypeService mealTypeService) { this.mealTypeService = mealTypeService;}

    @ApiOperation("Retrieve all mealTypes.")
    @GetMapping(value = "/mealtypes")
    public List<MealType> getMealTypes() {
        return mealTypeService.getMealTypes();
    }
}
