package com.formation.restaurant.rest;

import com.formation.restaurant.models.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class RestaurantController {
    @GetMapping("/restaurants")
    public List<Restaurant> findAll(){
        // créer la liste qui va contenir les différents objets
        List<Restaurant> liste = new ArrayList<Restaurant>();

        // Créer un premier objet nommé rest1
        Restaurant resto1 = new Restaurant();
        // ajouter des informations à cet objet créé
        resto1.setId("resto1");
        resto1.setNom("Le Restaurant");
        resto1.setAdresse("4 Boulevard de Paris 4400 Nantes");

        // ajouter l'objet à la liste
        liste.add(resto1);

        // Créer un second objet nommé rest2
        Restaurant resto2 = new Restaurant();
        // ajouter des informations à cet objet créé
        resto2.setId("resto2");
        resto2.setNom("Le Restaurant 02");
        resto2.setAdresse("03 Rue des Liondards, 63000 Clermont-Ferrand");

        // ajouter l'objet à la liste
        liste.add(resto2);
        return liste;
    }
}
