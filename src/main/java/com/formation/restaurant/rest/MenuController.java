package com.formation.restaurant.rest;

import com.formation.restaurant.models.Menu;
import com.formation.restaurant.services.MenuService;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class MenuController {
    // injécter le menu et le restaurant service
    @Autowired
    public MenuService menuService;
    @Autowired
    public RestaurantService restoService;

    @GetMapping("/restaurants/{idResto}/menus")
    // le path variable <=> idResto sur le path @GetMapping = idRestaurant (paramètre)
    public Set<Menu> findAllOfRestaurant(@PathVariable("idResto") String idRestaurant){
        CtrlPreConditions.checkfound(restoService.findById(idRestaurant));
        return  menuService.findAllOfRestaurant(idRestaurant);
    }
    @GetMapping("/menus/{id}")
    public Menu findById(@PathVariable("id") String id){
        Menu reponse = menuService.findById(id);
        CtrlPreConditions.checkfound(reponse);
        return reponse;
    }
    @PostMapping("/restaurants/{idResto}/menus")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String create(@PathVariable("idResto") String idRestaurant, @RequestBody Menu menu) {
        CtrlPreConditions.checkfound(restoService.findById(idRestaurant));
        return menuService.create(idRestaurant, menu);
    }
    @PutMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String id, @RequestBody Menu menu) {
        CtrlPreConditions.checkfound(menuService.findById(id));
        menuService.update(id, menu);
    }
    @PatchMapping("/menus/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String id, @RequestBody Map<String, Object> updates) {
        CtrlPreConditions.checkfound(menuService.findById(id));
        menuService.partialUpdate(id, updates);
    }
    @DeleteMapping("/restaurants/{idResto}/menus/{idMenu}")
    public void delete(@PathVariable("idResto") String idRestaurant, @PathVariable("idMenu") String idMenu) {
        CtrlPreConditions.checkfound(restoService.findById(idRestaurant));
        CtrlPreConditions.checkfound(menuService.findById(idMenu));
        menuService.deleteById(idRestaurant, idMenu);
    }

}
