package Hello.demo.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")  // name is servlet name, and urlPatters are url mapping
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("req = " + req);
        System.out.println("res = " + res);

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        res.setContentType("text/plain");   // content type of response
        res.setCharacterEncoding("utf-8");  // encoding type of response
        res.getWriter().write("hello " + username); // load the content to the response body
    }

}
