<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Hello.demo.domain.member.Member" %>
<%@ page import="Hello.demo.domain.member.MemberRepository" %>
<%
    // request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Member member = new Member(username, age, email, password);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
    <li>email=<%=member.getEmail()%></li>
    <li>password=<%=member.getPassword()%></li>
</ul>
<a href="/index.html">메인</a>
<a href="/jsp/members/new-form.jsp">입력 창으로</a>
</body>
</html>