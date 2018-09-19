package studentsInfo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

public class StartWindow implements ActionListener
{
	studentEntry se = new studentEntry();
	
	private JFrame frame = new JFrame("Dewaliabari Model School");
	
	private JPanel panelUp = new JPanel();
	private JPanel panelDown = new JPanel();
	
	
	private Font font = new Font("Serif",Font.BOLD,22);
	
	private JMenu menu = new JMenu("Menu"); 
	
	private JMenuBar mb = new JMenuBar();
	
	private JMenuItem stdEntry = new JMenuItem("New Student Entry");
	private JMenuItem stdTution = new JMenuItem("Tution Fee Entry");
	private JMenuItem exit = new JMenuItem("Exit");
	private JMenuItem about = new JMenuItem("About");
	
	private JLabel imageLabel = new JLabel();
	ImageIcon icon = new ImageIcon("Andromida.png");
	
	public StartWindow(){}
	
	public void iniwindow()
	{	
		BorderLayout upLayout = new BorderLayout();
		BorderLayout frameLayout = new BorderLayout();
		panelUp.setLayout(upLayout);
		frame.setLayout(frameLayout);
		
		menu.setFont(font);
		about.setFont(font);
		exit.setFont(font);
		
		menu.add(stdEntry);
		menu.add(stdTution);
		
		mb.add(menu);
		mb.add(about);
		mb.add(exit);
		
		
		panelUp.add(mb);
		
		imageLabel.setPreferredSize(new Dimension(700,600));
		
		imageLabel.setIcon(icon);	
		panelDown.add(imageLabel);

		frame.add(panelUp,frameLayout.NORTH);
		frame.add(panelDown,frameLayout.CENTER);	
	
		frame.setSize(740, 650);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		stdEntry.addActionListener(this);
		stdTution.addActionListener(this);
		about.addActionListener(this);
		exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == stdEntry)
		{
			se.initializeWindow();
		}
		else if(e.getSource() == stdTution)
		{
			stdTutionFeeLogin stl = new stdTutionFeeLogin();
			stl.initializeWindow();
		}
		else if(e.getSource() == exit)
		{
			frame.dispose();
		}
		else if(e.getSource() == about)
		{
			JOptionPane.showMessageDialog(null, "Founder : MD. Intaj Ali\nEst. : 2012\nPlace : dewaliabari",
					"School Description",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
		
}
