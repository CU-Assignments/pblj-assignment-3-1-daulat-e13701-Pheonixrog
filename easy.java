import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    if ("admin".equals(username) && "1234".equals(password)) {
      out.println("<h2>Welcome, " + username + "!</h2>");
    } else {
      out.println("<h2>Invalid login. Try again.</h2>");
    }
  }
}
