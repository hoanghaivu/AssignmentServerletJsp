<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 6/11/2020
  Time: 8:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Home</h1>

<table>
    <thead>
    <tr>
        <th>Title</th>
        <th>Content</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach var="note" items="${notes}">
        <tr>
            <td><c:out value="${note.title}"/></td>
            <td><c:out value="${note.content}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
