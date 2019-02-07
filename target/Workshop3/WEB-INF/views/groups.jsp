<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Groups Page</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">

<table class="table table-striped table-dark">
    <tr>
        <th>Group ID</th>
        <th>Group Name</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${groups}" var="group">
        <tr>
            <td>${group.id}</td>
            <td>${group.name}</td>
            <td><a href="/show-users?groupId=${group.id}">Details</a></td>
        </tr>
    </c:forEach>
</table>

<h4>Add new group:</h4>
<form method="post" action="/newGroup">
    <div class="form-group">
    <input type="text" name="newGroupName" placeholder="New Group Name">
    <p></p>
    <input type="submit" value="Submit">
    </div>
</form>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>
