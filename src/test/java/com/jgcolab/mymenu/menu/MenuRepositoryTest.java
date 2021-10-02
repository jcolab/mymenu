package com.jgcolab.mymenu.menu;

import com.jgcolab.mymenu.domain.Menu;
import com.jgcolab.mymenu.domain.Ingredients;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.jgcolab.mymenu.domain.MealType.DINNER;
import static com.jgcolab.mymenu.domain.Weekday.SATURDAY;
import static com.jgcolab.mymenu.domain.Weekday.SUNDAY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class MenuRepositoryTest {

    @Autowired private MenuRepository menuRepository;

    @Test
    void itShouldCheckIfMenuExists() {
        //given
        Ingredients ingredients = new Ingredients("Onion");
        List<Ingredients> listOfIngredients = new ArrayList<>();
        listOfIngredients.add(ingredients);
        Menu menu = new Menu("Breakfast", DINNER, SUNDAY, listOfIngredients);menuRepository.save(menu);

        //when
       List<Optional<Menu>> menuToTest = menuRepository.findByWeekday(SUNDAY);

        //then
        assertThat(menuToTest).isNotNull();
    }

    @Test
    void itShouldCheckIfSaturdayMenuDoesntExists() {
        //given
        Ingredients ingredients = new Ingredients("Onion");
        List<Ingredients> listOfIngredients = new ArrayList<>();
        listOfIngredients.add(ingredients);
        Menu menu = new Menu("Breakfast", DINNER, SUNDAY, listOfIngredients);menuRepository.save(menu);

        //when
        List<Optional<Menu>> menuByWeekday = menuRepository.findByWeekday(SUNDAY);

        //then
        assertThat(menuByWeekday.get(0).get().getWeekday()).isNotEqualTo(SATURDAY);
    }

    @Test
    void itShouldCheckIfIngredientsAreNull(){
        //given
        Menu menu = new Menu("Breakfast", DINNER, SUNDAY);menuRepository.save(menu);

        //when
        List<Optional<Menu>> menuToTest = menuRepository.findByWeekday(SUNDAY);

        //then
        assertThat(menuToTest.get(0).get().getIngredients()).isNull();
    }
}
