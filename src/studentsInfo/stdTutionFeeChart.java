package studentsInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.*;


public class stdTutionFeeChart  implements ActionListener
{
	private String stuName ;
	private String stuClass ;
	private String stuRoll; 
	private static String year;
	private String[] column = new String[7];
	private String[][] row = new String[12][7];
	private String[][] tempTable = new String[12][6];
	private int Sum;
	private int rowNumber;
	private String date;
	
	
	private JFrame frame = new JFrame("Tution Fee Chart");
	private Font font1 = new Font("Serif",Font.BOLD,18);
	private Font font2 = new Font("Serif",Font.BOLD,16);
	private Font font3 = new Font("Serif",Font.BOLD,14);
	
	private Date d = new Date();
	private Calendar calendar = Calendar.getInstance();
	
	private JMenu menu = new JMenu("Select Month");
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem jan = new JMenuItem("January");
	private JMenuItem feb = new JMenuItem("February");
	private JMenuItem mar = new JMenuItem("March");
	private JMenuItem apr = new JMenuItem("April");
	private JMenuItem may = new JMenuItem("May");
	private JMenuItem june = new JMenuItem("June");
	private JMenuItem july = new JMenuItem("July");
	private JMenuItem aug = new JMenuItem("August");
	private JMenuItem sep = new JMenuItem("September");
	private JMenuItem oct = new JMenuItem("October");
	private JMenuItem nov = new JMenuItem("November");
	private JMenuItem dec = new JMenuItem("December");
	
	
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
	private JLabel Name = new JLabel("Name :");
	private JLabel fixName;
	private JLabel Class = new JLabel("Class :");
	private JLabel fixClass;
	private JLabel Roll = new JLabel("Roll  :");
	private JLabel fixRoll ;
	private JLabel emptyLabel = new JLabel();
	private JLabel  y = new JLabel("Year");
	private JLabel yearValue;
	
	private JLabel monthFee = new JLabel("Enter Monthly Fee");
	private JLabel admissionFee = new JLabel("Enter Admission Fee");
	private JLabel examFee = new JLabel("Enter Exam Fee");
	private JLabel otherFee = new JLabel("Enter Other Fee");
	
	private JTextField MonthFee = new JTextField("Numeric Value");
	private JTextField AdmissionFee = new JTextField("Numeric Value");
	private JTextField ExamFee = new JTextField("Numeric Value");
	private JTextField OtherFee = new JTextField("Numeric Value");
	
	private JButton save = new JButton("Save");
	private JButton clear = new JButton("clear");
	
	private JTable monthTable = new JTable();
	private DefaultTableModel dm;
	
	private Dimension dimsn = new Dimension(1150,350);
	
	public stdTutionFeeChart(){}
	public stdTutionFeeChart(String stdName,String stdClass,String stdRoll)
	{
		this.stuName = stdName;
		this.stuClass = stdClass;
		this.stuRoll = stdRoll;
	}
	
	public void iniWindow()
	{
		GridLayout panel1Layout = new GridLayout(5,2,5,5);
		GridLayout panel3Layout = new GridLayout(5,2,5,5);
		BorderLayout frameLayout = new BorderLayout();
		
		fixName = new JLabel(stuName);
		fixClass = new JLabel(stuClass);
		fixRoll = new JLabel(stuRoll);
		
		Name.setFont(font3);
		Class.setFont(font3);
		Roll.setFont(font3);
		fixName.setFont(font3);
		fixClass.setFont(font3);
		fixRoll.setFont(font3);
		y.setFont(font1);
		monthFee.setFont(font1);
		MonthFee.setFont(font2);
		admissionFee.setFont(font1);
		AdmissionFee.setFont(font2);
		examFee.setFont(font1);
		ExamFee.setFont(font2);
		otherFee.setFont(font1);
		OtherFee.setFont(font2);
		
		menu.setFont(font1);	
		save.setFont(font1);
		clear.setFont(font1);
		
		menu.add(jan);
		menu.add(feb);
		menu.add(mar);
		menu.add(apr);
		menu.add(may);
		menu.add(june);
		menu.add(july);
		menu.add(aug);
		menu.add(sep);
		menu.add(oct);
		menu.add(nov);
		menu.add(dec);
		
		menuBar.add(menu);
		
		year = Integer.toString(calendar.get(Calendar.YEAR));
		
		yearValue = new JLabel(year);
		yearValue.setFont(font1);
		
		panel1.setLayout(panel1Layout);
		panel1.add(menuBar);
		panel1.add(emptyLabel);
		panel1.add(Name);
		panel1.add(fixName);
		panel1.add(Class);
		panel1.add(fixClass);
		panel1.add(Roll);
		panel1.add(fixRoll);
		panel1.add(y);
		panel1.add(yearValue);
		
		table();
	
		dm = new DefaultTableModel(row,column);
			
		monthTable.setModel(dm);
		
		monthTable.setRowHeight(40);	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(dimsn);
		scrollPane.setViewportView(monthTable);
			
		for(int i=0;i<12;i++)
		{
			dm.setValueAt(row[i][0], i,0);
		}
		
		for(int i=0;i<12;i++)
		{
			for(int j=0;j<6;j++)
			{
				dm.setValueAt(tempTable[i][j], i, j+1);
			}
		}		
	
		panel2.add(scrollPane);
		
		panel3.setLayout(panel3Layout);
		panel3.add(monthFee);
		panel3.add(MonthFee);
		panel3.add(admissionFee);
		panel3.add(AdmissionFee);
		panel3.add(examFee);
		panel3.add(ExamFee);
		panel3.add(otherFee);
		panel3.add(OtherFee);
		panel3.add(save);
		panel3.add(clear);
	
		frame.setLayout(frameLayout);
		frame.add(panel1,frameLayout.NORTH);
		frame.add(panel2, frameLayout.CENTER);
		frame.add(panel3,frameLayout.SOUTH);
		//frame.setSize(1000, 800);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		save.addActionListener(this);
		clear.addActionListener(this);
		jan.addActionListener(this);
		feb.addActionListener(this);
		mar.addActionListener(this);
		apr.addActionListener(this);
		may.addActionListener(this);
		june.addActionListener(this);
		july.addActionListener(this);
		aug.addActionListener(this);
		sep.addActionListener(this);
		oct.addActionListener(this);
		nov.addActionListener(this);
		dec.addActionListener(this);
	}
	
