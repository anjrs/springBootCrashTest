package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUIT")
public class Produit
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(nullable = false)
    String nom_produit;

    @Column(nullable = false)
    private double prix_produit;

    // Getters et Setters
    public Integer getId() { return Id; }
    public String getNomProduit() { return nom_produit; }
    public void setNomProduit(String nom_produit) { this.nom_produit = nom_produit; }
    public double getPrixProduit() { return prix_produit; }
    public void setPrixProduit(double prix_produit) { this.prix_produit = prix_produit; }
}
