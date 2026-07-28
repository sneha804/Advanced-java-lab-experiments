import java.util.Scanner;
import java.sql.*;

class Democonne {
    public static void main(String args[]) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/studentdb";
            String username = "root";
            String password = "";

            Connection con = DriverManager.getConnection(url, username, password);

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter roll number:");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.println("Enter student name:");
            String name = sc.nextLine();

            String query = "INSERT INTO student1223 VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, roll);
            ps.setString(2, name);

            int result = ps.executeUpdate();

            if (result == 1) {
                System.out.println("A new student was inserted successfully!");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
