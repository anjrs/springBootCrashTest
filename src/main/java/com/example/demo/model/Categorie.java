package com.example.demo.model;

import java.sql.Connection;
import jakarta.persistence.*;


import orm.DynamicORM;

public class Categorie extends DynamicORM<Categorie>
{
    @Id
    Integer Id;
    String nom_categorie;

    //contrsuctor
    public Categorie(Integer id, String nom_categorie)
    {
        Id = id;
        this.nom_categorie = nom_categorie;
    }
    public Categorie()
    {

    }

    // Getters et Setters
    public Integer getId()
    { 
        return Id;
    }   
    public String getNomCategorie()
    { 
        return nom_categorie;
    }
    public void setNomCategorie(String nom_categorie)
    { 
        this.nom_categorie = nom_categorie;
    }
    
    public Categorie[] getAllCategorie(Connection connection) throws Exception
    {
        Categorie instance = new Categorie();
        Categorie[] lesCategories = instance.select(connection, false);
        return lesCategories;
    }
}
