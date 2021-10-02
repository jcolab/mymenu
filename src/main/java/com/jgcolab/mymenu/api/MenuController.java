package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.*;
import com.jgcolab.mymenu.repository.MenuRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MenuController {

	@Autowired private MenuRepository menuRepository;
	@Autowired private MenuService menuService;

	@ApiOperation("Return all menus.")
	@GetMapping (value = "/menus", produces = "application/json")
	public List<MenuDTO> listMenus () {
		return menuService.getAllMenus();
	}

	@ApiOperation("Return a menu by provided weekday.")
	@GetMapping(value = "/menu/{weekday}", produces = "application/json")
	public List<Optional<Menu>> listMenuByWeekday (@PathVariable("weekday") Weekday weekday) {return menuRepository.findByWeekday(weekday);}

	@ApiOperation("Create a new menu.")
	@PostMapping (value = "/menu", produces = "application/json")
	@ResponseStatus (HttpStatus.CREATED)
	@Transactional
	public MenuDTO registerMenu(@RequestBody Menu menu) {
		return menuService.registerMenu(menu);
	}

	@ApiOperation("Update a menu by ID.")
	@PutMapping (value = "/menu/{id}", produces = "application/json")
	@Transactional
	public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @Validated @RequestBody Menu newMenu) {
		Optional<Menu> oldMenu = menuRepository.findById(id);
		if (oldMenu.isPresent()) {
			oldMenu.get().setDescription(newMenu.getDescription());
			oldMenu.get().setMealType(newMenu.getMealType());
			oldMenu.get().setWeekday(newMenu.getWeekday());
			for (Ingredients newIngredients : newMenu.getIngredients()) {
				for (Ingredients oldIngredients: oldMenu.get().getIngredients()) {
					if (!newIngredients.getDescription().equals(oldIngredients.getDescription())) {
						oldIngredients.setDescription(newIngredients.getDescription());
					}
				}

			}
			menuRepository.save(oldMenu.get());
			return new ResponseEntity<>(oldMenu.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation("Delete a menu by ID.")
	@DeleteMapping (value = "/menu/{id}", produces = "application/json")
	@Transactional
	public ResponseEntity<Menu> removeById(@PathVariable Long id) {
		Optional<Menu> menu = menuRepository.findById(id);
		if (menu.isPresent()) {
			menuRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
