package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Restaurant findById(String id) {
        if(restoRepository.findById(id).isPresent()){
            return restoRepository.findById(id).get();
        }
        return null;
        // findById(id) retourne un optionnal : si il existe en bdd ou pas
    }

    @Override
    public String create(Restaurant restaurant) {
        return restoRepository.save(restaurant).getId();
    }

    @Override
    public void update(String identifiant, Restaurant restaurant) {
        restaurant.setId(identifiant);
        restoRepository.save(restaurant); // mettre à jour tout l'objet restaurant
    }

    @Override
    public void partialUpdate(String identifiant, Map<String, Object> updates) {
        Restaurant restoToUpdate = restoRepository.findById(identifiant).get();
        for(String key : updates.keySet()){
            switch (key){
                case "nom":{
                    restoToUpdate.setNom((String) updates.get(key));
                    break;
                }
                case "adresse":{
                    restoToUpdate.setAdresse((String) updates.get(key));
                    break;
                }
            }
        }
        restoRepository.save(restoToUpdate);
    }

}
