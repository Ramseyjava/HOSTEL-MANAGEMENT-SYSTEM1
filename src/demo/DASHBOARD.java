package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class DASHBOARD  {

	private static final int MAXIMIZED_BOTH = 0;
	public JFrame frmDashboard;
	JLabel note ;
	public JLabel lblNewLabel_1;
	private JButton btnc;
	/**
	 * @wbp.nonvisual location=137,5
	 */
	private final JLayeredPane layeredPane = new JLayeredPane();
	public DASHBOARD() {
		
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboard = new JFrame();
		JFrame jFrame = new JFrame();
		
		frmDashboard.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 26));
		frmDashboard.setTitle("DASHBOARD");
		frmDashboard.getContentPane().setBackground(new Color(255, 0, 255));
		frmDashboard.setBounds(200, 200, 845, 524);
		frmDashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboard.getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New Student");
		btnNewButton_1.setFont(new Font("Open Sans Extrabold", Font.BOLD, 20));
		btnNewButton_1.setBounds(12, 85, 200, 36);
		btnNewButton_1.addActionListener(object->{
			Newstudent ns = new Newstudent();
			frmDashboard.setVisible(false);
		});
		frmDashboard.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update &DeleteStudent");
		btnNewButton_2.setBackground(Color.ORANGE);
		btnNewButton_2.setFont(new Font("URW Chancery L", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(12, 146, 200, 40);
		btnNewButton_2.addActionListener(object->{
			btnNewButton_2.setForeground(Color.red);
			btnNewButton_2.setBackground(new Color(255,255,255));
			new updateStudent().setVisible(true);
			updateStudent us = new updateStudent();
			us.frmUpdateAndDelete.setVisible(true);
			frmDashboard.setVisible(false);
		});
		frmDashboard.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Student Rent");	
		btnNewButton_3.setFont(new Font("eufm10", Font.BOLD, 22));
		btnNewButton_3.setBounds(12, 196, 200, 35);
		btnNewButton_3.addActionListener(object->{
            STUDENTRENT sl = new STUDENTRENT();
            frmDashboard.setVisible(false);
		});
		frmDashboard.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("HOSTEL SETTING");
		btnNewButton_4.setBackground(Color.ORANGE);
		btnNewButton_4.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmDashboard.setVisible(false);
				JButton btn = new JButton();
				btn.setBackground(Color.blue);
				btn.setForeground(new Color(255,255,255));
				btn.setVisible(true);
				HOSTELSETTING all = new HOSTELSETTING();
				all.frmAllStudentLiving.setVisible(true);
				
			}
		});
		btnNewButton_4.setBounds(12, 450, 200, 35);
		frmDashboard.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New Employee");
		btnNewButton_5.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 21));
		btnNewButton_5.setBounds(12, 296, 200, 35);
		btnNewButton_5.addActionListener(ob->{
			NewEmployee ne = new NewEmployee();
			ne.Show();
			frmDashboard.setVisible(false);
		});
		frmDashboard.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Update & Delete Employee");
		btnNewButton_6.setBackground(Color.ORANGE);
	
		btnNewButton_6.setFont(new Font("Cantarell Extra Bold", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_6.setBounds(12, 359, 200, 36);
		btnNewButton_6.addActionListener(ob->{
			UpdateDelectEmployee ue = new UpdateDelectEmployee();
			ue.Show();
			frmDashboard.setVisible(false);
			
		});
		frmDashboard.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Employee payment");
		btnNewButton_7.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 21));
		btnNewButton_7.setBounds(12, 410, 200, 28);
		btnNewButton_7.addActionListener(oj->{
			EmployeePayment ep = new EmployeePayment();
			ep.Show();
			frmDashboard.setVisible(false);
		});
		frmDashboard.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_9 = new JButton("Exit");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_9.setBounds(302, -47, 117, 28);
		frmDashboard.getContentPane().add(btnNewButton_9);
		
		JButton btnExit = new JButton("LogOut");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(Color.RED);
		btnExit.setFont(new Font("DejaVu Sans Mono", Font.BOLD | Font.ITALIC, 14));
		btnExit.setIcon(null);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(748, 0, 85, 42);
		frmDashboard.getContentPane().add(btnExit);
		
		JButton btnManageRoom = new JButton("MANAGE ROOM");
		btnManageRoom.setBackground(Color.GREEN);
		btnManageRoom.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 20));
		btnManageRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JButton btn= new JButton();
//				btnc.setBackground(Color.blue);
//				btnc.setForeground(new Color(255,255,255));
				ManageRoom mr = new ManageRoom();
				mr.show();
				frmDashboard.setVisible(false);
			}
		});
		btnManageRoom.setBounds(12, 10, 200, 63);
		frmDashboard.getContentPane().add(btnManageRoom);
		
		JButton btnNewButton = new JButton("Student Details");
		btnNewButton.setBackground(Color.ORANGE);
		btnNewButton.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD | Font.ITALIC, 20));
		btnNewButton.setBounds(12, 249, 200, 35);
		btnNewButton.addActionListener(ob->{
			STUDENTDETAILS ls = new STUDENTDETAILS();
			ls.Show();
			
		});
		
		frmDashboard.getContentPane().add(btnNewButton);
	   lblNewLabel_1 = new JLabel("");
	   lblNewLabel_1.setForeground(Color.BLUE);
	   lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(238, 6, 417, 29);
		frmDashboard.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/background.png"));
		lblNewLabel.setBounds(215, 6, 630, 479);
		frmDashboard.getContentPane().add(lblNewLabel);
		jFrame.setExtendedState(MAXIMIZED_BOTH);

	}
	public void show() {
		frmDashboard.setVisible(true);
	}
}
