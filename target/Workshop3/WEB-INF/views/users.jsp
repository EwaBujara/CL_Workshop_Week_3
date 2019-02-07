<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsersPage</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">
<h4>Group ${groupId} Users:</h4>
<table class="table table-striped table-dark">
    <tr>
        <th>User ID</th>
        <th>User Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><a href="/show-user?id=${user.id}">Details</a></td>
        </tr>
    </c:forEach>
</table>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>

