<%@ page import="com.example.demo.model.*" %>

<h1>Coucou</h1>

<table class="table custom-table">
    <thead>
        <tr>  
            <th scope="col">Nom</th>
            <th scope="col">Prix</th>
        </tr>
    </thead>
    <tbody>

        <% Produit[] produits =(Produit[])(request.getAttribute("lesProduits")) ;
                        for (Produit produit :produits) { %>
                        <tr scope="row">
                            <td><%= produit.getNomProduit() %></td>

                            <td><%= produit.getPrixProduit() %></td>
                            
                             
                        </tr>
                        <tr class="spacer"><td colspan="100"></td></tr>
                      <% } %>
                      
                    </tbody>
                  </table>