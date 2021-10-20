package com.jgcolab.mymenu.domain;

import com.jgcolab.mymenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Service
public class MenuService {

    private MenuRepository menuRepository;

    MenuService(MenuRepository menuRepository) {this.menuRepository = menuRepository;}

    public List<Menu> getAllMenus() {
        return (menuRepository.findAll());
    }

    public List<Optional<Menu>> getMenuByWeekday(Weekday weekday) {
        return menuRepository.findByWeekday(weekday);
    }

    public Optional<Menu> getMenuById(Long id) {return menuRepository.findById(id);}

    public Menu registerMenu(Menu menu) {return menuRepository.save(menu);}

    public ResponseEntity<Menu> updateMenu(Long id, Menu newMenu) {
        Optional<Menu> oldMenu = menuRepository.findById(id);
        if (oldMenu.isPresent()) {
            oldMenu.get().setDescription(newMenu.getDescription());
            oldMenu.get().setMealType(newMenu.getMealType());
            oldMenu.get().setWeekday(newMenu.getWeekday());
            for (Ingredients newIngredients : newMenu.getIngredients()) {
                for (Ingredients oldIngredients : oldMenu.get().getIngredients()) {
                    if (!newIngredients.equals(oldIngredients)) {
                        oldIngredients.setDescription(newIngredients.getDescription());
                    }
                }
            }
            menuRepository.save(oldMenu.get());
            return new ResponseEntity(oldMenu.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity removeMenu (Long id) {
        Optional menu = menuRepository.findById(id);
        if(menu.isPresent()) {
            menuRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
