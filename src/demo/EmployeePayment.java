package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;

public class EmployeePayment {

	public JFrame frmEmployeePayment;
	private JTextField fldMobile;
	private JTextField fldName;
	private JTextField fldId;
	private JTextField fldEmail;
	private JTextField fldRole;
	private JTextField fldDate;
	private JTextField fldAmount;
//	private JTextArea txtprint;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public EmployeePayment() {
		initialize();
		frmEmployeePayment.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeePayment = new JFrame();
		frmEmployeePayment.getContentPane().setBackground(Color.PINK);
		frmEmployeePayment.setTitle("Employee Payment");
		frmEmployeePayment.setBounds(200, 200, 650, 550);
		frmEmployeePayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeePayment.getContentPane().setLayout(null);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date df = new Date();
		Calendar c = Calendar.getInstance();
		int year =c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		String yearString=String.valueOf(year);
		String monthString=String.valueOf(month);
		String dateString = String.valueOf(date);
		String currentDate = dateString+"/" +monthString+"/"+yearString;
		
		
		JButton btnExit = new JButton("EXICT");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmEmployeePayment.setVisible(false);
					DASHBOARD GH=new DASHBOARD();
				}
			}
		});
		btnExit.setBounds(532, 0, 106, 42);
		frmEmployeePayment.getContentPane().add(btnExit);
		
		JButton btnMobile = new JButton("Mobile No");
		btnMobile.setBackground(Color.MAGENTA);
		btnMobile.setForeground(Color.BLACK);
		btnMobile.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMobile.setBounds(12, 53, 117, 42);
		frmEmployeePayment.getContentPane().add(btnMobile);
		
		JButton btnName = new JButton("NAME");
		btnName.setBackground(Color.MAGENTA);
		btnName.setForeground(Color.BLACK);
		btnName.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnName.setBounds(12, 107, 117, 35);
		frmEmployeePayment.getContentPane().add(btnName);
		
		JButton btnId = new JButton("ID NO");
		btnId.setBackground(Color.MAGENTA);
		btnId.setForeground(Color.BLACK);
		btnId.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnId.setBounds(12, 165, 117, 35);
		frmEmployeePayment.getContentPane().add(btnId);
		
		JButton btnEmail = new JButton("EMAIL");
		btnEmail.setBackground(Color.MAGENTA);
		btnEmail.setForeground(Color.BLACK);
		btnEmail.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnEmail.setBounds(12, 223, 117, 35);
		frmEmployeePayment.getContentPane().add(btnEmail);
		
		JButton btnRole = new JButton("ROLE");
		btnRole.setBackground(Color.MAGENTA);
		btnRole.setForeground(Color.BLACK);
		btnRole.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnRole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRole.setBounds(12, 270, 117, 35);
		frmEmployeePayment.getContentPane().add(btnRole);
		
		JButton btnMonth = new JButton("DATE");
		btnMonth.setBackground(Color.MAGENTA);
		btnMonth.setForeground(Color.BLACK);
		btnMonth.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMonth.setBounds(12, 331, 117, 35);
		frmEmployeePayment.getContentPane().add(btnMonth);
		
		JButton btnPayment = new JButton("PAYMENT");
		btnPayment.setBackground(Color.GREEN);
		btnPayment.setFont(new Font("Dialog", Font.BOLD, 17));
		btnPayment.setForeground(Color.BLACK);
		
		btnPayment.addActionListener(object->{
			try {
				Resultshow();
				ShowArea();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		btnPayment.setBounds(282, 453, 175, 35);
		frmEmployeePayment.getContentPane().add(btnPayment);
		
		fldMobile = new JTextField();
		fldMobile.setBounds(180, 57, 148, 35);
		frmEmployeePayment.getContentPane().add(fldMobile);
		fldMobile.setColumns(10);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setForeground(Color.WHITE);
		btnsearch.setFont(new Font("Dialog", Font.BOLD, 13));
		btnsearch.setBackground(Color.BLUE);
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				Object color;
//				btnsearch.setBackground(color.blue);
				String mobile = fldMobile.getSelectedText();
				Connection con;
				PreparedStatement ps;
				try {
					con = Connector.getConnection();
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery("select * from NewEmployee where mobile = '"+fldMobile.getText()+"'");
					if(rs.next()) {
						fldMobile.setEditable(false);
						fldName.setText(rs.getString(2));
						fldId.setText(rs.getString(3));
						fldEmail.setText(rs.getString(4));
						fldRole.setText(rs.getString(5));
//						fldDate.setText(rs.getString(6));
						
					}
					else {
						System.out.println("error fetching data");
					}
				}catch(Exception e) {
					System.out.println("error seacrh"+ e);
				}
			}
		});
		btnsearch.setBounds(352, 59, 85, 30);
		frmEmployeePayment.getContentPane().add(btnsearch);
		
		fldName = new JTextField();
		fldName.setBounds(180, 110, 257, 30);
		frmEmployeePayment.getContentPane().add(fldName);
		fldName.setColumns(10);
		
		fldId = new JTextField();
		fldId.setColumns(10);
		fldId.setBounds(180, 165, 257, 30);
		frmEmployeePayment.getContentPane().add(fldId);
		
		fldEmail = new JTextField();
		fldEmail.setColumns(10);
		fldEmail.setBounds(180, 223, 257, 30);
		frmEmployeePayment.getContentPane().add(fldEmail);
		
		fldRole = new JTextField();
		fldRole.setColumns(10);
		fldRole.setBounds(180, 278, 257, 30);
		frmEmployeePayment.getContentPane().add(fldRole);
		
		fldDate = new JTextField();
		fldDate.setForeground(Color.BLUE);
		fldDate.setBackground(Color.CYAN);
		fldDate.setText(currentDate);
		fldDate.setEditable(false);
		fldDate.setColumns(10);
		fldDate.setBounds(180, 331, 257, 30);
		frmEmployeePayment.getContentPane().add(fldDate);
		
		JButton btnMonth_1 = new JButton("Amount");
		btnMonth_1.setBackground(Color.MAGENTA);
		btnMonth_1.setForeground(Color.BLACK);
		btnMonth_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnMonth_1.setBounds(12, 397, 117, 35);
		frmEmployeePayment.getContentPane().add(btnMonth_1);
		
		fldAmount = new JTextField();
		fldAmount.setColumns(10);
		fldAmount.setBounds(180, 400, 257, 30);
		frmEmployeePayment.getContentPane().add(fldAmount);
		
		JButton btnSave_1 = new JButton("Delete");
		btnSave_1.setFont(new Font("Dialog", Font.BOLD, 17));
		btnSave_1.setForeground(Color.WHITE);
		btnSave_1.setBackground(Color.RED);
		btnSave_1.addActionListener(object->{
			fldEmail.setText(null);
			fldAmount.setText(null);
			fldDate.setText(null);
			fldMobile.setText(null);
			textArea.setText(null);
			fldId.setText(null);
			fldRole.setText(null);
			textArea.setText(null);
			fldMobile.requestFocus();
			
		});
		btnSave_1.setBounds(521, 453, 117, 35);
		frmEmployeePayment.getContentPane().add(btnSave_1);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(449, 53, 189, 373);
		frmEmployeePayment.getContentPane().add(textArea);
		textArea.setVisible(true);
	}

	public void Show() {
		// TODO Auto-generated method stub
		frmEmployeePayment.setVisible(true);
	}
	private void Resultshow() throws Exception, ClassNotFoundException {
		Connection con;
		PreparedStatement ps;
		try  {
			con = Connector.getConnection();
		String sql = "insert into Salary (mobile,Name,IDNO,Email,Designation,Date,Amount) values(?,?,?,?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(fldMobile.getText()));
		ps.setString(2, fldName.getText());
		ps.setInt(3,Integer.parseInt(fldId.getText()));
		ps.setString(4, fldEmail.getText());
		ps.setString(5, fldRole.getText());
		ps.setString(6, fldDate.getText());
		ps.setString(7, fldAmount.getText());
//		textArea_1.setText("Name: "+);
		
		int i =ps.executeUpdate();
		if(i>0) {
			JOptionPane.showMessageDialog(null, "Payment Succefull!....Welcome!");
			fldMobile.setText(null);
			fldName.setText(null);
			fldId.setText(null);
			fldRole.setText(null);
			fldDate.setText(null);
			fldAmount.setText(null);
			fldMobile.requestFocus();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, " error!!!...unsuccefull Payment Please Try Again!");
			fldMobile.setText(null);
			fldName.setText(null);
			fldId.setText(null);
			fldRole.setText(null);
			fldDate.setText(null);
			fldAmount.setText(null);
			fldMobile.requestFocus();
		}
		
	}catch(SQLException e) {
		System.out.println("error seacrh"+ e);
	}
	}
	private void ShowArea() throws ClassNotFoundException  {
		Connection con;
		PreparedStatement ps;
		try {
			con = Connector.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Salary");
			while(rs.next()) {
			textArea.setText("NAME:"+"\t"+rs.getString(3)+"\n"   +"ID:"+"\t"+rs.getString(4)+"\n"+"EMAIL Address:"+"\t"+rs.getString(5)+"\n"+"ROLE:"+"\t"+rs.getString(6)+"\n"+"DATE:"+"\t"+rs.getString(7)+"\n"+"AMOUNT:"+"\t"+rs.getString(8)+"\n"+"MOBILE:"+"\t"+rs.getString(2)+"");
			
				}
		}catch(Exception e) {
			System.out.println("error print"+ e);
		}
	
	} 
}
