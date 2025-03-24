package com.example.demo.model;

import java.sql.Connection;

import jakarta.persistence.Id;
import orm.DynamicORM;

public class Categorie_Produit extends DynamicORM<Categorie_Produit>
{
    @Id
    Integer id;
    Integer id_categorie;
    Integer id_produit;

    //contrsuctor
    public Categorie_Produit(Integer id, Integer id_categorie, Integer id_produit)
    {
        this.id = id;
        this.id_categorie = id_categorie;
        this.id_produit = id_produit;
    }
    public Categorie_Produit()
    {

    }
    // Getters et Setters
    public Integer getId()
    { 
        return id;
    }
    public Integer getIdCategorie()
    { 
        return id_categorie;
    }
    public void setIdCategorie(Integer id_categorie)
    { 
        this.id_categorie = id_categorie;
    }
    public Integer getIdProduit()
    { 
        return id_produit;
    }
    public void setIdProduit(Integer id_produit)
    { 
        this.id_produit = id_produit;
    }

    public void insertCategorieProduit(Connection connection , Integer idCategorie , Integer idProduit) throws Exception
    {
        Categorie_Produit instance = new Categorie_Produit();
        instance.setIdCategorie(idCategorie);
        instance.setIdProduit(idProduit);
        instance.insert(connection, false);
    }
}
