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
    <title>Resources</title>
</head>
<body>

<a href="../SmartHome/">Back to main menu</a>
<br/>

<h1>SysInfo list</h1>


<c:url var="addAction" value="/resources/add"/>
<form:form action="${addAction}" commandName="resources">
    <table>

        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<spring:message text="Start recording"/>"/>
            </td>
        </tr>
    </table>
</form:form>




<table id="myTable" class="display" width="33%" cellspacing="0">
    <thead>
    <tr>
        <th width="60">DateTime/th>
        <th width="40">CPU</th>
        <th width="40">RAM</th>
        <th width="40">HDD</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${listLimitedResources}" var="resources">
        <tr>

            <td>${resources.time}</td>
            <td>${resources.cpu}</td>
            <td>${resources.ram}</td>
            <td>${resources.hdd}</td>

        </tr>
    </c:forEach>
    </tbody>


</table>

</body>
</html>

