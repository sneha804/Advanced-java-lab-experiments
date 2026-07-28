import java.sql.*;

class DemoTransaction {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Database connection details
            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";   // Change if required
            String password = "";         // Enter your MySQL password

            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create statement
            Statement stmt = con.createStatement();

            // Disable auto-commit
            con.setAutoCommit(false);

            try {
                int i1 = stmt.executeUpdate(
                        "INSERT INTO student1223 VALUES (1227, 'narayana')");


                // Commit transaction
                con.commit();
                System.out.println("Transaction is successful");
            } catch (Exception e) {
                // Rollback transaction
                con.rollback();
                System.out.println("Transaction failed");
                System.out.println(e);
            }

            // Close resources
            stmt.close();
            con.close();

            System.out.println("Connection is closed");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}