package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Action;
import javax.swing.ButtonGroup;
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
import javax.swing.JCheckBox;

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
	private JRadioButton btnfemale ;
	private JRadioButton btnmale ;
	
	String []status = {"Living","Leaved"};
	String currentstatus;
	String item ;
	JLabel lblGender ;
    int id;
    int id1;
    String gender;
	JComboBox<?> comboBox;
	/**
	 * Create the application.
	 */
	public Newstudent() {
		initialize();
		ButtonGroup gb =new ButtonGroup();
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
					mobile.setText(null);
					student.setText(null);
					parentname.setText(null);
		            email.setText(null);
		            idnumber.setText(null);
		            room.setText(null);
		            year.setText(null);
		            admno.setText(null);
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
//		room=set.
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
		

		 lblGender = new JLabel("Gender");
		 lblGender.setFont(new Font("Dialog", Font.BOLD, 23));
		 lblGender.setBackground(Color.MAGENTA);
		 lblGender.setBounds(12, 469, 138, 36);
		frame2.getContentPane().add(lblGender);
		
		JLabel lblstatus = new JLabel("lIVING STATUS");
		lblstatus.setFont(new Font("Dialog", Font.BOLD, 23));
		lblstatus.setBackground(Color.MAGENTA);
		lblstatus.setBounds(12, 412, 193, 36);
		frame2.getContentPane().add(lblstatus);
		
		JLabel lblyear = new JLabel("Year");
		lblyear.setFont(new Font("Dialog", Font.BOLD, 23));
		lblyear.setBackground(Color.MAGENTA);
		lblyear.setBounds(12, 358, 138, 36);
		frame2.getContentPane().add(lblyear);
		
		JLabel lbladm = new JLabel("ADM No");
		lbladm.setFont(new Font("Dialog", Font.BOLD, 23));
		lbladm.setBackground(Color.MAGENTA);
		lbladm.setBounds(12, 321, 138, 36);
		frame2.getContentPane().add(lbladm);
		
		JLabel lblroom = new JLabel("ROOM No");
		lblroom.setFont(new Font("Dialog", Font.BOLD, 23));
		lblroom.setBackground(Color.MAGENTA);
		lblroom.setBounds(12, 258, 138, 36);
		frame2.getContentPane().add(lblroom);
		
		JLabel lblid = new JLabel("STUDENT ID");
		lblid.setFont(new Font("Dialog", Font.BOLD, 23));
		lblid.setBackground(Color.MAGENTA);
		lblid.setBounds(12, 207, 193, 36);
		frame2.getContentPane().add(lblid);
		
		JLabel lblemail = new JLabel("Email Address");
		lblemail.setFont(new Font("Dialog", Font.BOLD, 23));
		lblemail.setBackground(Color.MAGENTA);
		lblemail.setBounds(12, 157, 200, 36);
		frame2.getContentPane().add(lblemail);
		
		JLabel lblparent = new JLabel("PARENT NAME");
		lblparent.setFont(new Font("Dialog", Font.BOLD, 23));
		lblparent.setBackground(Color.MAGENTA);
		lblparent.setBounds(12, 104, 193, 36);
		frame2.getContentPane().add(lblparent);
		
		JLabel lblname = new JLabel("STUDENT NAME");
		lblname.setFont(new Font("Dialog", Font.BOLD, 23));
		lblname.setBackground(Color.MAGENTA);
		lblname.setBounds(12, 56, 220, 36);
		frame2.getContentPane().add(lblname);
		
		ButtonGroup gb =new ButtonGroup();
		
		
		 btnmale = new JRadioButton("Male");
		btnmale.addItemListener(v->{
			gender="Male";
			
			gb.add(btnmale);
		});
		btnmale.setBounds(250, 487, 69, 35);
		frame2.getContentPane().add(btnmale);
		
		 btnfemale = new JRadioButton("Female");
		btnfemale.addItemListener(v->{
			gender="Female";
			gb.add(btnfemale);
			
//			btnfemale.setToggleGroup(gb);
//			

		});
		btnfemale.setBounds(431, 483, 76, 43);
		frame2.getContentPane().add(btnfemale);
		frame2.setVisible(true);
	}
	private void Insert() throws Exception {

//if(mobile.setMaximumSize(10)) {}
	
		id1 = comboBox.getSelectedIndex();
		Connection conn;
		PreparedStatement ps;
		
		try {
			conn = Connector.getConnection();
		String sql = "insert into Students (mobile,studentname,parent,email,idno,roomno,year,status,gender,comment) values(?,?,?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(mobile.getText()));
		ps.setString(2, student.getText());
		ps.setString(3, parentname.getText());
		ps.setString(4, email.getText());
		ps.setInt(5, Integer.parseInt(idnumber.getText()));
		ps.setInt(6, Integer.parseInt(room.getText()));
		ps.setString(7, year.getText());
		ps.setString(8, comboBox.getItemAt(id)+"");
		ps.setString(9, gender);
		ps.setString(10, "");
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