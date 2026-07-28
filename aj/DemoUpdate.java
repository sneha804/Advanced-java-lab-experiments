import java.util.Scanner;
import java.sql.*;  
class DemoUpdate
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
System.out.print("Enter Roll Number: ");
String roll = sc.nextLine();
System.out.print("Enter Name to be Update: ");
String name = sc.nextLine();

String query = "UPDATE student1223 set name='"+name+"' where roll='"+roll+"'";
Statement st=con.createStatement();
int exec = st.executeUpdate(query);
if (exec>0)
{
System.out.println("Table Updated successfully!");
}
con.close();  
    }
    catch(Exception e){ System.out.println(e);}  
  }  
}