<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Home Page</title>
    <div class="p-3 mb-2 bg-dark text-white">
        <h5 class="text-right">Welcome, ${currentUser.getUsername()} !</h5>
        <a class="btn btn-info float-right" href="http://localhost:8080/logOut">Log OUT</a>
        <p></p>
        <a class="btn btn-info" href="http://localhost:8080/">Home</a>
        <a class="btn btn-info" href="http://localhost:8080/groups">Groups</a>
        <a class="btn btn-info" href="http://localhost:8080/exercises">Exercises</a>
        <a class="btn btn-info" href="http://localhost:8080/adminPage">AdminPage</a>

    </div>
</head>
