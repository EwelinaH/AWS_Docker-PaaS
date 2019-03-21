<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>crInst</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>
<div class="content">


<h1>Instance info</h1>


<table>
    <tr>
        <th>Instance ID</th>
        <th>SSH Key name</th>
        <th>Launch Time</th>
        <th>Private IP</th>
        <th>Instance Type</th>
    </tr>

        <tr>
            <td>${instance_id}</td>
            <td>${instance_keyName}</td>
            <td>${instance_launchTime}</td>
            <td>${instance_privIP}</td>
            <td>${instance_type}</td>
        </tr>

</table>

</div>
</body>
</html>

