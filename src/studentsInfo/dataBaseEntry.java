package studentsInfo;

import java.sql.*;

import javax.swing.JOptionPane;

import java.lang.*;

public class dataBaseEntry 
{
	private String stuName;
	private String fatherName;
	private String motherName;
	private String stuAge;
	private String birthDate;
	private String stuClass;
	private String stuRoll; 
	
	
	public dataBaseEntry(String stuName,String stuClass, String stuRoll,
			String fatherName, String motherName, 
			 String birthDate,String stuAge) 
	{
		
		this.stuName = stuName;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.stuAge = stuAge;
		this.birthDate = birthDate;
		this.stuClass = stuClass;
		this.stuRoll = stuRoll;
	}

	
	public dataBaseEntry(String stuName,String stuClass,String stuRoll)
	{
		this.stuName = stuName;
		this.stuClass = stuClass;
		this.stuRoll = stuRoll;
	}
	
	public void manageTask()
	{
		String var = "'" + stuName + "','" + stuClass + "','" + stuRoll + "','" + fatherName + "','"
				+ motherName + "','" + birthDate + "','" + stuAge + "'";	
		String query = "INSERT INTO studentDataEntry VALUES(" + var + ")";
	
		performQuery(query);
	}
	
	public static void performQuery(String query)
	{
		Connection con = getConnection();
		
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			JOptionPane.showMessageDialog(null,"Successfully entry");
			
			rs.close();
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static Connection getConnection()
	{
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "system";
		String pass = "#Alfaisal151";
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection con = DriverManager.getConnection(url,userName,pass);
			
			return con;
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		return null;
	}
}