	public void table()
	{
		column[0] = "Month";column[1] = "Monthly Fee";column[2] = "Admission Fee";
		column[3] = "Exam Fee";column[4] = "Other Fee";column[6] = "Total";column[5] = "Date";
		
		row[0][0] = "January";row[1][0] = "February";row[2][0] = "March";row[3][0] = "April";
		row[4][0] = "May";row[5][0] = "June";row[6][0] = "July";row[7][0] = "August";row[8][0] = "September";row[9][0] = "October";
		row[10][0] = "November";row[11][0] = "December";
		
		tempTable = dataBaseFee.getTable();		
	}
	
	
	public void sum()
	{
		int columnSize = monthTable.getColumnCount();	
		
		Sum=0;
		
			try
			{
				for(int i=1;i<columnSize-2;i++)
				{
					Sum = Sum + Integer.parseInt(monthTable.getValueAt(rowNumber,i).toString());
					
				}
				monthTable.setValueAt(Integer.toString(Sum),rowNumber, columnSize-1);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Invalid Entry");
				
			}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == clear)
		{
			MonthFee.setText(null);
			AdmissionFee.setText(null);
			ExamFee.setText(null);
			OtherFee.setText(null);
		}
		else if(e.getSource() == save)
		{
			try
			{
				int mf = Integer.parseInt(MonthFee.getText());
				int af = Integer.parseInt(AdmissionFee.getText());
				int ef = Integer.parseInt(ExamFee.getText());
				int of = Integer.parseInt(OtherFee.getText());
				
				
				dm.setValueAt(MonthFee.getText(), rowNumber,1);
				dm.setValueAt(AdmissionFee.getText(), rowNumber,2);
				dm.setValueAt(ExamFee.getText(), rowNumber,3);
				dm.setValueAt(OtherFee.getText(), rowNumber,4);
				
				dm.setValueAt(d.toString(), rowNumber, 5);
				
				sum();
				
				Calendar cl = Calendar.getInstance();
				
				String month = row[rowNumber][0];
				String total = Integer.toString(Sum);
				String y = Integer.toString(cl.get(Calendar.YEAR));
				String dat = d.toString();
				
				
				dataBaseFee dataEntry = new dataBaseFee(stuName,stuClass,stuRoll,month,MonthFee.getText(),
						ExamFee.getText(),AdmissionFee.getText(),OtherFee.getText(),total,y,dat);
				
				
				dataEntry.saveTodataBase();
				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Invalid Entry");
			}
			
		}
		else if(e.getSource() == jan)
		{
			rowNumber = 0;	
		}
		else if(e.getSource() == feb)
		{
			rowNumber = 1;
		}
		else if(e.getSource() == mar)
		{
			rowNumber = 2;
		}
		else if(e.getSource() == apr)
		{
			rowNumber = 3;
		}
		else if(e.getSource() == may)
		{
			rowNumber = 4;
		}
		else if(e.getSource() == june)
		{
			rowNumber = 5;
		}
		else if(e.getSource() == july)
		{
			rowNumber = 6;
		}
		else if(e.getSource() == aug)
		{
			rowNumber = 7;
		}
		else if(e.getSource() == sep)
		{
			rowNumber = 8;
		}
		else if(e.getSource() == oct)
		{
			rowNumber = 9;
		}
		else if(e.getSource() == nov)
		{
			rowNumber = 10;
		}
		else if(e.getSource() == dec)
		{
			rowNumber = 11;
		}	
	}
}
