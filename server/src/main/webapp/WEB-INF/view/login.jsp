<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project Create</title>
    <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
</head>
<body>

    <form method="post" action="spring_security_check" class="ui-form">
        <h3 class="whiteTextOverride">${message}</h3>
        <h3>Log In</h3>
        <div class="form-row">
            <input type="text"  id="name" name="username" required autocomplete="off"><label for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="password"  id="password" name="password" required autocomplete="off"><label for="password">Password</label>
        </div>
        <p><input type="submit" value="LogIn"></p>
    </form>

</body>
</html>