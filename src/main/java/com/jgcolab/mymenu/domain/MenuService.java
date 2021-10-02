package com.jgcolab.mymenu.domain;

import com.jgcolab.mymenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDTO> getAllMenus () {
        return (menuRepository
                .findAll())
                .stream()
                .map(this::convertToMenuDTO)
                .collect(Collectors.toList());
    }

    public MenuDTO registerMenu (Menu menu) {
        return convertToMenuDTO(menuRepository.save(menu));
    }

    private MenuDTO convertToMenuDTO(Menu menu) {
        MenuDTO menuDTO = new MenuDTO();
        menuDTO.setId(menu.getId());
        menuDTO.setDescription(menu.getDescription());
        menuDTO.setMealType(menu.getMealType());
        menuDTO.setWeekday(menu.getWeekday());
        menuDTO.setIngredients(menu.getIngredients());
        return menuDTO;
    }
}
