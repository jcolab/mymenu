package com.jgcolab.mymenu.api;

import com.jgcolab.mymenu.domain.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (produces = "application/json")
public class MenuController {
	private final MenuService menuService;

	public MenuController (MenuService menuService) {this.menuService = menuService;}

	@ApiOperation("Return all menus.")
	@GetMapping (value = "/menus")
	public List<Menu> listMenus () {
		return menuService.getAllMenus();
	}

	@ApiOperation("Return a menu by provided weekday.")
	@GetMapping(value = "/menu")
	public List<Optional<Menu>> listMenuByWeekday (@RequestParam(value = "weekday") Weekday weekday) {return menuService.getMenuByWeekday(weekday);}

	@ApiOperation("Return a menu by provided id.")
	@GetMapping (value = "/menu/{id}")
	public Optional<Menu> listMenuById (@PathVariable ("id") Long id) {return menuService.getMenuById(id);}

	@ApiOperation("Create a new menu.")
	@PostMapping (value = "/menu")
	@ResponseStatus (HttpStatus.CREATED)
	public Menu registerMenu(@RequestBody Menu menu) {
		return menuService.registerMenu(menu);
	}

	@ApiOperation("Update a menu by ID.")
	@PutMapping (value = "/menu/{id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable Long id, @Validated @RequestBody Menu newMenu) {
		return menuService.updateMenu(id, newMenu);
	}

	@ApiOperation("Delete a menu by ID.")
	@DeleteMapping (value = "/menu/{id}")
	public ResponseEntity removeById(@PathVariable Long id) {
		return menuService.removeMenu(id);
	}
}
