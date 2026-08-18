import java.sql.*;

public class ScrollResult {

    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "system";
        String password = "system";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection(
                    url, username, password);

            System.out.println("DB Connected.....");

            Statement st = con.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY
            );

            ResultSet rs = st.executeQuery(
                    "SELECT * FROM student1223"
            );

            // Check whether table contains records
            if (!rs.next()) {
                System.out.println("student1223 table contains no records.");
                rs.close();
                st.close();
                con.close();
                return;
            }

            /*
             * The cursor is currently on the first row.
             * Move it before the first row.
             */
            rs.beforeFirst();

            System.out.println("\nTable info from first row to last row is.....");

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            }

            /*
             * Move cursor after the last row.
             */
            rs.afterLast();

            System.out.println("\nTable info from last row to first row is.....");

            while (rs.previous()) {
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            }

            // Move to 3rd row
            if (rs.absolute(3)) {
                System.out.println("\n3rd row info is.....");
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            } else {
                System.out.println("\n3rd row does not exist.");
            }

            // Move 2 rows forward: 3rd -> 5th
            if (rs.relative(2)) {
                System.out.println("\n5th row info is.....");
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            }

            // Move 1 row backward: 5th -> 4th
            if (rs.relative(-1)) {
                System.out.println("\n4th row info is.....");
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            }

            // First row
            if (rs.first()) {
                System.out.println("\n1st row info is.....");
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));
            }

            // Last row
            if (rs.last()) {
                System.out.println("\nLast row info is.....");
                System.out.println(
                        rs.getInt(1) + " " +rs.getString(2) + " " +rs.getString(3) + " " +rs.getFloat(4));

                System.out.println(
                        "\nCurrent row number is: " + rs.getRow()
                );
            }

            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
