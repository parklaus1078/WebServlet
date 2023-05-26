package Hello.demo.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("req.getMethod() = " + req.getMethod());             // GET
        System.out.println("req.getProtocol() = " + req.getProtocol());         // HTTP/1.1
        System.out.println("req.getScheme() = " + req.getScheme());             // http
        System.out.println("req.getRequestURL() = " + req.getRequestURL());     // http://localhost:8080/request-header
        System.out.println("req.getRequestURI() = " + req.getRequestURI());     // /request-test (shouldn't this be /request-header?) => It is /request-header!
        System.out.println("req.getQueryString() = " + req.getQueryString());   // username=hi
        System.out.println("req.isSecure = " + req.isSecure());                 // whether https is being used
        System.out.println("--- REQUEST-LINE - end ---");
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- HEADER - start ---");

//      method 1 - getting header information(old)
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName = " + headerName);
//        }

//      method 2 - getting header information(new)
        req.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println(headerName + " : " + headerName));

        System.out.println("--- HEADER - end ---");
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- HEADER UTILITY - start ---");

        System.out.println("[HOST UTILITY]");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());
        System.out.println();

        System.out.println("[ACCEPT-LANGUAGE UTILITY]");
        req.getLocales().asIterator().forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("req.getLocales() = " + req.getLocales());

        System.out.println("[COOKIE UTILITY]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + " = " + cookie.getValue());
            }
        }

        System.out.println("[CONTENT UTILITY]");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

        System.out.println("--- HEADER UTILITY - end ---");
    }

    private void printEtc(HttpServletRequest req) {
        System.out.println("--- Etc Information - start ---");

        System.out.println("[REMOTE info]");
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost());
        System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr());
        System.out.println("req.getRemotePort() = " + req.getRemotePort());

        System.out.println("[Local info]");
        System.out.println("req.getLocalName() = " + req.getLocalName());
        System.out.println("req.getLocalAddr() = " + req.getLocalAddr());
        System.out.println("req.getLocalPort() = " + req.getLocalPort());

        System.out.println("--- Etc Information - end ---");
        System.out.println();
    }
}
