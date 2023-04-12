package com.formation.restaurant.rest;

import com.formation.restaurant.exceptions.RessourceNotFoundException;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(reponse == null){
            throw new RessourceNotFoundException();
        }
        return reponse;
    }
}
