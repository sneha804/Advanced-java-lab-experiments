import java.sql.*;
import java.util.*;

public class Result {

    public static void main(String... gec) throws Exception {

        Scanner s = new Scanner(System.in);
        char ch;

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "system"
        );

        if (con == null)
            System.out.println("Connection Failed......");
        else
            System.out.println("DB Connected.....");

        do {

            System.out.println("\n1.Insert");
            System.out.println("2.Update");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            System.out.println("5.Exit");

            System.out.print("Enter your choice: ");
            int n = s.nextInt();

            switch (n) {

            case 1:
                try {

                    Statement st = con.createStatement(
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );

                    ResultSet rs = st.executeQuery(
                            "SELECT eid, ename, salary, eaddress " +
                            "FROM employee1223"
                    );

                    rs.moveToInsertRow();

                    System.out.print("Enter id: ");
                    int x = s.nextInt();

                    System.out.print("Enter name: ");
                    String y = s.next();

                    System.out.print("Enter Salary: ");
                    int z = s.nextInt();

                    System.out.print("Enter address: ");
                    String w = s.next();

                    rs.updateInt("eid", x);
                    rs.updateString("ename", y);
                    rs.updateInt("salary", z);
                    rs.updateString("eaddress", w);

                    rs.insertRow();

                    System.out.println("Row inserted.......");

                    rs.close();
                    st.close();

                } catch (Exception e) {
                    System.out.println("Error....." + e);
                }

                break;


            case 2:
                try {

                    Statement st = con.createStatement(
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );

                    ResultSet rs = st.executeQuery(
                            "SELECT eid, ename, salary, eaddress " +
                            "FROM employee1223"
                    );

                    System.out.print(
                            "Enter employee id to update salary: "
                    );

                    int p = s.nextInt();
                    boolean found = false;

                    while (rs.next()) {

                        if (rs.getInt("eid") == p) {

                            found = true;

                            int oldSalary = rs.getInt("salary");
                            int newSalary = oldSalary + 2000;

                            rs.updateInt("salary", newSalary);

                            // This writes the updated value
                            // back to the database.
                            rs.updateRow();

                            System.out.println(
                                    p + " empid salary is incremented by 2000."
                            );

                            System.out.println(
                                    "Old Salary : " + oldSalary
                            );

                            System.out.println(
                                    "New Salary : " + newSalary
                            );

                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Employee not found......");

                    rs.close();
                    st.close();

                } catch (Exception e) {
                    System.out.println("Error....." + e);
                }

                break;


            case 3:
                try {

                    Statement st = con.createStatement(
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );

                    ResultSet rs = st.executeQuery(
                            "SELECT eid, ename, salary, eaddress " +
                            "FROM employee1223"
                    );

                    System.out.print(
                            "Enter employee id to delete record: "
                    );

                    int p = s.nextInt();
                    boolean found = false;

                    while (rs.next()) {

                        if (rs.getInt("eid") == p) {

                            found = true;

                            rs.deleteRow();

                            System.out.println(
                                    p + " empid record deleted......"
                            );

                            break;
                        }
                    }

                    if (!found)
                        System.out.println("Employee not found......");

                    rs.close();
                    st.close();

                } catch (Exception e) {
                    System.out.println("Error......." + e);
                }

                break;


            case 4:
                try {

                    Statement st = con.createStatement(
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE
                    );

                    ResultSet rs = st.executeQuery(
                            "SELECT eid, ename, salary, eaddress " +
                            "FROM employee1223"
                    );

                    System.out.println();
                    System.out.println(
                            "EID\tENAME\tSALARY\tADDRESS"
                    );

                   
                    while (rs.next()) {

                        System.out.println(
                                rs.getInt("eid") + "\t" +
                                rs.getString("ename") + "\t" +
                                rs.getInt("salary") + "\t" +
                                rs.getString("eaddress")
                        );
                    }

                    rs.close();
                    st.close();

                } catch (Exception e) {
                    System.out.println("Error......." + e);
                }

                break;


            case 5:
               
                con.close();
                s.close();
                System.exit(0);
                break;


            default:
                System.out.println("Wrong choice........");
            }

            System.out.print("Do you want to continue y/n: ");
            ch = s.next().charAt(0);

        } while (ch == 'y' || ch == 'Y');

        con.close();
      
    }
}
