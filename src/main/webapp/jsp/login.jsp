<%--
  Created by IntelliJ IDEA.
  User: Palw
  Date: 14.06.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.journal.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.min.css"/>
    <title>Login</title>
</head>
<body>
<form _lpchecked="1" method="post" action="${pageContext.request.contextPath}/account">
    <fieldset>
        <legend>Login</legend>
        <div class="form-group">
            <div class="col-sm-3">
                <label for="login" class="col-form-label">Login</label>
                <input type="text" class="form-control"
                       placeholder="Login" id="login"
                       name="login">
            </div>
        </div>
        <div class="form-group col-sm-3">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password"
                   style="background-repeat: no-repeat; background-attachment: scroll; background-size: 16px 18px; background-position: 98% 50%; cursor: auto;">
        </div>
        <div class="row">
            <div class="form-group col-sm-1">
                <button type="submit" class="btn btn-primary">Login</button>
            </div>

        </div>

    </fieldset>
</form>
<form _lpchecked="1" method="get" action="${pageContext.request.contextPath}/registration">
    <div class="form-group col-sm-1">
        <button type="submit" class="btn btn-primary">Registration</button>
    </div>
</form>
</body>
</html>
