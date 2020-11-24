<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
<%@include file="/WEB-INF/views/header.jsp"%>

<body class="p-3 mb-2 bg-info text-white">
<h4>Most recent solutions:</h4>
<table class="table table-striped table-dark">
        <tr>
            <th>Exercise</th>
            <th>Author</th>
            <th>Created</th>
            <th>Actions</th>
        </tr>
        <c:forEach items="${solutions}" var="solution">
            <tr>
                <td>${solution.exercise.name}</td>
                <td>${solution.user.username}</td>
                <td>${solution.created}</td>
                <td><a href="/show-solution?id=${solution.id}">Details</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>
