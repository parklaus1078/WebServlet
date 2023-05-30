package Hello.demo.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet"git , urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // [Status-line]
        res.setStatus(HttpServletResponse.SC_OK);                                                     // res.status(200)

        // [response-headers]
//        res.setHeader("Content-Type", "text/plain;charset=utf-8");                                  // response type is text(raw)
        res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");           // Caching is fully defeased
        res.setHeader("pragma", "no-cache");                                             // Past Caching data is defeased as well
        res.setHeader("custom-header", "hello");                                         // Custom header information

        // Header 편의 메소드
        content(res);
        cookie(res);
        redirect(res);

        PrintWriter writer = res.getWriter();
        writer.println("ㅎㅇㅎㅇ");
        writer.write("ㅎㅇㅎㅇ");
        writer.write("ㅎㅇㅎㅇ");
    }

    private void content(HttpServletResponse res) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        // res.setHeader("Content-Type", "text/plain;charset=utf-8");
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        // res.setContentLength(2)  // 생략 시 자동 생성
    }

    private void cookie(HttpServletResponse res) {
        // Set-Cookie: myCookie=Hello, my friend; Max-Age=600;
        // res.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);                                                                        // Life Cycle = 600 sec
        res.addCookie(cookie);
    }

    private void redirect(HttpServletResponse res) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

        res.setStatus(HttpServletResponse.SC_FOUND);
        res.setHeader("Location", "/basic/hello-form.html");
        // res.sendRedirect("/basic/hello-form.html");
    }
}
