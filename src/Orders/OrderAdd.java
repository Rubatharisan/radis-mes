package Orders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OrderAdd {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://95.47.119.185:3306/foo";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "password";

	public static void main(String[] args) {
		  Connection conn = null;
		    Statement stmt = null;
		    Scanner scn = new Scanner(System.in);
		    String course_code = null, course_desc = null, course_chair = null;

		    try {
		        // STEP 2: Register JDBC driver
		        Class.forName("com.mysql.jdbc.Driver");

		        // STEP 3: Open a connection
		        System.out.print("\nConnecting to database...");
		        conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        System.out.println(" SUCCESS!\n");

		        // STEP 4: Ask for user input
		        System.out.print("Enter course code: ");
		        course_code = scn.nextLine();

		        System.out.print("Enter course description: ");
		        course_desc = scn.nextLine();

		        System.out.print("Enter course chair: ");
		        course_chair = scn.nextLine();

		        // STEP 5: Execute query
		        System.out.print("\nInserting records into table...");
		        stmt = conn.createStatement();

		        String sql = "INSERT INTO Orders (orderName, orderStatus, orderComment)" +
		                "VALUES (?, ?, ?)";
		        PreparedStatement preparedStatement = conn.prepareStatement(sql);
		        preparedStatement.setString(1, course_code);
		        preparedStatement.setString(2, course_desc);
		        preparedStatement.setString(3, course_chair);

		        preparedStatement.executeUpdate(); 
		        System.out.println(" SUCCESS!\n");

		    } catch(SQLException se) {
		        se.printStackTrace();
		    } catch(Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if(stmt != null)
		                conn.close();
		        } catch(SQLException se) {
		        }
		        try {
		            if(conn != null)
		                conn.close();
		        } catch(SQLException se) {
		            se.printStackTrace();
		        }
		    }
		    System.out.println("Thank you for your patronage!");
		  }
}


