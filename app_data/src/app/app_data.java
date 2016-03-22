package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class app_data
 */
@WebServlet("/app_data")
public class app_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String TITLE = "send message ";
   @Override
public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
    String msg=req.getParameter("msg");
    res.setContentType("text/html");
    PrintWriter writer = res.getWriter();
    
    writer.println("<html>"
    		+ "<form method='post'>"
    		+ " <table>"
    	    + " <tr><td>Message:</td><td><input type='text' name='msg'></td></tr>"
    		+ " <tr><td></td><td><input type='submit' value='Submit'></td></tr>"
    		+ "</table>"
    		+ "</form>"
    		+ "</html>");
    
    System.out.println(msg);
    try
    {
    	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    	Connection con=DriverManager.getConnection("jdbc:odbc:student","","");
    	Statement stmt=con.createStatement();
    	int i=stmt.executeUpdate("insert into data(message) values('"+msg+"')");
    	writer.println("Message successfully added!");
    	con.close();
    } 
    catch(Exception e)
    {
    System.out.println(e);
    }
   
   }
   @Override
   public void doPost(HttpServletRequest request,
           HttpServletResponse response)
           throws ServletException, IOException
   {
	   
	   System.out.printf("cool");
   }
   
}
