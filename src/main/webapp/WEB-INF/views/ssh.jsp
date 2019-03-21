
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>SSH KEY created</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>

<div class="content">
<form method="post">

    <label type="keyNameId">SSH key name</label>
    <input type="text" name="key_name" id="keyNameId" class="form-control" value="keyName1">

    <input type="submit" value="OK" class="btn btn-primary">

</form>
</div>

</body>
</html>
