<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AWS Instance</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>
<div class="content">
<form method="post">

    <label type="nameId">Instance name</label>
    <input type="text" name="name" id="nameId" class="form-control" value=${name}>

    <label type="ownerId">Instance owner</label>
    <input type="text" name="owner" id="ownerId" class="form-control" value=${owner}>

    <label type="sshKeyId">SSH Key</label>
    <input type="text" name="keyName" id="sshKeyId" class="form-control" value="jenkins-deploy">


    <input type="submit" value="OK" class="btn btn-primary">


</form>
</div>

</body>
</html>