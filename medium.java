import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class EmployeeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String empId = request.getParameter("empId");
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "root", "password");

      String query = "SELECT * FROM employees WHERE emp_id=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, empId);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        out.println("<h3>Employee Details:</h3>");
        out.println("ID: " + rs.getInt("emp_id") + "<br>");
        out.println("Name: " + rs.getString("name") + "<br>");
        out.println("Department: " + rs.getString("department") + "<br>");
      } else {
        out.println("Employee not found.");
      }

      con.close();
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }
}
