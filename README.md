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
- Project: Web Application(using jsp)
  - Use JSP to create same user management application that I created with Webservlet
  - Things to be aware:
    1. implementation
    - ```implementation 'org.apache.tomcat.embed:tomcat-embed-jasper'```
    - ```implementation 'javax.servlet:jstl'```
      - The second line only works in SpringBoot under 3.0
      - Since I am using SpringBoot 3.1.0, I had to substitute this line with other 3 lines.
      - ```implementation 'jakarta.servlet:jakarta.servlet-api'```
      - ```implementation 'jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api'```
      - ```implementation 'org.glassfish.web:jakarta.servlet.jsp.jstl'```
    
    2. Limit of Servlet and JSP
    - When programming in Servlet, creating HTML for the View display is in the middle of Java source. Hence, it is very likely to make mistake when writing html.
    - When programming in jsp, creating HTML is simpler and easier, and I only needed to embed Java sources where the View need to be dynamic.
    - However, putting HTML source and Java source together looks awful since the whole project solely depends on JSP.
    - Hence, MVC pattern enters the scene.

# MVC pattern
- What?
  - **Model**
    1. Contains the data to be mapped by the View.
    - Since the Model contains the computed data, which are ready to be mapped, View does not need to have any source code related to Business Logic or DB I/O.
    - Helps the View to focus on rendering display only.
  - **View**
    1. Renders Display
    2. Maps the data contained in the Models to the display
    - In this project, View takes care of creating HTML.
  - **Controller**:
    1. Takes in HTTP Request
    2. Inspects/Validates Parameters
    3. Runs Business Logics
    4. Gets data, contains them in the Models, and tosses them to the Views
    - Since Controller's workload is so much heavier than the other components, Model and View, do, usually another component, Service is added to take care of Business Logics, so that controller's workload does not overflow.
    - Sometimes, another component called, Repository, can be added to handle DB I/O to lessen the workload of Business logics as well.
- How?
  - Servlet takes care of the Business Logics
  - JSP takes care of building the View using HTML
- Why?
  - Dependency overloaded:
    - If one file handles all tasks, the source becomes longer, and makes it harder to manage
  - Life Cycle of modification:
    - The life cycle of modification of the Business Logics and View are different. Modifying UI View and Business logic differ a lot in frequency, and they do not affect each other. Hence, it makes more sense to manage codes in different sources.
  - Functionality Specialization:
    - View Templates like JSP are optimized at rendering the displays, so it is the most effective to let it taking care of rendering only.
- Project:
  - Objective:
    - Applying MVC pattern to the project developed previously.
      - **Controller**: Servlet
      - **View**: JSP
      - **Model**: HttpServletRequest Object
        - request has data storage as the properties.
        - ```request.setAttribute()``` sets(stores) the data inside the request. 
        - ```request.getAttribute()``` gets(loads) the data from the request.