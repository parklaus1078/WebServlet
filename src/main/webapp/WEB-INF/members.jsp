<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    <th>email</th>
    <th>password</th>
    </thead>
    <tbody>
    <c:forEach var="item" items="${members}">
        <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.age}</td>
            <td>${item.email}</td>
            <td>${item.password}</td>
        </tr>
    </c:forEach>
    </tbody>

<a href="/index.html">메인</a>
<a href="/views/members/new-form.jsp">입력 창으로</a>
</body>
</html>