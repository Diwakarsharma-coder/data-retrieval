package cont;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			
			String email=request.getParameter("uemail");
			String pass=request.getParameter("upass");
				
			PrintWriter out=response.getWriter();
			
			
			Connection con1=ConnectionProvider.getCon();
			
			try
			{
				PreparedStatement ps=con1.prepareStatement("Select * from register where email=? and pass=?");
				ps.setString(1,email);
				ps.setString(2,pass);
				ResultSet rs=ps.executeQuery();
				
				while(rs.next())
				{
					RequestDispatcher rd=request.getRequestDispatcher("index.html");		
					rd.include(request, response);
					out.println("Name: "+rs.getString(1)+"<br>");
					out.println("Age: "+rs.getString(2)+"<br>");
					out.println("Phone No: "+rs.getString(3)+"<br>");
					out.println("Email: "+rs.getString(4)+"<br>");
					out.println("Pass: "+rs.getString(5)+"<br>");
					
										
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}

}
