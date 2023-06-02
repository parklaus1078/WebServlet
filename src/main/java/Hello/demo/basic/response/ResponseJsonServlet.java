package Hello.demo.basic.response;

import Hello.demo.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Content-Type: application/json
        res.setContentType("application/json");
        res.setCharacterEncoding("utf-8");                          // application/json은 스펙상 utf-8 형식을 사용하도록 정의되어있어 이 라인은 사실 의미가 없음

        HelloData helloData = new HelloData();
        helloData.setUsername("park");
        helloData.setAge(28);

        // to { "username": "park", "age": 28 }
        String result = objectMapper.writeValueAsString(helloData);
        res.getWriter().write(result);                              // 하지만 getWriter()을 사용하면 추가 파라미터를 자동으로 추가해버려 문제가 생기는데, res.getOutputStream()으로 대체하면 문제가 생기지 않는다.

    }
}
