package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.MenuRepository;
import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Menu;
import com.formation.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class MenuServiceImpl implements MenuService {
    // le restoRepository est vide pour l'instant on aura un null pointer
    @Autowired
    private RestaurantRepository restoRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public Set<Menu> findAllOfRestaurant(String idRestaurant) {
        // réccupérer les réstaurants puis les menus des réstaurants
        return restoRepository.findById(idRestaurant).get().getMenus();
    }

    @Override
    public Menu findById(String id) {
        // pour accéder à la table menu il faudra créer le repository via le dao
        if(menuRepository.findById(id).isPresent()){
            return menuRepository.findById(id).get();
        }
        return null;
    }
}
