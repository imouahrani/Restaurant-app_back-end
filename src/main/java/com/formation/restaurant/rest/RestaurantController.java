package com.formation.restaurant.rest;

import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin("http://localhost:4200")
@CrossOrigin("*")
@RequestMapping("/restaurants")
public class RestaurantController {
    // il faut injecter via autowired sinon ça sera un null pointer exception ! car l'objet est vide
    @Autowired
    private RestaurantService restoService;

    @GetMapping
    public List<Restaurant> findAll() {
        List<Restaurant> restaurants = restoService.findAll();
        // créer un link pour accéder au détails d'un restaurant
        for (Restaurant restaurant : restaurants) {
            Link selfLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(restaurant.getId()).withSelfRel();
            restaurant.add(selfLink);
        }
        return restaurants;
    }

    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant) {
        Restaurant reponse = restoService.findById(identifiant);
        CtrlPreConditions.checkfound(reponse);
        // créer un link pour accéder au menu d'un restaurant
        Link menusLink = WebMvcLinkBuilder.linkTo(RestaurantController.class).slash(reponse.getId()).slash("menus").withRel("menus");
        reponse.add(menusLink);
        return reponse;
    }
    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public String create(@RequestBody Restaurant restaurant){
        return restoService.create(restaurant);
    }
    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable("id") String identifiant, @RequestBody Restaurant restaurant){
        CtrlPreConditions.checkfound(restoService.findById(identifiant));
        restoService.update(identifiant, restaurant);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable("id") String identifiant, @RequestBody Map<String,Object> updates){
        CtrlPreConditions.checkfound(restoService.findById(identifiant));
        restoService.partialUpdate(identifiant, updates);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") String identifiant){
        CtrlPreConditions.checkfound(restoService.findById(identifiant));
        restoService.deleteById(identifiant);
    }
}
