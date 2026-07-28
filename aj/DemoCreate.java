import java.sql.*;

class DemoCon {
    public static void main(String args[]) {
        try {
            // Load Oracle JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/studentdb";
String username = "root";
String password = "";

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // SQL query
            String query = "CREATE TABLE student (Roll VARCHAR(20), Name VARCHAR(20))";

            // Create statement
            Statement st = con.createStatement();

            // Execute query
            st.execute(query);

            System.out.println("Table created successfully.");

            // Close resources
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}