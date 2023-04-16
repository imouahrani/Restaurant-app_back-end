package com.formation.restaurant.rest;

import com.formation.restaurant.exceptions.RessourceNotFoundException;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import com.formation.restaurant.util.CtrlPreConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
    // il faut injecter via autowired sinon ça sera un null pointer exception ! car l'objet est vide
    @Autowired
    private RestaurantService restoService;

    @GetMapping
    public List<Restaurant> findAll(){
    // comment à partir de ce controleur on aura accès au service de spring ? => injection de dépendances
        return restoService.findAll();
    }
    // ajouter le @GetMapping pour accéder via Insomnia
    @GetMapping("/{id}")
    public Restaurant findById(@PathVariable("id") String identifiant){
        // comment à partir de ce controleur on aura accès au service de spring ? => injection de dépendances
        Restaurant reponse = restoService.findById(identifiant);
        CtrlPreConditions.checkfound(reponse);
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
