package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;

public class STUDENTRENT {

	private JFrame frmStudentFeesLent;
	private JTextField fldmobile;
	private JTextField fdName;
	private JTextField fdemail;
	private JTextField fdroom;
	private JTextField fdMonth;
	private JTextField fdAmount;
	private JTextField fldDate;
	public JTextArea textArea_1;


	/**
	 * Create the application.
	 */
	public STUDENTRENT() {
		initialize();
		frmStudentFeesLent.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmStudentFeesLent = new JFrame();
		frmStudentFeesLent.getContentPane().setForeground(Color.WHITE);
		frmStudentFeesLent.getContentPane().setFont(new Font("Dialog", Font.PLAIN, 12));
		frmStudentFeesLent.getContentPane().setBackground(Color.DARK_GRAY);
		frmStudentFeesLent.setTitle("STUDENT FEES/ LENT");
		frmStudentFeesLent.setBounds(200, 200, 600, 450);
		frmStudentFeesLent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentFeesLent.getContentPane().setLayout(null);
		SimpleDateFormat dfrt = new SimpleDateFormat("yyyy/MM/dd");
		Date df = new Date();
		Calendar c = Calendar.getInstance();
		int year =c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int date = c.get(Calendar.DATE);
		String yearString=String.valueOf(year);
		String monthString=String.valueOf(month);
		String dateString = String.valueOf(date);
		String currentDate = yearString+ "/"+monthString +"/"+ dateString;
		
		JButton btnMobile = new JButton("Mobile No");
		btnMobile.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 18));
		btnMobile.setBounds(12, 12, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnMobile);
		
		JButton btnStudent = new JButton("StudentName");
		btnStudent.setFont(new Font("DejaVu Math TeX Gyre", Font.BOLD | Font.ITALIC, 15));
		btnStudent.setBounds(12, 67, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnStudent);
		
		JButton btnEmail = new JButton("Email Address");
		btnEmail.setFont(new Font("Lato Heavy", Font.BOLD | Font.ITALIC, 16));
		btnEmail.setBounds(12, 122, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnEmail);
		
		JButton btnRoom = new JButton("Room No");
		btnRoom.setFont(new Font("eufm10", Font.BOLD | Font.ITALIC, 19));
		btnRoom.setBounds(12, 172, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnRoom);
		
		JButton btnMonth = new JButton("Semester");
		btnMonth.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 22));
		btnMonth.setBounds(12, 214, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnMonth);
		
		JButton btnAmount = new JButton("Amount ");
		btnAmount.setFont(new Font("eufm10", Font.BOLD, 21));
		btnAmount.setBounds(12, 261, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnAmount);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmStudentFeesLent.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
			}
			
		});
		btnExit.setBounds(508, 12, 80, 35);
		frmStudentFeesLent.getContentPane().add(btnExit);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					insert();
					ShowResult();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		btnSave.setBounds(227, 373, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 fldmobile.setText(null);
				 fdName.setText(null);
				 fdemail.setText(null);
				 fdroom.setText(null);
				 fdMonth.setText(null);
				 fdAmount.setText(null);
				 fldDate.setText(null);
			}
		});
		btnDelete.setBounds(436, 373, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnDelete);
		
		fldmobile = new JTextField();
		fldmobile.setBounds(162, 12, 150, 30);
		frmStudentFeesLent.getContentPane().add(fldmobile);
		fldmobile.setColumns(10);
		
		fdName = new JTextField();
		fdName.setColumns(10);
		fdName.setBounds(162, 70, 206, 27);
		frmStudentFeesLent.getContentPane().add(fdName);
		
		fdemail = new JTextField();
		fdemail.setColumns(10);
		fdemail.setBounds(162, 125, 206, 27);
		frmStudentFeesLent.getContentPane().add(fdemail);
		
		fdroom = new JTextField();
		fdroom.setColumns(10);
		fdroom.setBounds(162, 175, 206, 27);
		frmStudentFeesLent.getContentPane().add(fdroom);
		
		fdMonth = new JTextField();
		fdMonth.setColumns(10);
		fdMonth.setBounds(162, 217, 206, 27);
		frmStudentFeesLent.getContentPane().add(fdMonth);
		
		fdAmount = new JTextField();
		fdAmount.setColumns(10);
		fdAmount.setBounds(162, 269, 206, 27);
		frmStudentFeesLent.getContentPane().add(fdAmount);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBackground(Color.LIGHT_GRAY);
		btnsearch.setFont(new Font("eufm10", Font.BOLD, 18));
		btnsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mobile =  fldmobile.getSelectedText();
				Connection conn;
				PreparedStatement ps;
				try {
					conn = Connector.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("select * from Students where mobile = "+fldmobile.getText());
					while(rs.next())
					{
						fldmobile.setEditable(false);
						fdName.setText(rs.getString(2));
						fdemail.setText(rs.getString(3));
						fdroom.setText(rs.getString(4));
//						fdMonth.setText(rs.getString(5));
//						fdAmount.setText(rs.getString(6));
					}
				}catch(Exception e) {}
				fldmobile.requestFocus();
			}
		});
		btnsearch.setBounds(331, 12, 100, 30);
		frmStudentFeesLent.getContentPane().add(btnsearch);
		
		JButton btnAmount_1 = new JButton("Amount ");
		btnAmount_1.setBounds(12, 261, 117, 25);
		frmStudentFeesLent.getContentPane().add(btnAmount_1);
		
		JButton btnDate = new JButton("Date ");
		
		btnDate.setFont(new Font("eufm10", Font.BOLD, 23));
		btnDate.setBounds(12, 326, 117, 35);
		frmStudentFeesLent.getContentPane().add(btnDate);
		
		fldDate = new JTextField();
		fldDate.setText(currentDate);
		fldDate.setEditable(false);
		fldDate.setColumns(10);
		fldDate.setBounds(162, 333, 206, 27);
		frmStudentFeesLent.getContentPane().add(fldDate);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(447, 157, 1, 15);
		frmStudentFeesLent.getContentPane().add(textArea);
		
		textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.GREEN);
		textArea_1.setBackground(Color.BLACK);
		textArea_1.setBounds(380, 67, 208, 294);
		frmStudentFeesLent.getContentPane().add(textArea_1);
	}
	private void insert() throws Exception{
		Connection conn;
		PreparedStatement ps;
		try  {
			conn = Connector.getConnection();
		String sql = "insert into rent (mobile,studentName,emailNo,roomNo,month,Amount,Date) values(?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, Integer.parseInt(fldmobile.getText()));
		ps.setString(2, fdName.getText());
		ps.setString(3, fdemail.getText());
		ps.setString(4, fdroom.getText());
		ps.setString(5, fdMonth.getText());
		ps.setString(6, fdAmount.getText());
		ps.setString(7, fldDate.getText());
//		textArea_1.setText("Name: "+);
		
		int i =ps.executeUpdate();
		if(i>0) {
			JOptionPane.showMessageDialog(null, "succefull inserted!");
			fldmobile.requestFocus();
		}
		else
		{
			JOptionPane.showMessageDialog(null, " error!!!...unsuccefull inserted try again");
		}
		
	}catch(SQLException e) {}
	}
	private void ShowResult() {
		Connection con;
		PreparedStatement st;
		try {
			con = Connector.getConnection();
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from rent");
			while(rs.next()) {
			textArea_1.setText("NAME:"+"\t"+rs.getString(3)+"\n"+ "EMAIL:"+"\t"+rs.getString(4) +"\n"+"ROOM:"+"\t"+rs.getString(5)+"\n"+"SEMESTER: \t"+rs.getString(6));
//				textArea_1.setText(rs.getString(4));
////				textArea_1.setText(rs.getString(5));
//				textArea_1.setText(rs.getString(6));
				
			}
			
			
		}catch(Exception e) {}
	}
}
