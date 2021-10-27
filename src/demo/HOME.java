package demo;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
//
import javax.swing.JTextField;
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
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeEvent;
   public class HOME {

	public JFrame frmLogin;
	private JTextField textField;
	public Connection conn;
	public PreparedStatement ps;
	private JPasswordField passwordField;
	private JCheckBox check;
	protected Object show;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME window = new HOME();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
	/**
	 * Create the application.
	 */
	public HOME() {
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
					 
				 }
				 else {
				JOptionPane.showMessageDialog(null, "you are an admin");
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
		frmLogin.setBounds(100, 100, 450, 450);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 26));
		lblUsername.setBounds(156, 27, 126, 33);
		frmLogin.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(115, 72, 212, 44);
		frmLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("FreeSans", Font.BOLD | Font.ITALIC, 20));
		lblPassword.setBounds(172, 128, 102, 23);
		frmLogin.getContentPane().add(lblPassword);
		
		 check = new JCheckBox("show");
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
		check.setBounds(215, 210, 63, 44);
		frmLogin.getContentPane().add(check);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(Color.RED);
		btnLogin.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 17));
		btnLogin.setBounds(166, 282, 134, 53);
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
					Check();
				}catch(Exception e ){}
			}
		});
		passwordField.setBounds(115, 163, 236, 39);
		frmLogin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL MANAGEMENT SYSTEM/icons/login.jpg"));
		lblNewLabel_1.setBounds(-124, 12, 562, 396);
		lblNewLabel_1.setVisible(true);
		frmLogin.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(true);
		
		
	}

	public void show() {
		// TODO Auto-generated method stub
	frmLogin.setVisible(true);
	}
}
