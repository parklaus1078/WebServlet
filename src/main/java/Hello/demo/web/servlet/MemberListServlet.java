package Hello.demo.web.servlet;

import Hello.demo.domain.member.Member;
import Hello.demo.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Member> members =  memberRepository.findAll();

        res.setContentType("text/html");
        res.setCharacterEncoding("utf-8");

        PrintWriter w = res.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write("    <meta charset=\"UTF-8\">");
        w.write("    <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write("    <thead>");
        w.write("    <th>id</th>");
        w.write("    <th>username</th>");
        w.write("    <th>age</th>");
        w.write("    <th>email</th>");
        w.write("    <th>password</th>");
        w.write("    </thead>");
        w.write("    <tbody>");

        for (Member member: members) {
            w.write("   <tr>");
            w.write("       <td>" + member.getId() + "</td>");
            w.write("       <td>" + member.getUsername() + "</td>");
            w.write("       <td>" + member.getAge() + "</td>");
            w.write("       <td>" + member.getEmail() + "</td>");
            w.write("       <td>" + member.getPassword() + "</td>");
            w.write("   </tr>");
        }

        w.write("    </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}
