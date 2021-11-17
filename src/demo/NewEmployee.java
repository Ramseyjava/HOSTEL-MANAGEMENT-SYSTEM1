package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;

public class NewEmployee extends Login{

	private JFrame frmNewEmployee;
	private JTextField fdphone;
	private JTextField fdName;
	private JTextField fdNationalId;
	private JTextField Email;
	private JTextField fdEmail;
	private JTextField fldBirth;
	private JComboBox comboBox;
	String[]role;
	int id;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public NewEmployee() {
//		this.comboBox = new JComboBox();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewEmployee = new JFrame();
		frmNewEmployee.setTitle("NEW EMPLOYEE");
		frmNewEmployee.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmNewEmployee.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.border.background"));
		frmNewEmployee.setBounds(200, 200, 550, 500);
		frmNewEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNewEmployee.getContentPane().setLayout(null);
		
		JButton btnexit = new JButton("Exit");
		btnexit.setBackground(Color.RED);
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmNewEmployee.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
			}
			
		});
		btnexit.setBounds(452, 12, 86, 35);
		frmNewEmployee.getContentPane().add(btnexit);
		
		JButton btnphone = new JButton("Mobile No");
		btnphone.setForeground(Color.BLACK);
		btnphone.setBackground(Color.YELLOW);
		btnphone.setBounds(12, 23, 138, 47);
		frmNewEmployee.getContentPane().add(btnphone);
		
		JButton btnname = new JButton("Name");
		btnname.setBackground(Color.MAGENTA);
		btnname.setBounds(12, 82, 138, 47);
		frmNewEmployee.getContentPane().add(btnname);
		
		JButton btnId = new JButton("Natinal ID");
		btnId.setForeground(Color.BLACK);
		btnId.setBackground(Color.YELLOW);
		btnId.setBounds(12, 141, 138, 40);
		frmNewEmployee.getContentPane().add(btnId);
		
		JButton btnemail = new JButton("Email Address");
		btnemail.setBackground(Color.MAGENTA);
		btnemail.setBounds(12, 193, 138, 41);
		frmNewEmployee.getContentPane().add(btnemail);
		
		JButton btnrole = new JButton("Designation");
		btnrole.setForeground(Color.BLACK);
		btnrole.setBackground(Color.YELLOW);
		btnrole.setBounds(12, 260, 138, 42);
		frmNewEmployee.getContentPane().add(btnrole);
		
		JButton btnSave = new JButton("Save");
		btnSave.setForeground(Color.BLACK);
		btnSave.setBackground(Color.GREEN);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Insert();
					clear();
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
		btnSave.setBounds(216, 402, 100, 35);
		frmNewEmployee.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fdphone.setText(null);
				fdName.setText(null);
				fdNationalId.setText(null);
				fdEmail.setText(null);
				comboBox.setSelectedIndex(id);
				fldBirth.setText(null);
				
			}
		});
		btnDelete.setBounds(405, 402, 100, 35);
		frmNewEmployee.getContentPane().add(btnDelete);
		
		fdphone = new JTextField();
		fdphone.setBounds(177, 23, 233, 40);
		frmNewEmployee.getContentPane().add(fdphone);
		fdphone.setColumns(10);
		
		fdName = new JTextField();
		fdName.setColumns(10);
        fdName.setBounds(177, 81, 233, 40);
		frmNewEmployee.getContentPane().add(fdName);
		
		fdNationalId = new JTextField();
		fdNationalId.setColumns(10);
		fdNationalId.setBounds(177, 141, 233, 40);
		frmNewEmployee.getContentPane().add(fdNationalId);
		
		Email = new JTextField();
		Email.setColumns(10);
		Email.setBounds(177, 196, 233, 19);
		frmNewEmployee.getContentPane().add(fdNationalId);
		
		fdEmail = new JTextField();
		fdEmail.setColumns(10);
		fdEmail.setBounds(177, 197, 233, 34);
		frmNewEmployee.getContentPane().add(fdEmail);
		
		JButton btnBirth = new JButton("DATE OF BIRTH");
		btnBirth.setForeground(Color.BLACK);
		btnBirth.setBackground(Color.YELLOW);
		btnBirth.setBounds(12, 325, 138, 42);
		frmNewEmployee.getContentPane().add(btnBirth);
		
		fldBirth = new JTextField();
		fldBirth.setForeground(Color.BLACK);
		fldBirth.setFont(new Font("Dialog", Font.PLAIN, 14));
		fldBirth.setBackground(Color.GREEN);
		fldBirth.setColumns(10);
		fldBirth.setBounds(177, 326, 233, 41);
		frmNewEmployee.getContentPane().add(fldBirth);
		
		role =new String[] {"Maintenance", "Cook", "HouseKeeping", "Purcharsing and inventory control", "Accounting & Budgeting"};
		comboBox = new JComboBox(role);
		comboBox.setBounds(177, 260, 238, 33);
		frmNewEmployee.getContentPane().add(comboBox);
		

	}
	public void Show() {
		frmNewEmployee.setVisible(true);
	}
	private void Insert() throws Exception {
		Connection con;
		PreparedStatement pst;
		try {
			con= Connector.getConnection();
			id=comboBox.getSelectedIndex();
			String sql =" insert into NewEmployee(mobile,name,nationalId,email,Designation,DateOfBirth,Status)VALUES(?,?,?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(fdphone.getText()));
			pst.setString(2, fdName.getText());
			pst.setInt(3, Integer.parseInt(fdNationalId.getText()));
			pst.setString(4, fdEmail.getText());
			pst.setString(5, comboBox.getItemAt(id)+"");
			pst.setString(6, fldBirth.getText());
			pst.setString(7, "");
			
			pst.execute();
				JOptionPane.showMessageDialog(null, "succefull inserted!");
			}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	private void clear() {
		fdphone.setText(null);
		fdName.setText(null);
		fdNationalId.setText(null);
		fdEmail.setText(null);
		comboBox.setSelectedIndex(id);
		fldBirth.setText(null);
		
	}
}
