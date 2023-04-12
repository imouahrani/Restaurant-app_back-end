package com.formation.restaurant.services.impl;

import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Override
    public List<Restaurant> findAll() {
        // créer la liste qui va contenir les différents objets
        List<Restaurant> liste = new ArrayList<Restaurant>();

        // Créer un premier objet nommé rest1
        Restaurant resto1 = new Restaurant();
        // ajouter des informations à cet objet créé
        resto1.setId("resto1");
        resto1.setNom("Le Restaurant");
        resto1.setAdresse("44 Boulevard de Paris 4400 Nantes");

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
