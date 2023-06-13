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
  - Routes
    - servlet/members/new-form : Provides a form that accepts a user's username, age, email, and password.
    - servlet/members/save     : Saves the values entered in the form provided.
    - servlet/members          : Lists the information of the members entered so far.
  
# Template Engine: JSP, Thymeleaf, Freemaker, Velocity, ...
- Why?
  - In the previous step, I could create a view by writing html codes in strings with PrintWriter only because it was SO SHORT.
  - This is very complicated and inefficient.
  - Template Engine allows embedding Java source in the middle of html source, where the view has to be changed dynamically.
  - Rather than making HTML with Java, embedding Java sources in the HTML source would make server-side rendering much easier. 
- What I am going to use:
  - JSP(outdated)
  - Thymeleaf