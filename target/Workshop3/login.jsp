<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>SignIn</title>
    <div class="p-3 mb-2 bg-dark text-white">
        <h4 class="text-center">Please Sign In</h4>
    </div>
</head>
<body class="p-3 mb-2 bg-info text-white">
<form method="post" action="/signIn">
    <div class="form-group">
    <input type="text" name="userName" placeholder="User Name">
    <p></p>
    <input type="password" name="userPassword" placeholder="Your password">
    <p></p>
    <input type="submit" value="Submit">
    </div>
</form>

</body>
<%@include file="/WEB-INF/views/footer.jsp"%>
</html>
