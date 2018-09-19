package studentsInfo;

import java.sql.*;

import javax.swing.JOptionPane;

public class dataBaseFee 
{
	private String Name;
	private String stdClass;
	private String Roll;
	private String Month;
	private String monthFee;
	private String examFee;
	private String admissionFee;
	private String otherFee;
	private String total;
	private String year;
	private String date;
	private int row;
	
	private static String[][] table = new String[12][6];
	
	private static String[][] tempTable = new String[12][6];
	
	public dataBaseFee()
	{
		
	}
	
	
		
	public dataBaseFee(String name, String stdClass, String roll,String year)
	{
		Name = name;
		this.stdClass = stdClass;
		Roll = roll;
		this.year = year;
	}



	public dataBaseFee(String name, String stdClass, String roll, String month, String monthFee,
			String examFee,String admissionFee, String otherFee,
			String total, String year, String date)
	{	
		Name = name;
		this.stdClass = stdClass;
		Roll = roll;
		Month = month;
		this.monthFee = monthFee;
		this.examFee = examFee;
		this.admissionFee = admissionFee;
		this.otherFee = otherFee;
		this.total = total;
		this.year = year;
		this.date = date;
	}
	
	public void saveTodataBase()
	{
		String temp = "'" + Name + "','" + stdClass + "','" + Roll + "','" + Month + "','" + 
						monthFee + "','" + examFee + "','" + admissionFee + "','" + otherFee +
						"','" + total + "','" + year + "','" + date + "'";
		
		String query = "INSERT INTO FeeEntry values(" + temp + ")";
		
		performQuery(query);
	}
	
	//SELECT month1, monthFee, examFee, admissionFee, otherFee, total, year1, date1 FROM FeeEntry 
	//WHERE stdName = 'sakib' AND stdClass = '7' AND stdRoll = '7';
	
	public void retrieveData()
	{
		String query = "SELECT month1, monthFee, examFee, admissionFee, otherFee, total, date1 "
				+ "FROM FeeEntry WHERE stdName = '" + Name + "' AND stdClass = '" + stdClass +
				"' AND stdRoll = '" + Roll + "' AND year1 = '" + year + "'";
			
		Connection con = getConnection();
		
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<6;j++)
			{
				table[i][j] = "-";
			}
			
		}
		
		try
		{
			Statement st = con.createStatement();
			ResultSet  rs = st.executeQuery(query);
			
			while(rs.next())
			{		
				switch(rs.getString(1))
				{
				case "January":
				{
					row = 0; 
	
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "February":
				{
					row = 1; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "March":
				{
					row = 2; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "April":
				{
					row = 3; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "May":
				{
					row = 4; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "June":
				{
					row = 5; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "July":
				{
					row = 6; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "August":
				{
					row = 7; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "September":
				{
					row = 8; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "October":
				{
					row = 9; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "November":
				{
					row = 10; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				case "December":
				{
					row = 11; 
					
					table[row][0] = rs.getString(2);
					table[row][1] = rs.getString(3);
					table[row][2] = rs.getString(4);
					table[row][3] = rs.getString(5);
					table[row][4] = rs.getString(7);
					table[row][5] = rs.getString(6);
					break;
				}
				
				}
			}	
			rs.close();
			
			tempTable = table;
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}

	//static return
	public static String[][] getTable()
	{
		return tempTable;
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
