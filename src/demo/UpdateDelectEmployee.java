package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;

public class UpdateDelectEmployee {

	public JFrame update;
	private JTextField textField;
	private JTextField fldName;
	private JTextField fldId;
	private JTextField fldEmail;
    private int Id,id;
    private String CStatus,selecteditem;
    private  String mobileNumber;
    private JButton btnSearch;
    private JComboBox comboBox, comboBox_1;
    String[]status,status2;


	/**
	 * Create the application.
	 */
	public UpdateDelectEmployee() {
		initialize();
	update.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		update = new JFrame();
		update.getContentPane().setBackground(Color.LIGHT_GRAY);
		update.setBounds(200, 200, 550, 500);
		update.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		update.getContentPane().setLayout(null);
		
		JButton btnMobile = new JButton("Mobile No.");
		btnMobile.setFont(new Font("Dialog", Font.BOLD, 17));
		btnMobile.setForeground(Color.BLACK);
		btnMobile.setBackground(Color.GREEN);
		btnMobile.setBounds(12, 44, 153, 35);
		update.getContentPane().add(btnMobile);
		
		JButton btnName = new JButton("Name");
		btnName.setFont(new Font("Dialog", Font.BOLD, 17));
		btnName.setForeground(Color.BLACK);
		btnName.setBackground(Color.GREEN);
		btnName.setBounds(12, 100, 153, 35);
		update.getContentPane().add(btnName);
		
		JButton btnId = new JButton("National ID ");
		btnId.setFont(new Font("Dialog", Font.BOLD, 17));
		btnId.setForeground(Color.BLACK);
		btnId.setBackground(Color.GREEN);
		btnId.setBounds(12, 164, 153, 35);
		update.getContentPane().add(btnId);
		
		JButton btnEmail = new JButton("Email Address");
		btnEmail.setFont(new Font("Dialog", Font.BOLD, 17));
		btnEmail.setForeground(Color.BLACK);
		btnEmail.setBackground(Color.GREEN);
		btnEmail.setBounds(12, 231, 153, 35);
		update.getContentPane().add(btnEmail);
		
		JButton btnRole = new JButton("Role");
		btnRole.setFont(new Font("Dialog", Font.BOLD, 17));
		btnRole.setForeground(Color.BLACK);
		btnRole.setBackground(Color.GREEN);
		btnRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRole.setBounds(12, 300, 153, 35);
		update.getContentPane().add(btnRole);
		
		JButton BtnStatus = new JButton("Status");
		BtnStatus.setFont(new Font("Dialog", Font.BOLD, 17));
		BtnStatus.setForeground(Color.BLACK);
		BtnStatus.setBackground(Color.GREEN);
		BtnStatus.setBounds(12, 373, 153, 35);
		update.getContentPane().add(BtnStatus);
		
		JButton btnLogout = new JButton("Exit");
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLogout.setBackground(Color.RED);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					update.setVisible(false);
				}
				//frmDashboard.setVisible(true);
			}
		});
		btnLogout.setBounds(458, 12, 100, 35);
		update.getContentPane().add(btnLogout);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(object->{
			mobileNumber = textField.getText();
			Connection con;
			Statement st;
			try {
				con = Connector.getConnection();
				st =con.createStatement();
				int i=st.executeUpdate("delete from NewEmployee where mobile= "+textField.getText());
				if(i>0) {JOptionPane.showMessageDialog(null, "succefull Deleted!!");
				textField.requestFocus();
				clear();
				}else
				{
					JOptionPane.showMessageDialog(null, "unsuccefull Deleted!!");
					clear();
				}
				
			}catch(Exception e) {}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 17));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(421, 433, 100, 35);
		update.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(object->{
			mobileNumber = textField.getText();
			Connection conn;
			PreparedStatement pst;
			int des= comboBox_1.getSelectedIndex();
			int status = comboBox.getSelectedIndex();
			
			
			try {
				conn = Connector.getConnection();
				pst =conn.prepareStatement("update NewEmployee set Designation=?,Status=? where mobile=?");
				pst.setString(1,  comboBox_1.getItemAt(des)+"");
				pst.setString(2,comboBox.getItemAt(status)+"" );
				pst.setInt(3, Integer.parseInt(textField.getText()));
				int i=pst.executeUpdate();
				if(i>0) {
					JOptionPane.showMessageDialog(null, "Succefull Updated!!");
				clear();
				}else
				{
					JOptionPane.showMessageDialog(null, "Error in occured Updating\n try again!!");
					clear();
					
				}
				
			}catch(Exception e) {}
			
		});
		btnUpdate.setBackground(Color.MAGENTA);
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 17));
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setBounds(206, 434, 117, 35);
		update.getContentPane().add(btnUpdate);
		
		textField = new JTextField();
		textField.setBounds(195, 45, 142, 34);
		update.getContentPane().add(textField);
		textField.setColumns(10);
		
		fldName = new JTextField();
		fldName.setColumns(10);
		fldName.setBounds(195, 101, 246, 34);
		update.getContentPane().add(fldName);
		
		fldId = new JTextField();
		fldId.setColumns(10);
		fldId.setBounds(195, 165, 246, 34);
		update.getContentPane().add(fldId);
		
		fldEmail = new JTextField();
		fldEmail.setColumns(10);
		fldEmail.setBounds(195, 231, 246, 35);
		update.getContentPane().add(fldEmail);
		
//		String =jcomboBoxOption();
		String []Status = {"living, leaved"};
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(object->{
			Connection con;
			Statement st;
			try {
				con = Connector.getConnection();
				st =con.createStatement();
				ResultSet rs = st.executeQuery("select * from NewEmployee where mobile = "+textField.getText());
				if(rs.next())
				{
					textField.setEditable(false);
					fldName.setText(rs.getString(2));
					fldId.setText(rs.getInt(3)+"");
					fldEmail.setText(rs.getString(4));
					comboBox_1.setSelectedItem(rs.getString(5));
				    comboBox.setSelectedItem(rs.getString(6));
					
				}
				else
				{JOptionPane.showMessageDialog(null, "The Number does not Exict in System "+"\n"+"Please Enter Correct Number");
		         clear();
				}
				
			}catch(Exception e) {
				
			}
		});
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setBounds(343, 43, 98, 35);
		update.getContentPane().add(btnSearch);
		
		
		status = new String[] {"living","Leaved"};
	
	    comboBox = new JComboBox(status);
	    comboBox.setFont(new Font("Dialog", Font.BOLD, 23));
	    comboBox.setBackground(Color.PINK);
		comboBox.setBounds(195, 374, 246, 35);
		update.getContentPane().add(comboBox);
		
		status2 = new String[] {"Maintenance", "Cook", "HouseKeeping", "Purcharsing and inventory control", "Accounting & Budgeting"};
		comboBox_1 = new JComboBox(status2);
		comboBox_1.setFont(new Font("Dialog", Font.BOLD, 23));
		comboBox_1.setBackground(Color.PINK);
		comboBox_1.setBounds(195, 301, 242, 35);
		update.getContentPane().add(comboBox_1);
	}
	public void Show() {
		// TODO Auto-generated method stub
		update.setVisible(true);
	}
	private void clear() {
		textField.setText(null);
		fldName.setText(null);
		fldId.setText(null);
		fldEmail.setText(null);
		comboBox_1.setSelectedItem(null);
		comboBox.setSelectedItem(null);
		
	}
}
