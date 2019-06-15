<%--
  Created by IntelliJ IDEA.
  User: Palw
  Date: 12.06.2019
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.journal.css"/>
    <link rel="stylesheet" type="text/css" href="css/custom.min.css"/>
</head>
<body>

<form _lpchecked="1" method="post" action="${pageContext.request.contextPath}/account">
    <fieldset>


        <legend>Registration</legend>
        <div class="form-group">
            <div class="col-sm-3">
                <label for="firstname" class="col-form-label">First name</label>
                <input type="text" class="form-control"
                       placeholder="First Name" id="firstname"
                       name="firstname">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-3">
                <label for="lastname" class="col-form-label">Last name</label>
                <input type="text" class="form-control"
                       placeholder="Last Name" id="lastname"
                       name="lastname">
            </div>
        </div>

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
        <div class="form-group">
            <div class="col-sm-3">
                <label for="bithdate" class="col-form-label">Birth Date</label>
                <input type="text" class="form-control"
                       placeholder="Birth Date" id="bithdate"
                       name="bithdate">
            </div>
        </div>
        <div class="form-group col-sm-3">
            <button type="submit" class="btn btn-primary">Registration</button>
        </div>
    </fieldset>
</form>

</body>
</html>
