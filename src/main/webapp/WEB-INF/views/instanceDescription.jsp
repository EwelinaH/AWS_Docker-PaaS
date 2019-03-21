<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>instanceDescription</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jspf" %>

<div class="content">

<table>
    <tr>
        <th>Instance ID</th>
        <th>Image ID</th>
        <th>Instance Type</th>
        <th>Key Name</th>
        <th>Launch Time</th>
        <th>Private IP Adderss</th>
        <th>Public IP Adderss</th>
        <th>Security Groups</th>
        <th>State</th>
    </tr>

    <tr>
        <td>${instanceId}</td>
        <td>${imageId}</td>
        <td>${instanceType}</td>
        <td>${keyName}</td>
        <td>${launchTime}</td>
        <td>${privateIpAddress}</td>
        <td>${publicIpAddress}</td>
        <td>${securityGroupName}</td>
        <td>${state}</td>
    </tr>

</table>

</div>
</body>
</html>
