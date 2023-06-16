package Hello.demo.web.servletmvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";                        // If a JSP file is located in /WEB-INF, cannot be requested from the client side. Only server can request to the files in this.
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);      // used when moving from a controller to a view
        dispatcher.forward(req, res);                                           // JSP can be referred by Servlet using this. This line redirects the server to the viewPath directory. !!!Request is made in the server!!! different from Redirection. It's forward
    }
}
