package com.example.demo.model;

import java.sql.Connection;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.PathVariable;

import orm.DynamicORM;

public class Produit extends DynamicORM<Produit>
{

    @Id
    Integer Id;
    String nom_produit;
    double prix_produit;

    //contrsuctor
    public Produit(Integer id, String nom_produit, double prix_produit)
    {
        Id = id;
        this.nom_produit = nom_produit;
        this.prix_produit = prix_produit;
    }
    public Produit()
    {

    }

    // Getters et Setters
    public Integer getId()
    { 
        return Id;
    }
    public String getNomProduit()
    { 
        return nom_produit;
    }
    public void setNomProduit(String nom_produit)
    { 
        this.nom_produit = nom_produit;
    }
    public double getPrixProduit()
    { 
        return prix_produit;
    }
    public void setPrixProduit(double prix_produit)
    { 
        this.prix_produit = prix_produit;
    }

    //select les produits
    public Produit[] getAllProduit(Connection connection) throws Exception
    {
        Produit instance = new Produit();
        Produit[] lesProduits = instance.select(connection, false);
        return lesProduits;
    }

    public Produit[] getById(Connection connection, @PathVariable Integer Id) throws Exception
    {
        Produit[] lesProduits = new Produit().selectWhere(connection , false , "Id= '" + Id + "'");
        return lesProduits;
    }

    //insertion manuelle
    public void insertProduit(Connection connection , String nom_produit , double prix_produit) throws Exception
    {
        Produit instance = new Produit();
        instance.setNomProduit(nom_produit);
        instance.setPrixProduit(prix_produit);
        instance.insert(connection , false);
    }

    public Produit getProduitById(Connection connection, Integer id) throws Exception
    {
        Produit instance = new Produit();
        Produit[] lesProduits = instance.selectWhere(connection , false, "Id= '" + id + "'");
        if (lesProduits.length > 0)
        {
            return lesProduits[0];
        } 
        else
        {
            return null; // ou vous pouvez lancer une exception si le produit n'est pas trouvé
        }
        
    }

    public Produit getByNom(Connection connection , String nom_produit) throws Exception
    {
        Produit instance = new Produit();
        Produit[] lesProduits = instance.selectWhere(connection , false, "nom_produit= '" + nom_produit + "'");
        if (lesProduits.length > 0)
        {
            return lesProduits[0];
        } 
        else
        {
            return null; // ou vous pouvez lancer une exception si le produit n'est pas trouvé
        }
    }

    //insertion de csv

    
}

