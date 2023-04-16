package com.formation.restaurant.services;

import com.formation.restaurant.models.Restaurant;

import java.util.*;

public interface RestaurantService {
    public List<Restaurant> findAll();

    Restaurant findById(String id);

    String create(Restaurant restaurant);

    void update(String identifiant, Restaurant restaurant);

    void partialUpdate(String identifiant, Map<String, Object> updates);

    void deleteById(String identifiant);
}
