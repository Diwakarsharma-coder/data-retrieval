package cont;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection con=null;
	static final String url="jdbc:mysql://localhost:3306/student";
	static final String username="root";
	static final String pass=""; 
	public static Connection getCon()
	{
		try
		{
			if(con==null)
			{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,pass);
			return con;
			}
			else
			{
				return con;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
