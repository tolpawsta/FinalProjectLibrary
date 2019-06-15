<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Palw
  Date: 11.06.2019
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.journal.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.min.css"/>
    <title>All Users</title>
</head>
<body>
<table class="table table-hover">
    <tr class="table-active">
        <th scope="col">
            <span style="color: ${cookie.color.value}"> User name</span></th>
        <th><span style="color: ${cookie.color.value}">Birth Date</span></th>
    </tr>
    <c:forEach items="$users" var="user">
    <tr class="table-secondary">
        <td>${user.firstname}</td>
        <td>${user.lastname}</td>
        <td>${user.birthday}</td>

    </tr>
    </c:forEach>
</table>

<form method="get" action="${pageContext.request.contextPath}/login">
    <button type="submit" class="btn btn-primary" name="logout">Logout</button>

</form>


<div class="col col-lg-4">
    <div class="bs-component">
        <form method="post" action="${pageContext.request.contextPath}/account">
            <div class="form-group">
                <label for="exampleSelect1">Color select</label>
                <select name="color"
                        class="form-control" id="exampleSelect1">
                    <option value="red">red</option>
                    <option value="green">green</option>
                    <option value="yellow">yellow</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </div>
</div>

</body>
</html>
