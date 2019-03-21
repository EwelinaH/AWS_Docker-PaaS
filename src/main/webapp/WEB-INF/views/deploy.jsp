<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload File</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>
<div class="content">

    <form method="POST">

        Server IP: <input type="text" name="serverIP" ><br /> <br />

        File name: <input type="file" name="warName" ><br />


        <input type="submit" value="Deploy your app"> Press here to upload the file!
    </form>
</div>

</body>
</html>
