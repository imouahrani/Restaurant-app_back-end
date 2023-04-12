package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    // Injéction de dépendance afin de réutiliser directement les élément de la bdd
    /**
     * Depuis mon restaurantService j'appelle le repository
     * ce repository va appeler la bdd h2
     */

    @Autowired
    private RestaurantRepository restoRepository;
    @Override
    public List<Restaurant> findAll() {
        // créer la liste qui va contenir les différents objets
        List<Restaurant> liste = new ArrayList<Restaurant>();

        // pour chaque élément de la bdd l'ajouter à la liste
        restoRepository.findAll().forEach(liste::add);
        return liste;
    }
}
