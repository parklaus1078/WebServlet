# WebServlet

## 한 것:
1. HttpServletRequest
   1. 개요(RequestHeaderServlet)
   2. GET Query parameters(RequestParamServlet)
   3. POST HTML form(webapp/basic/hello-form.html)
   4. API Body text/plain(RequestBodyStringServlet)
   5. API Body application/json(basic/HelloData, RequestBodyJsonServlet)
   
2. HttpServletResponse
   1. 개요(ResponseHeaderServlet)
   2. Header Content-Type: text/plain(ResponseHeaderServlet)
   3. Response's header Content-Type: HTML(ResponseHtmlServlet)
   4. Response's header Content-Type: Json(ResponseJsonServlet)


# Servlet, JSP, MVC Patterns
- Project: User Management Web Application
  - Requirements(Functionality)
    - store user information
    - view list of user information
  - User information:
    - name: `username`
    - age: `age`
    - email: `email` - format: email@domain.com
    - password: `password`
  