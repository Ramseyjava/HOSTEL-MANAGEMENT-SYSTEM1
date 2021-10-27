package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;

public class HOSTELSETTING  extends javax.swing.JFrame{

	protected static final boolean False = false;
	public JFrame frmAllStudentLiving;
	private JLabel flRegestration;
	private JTextField fldFname;
	private JTextField fldLname;
	private JTextField fldUname;
	private JTextField fldDBT;
	private JTextField fldemail;
	private JButton btnCancel;
	private JButton btnRegister;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	String password,correct;
	private JLabel lblNewLabel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	protected JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public HOSTELSETTING() {
		this.setUndecorated(true);
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setVisible(true);
		initialize();
//		Toolkit tl = new Toolkit.getDefaultToolkit();
//int	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmAllStudentLiving = new JFrame();
		frmAllStudentLiving.getContentPane().setBackground(Color.BLUE);
		frmAllStudentLiving.getContentPane().setForeground(Color.WHITE);
		frmAllStudentLiving.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		frmAllStudentLiving.setTitle("HOSTEL MORE SETTING");
		frmAllStudentLiving.setBounds(300, 300, 700, 850);
		frmAllStudentLiving.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAllStudentLiving.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("LogOut");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmAllStudentLiving.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
			}
		});
		btnNewButton.setBounds(603, 0, 97, 43);
		frmAllStudentLiving.getContentPane().add(btnNewButton);
		
		flRegestration = new JLabel("Regislation ID:");
		flRegestration.setFont(new Font("Dialog", Font.BOLD, 26));
		flRegestration.setForeground(Color.YELLOW);
		flRegestration.setBackground(Color.BLACK);
		flRegestration.setBounds(228, 128, 313, 43);
		frmAllStudentLiving.getContentPane().add(flRegestration);
		
		JButton btnSalary = new JButton("Search");
		
		btnSalary.addActionListener(object->{
			 try {
				Search();
				textField.requestFocus();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnSalary.setBackground(Color.MAGENTA);
		btnSalary.setForeground(Color.BLACK);
		btnSalary.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSalary.setBounds(434, 73, 120, 50);
		frmAllStudentLiving.getContentPane().add(btnSalary);
		
		JLabel lblFirstName = new JLabel("first Name");
		lblFirstName.setBackground(Color.MAGENTA);
		lblFirstName.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName.setForeground(new Color(0, 0, 0));
		lblFirstName.setBounds(12, 183, 155, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName);
		
		JLabel lblFirstName_1 = new JLabel("Last Name");
		lblFirstName_1.setBackground(Color.MAGENTA);
		lblFirstName_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_1.setForeground(new Color(0, 0, 0));
		lblFirstName_1.setBounds(12, 234, 156, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_1);
		
		JLabel lblFirstName_2 = new JLabel("User Name");
		lblFirstName_2.setBackground(Color.MAGENTA);
		lblFirstName_2.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_2.setForeground(new Color(0, 0, 0));
		lblFirstName_2.setBounds(13, 282, 155, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_2);
		
		JLabel lblFirstName_3 = new JLabel("Password");
		lblFirstName_3.setBackground(Color.MAGENTA);
		lblFirstName_3.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_3.setForeground(new Color(0, 0, 0));
		lblFirstName_3.setBounds(12, 339, 156, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_3);
		
		JLabel lblFirstName_4 = new JLabel("Confirm");
		lblFirstName_4.setBackground(Color.MAGENTA);
		lblFirstName_4.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_4.setForeground(new Color(0, 0, 0));
		lblFirstName_4.setBounds(12, 413, 155, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_4);
		
		JLabel lblFirstName_5 = new JLabel("DateOfBirth");
		lblFirstName_5.setBackground(Color.MAGENTA);
		lblFirstName_5.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_5.setForeground(new Color(0, 0, 0));
		lblFirstName_5.setBounds(12, 473, 155, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_5);
		
		JLabel lblFirstName_6 = new JLabel("Email Address");
		lblFirstName_6.setBackground(Color.MAGENTA);
		lblFirstName_6.setFont(new Font("Dialog", Font.BOLD, 22));
		lblFirstName_6.setForeground(new Color(0, 0, 0));
		lblFirstName_6.setBounds(12, 534, 156, 36);
		frmAllStudentLiving.getContentPane().add(lblFirstName_6);
		
		fldFname = new JTextField();
		fldFname.setBounds(201, 183, 231, 37);
		frmAllStudentLiving.getContentPane().add(fldFname);
		fldFname.setColumns(10);
		
		fldLname = new JTextField();
		fldLname.setColumns(10);
		fldLname.setBounds(201, 235, 231, 37);
		frmAllStudentLiving.getContentPane().add(fldLname);
		
		fldUname = new JTextField();
		fldUname.setColumns(10);
		fldUname.setBounds(201, 283, 231, 37);
		frmAllStudentLiving.getContentPane().add(fldUname);
		
		fldDBT = new JTextField();
		fldDBT.setColumns(10);
		fldDBT.setBounds(201, 474, 231, 37);
		frmAllStudentLiving.getContentPane().add(fldDBT);
		
		fldemail = new JTextField();
		fldemail.setColumns(10);
		fldemail.setBounds(201, 535, 231, 37);
		frmAllStudentLiving.getContentPane().add(fldemail);
		
		btnCancel = new JButton("Delete");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Connection conn = Connector.getConnection();
					Statement st = conn.createStatement();
					int i=st.executeUpdate("delete from users where id= "+textField.getText());
					if(i>0) {
						JOptionPane.showMessageDialog(null, "Deleted Succefull!!");
						clear();
					}
					else
					{
						JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
						clear();
					}
				}catch(Exception e) {}
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 17));
		btnCancel.setBounds(324, 595, 128, 43);
		frmAllStudentLiving.getContentPane().add(btnCancel);
		
		btnRegister = new JButton("Register");
		btnRegister.setBackground(Color.MAGENTA);
		btnRegister.setFont(new Font("Dialog", Font.BOLD, 18));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					isValidPassword("String password");
					smartinsert();
					JOptionPane.showMessageDialog(null,"Succefull Registration");
					Connection conn= Connector.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select * from users");
					while(rs.next())
					{
						textField_1.setEditable(false);	
						textField_1.setText(rs.getString(8));
					
					}			
					clear();
					textField.setRequestFocusEnabled(true);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		btnRegister.setBounds(168, 595, 128, 43);
		frmAllStudentLiving.getContentPane().add(btnRegister);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(153, 650, 313, -22);
		frmAllStudentLiving.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("click here to login !");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HOME hm = new HOME();
				hm.show();
				frmAllStudentLiving.setVisible(false);
				DASHBOARD DC = new DASHBOARD();
				DC.frmDashboard.setVisible(false);
				
