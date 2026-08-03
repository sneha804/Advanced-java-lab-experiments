import java.util.*;
import java.sql.*;
class StudentDb
{
static public void main(String   args[]) throws Exception 
{
Scanner s=new Scanner(System.in);
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
char ch;
String t=null;
int f=0;
Statement st=null;
do{
System.out.println("1.Create");
System.out.println("2.Insert");
System.out.println("3.Update");
System.out.println("4 Delete");
System.out.println("5.Display");
System.out.println("6.Exit");
int n=s.nextInt();
switch(n)
{
case 1:
try{
System.out.println("Enter Table Name:");
t=s.next();
String q="create table  "+t+" (rno varchar(20),name varchar(30),address varchar(50))";
st=con.createStatement();
st.executeUpdate(q);
System.out.println("Table Created");
}
catch(Exception e)
{
System.out.println("Table already exist..."+e);
}
break;
case 2:
try{
if(f==0)
{
System.out.println("Enter Table Name:");
t=s.next();
f=1;
}
System.out.println("Enter Roll Number");
String x=s.next();
System.out.println("Enter Name");
String y=s.next();
System.out.println("Enter Address");
String z=s.next();
String q="insert into  "+t+"  values ('"+x+"','"+y+"','"+z+"')";
st=con.createStatement();
int k=st.executeUpdate(q);
if(k==0)
System.out.println("Insertion Failed.....");
else
System.out.println("Record successfully Inserted");
}
catch(Exception e)
{
System.out.println("Db error in Insertion......"+e);
}
break;
case 3:
try{
System.out.println("Enter Table Name:");
t=s.next();
System.out.println("Enter choice for update");
System.out.println("1.Name update");
System.out.println("2.Address update");
System.out.println("3.Both Name and Address update");
int r=s.nextInt();
String q=null;
String y;
String n1;
String n2;
	switch(r)
	{
	case 1:System.out.println("enter Roll Number to update Name:");
	y=s.next();
	System.out.println("Enter New Name:");
	n1=s.next();
	q="update  "+t+" set name='"+n1+"'  where rno='"+y+"' ";
	break;
	case 2:
	System.out.println("Enter Roll Number to Update Address");
	y=s.next();
	System.out.println("Enter New Address:");
	n2=s.next();
	q="update  "+t+" set address='"+n2+"' where rno='"+y+"'";
	break;
	case 3:System.out.println("Enter Roll Number to update Both name and address: ");
	y=s.next();
	System.out.println("Enter New Name and Address:");
	n1=s.next();
	n2=s.next();
	q="update  "+t+" set name='"+n1+"',address='"+n2+"' where rno='"+y+"'";
	break;
        default:System.out.println("Invalid option...");
	}
st=con.createStatement();
int k=st.executeUpdate(q);
if(k==0)
System.out.println("No rows are updated..");
else
System.out.println(k+" Record(s) is/are updated");
}
catch(Exception e)
{
System.out.println("error in update record...");
}
break;
case 4:
try{
System.out.println("Enter Table Name:");
t=s.next();
System.out.println("Enter Roll Number:");
String x=s.next();
String q="delete from "+t+" where rno='"+x+"' ";
st=con.createStatement();
int k=st.executeUpdate(q);
if(k==0)
System.out.println("Record not found ...");
else
System.out.println("Record deleted...");
}
catch(Exception e)
{
System.out.println("Error in delete operation...."+e);
}
break;
case 5: int i=1;
try{
System.out.println("Enter Table name:");
t=s.next();
String q="select *from "+t;
st=con.createStatement();
ResultSet rs=st.executeQuery(q);
while(rs.next())
{
System.out.println("Student "+i+" Details:");
System.out.println("Roll Number is:"+rs.getString(1));
System.out.println("Name is:"+rs.getString(2));
System.out.println("Address is:"+rs.getString(3));
i++;
}
}
catch(Exception e)
{
System.out.println("Retrieval error...");
}
break;
case 6:System.exit(0);break;
default:System.out.println("Invalid choice...");
}
System.out.println("Do you want to continue y/n");
ch=s.next().charAt(0);
}while(ch=='y');
con.close();
}
}
 