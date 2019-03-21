<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>

<div class="content">

<div class="row">
    <div class="col s8 offset-s2">
        <div class="card-panel grey lighten-5 z-depth-1">
            <table>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Password</th>
                    <th>Email</th>


                </tr>
                <c:forEach items="${users}" var="user">

                    <tr>
                        <td>${user.id}</td>
                        <td>${user.userName}</td>
                        <td>${user.password}</td>
                        <td>${user.email}</td>

                    </tr>

                </c:forEach>

            </table>
        </div>
    </div>
</div>
</div>

</body>
</html>
