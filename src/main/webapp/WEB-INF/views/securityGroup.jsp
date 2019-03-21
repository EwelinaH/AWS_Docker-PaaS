<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security Group</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>

<div class="content">
<form method="post">

    <label type="nameId">SG name</label>
    <input type="text" name="group_name" id="nameId" class="form-control" value="GRtestowa">

    <label type="descId">SG description</label>
    <input type="text" name="group_desc" id="descId" class="form-control" value="GRtestowa1">


    <input type="submit" value="OK" class="btn btn-primary">


</form>
</div>
</body>
</html>