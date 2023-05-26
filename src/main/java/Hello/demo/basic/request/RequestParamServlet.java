package Hello.demo.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - start");
        
        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println("req.getParameter(paramName) = " + req.getParameter(paramName)));
        
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = req.getParameter("username");                     // const {username} = req.param
        String age = req.getParameter("age");                               // const {username} = req.param

        System.out.println("username = " + username);                             // console.log("username =", username);
        System.out.println("age = " + age);                                       // console.log("age =", age);
        System.out.println();

        System.out.println("[키 값이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String name: usernames) {
            System.out.println("name = " + name);
        }

        res.getWriter().write("ok");                                        // return res.json()
    }

}
