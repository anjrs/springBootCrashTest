<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Categorie" %>

<!DOCTYPE html>
<html>
<head>
    <title>Insertion Categorie</title>
</head>
<body>
    <h1><%= request.getAttribute("nom_produit") %></h1>
    <form action="/categories/save" method="post">
        <input type="hidden" name="idProduit" value="<%= request.getAttribute("idProduit") %>" />
        <label for="categorie">Choisir une catégorie:</label>
        <select name="idCategorie" id="categorie">
            <%
                Categorie[] lesCategories = (Categorie[]) request.getAttribute("lesCategories");
                if (lesCategories != null) {
                    for (Categorie categorie : lesCategories) {
            %>
                        <option value="<%= categorie.getId() %>"><%= categorie.getNomCategorie() %></option>
            <%
                    }
                }
            %>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>
