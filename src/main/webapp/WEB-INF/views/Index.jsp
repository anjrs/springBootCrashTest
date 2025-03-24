<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertion Produit</title>
</head>
<body>
    <h1 style="text-align: center;">Insertion Produit</h1>
    <form method="post" action="/produits/insertion" method="POST">
        <label for="nom_produit">Nom du produit :</label>
        <input type="text" id="nom_produit" name="nom_produit" required>

        <label for="prix">Prix en Euros :</label>
        <input type="number" id="prix_produit" name="prix_produit" step="0.01" min="0" required>

        <button type="submit">Insérer le produit</button>
    </form>

     <h2 style="text-align: center;">Liste des Produits</h2>
    <table border="1" style="width: 100%; text-align: left;">
        <thead>
            <tr>
                <th>Nom du produit</th>
                <th>Prix</th>
                <th>ID Catégorie</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produit" items="${lesProduits}">
                <tr>
                    <td>${produit.nom_produit}</td>
                    <td>${produit.prix_produit}</td>
                    <td>${produit.idCategorie}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
