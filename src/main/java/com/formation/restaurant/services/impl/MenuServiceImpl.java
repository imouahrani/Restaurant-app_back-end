package com.formation.restaurant.services.impl;

import com.formation.restaurant.dao.MenuRepository;
import com.formation.restaurant.dao.RestaurantRepository;
import com.formation.restaurant.models.Menu;
import com.formation.restaurant.models.Restaurant;
import com.formation.restaurant.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
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

    @Override
    public String create(String idRestaurant, Menu menu) {
        Restaurant restoEntity = restoRepository.findById(idRestaurant).get();
        restoEntity.getMenus().add(menu);
        restoRepository.save(restoEntity);
        // chercher dans le resto entity le menu tel que le menu = paramètre de la méthode
        // et vu que c'est un set, ça retourne le premier recherché
        // implémenter la méthode equal sur le modèle Menu
        Menu menuEntity = restoEntity.getMenus().stream().filter(m -> m.equals(menu)).findFirst().get();
        return menuEntity.getIdentifiant();
    }

    @Override
    public void update(String id, Menu menu) {
        menu.setIdentifiant(id);
        menuRepository.save(menu);
    }

    @Override
    public void partialUpdate(String id, Map<String, Object> updates) {
        Menu menuToUpdate = menuRepository.findById(id).get();
        for (String key : updates.keySet()) {
            switch (key) {
                case "entrees": {
                    menuToUpdate.setEntrees((String) updates.get(key));
                    break;
                }
                case "plats": {
                    menuToUpdate.setPlats((String) updates.get(key));
                    break;
                }
                case "desserts": {
                    menuToUpdate.setDesserts((String) updates.get(key));
                    break;
                }
            }

        }
        menuRepository.save(menuToUpdate);
    }
}
