package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class MenuController {
	private final MenuService menuService;

	@Autowired public MenuController (MenuService menuService) {this.menuService = menuService;}

	@ApiOperation("Return all menus.")
	@GetMapping (value = "/menus", produces = "application/json")
	public List<Menu> listMenus () {
		return menuService.getAllMenus();
	}

	@ApiOperation("Return a menu by provided weekday.")
	@GetMapping(value = "/menu/{weekday}", produces = "application/json")
	public List<Optional<Menu>> listMenuByWeekday (@PathVariable("weekday") Weekday weekday) {return menuService.getMenuByWeekday(weekday);}

	@ApiOperation("Create a new menu.")
	@PostMapping (value = "/menu", produces = "application/json")
	@ResponseStatus (HttpStatus.CREATED)
	public Menu registerMenu(@RequestBody Menu menu) {
		return menuService.registerMenu(menu);
	}

	@ApiOperation("Update a menu by ID.")
	@PutMapping (value = "/menu/{id}", produces = "application/json")
	public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @Validated @RequestBody Menu newMenu) {
		return menuService.updateMenu(id, newMenu);
	}

	@ApiOperation("Delete a menu by ID.")
	@DeleteMapping (value = "/menu/{id}", produces = "application/json")
	public ResponseEntity removeById(@PathVariable Long id) {
		return menuService.removeMenu(id);
	}
}
