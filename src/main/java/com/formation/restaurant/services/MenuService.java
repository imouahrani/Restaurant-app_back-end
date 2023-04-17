package com.formation.restaurant.services;

import com.formation.restaurant.models.Menu;

import java.util.Map;
import java.util.Set;

public interface MenuService {
    public Set<Menu> findAllOfRestaurant(String idRestaurant);

    public Menu findById(String id);

    public String create(String idRestaurant, Menu menu);

    public void update(String id, Menu menu);

    void partialUpdate(String id, Map<String, Object> updates);

    void deleteById(String idRestaurant, String idMenu);
}