//				hm.pack();
//				hm.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_1.setForeground(Color.YELLOW);
		lblNewLabel_1.setBounds(178, 652, 316, 33);
		frmAllStudentLiving.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Create Account");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 21));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(12, 123, 217, 38);
		frmAllStudentLiving.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("USERNAME:");
		lblNewLabel_3.setForeground(Color.CYAN);
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 23));
		lblNewLabel_3.setBounds(12, 78, 155, 36);
		frmAllStudentLiving.getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBackground(Color.ORANGE);
		textField.setBounds(171, 73, 217, 43);
		frmAllStudentLiving.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		textField_1.setBackground(Color.BLACK);
		textField_1.setBounds(456, 128, 202, 56);
		frmAllStudentLiving.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 351, 230, 36);
		frmAllStudentLiving.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(202, 413, 230, 36);
		frmAllStudentLiving.getContentPane().add(passwordField_1);
	}
	private void deleteShow() throws Throwable {
		Connection conn;
		Statement st;
		try {
          conn = Connector.getConnection();
          st =conn.createStatement();
          st.executeUpdate("delete from users where username= "+textField);
          

		}catch(SQLException e) {}
		textField.setText(null);
		textField.requestFocus();
	}
	private void smartinsert() throws SQLException, ClassNotFoundException{
		Connection conn;
		PreparedStatement pst;
		try {
			conn=Connector.getConnection();
			String sql1= "select * from users where username=? and password=?";
			pst= conn.prepareStatement(sql1);
			ResultSet rs = pst.executeQuery();
			String user=fldUname.getText();
			if(rs.next()) {
//				
				if(rs.getString('1').equals(user) || rs.getString('2').equals(password)); 
				JOptionPane.showMessageDialog(null, "Username and password are already used!!!","" +"\n"+ "Try again please!.", getDefaultCloseOperation() );
			}else {
				conn = Connector.getConnection();
				String sql ="insert into users (username,password,role,firstName,lastName,DateOfBirth,Email)values(?,?,?,?,?,?,?)";
				  String password = Confirm(passwordField.getText(),passwordField_1.getText());
				pst =conn.prepareStatement(sql);
				pst.setString(1, fldUname.getText());
				pst.setString(2, password);
				pst.setString(3, "");
				pst.setString(4, fldFname.getText());
				pst.setString(5, fldLname.getText());
				pst.setString(6, fldDBT.getText());
				pst.setString(7, fldemail.getText());
				pst.execute();
			}
		
//		JOptionPane.showMessageDialog(null, "Succefull inserted!!");
	
		}catch(Exception e) {
		e.printStackTrace();
		
		}
	}
