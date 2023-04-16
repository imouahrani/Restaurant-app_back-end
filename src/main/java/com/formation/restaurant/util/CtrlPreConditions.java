package com.formation.restaurant.util;

import com.formation.restaurant.exceptions.RessourceNotFoundException;


// classe non modifiable
// passer n'importe quel objet pas que le restaurant mais aussi le menu
// rendre la méthode générique
// tester si l'objet est null sinon retourner un not found exception
public final class  CtrlPreConditions {
    public static <T> T  checkfound( T object){
        if(object == null){
            throw new RessourceNotFoundException();
        }
        return object;
    }
}
