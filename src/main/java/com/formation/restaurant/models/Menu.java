package com.formation.restaurant.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// table liée
@Table(name = "menus")
@Entity
public class Menu {
    // identifiant généré et unique
    @Id
    @GeneratedValue(generator =  "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")


    private String identifiant;
    private String entrees;
    private String plats;
    private String desserts;




    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEntrees() {
        return entrees;
    }

    public void setEntrees(String entrees) {
        this.entrees = entrees;
    }

    public String getPlats() {
        return plats;
    }

    public void setPlats(String plats) {
        this.plats = plats;
    }

    public String getDesserts() {
        return desserts;
    }

    public void setDesserts(String desserts) {
        this.desserts = desserts;
    }
}
