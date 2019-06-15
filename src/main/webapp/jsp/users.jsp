<%--
  Created by IntelliJ IDEA.
  User: Palw
  Date: 11.06.2019
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            First name
        </th>
        <th>Last Date</th>
        <th>Birth Date</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr class="table-secondary">
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.birthday}</td>

        </tr>
    </c:forEach>
</table>


</body>
</html>
