<%--
  Created by IntelliJ IDEA.
  User: Maxim.Temborskiy
  Date: 20.11.2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
</head>
<body>

<a href="../SmartHome/">Back to main menu</a>
<br/>

<h1>User list</h1>

<c:if test="${!empty listUsers}">
<h1>Add User</h1>
</c:if>



<table id="myTable" class="display" width="50%" cellspacing="0">
    <thead>
    <tr>
        <th width="40">ID</th>
        <th width="80">Login</th>
        <th width="80">Email</th>
        <th width="80">Name</th>
        <th width="80">ExpirationDate</th>
        <th width="10">isAdmin</th>
        <th width="10">Edit</th>
        <th width="10"> Delete</th>
    </tr>
    </thead>

        <tbody>
        <c:forEach items="${listUsers}" var="user">
        <tr>

            <td>${user.id}</td>
            <td><a href="/userdata/${user.id}" target="_blank"> ${user.login}</a></td>
            <td>${user.email}</td>
            <td>${user.name}</td>
            <td>${user.date}</td>
            <td>${user.admin}</td>
            <td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>

        </tr>
        </c:forEach>
        </tbody>


</table>
<c:url var="addAction" value="/users/add"/>

<form:form action="${addAction}" commandName="user">
    <table>
        <c:if test="${!empty user.login}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="login">
                    <spring:message text="Login"/>
                </form:label>
            </td>
            <td>
                <form:input path="login"/>
            </td>

        </tr>
        <tr>
            <td>
                <form:label path="email">
                    <spring:message text="E-Mail"/>
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>

                <form:label path="date">
                    <spring:message text="ExpDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="date"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="admin">
                    <spring:message text="isAdmin"/>
                </form:label>
            </td>
            <td>
                <form:input path="admin"/>
            </td>

        </tr>


        <tr>
            <td colspan="2">
                <c:if test="${!empty user.login}">
                    <input type="submit"
                           value="<spring:message text="Edit User"/>"/>
                </c:if>
                <c:if test="${empty user.login}">
                    <input type="submit"
                           value="<spring:message text="Add User"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>


<script>
    $(function(){
        $("#myTable").dataTable({
            "sPaginationType": "full_numbers",
            "bJQueryUI": true
        });
    })
</script>
</body>
</html>

