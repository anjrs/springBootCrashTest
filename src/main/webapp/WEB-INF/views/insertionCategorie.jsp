<!-- filepath: c:\Users\USER\Downloads\demo\demo\src\main\webapp\WEB-INF\jsp\insertionCategorie.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insertion Categorie</title>
</head>
<body>
    <h1>${nom_produit}</h1>
    <form action="/categories/saveCategorie" method="post">
        <input type="hidden" name="idCategorie" value="${idCategorie}" />
        <label for="categorie">Choisir une catégorie:</label>
        <select name="categorie" id="categorie">
            <c:forEach var="categorie" items="${lesCategories}">
                <option value="${categorie.id}">${categorie.nom}</option>
            </c:forEach>
        </select>
        <button type="submit">Enregistrer</button>
    </form>
</body>
</html>