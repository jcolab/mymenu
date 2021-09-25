package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.Menu;
import com.jgcolab.mymenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
	public Menu register(@RequestBody Menu menu) {
		return menuRepository.save(menu);
	}
}
