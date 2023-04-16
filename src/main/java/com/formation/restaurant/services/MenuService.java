package com.formation.restaurant.services;

import com.formation.restaurant.models.Menu;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Set;

public interface MenuService {
    public Set<Menu> findAllOfRestaurant(String idRestaurant);

    Menu findById(String id);
}
