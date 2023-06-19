<%@ page import="Hello.demo.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
성공
<!-- 원래는
<ul>
    <li> id = <%=((Member)request.getAttribute("member")).getId()%> </li>
    <li> username = <%=((Member)request.getAttribute("member")).getUsername()%> </li>
    <li> password = <%=((Member)request.getAttribute("member")).getPassword()%> </li>
    <li> email = <%=((Member)request.getAttribute("member")).getEmail()%> </li>
    <li> age = <%=((Member)request.getAttribute("member")).getAge()%> </li>
</ul>
-->
<!-- JSP provides simpler version's syntax -->
<ul>
    <li>id=${member.id}</li>
    <li>username=${member.username}</li>
    <li>password=${member.password}</li>
    <li>email=${member.email}</li>
    <li>age=${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>