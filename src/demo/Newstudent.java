package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;

public class Newstudent {

	private JFrame frame2;
	private JTextField mobile;
	private JTextField student;
	private JTextField parentname;
	private JTextField email;
	private JTextField idnumber;
	private JTextField room;
	private JTextField admno;
	private JTextField year;
	String []status = {"Living","Leaved"};
	String currentstatus;
	String item ;
    int id;
    int id1;
    String Gender;
	JComboBox<?> comboBox;
	/**
	 * Create the application.
	 */
	public Newstudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.getContentPane().setFont(new Font("Lato Black", Font.PLAIN, 16));
		frame2.getContentPane().setBackground(Color.BLUE);
		frame2.getContentPane().setForeground(Color.BLUE);
		frame2.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 22));
		frame2.setTitle("NEW STUDENT");
		frame2.setBounds(200, 200, 600, 650);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Mobile No.");
		btnNewButton.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(12, 21, 138, 35);
		frame2.getContentPane().add(btnNewButton);
		
		mobile = new JTextField();
		mobile.setBackground(Color.MAGENTA);
		mobile.setBounds(205, 21, 285, 35);
		frame2.getContentPane().add(mobile);
		mobile.setColumns(10);
		
		student = new JTextField();
		student.setColumns(10);
		student.setBounds(250, 67, 257, 30);
		frame2.getContentPane().add(student);
		
		parentname = new JTextField();
		parentname.setColumns(10);
		parentname.setBounds(250, 113, 257, 30);
		frame2.getContentPane().add(parentname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(250, 166, 257, 30);
		frame2.getContentPane().add(email);
		
		idnumber = new JTextField();
		idnumber.setColumns(10);
		idnumber.setBounds(250, 216, 257, 30);
		frame2.getContentPane().add(idnumber);
		
		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.setBackground(Color.PINK);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Insert();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_6.setFont(new Font("DejaVu Serif Condensed", Font.BOLD | Font.ITALIC, 20));
		btnNewButton_6.setBounds(244, 550, 117, 35);
	
		frame2.getContentPane().add(btnNewButton_6);
		
		JButton btnDelect = new JButton("Delete");
		btnDelect.setBackground(Color.RED);
		btnDelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mobile.setText(null);
				student.setText(null);
				parentname.setText(null);
	            email.setText(null);
	            idnumber.setText(null);
	            room.setText(null);
	            year.setText(null);
	            admno.setText(null);
	            
			}
		});
		btnDelect.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 20));
		btnDelect.setBounds(390, 552, 117, 35);
		frame2.getContentPane().add(btnDelect);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(Color.CYAN);
		btnExit.setBackground(Color.RED);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnExit.setBackground(Color.blue);
				btnExit.setForeground(new Color(255,255,255));
			}
		});
		btnExit.setFont(new Font("C059", Font.BOLD | Font.ITALIC, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frame2.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
			}
		});
		btnExit.setBounds(513, 0, 87, 48);
		frame2.getContentPane().add(btnExit);
		
		room = new JTextField();
		room.setBounds(250, 267, 257, 30);
		frame2.getContentPane().add(room);
		room.setColumns(10);
		
		admno = new JTextField();
		admno.setColumns(10);
		admno.setBounds(250, 326, 257, 30);
		frame2.getContentPane().add(admno);
		
//		Date date = (Date)getDate().
		
		year = new JTextField();
		year.setColumns(10);
		year.setBounds(250, 368, 257, 30);
		frame2.getContentPane().add(year);
		
		comboBox = new JComboBox(status);
		comboBox.setBackground(Color.MAGENTA);
		comboBox.setBounds(250, 417, 257, 32);
		comboBox.addItemListener((args)->{
		id = comboBox.getSelectedIndex();
	     switch(id) {
	     case 0:
	    	 currentstatus = "Living";
	    	 break;
	     case 1:
	    	 currentstatus = "leaved";
	    	 break;
	    	 
	     }
		});
		frame2.getContentPane().add(comboBox);
		

		JLabel Gender = new JLabel("Gender");
		Gender.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender.setBackground(Color.MAGENTA);
		Gender.setBounds(12, 469, 138, 36);
		frame2.getContentPane().add(Gender);
		
		JLabel Gender_1 = new JLabel("lIVING STATUS");
		Gender_1.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_1.setBackground(Color.MAGENTA);
		Gender_1.setBounds(12, 412, 193, 36);
		frame2.getContentPane().add(Gender_1);
		
		JLabel Gender_2 = new JLabel("Year");
		Gender_2.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_2.setBackground(Color.MAGENTA);
		Gender_2.setBounds(12, 358, 138, 36);
		frame2.getContentPane().add(Gender_2);
		
		JLabel Gender_3 = new JLabel("ADM No");
		Gender_3.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_3.setBackground(Color.MAGENTA);
		Gender_3.setBounds(12, 321, 138, 36);
		frame2.getContentPane().add(Gender_3);
		
		JLabel Gender_4 = new JLabel("ROOM No");
		Gender_4.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_4.setBackground(Color.MAGENTA);
		Gender_4.setBounds(12, 258, 138, 36);
		frame2.getContentPane().add(Gender_4);
		
		JLabel Gender_5 = new JLabel("STUDENT ID");
		Gender_5.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_5.setBackground(Color.MAGENTA);
		Gender_5.setBounds(12, 207, 193, 36);
		frame2.getContentPane().add(Gender_5);
		
		JLabel Gender_6 = new JLabel("Email Address");
		Gender_6.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_6.setBackground(Color.MAGENTA);
		Gender_6.setBounds(12, 157, 200, 36);
		frame2.getContentPane().add(Gender_6);
		
		JLabel Gender_7 = new JLabel("PARENT NAME");
		Gender_7.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_7.setBackground(Color.MAGENTA);
		Gender_7.setBounds(12, 104, 193, 36);
		frame2.getContentPane().add(Gender_7);
		
		JLabel Gender_8 = new JLabel("STUDENT NAME");
		Gender_8.setFont(new Font("Dialog", Font.BOLD, 23));
		Gender_8.setBackground(Color.MAGENTA);
		Gender_8.setBounds(12, 56, 220, 36);
		frame2.getContentPane().add(Gender_8);
		frame2.setVisible(true);
	}
	private void Insert() throws Exception {
		id1 = comboBox.getSelectedIndex();
		Connection conn;
		PreparedStatement ps;
		try {
			conn = Connector.getConnection();
		String sql = "insert into Students (mobile,studentname,parent,email,idno,roomno,year,status,Gender) values(?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(mobile.getText()));
		ps.setString(2, student.getText());
		ps.setString(3, parentname.getText());
		ps.setString(4, email.getText());
		ps.setInt(5, Integer.parseInt(idnumber.getText()));
		ps.setInt(6, Integer.parseInt(room.getText()));
		ps.setString(7, year.getText());
		ps.setString(8, comboBox.getItemAt(id)+"");
		ps.setString(9, Gender);
		int i =ps.executeUpdate();
		if(i>0) {
			JOptionPane.showMessageDialog(null, "succefull inserted!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, " error!!!...unsuccefull inserted try again");
		}
		
	}catch(SQLException e) {
		System.out.println(" insert student error"+ e);
	}
}
}