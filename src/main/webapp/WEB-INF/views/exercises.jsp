<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exercises Page</title>
    <%@include file="/WEB-INF/views/header.jsp"%>
<body class="p-3 mb-2 bg-info text-white">


<table class="table table-striped table-dark">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Created</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${exercises}" var="exercise">
        <tr>
            <td>${exercise.id}</td>
            <td>${exercise.name}</td>
            <td>${exercise.user.username}</td>
            <td>${exercise.created}</td>
            <td><a href="/show-solutions?exerciseId=${exercise.id}">Details</a></td>
        </tr>
    </c:forEach>
</table>

<h4>Add new exercise:</h4>
<form method="post" action="/newExercise">
    <div class="form-group">
    <input type="text" name="newExerciseName" placeholder="Exercise Name">
    <p></p>
        <textarea type="text" name="newExerciseContent" placeholder="Content"></textarea>
    <p></p>
    <input type="submit" value="Submit">
    </div>
</form>
</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>
