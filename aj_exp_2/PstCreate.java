import java.sql.*;

class PstCreate {
    public static void main(String args[]) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "";

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // SQL query
            String query = "CREATE TABLE student230 (" +
                           "Roll VARCHAR(20), " +
                           "Name VARCHAR(20), " +
                           "Address VARCHAR(30))";

            // Create PreparedStatement
            PreparedStatement pst = con.prepareStatement(query);

            // Execute
            boolean exec = pst.execute();

            if (!exec) {
                System.out.println("Table created successfully.");
            }

            // Close resources
            pst.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}