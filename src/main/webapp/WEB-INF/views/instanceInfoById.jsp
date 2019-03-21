<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Instance Info By ID</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>

<div class="content">

<form method="post" >

    <label type="instanceIdId">Instance id</label>
    <input type="text" name="instanceId" id="instanceId" class="form-control" value="provide instance id">


    <input type="submit" value="OK" class="btn btn-primary">

</form>
</div>

</body>
</html>
