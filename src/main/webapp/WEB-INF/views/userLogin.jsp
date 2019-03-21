<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<html>
<head>
    <title>Title</title>
</head>
<body>

<%--<%@ include file="/WEB-INF/views/header.jspf" %>--%>
<div class="content">

<div class="row">
    <div class="z-depth-3, col s4 offset-s4">
        <form method="post">

            User Name : <br><input type="text" name="userName"/><br>
            Password : <br><input type="password" name="password"/><br>
            <c:if test="${loginFailed == true}">
                <span>Login Failed!</span><br>
            </c:if>
            <center>
                <input type="submit" class="waves-effect waves-light btn" value="Log In">
            </center>
        </form>
        <center>
            <a href="/addUser" class="waves-effect waves-light btn">New User</a>
        </center>
    </div>
</div>
</div>

</body>
</html>