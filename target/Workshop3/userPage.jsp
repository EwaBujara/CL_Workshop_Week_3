<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">
<table class="table table-striped table-dark">
    <tr>
        <th>User ID</th>
        <th>User Name</th>
        <th>User email</th>
        <th></th>
        <th>Actions</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.email}</td>
        <td><a href="/show-user?id=${user.id}">Details</a></td>
    </tr>
</table>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>
