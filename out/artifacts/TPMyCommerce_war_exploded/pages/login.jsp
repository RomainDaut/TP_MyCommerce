<%--
  Created by IntelliJ IDEA.
  User: Shaman
  Date: 2019-05-29
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<form method="post" action="process?action=login">
    <div class="form-group">
        <label for="exampleInputNom">Name</label>
        <input name="nom" type="Nom" class="form-control" id="exampleInputNom" placeholder="Enter Nom">
        <small id="NomHelp" class="form-text text-muted">This is the name you registered with.</small>
    </div>
    <div class="form-group">
        <label for="exampleInputPassword">Password</label>
        <input name="motdepasse" type="password" class="form-control" id="exampleInputPassword" placeholder="Password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
