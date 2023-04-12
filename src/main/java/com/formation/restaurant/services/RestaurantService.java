package com.formation.restaurant.services;

import com.formation.restaurant.models.Restaurant;

import java.util.*;

public interface RestaurantService {
    public List<Restaurant> findAll();

    Restaurant findById(String id);
}
