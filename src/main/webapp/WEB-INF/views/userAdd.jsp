<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="content">

<div class="row">
    <div class="z-depth-3, col s4 offset-s4">
        <form method="post">

            <form:form method="post" modelAttribute="user">

                Login : <br><form:input type="text" path="userName"/><br>
                <form:errors path="userName"/><br>

                Password : <br><form:input type="password" path="password"/><br>
                <form:errors path="password"/><br>

                Email : <br><form:input type="text" path="email"/><br>
                <form:errors path="email"/><br>
                <center>
                    <input type="submit" class="waves-effect waves-light btn" value="Add User">
                </center>
            </form:form>

        </form>
    </div>
</div>
</div>
</body>
</html>