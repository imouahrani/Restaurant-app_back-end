package com.formation.restaurant.rest;

import com.formation.restaurant.models.Menu;
import com.formation.restaurant.services.MenuService;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
