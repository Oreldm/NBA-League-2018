package z_drafts_package;
import  java.sql.*;

public class conn_test {
	public  static  void  main(String[] args) throws Exception
	{
		Class.forName("oracle.jdbc.OracleDriver");
		String  url = "jdbc:oracle:thin:@oraclenba.c9jdzgmhpebu.eu-west-1.rds.amazonaws.com:1521:orcl";
		String  user = "Administrator";
		String  password = "Administrator";
		Connection  connection = DriverManager.getConnection(url,user,password);

		Statement  statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
		ResultSet  emps = statement.executeQuery("Select * from fatclub");
		while (emps.next())
		{
			int  number = emps.getInt(1);
			String  name = emps.getString(2);
//			String  job = emps.getString(3);
//			int  manager = emps.getInt(4);
//			Date  hired = emps.getDate(5);
//			int  salary = emps.getInt(6);
//			int  commission = emps.getInt(7);
//			int  department = emps.getInt(8);
//			System.out.println(number + " " + name + " " + job + " " + manager + " " + hired + " " + salary + " " + commission + " " + department);
			System.out.println("id= "+number + ", str= " + name);
		}
		connection.close();
		System.out.println("here");
	}
}
