package studentsInfo;

import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class studentEntry implements ActionListener
{
	private JFrame window = new JFrame("NEW STUDENT ENTRY");

	private Font font1 = new Font("Serif",Font.BOLD,20);
	private Font font2 = new Font("Serif",Font.BOLD,18);
	
	private JLabel stuName = new JLabel("Student Name");
	private JLabel fatherName = new JLabel("Father Name");
	private JLabel motherName = new JLabel("Mother Name");
	private JLabel stuAge = new JLabel("Student Age");
	private JLabel birthDate = new JLabel("Student BirthDate (day-month-year)");
	private JLabel stuClass = new JLabel("Student Class");
	private JLabel stuRoll = new JLabel("Student Roll");
	
	private JTextField StuName = new JTextField("Enter Name Here");
	private JTextField FatherName = new JTextField("Father Name");
	private JTextField MotherName = new JTextField("Mother Name");
	private JTextField StuAge = new JTextField("Student Age");
	private JTextField BirthDate = new JTextField("Student BirthDate");
	private JTextField StuClass = new JTextField("Enter Class Here");
	private JTextField StuRoll = new JTextField("Enter Roll Here");
	
	private JButton entry = new JButton("ENTRY");
	private JButton clear = new JButton("CLEAR");
	
	public studentEntry()
	{
		
	}
	
	public void initializeWindow()
	{
		GridLayout gl = new GridLayout(8,2,5,5);
		
		window.setLayout(gl);
		
		stuName.setFont(font1);
		StuName.setFont(font2);
		fatherName.setFont(font1);
		FatherName.setFont(font2);
		motherName.setFont(font1);
		MotherName.setFont(font2);
		birthDate.setFont(font1);
		BirthDate.setFont(font2);
		stuAge.setFont(font1);
		StuAge.setFont(font2);
		stuClass.setFont(font1);
		StuClass.setFont(font2);
		stuRoll.setFont(font1);
		StuRoll.setFont(font2);
		entry.setFont(font1);
		clear.setFont(font1);
		
		window.add(stuName);
		window.add(StuName);
		window.add(fatherName);
		window.add(FatherName);
		window.add(motherName);
		window.add(MotherName);
		window.add(birthDate);
		window.add(BirthDate);
		window.add(stuAge);
		window.add(StuAge);
		window.add(stuClass);
		window.add(StuClass);
		window.add(stuRoll);
		window.add(StuRoll);
		window.add(entry);
		window.add(clear);
		
		window.setSize(700, 600);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.setExtendedState(Frame.MAXIMIZED_BOTH);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		clear.addActionListener(this);
		entry.addActionListener(this);
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == clear)
		{
			StuName.setText(null);
			FatherName.setText(null);
			MotherName.setText(null);
			BirthDate.setText(null);
			StuAge.setText(null);
			StuClass.setText(null);
			StuRoll.setText(null);
		}
		else if(e.getSource() == entry)
		{
			dataBaseEntry dataEntry = new dataBaseEntry(StuName.getText().toUpperCase(),StuClass.getText(),
					StuRoll.getText(),FatherName.getText(),MotherName.getText(),BirthDate.getText()
					,StuAge.getText());
			
			dataEntry.manageTask();
		}		
	}
}
