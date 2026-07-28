import java.util.Scanner;
import java.sql.*;  
class DemoDelete
{
  public static void main(String args[])
  {
    try
    {  
Class.forName("com.mysql.cj.jdbc.Driver");  

String url = "jdbc:mysql://localhost:3306/studentdb";
String username = "root";
String password = "";
Connection con=DriverManager.getConnection(url, username, password);  
Scanner sc = new Scanner(System.in);
System.out.print("Enter name: ");
String name = sc.nextLine();

String query = "DELETE FROM student1223 WHERE name='"+name+"'";
Statement st=con.createStatement();
int exec = st.executeUpdate(query);
if (exec>0)
{
System.out.println("Records deleted successfully!");
}
con.close();  
    }
    catch(Exception e){ System.out.println(e);}  
  }  
}