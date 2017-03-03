<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<%--
  Created by IntelliJ IDEA.
  User: Maxim.Temborskiy
  Date: 20.11.2016
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>

</head>
<body>
<h1>User Details</h1>

<table class="tg">
    <tr>
        <th width="40">ID</th>
        <th width="40">Login</th>
        <th width="40">Email</th>
        <th width="40">Name</th>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.login}</td>
        <td>${user.email}</td>
        <td>${user.name}</td>
    </tr>
</table>
</body>
</html>
