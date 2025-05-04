package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import testComponents.BaseTest;

public class MySQL_DBTest extends BaseTest {

	@Test
	public void getDataFromMySQL() throws SQLException {
		
		System.out.println("Inside the method");
		
		 String dbURL = "jdbc:mysql://localhost:3306/qadbt"; // Make sure `qadbt` is the correct schema
	     String username = "root"; // or your DB username
	     String password = "root"; // use your actual MySQL password	
		
         // Load the MySQL JDBC driver
         //Class.forName("com.mysql.cj.jdbc.Driver");

         // Establish connection
         Connection conn = DriverManager.getConnection(dbURL, username, password);

         // Create statement
         Statement stmt = conn.createStatement();

         // Execute query
         ResultSet rs = stmt.executeQuery("SELECT * FROM AuthenticationData");
	     
         if(rs.next()) {
             String DBUserName = rs.getString("DBUsername");
             String DBPassword = rs.getString("DBPassword");

             System.out.println("Username: " + DBUserName + ", Password: " + DBPassword);

             // Call your login method
                        
             
             
             lp.loginApplication(DBUserName, DBPassword);
         }

         // Close connection
         conn.close();
	     
		
	}
}

