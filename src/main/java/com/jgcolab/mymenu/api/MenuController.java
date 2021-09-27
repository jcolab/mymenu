package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.Ingredients;
import com.jgcolab.mymenu.domain.Menu;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired private MenuRepository menuRepository;

	@GetMapping
	public List<Menu> listMenus () {
		return menuRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Menu> listMenuById (@PathVariable Long id) {
		return menuRepository.findById(id);
	}

	@PostMapping
	@ResponseStatus (HttpStatus.CREATED)
	@Transactional
	public Menu registerMenu(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}

	@PutMapping ("/{id}")
	@Transactional
	public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @Validated @RequestBody Menu newMenu) {
		Optional<Menu> oldMenu = menuRepository.findById(id);
		if (oldMenu.isPresent()) {
			oldMenu.get().setDescription(newMenu.getDescription());
			oldMenu.get().setMealType(newMenu.getMealType());
			oldMenu.get().setWeekday(newMenu.getWeekday());
			for (Ingredients newIngredients : newMenu.getIngredients()) {
				for (Ingredients oldIngredients: oldMenu.get().getIngredients()) {
					if (!newIngredients.getName().equals(oldIngredients.getName()) && !newIngredients.getDescription().equals(oldIngredients.getDescription())
					|| !newIngredients.getName().equals(oldIngredients.getName()) && newIngredients.getDescription().equals(oldIngredients.getDescription())
					|| newIngredients.getName().equals(oldIngredients.getName()) && !newIngredients.getDescription().equals(oldIngredients.getDescription())) {
						oldIngredients.setName(newIngredients.getName());
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

	@DeleteMapping ("/{id}")
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
