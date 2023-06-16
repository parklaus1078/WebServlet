<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Hello.demo.domain.member.Member" %>
<%@ page import="Hello.demo.domain.member.MemberRepository" %>
<%@ page import="java.util.List" %>
<%
    MemberRepository memberRepository = MemberRepository.getInstance();
    List<Member> members =  memberRepository.findAll();
%>
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
    <%
        for (Member member: members) {
                    out.write("   <tr>");
                    out.write("       <td>" + member.getId() + "</td>");
                    out.write("       <td>" + member.getUsername() + "</td>");
                    out.write("       <td>" + member.getAge() + "</td>");
                    out.write("       <td>" + member.getEmail() + "</td>");
                    out.write("       <td>" + member.getPassword() + "</td>");
                    out.write("   </tr>");
                }
    %>
    </tbody>

<a href="/index.html">메인</a>
<a href="/jsp/members/new-form.jsp">입력 창으로</a>
</body>
</html>