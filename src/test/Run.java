package test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Run")
public class Run extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  public Run() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse   
    response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();    
    out.println("<html><title>Hello</title><body>\n");
    out.println("<font color = blue>");
    out.println("<h1>Hello there!</h1>\n");
    out.println("</font>");
    out.println("</body></html>");
    out.close();
  }
}
