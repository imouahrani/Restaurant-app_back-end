package com.formation.restaurant.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "restaurant")
@Entity
public class Restaurant {
    @Id
    @GeneratedValue(generator =  "system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String id;
    private String nom;
    private String adresse;
    // un restaurant contient une liste de menu
    // la liste Set est une collection unique car on peut pas avoir 2 menus identiques
    // quelle est la relation entre un menu et un restaurant ? un restaurant contient plusieurs menus
    // une table de jointure sera créer entre le restaurant et les menus en BDD
    // si on supprime un restaurant il faudra supprimer tous ses menus = cascade pour éviter d'avoir des menus orphelins qui seront jamais remontés

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Menu> menus = new HashSet<Menu>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
