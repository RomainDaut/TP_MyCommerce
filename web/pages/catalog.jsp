<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shaman
  Date: 2019-05-29
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Catalog</title>
</head>
<body>
<!-- Table  -->
<table class="table table-bordered">
    <!-- Table head -->
    <thead>
    <tr>
        <th>
            <!-- Default unchecked -->
        </th>
        <th>Descriptif</th>
        <th>Prix</th>
        <th>Quantité en Stock</th>
    </tr>
    </thead>
    <!-- Table head -->

    <!-- Table body -->
    <tbody>
    <c:forEach items="${items.items}" var="biloute">
        <tr>
            <th scope="row">
                <!-- Default unchecked -->
                <input type="checkbox" name="Produits" value="${biloute.key}">
            </th>
            <td>${biloute.value.descriptif}</td>
            <td>${biloute.value.prix}</td>
            <td>${biloute.value.qteenstock}</td>
        </tr>
    </c:forEach>
    </tbody>
    <!-- Table body -->
</table>
<input type="submit"
       value="Ajouter au panier de depenses de trucs inutiles, que tu vas acheter, car tu fais partie de cette societe de consommation de MERDE"
       style="height:34px;
    margin:0 auto;
    margin-right:10px;
    float:left;">
<!-- Table  -->

</body>
</html>
