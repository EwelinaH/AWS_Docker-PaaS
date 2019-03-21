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

    Bucket: <input type="text" name="bucket" ><br /> <br />

    File Name: <input type="text" name="key" ><br /> <br />

    File to upload: <input type="file" name="file_path" ><br />


    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</div>

</body>
</html>
