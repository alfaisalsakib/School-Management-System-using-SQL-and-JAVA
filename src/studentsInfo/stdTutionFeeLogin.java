package studentsInfo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Calendar;

import javax.swing.*;

public class stdTutionFeeLogin  implements ActionListener
{
	private String Name;
	private String Class;
	private String Roll;
	private String year;
	private Calendar cd = Calendar.getInstance();
	
	private JFrame window = new JFrame("Student Authentication");
	
	private JLabel stuName = new JLabel("Student Name");
	private JLabel stuClass = new JLabel("Student Class (Numeric Number)");
	private JLabel stuRoll = new JLabel("Student Roll (Numeric Number)");
	
	private JTextField StuName = new JTextField("Enter Name Here");
	private JTextField StuClass = new JTextField("Enter Class Here");
	private JTextField StuRoll = new JTextField("Enter Roll Here");
	
	private JButton search = new JButton("SEARCH");
	private JButton clear = new JButton("CLEAR");
	
	public stdTutionFeeLogin()
	{
		
	}
	
	public void initializeWindow()
	{
		GridLayout gl = new GridLayout(4,2,5,5);
		
		window.setLayout(gl);
		
		
		window.add(stuName);
		window.add(StuName);
		window.add(stuClass);
		window.add(StuClass);
		window.add(stuRoll);
		window.add(StuRoll);
		window.add(search);
		window.add(clear);
		
		window.setSize(440, 340);
		window.setLocation(280,280);
		window.setVisible(true);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clear.addActionListener(this);
		search.addActionListener(this);
		
		Name = StuName.getText();
		Class = StuClass.getText();
		Roll = StuRoll.getText();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == clear)
		{
			StuName.setText("");
			StuClass.setText("");
			StuRoll.setText("");
		}
		
		//SELECT *FROM studentDataEntry
		//WHERE stdName = 'sakib'and stdClass = '7' and stdRoll = 1;
		else if(e.getSource() == search)
		{
			Connection con = dataBaseEntry.getConnection();
			String var = "stdName = '" + StuName.getText().toLowerCase() + "' and stdClass = '" + StuClass.getText()
							+  "' and stdRoll = '" + StuRoll.getText() + "'";
			String query = "SELECT *FROM studentDataEntry WHERE " + var;
			
			try 
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				rs.next();
				
				Name = rs.getString(1);
				Class = rs.getString(2);
				Roll = rs.getString(3);
				
				if(Name.equals(StuName.getText().toLowerCase()) && Class.equals(StuClass.getText()) && Roll.equals(StuRoll.getText()))
				{
					JOptionPane.showMessageDialog(null, StuName.getText() + " is found");
					
					year = Integer.toString(cd.get(Calendar.YEAR));
					
					dataBaseFee dbf = new dataBaseFee(Name,Class,Roll,year);
					dbf.retrieveData();
					
					stdTutionFeeChart stdChart = new stdTutionFeeChart(Name,Class,Roll);
					stdChart.iniWindow();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, StuName.getText() + " is not found");
				}
				
			} 
			catch (SQLException e1)
			{
				JOptionPane.showMessageDialog(null, StuName.getText() + " is not found");
			}
		}		
	}
}
