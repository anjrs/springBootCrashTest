package com.example.demo.controller;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.sql.DataSource;


import com.example.demo.model.Produit;

@Controller
@RequestMapping("/produits")

public class ProduitController
{
    
    @Autowired
    DataSource dataSource;

    @GetMapping("/allProduits")
    // @Auth(classSource = RulesConf.class, rule = "isAdmin")
    public String getAllProduit(Model model) throws Exception
    {
        Connection connection = dataSource.getConnection();
        try
        {
            Produit instance = new Produit();
            Produit[] lesProduits = instance.getAllProduit(connection);
            model.addAttribute("lesProduits", lesProduits);
        }
        finally
        {
            if (!connection.isClosed())
            {
                connection.close();
            }
        }
        return "Index";
    }
}
