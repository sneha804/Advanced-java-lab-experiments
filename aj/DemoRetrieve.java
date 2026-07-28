import java.util.Scanner;
import java.sql.*;  
class DemoRetrieve
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

String query = "SELECT * FROM student1223";
Statement st=con.createStatement();

ResultSet rs = st.executeQuery(query);

System.out.println("Roll No  Name");

     while(rs.next())
{
  System.out.println(rs.getString(1)+"       "+rs.getString(2));

}

st.close();
con.close();  
}
    catch(Exception e){ System.out.println(e);}  
  }  
}