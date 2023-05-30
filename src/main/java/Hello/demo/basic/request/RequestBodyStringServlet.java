package Hello.demo.basic.request;

import Hello.demo.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();                                   // getting request body as Byte code
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);      // converts Byte code into string using encoding method: UTF-8

        System.out.println("messageBody = " + messageBody);

        res.getWriter().write("ok");
    }
}
