package demo;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
//
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeEvent;
   public class Login   {

	public JFrame frmLogin;
	private JTextField textField;
	public Connection conn;
	public PreparedStatement ps;
	private JPasswordField passwordField;
	private JCheckBox check;
	protected Object show;
	private JLabel lblNewLabel;
	private final JPanel panel = new JPanel();
	JComboBox comboBox;
	String password,Security;
	int id;


	public Login() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	
protected void Get_Connection() throws SQLException {
		
	try {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/Hostel";
		String user = "root";
		String password = "";
		//register your driver
		Class.forName(driver);
		//create a connection
		conn = DriverManager.getConnection(url, user, password);
		//close connection	
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
 
	private void Check() throws SQLException {
		Get_Connection();
//		String sql = "select username,password from users where username=? and password=?";
		String sql="select * from users where username=? and password=?";
		//create statement
		 ps = conn.prepareStatement(sql);
		 String adminname = textField.getText();
		 String adminpass = passwordField.getText();
		 
		//execute statement
		 ps.setString(1, adminname);
		 ps.setString(2, adminpass);
//		 ps.setString(3, kendi);
//		 ps.setInt(4, 2021);
		 ResultSet rs  = ps.executeQuery();
		 if(rs.next()) {
			 frmLogin.setVisible(false);
//			 DASHBOARD dash = new DASHBOARD();
//			 dash.show();
				 
				 String  role=rs.getString("role");
				 String admin="super";
				 System.out.print(admin + role);
				 DASHBOARD ds=new DASHBOARD();
				 ds.lblNewLabel_1.setText("WELCOME ADMIN "+textField.getText().toUpperCase());
				 ds.show();
				 if(role.contentEquals(admin)) {
					 DASHBOARD dss=new DASHBOARD();
					 dss.show();
					 frmLogin.setVisible(false);
					 
				 }
				 else {
				System.out.println("Admin");
				 }
		 }
		 
		else {
		 JOptionPane.showMessageDialog(null, "username and password mismatch!!... try again");
		 textField.setText("");
		 passwordField.setText("");
	 textField.requestFocus();
		 }
		 conn.close();
	}
	


	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("LOGIN");
		
		
//		frmLogin.getContentPane().setBackground(Color.NONE);
		frmLogin.setBackground(Color.PINK);
		frmLogin.setBounds(100, 100, 600, 600);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 26));
		lblUsername.setBounds(46, 98, 126, 33);
		frmLogin.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(32, 140, 245, 44);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(60, 185, 102, 44);
		frmLogin.getContentPane().add(lblPassword);
		
		 check = new JCheckBox("show password");
		 check.setBackground(Color.GRAY);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(check.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar(('*'));
				}
			}
		});
		check.setBounds(81, 278, 226, 27);
		frmLogin.getContentPane().add(check);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/key.png"));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 17));
		btnLogin.setBounds(46, 343, 134, 53);
		btnLogin.addActionListener(object->{
			try {
				Check();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		frmLogin.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
//					isValidPassword("String password");
					Check();
				}catch(Exception e ){}
			}
		});
		passwordField.setBounds(31, 231, 284, 39);
		frmLogin.getContentPane().add(passwordField);
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 600, 53);
		frmLogin.getContentPane().add(panel);
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText(null);
				passwordField.setText(null);
				
				passwordField.requestFocus();
				textField.requestFocus();
				
			}
		});
		btncancel.setForeground(Color.WHITE);
		btncancel.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 17));
		btncancel.setBackground(Color.RED);
		btncancel.setBounds(202, 343, 134, 53);
		frmLogin.getContentPane().add(btncancel);
		
		JLabel lblforgotpass = new JLabel("Forgot Password");
		lblforgotpass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblforgotpass.setText(Security);
				JOptionPane.showInputDialog(lblforgotpass, "What is your firstName?","your last name?");
			}
		});
		lblforgotpass.setForeground(Color.BLUE);
		lblforgotpass.setFont(new Font("Dialog", Font.BOLD, 24));
		lblforgotpass.setBounds(46, 471, 231, 44);
		frmLogin.getContentPane().add(lblforgotpass);
//		
//		JLabel lblNewLabel_2 = new JLabel("New label");
//		lblNewLabel_2.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/login.jpg"));
//		lblNewLabel_2.setBounds(0, 49, 588, 545);
//		frmLogin.getContentPane().add(lblNewLabel_2);
//		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new TitledBorder(null,"LOGIN" ,TitledBorder.LEADING, TitledBorder.TOP,null, Color.blue));
		panel_1.setBounds(10, 78, 360, 492);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	
				frmLogin.setVisible(false);
				HOME hm= new HOME();
				hm.show();
			}
			
		});
	
		label.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/home.png"));
		label.setBounds(375, 38, 213, 532);
		frmLogin.getContentPane().add(label);
		
		JLabel lblBack = new JLabel("back");
		lblBack.setForeground(Color.BLACK);
		lblBack.setBackground(Color.BLUE);
		lblBack.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/back.png"));
		lblBack.setBounds(493, 63, 107, 44);
		frmLogin.getContentPane().add(lblBack);
		
		
		
		
	}

	public void show() {
		// TODO Auto-generated method stub
	frmLogin.setVisible(true);
	}
}
