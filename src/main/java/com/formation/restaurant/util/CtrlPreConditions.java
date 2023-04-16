package com.formation.restaurant.util;

import com.formation.restaurant.exceptions.RessourceNotFoundException;
import com.formation.restaurant.models.Restaurant;

// classe non modifiable
public final class  CtrlPreConditions {
    public static Restaurant checkfound(Restaurant restaurant){
        if(restaurant == null){
            throw new RessourceNotFoundException();
        }
        return restaurant;
    }
}
