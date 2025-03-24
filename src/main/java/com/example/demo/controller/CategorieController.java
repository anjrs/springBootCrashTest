package com.example.demo.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Categorie;
import com.example.demo.model.Categorie_Produit;

@Controller
@RequestMapping("/categories")

public class CategorieController
{
   @Autowired
    DataSource dataSource; 

    @GetMapping("/allCategories")
    public String getAllCategorie(Model model , @RequestParam("idProduit") Integer idProduit, @RequestParam("nomProduit") String nomProduit) throws Exception
    {
        Connection connection = dataSource.getConnection();
        try
        {
            Categorie instance = new Categorie();
            Categorie[] lesCategories = instance.getAllCategorie(connection);
            model.addAttribute("lesCategories", lesCategories);
            model.addAttribute("idProduit", idProduit);
            model.addAttribute("nom_produit", nomProduit);
        }
        finally
        {
            if (!connection.isClosed())
            {
                connection.close();
            }
        }
        return "insertionCategorie";
    }

    @PostMapping("/save")
    public String saveCategorie(@RequestParam("idCategorie") Integer idCategorie, @RequestParam("idProduit") Integer idProduit) throws Exception
    {
        Connection connection = dataSource.getConnection();
        try
        {
            Categorie_Produit instance = new Categorie_Produit();
            instance.insertCategorieProduit(connection, idCategorie, idProduit);
            return "redirect:/produits/allProduits";
        }
        finally
        {
            if (!connection.isClosed())
            {
                connection.close();
            }
        }
    }
}