private String Confirm(String pass1,String pass2) {
	if(pass1.equals(pass2)) {
	  password = passwordField_1.getText();
	}else if(pass1!=pass2) {
		JOptionPane.showMessageDialog(null, "password mismatch!!");
	}
	return password;
}
private void clear()
{
	fldemail.setText(null);
	fldFname.setText(null);
	fldLname.setText(null);
	passwordField.setText(null);
	fldUname.setText("");
	passwordField_1.setText(null);
	fldDBT.setText("");
}private void Search() throws Exception, ClassNotFoundException {
	Connection conn;
	
	try {
		conn = Connector.getConnection();

		String user = textField.getText();
		String sql="Select * from users where username= " + user;
		
		PreparedStatement pst;
		pst=conn.prepareStatement(sql);

		ResultSet rs=pst.executeQuery();
		pst.setString(1,fldFname.getText());
		while(rs.next()) {
			fldUname.setText(rs.getString(1));
			passwordField.setText(rs.getString(2));
			fldFname.setText(rs.getString(4));
			fldLname.setText(rs.getString(5));
			fldDBT.setText(rs.getString(6));
			fldemail.setText(rs.getString(7));	
		}		
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}
public  boolean isValidPassword(String password) throws SQLException, ClassNotFoundException {
	boolean isValid= true;
	if(password.length()>15 || password.length()<8)
	{
//   JOptionPane.showInputDialog(password);
   JOptionPane.showMessageDialog(null, "password must be less than 20 and more than 8 characters in lenght.");
   isValid= false;
	}
	String upperCaseChars ="(.*[A-Z])";
	if (!password.matches(upperCaseChars))
	{
	JOptionPane.showMessageDialog(null, "Password must have atleast one uppercase charcter!");
	isValid =False;
	}
	String lowerCaseChars ="(.*[a-z].*)";
	if (!password.matches(lowerCaseChars))
	{
	JOptionPane.showMessageDialog(null, "Password must have atleast one lowerCaseChars charcter!");
	isValid =False;
	}
	String numbers ="(.*[0-9].*)";
	if (!password.matches(numbers))
	{
	JOptionPane.showMessageDialog(null, "Password must have atleast one numbers charcter!");
	isValid =False;
	}
	String specialChars ="(.*[@,#,$,%].*$)";
	if (!password.matches(specialChars))
	{
	JOptionPane.showMessageDialog(null, "Password must have atleast one special charcter!");
	isValid =False;
	}
	return isValid=true;
	
}
}