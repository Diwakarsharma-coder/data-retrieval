package cont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Connection con1=ConnectionProvider.getCon();
			
			String name=request.getParameter("uname");
			String age=request.getParameter("uage");
			String phone=request.getParameter("uphone");
			String email=request.getParameter("uemail");
			String pass=request.getParameter("upass");
			
			try
			{
				PreparedStatement ps=con1.prepareStatement("insert into register values(?,?,?,?,?)");
				ps.setString(1,name);
				ps.setString(2,age);
				ps.setString(3,phone);
				ps.setString(4,email);
				ps.setString(5,pass);
				
				int i=ps.executeUpdate();
				if(i==1)
				{
					RequestDispatcher rd=request.getRequestDispatcher("index.html");
					rd.forward(request, response);
					response.getWriter().println("registration successful.....");
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("register.html");
					response.getWriter().println("Data Not Inserted.....");
					rd.include(request, response);
				}
		}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
			
			
	}

}
