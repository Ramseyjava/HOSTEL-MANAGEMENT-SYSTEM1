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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class updateStudent {
	public JFrame frmUpdateAndDelete;
	private JTextField fldRoom;
	private JTextField fldAdm;
	private JTextField fldEmail;
	private JTextField fldParent;
	private JTextField fldName;
	private JTextField fldMobile;
	String []status;
	private JTextField fldyear;
	private JComboBox comboBox;
	private JTextArea textArea;

	/**
	 * Create the application.
	 */
	public updateStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUpdateAndDelete = new JFrame();
		frmUpdateAndDelete.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmUpdateAndDelete.setFont(new Font("DejaVu Serif", Font.BOLD | Font.ITALIC, 14));
		frmUpdateAndDelete.setTitle("Update and Delete student");
		frmUpdateAndDelete.setBounds(10, 308, 700, 500);
		frmUpdateAndDelete.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUpdateAndDelete.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmUpdateAndDelete.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
			}
		});
		btnExit.setBounds(618, 0, 90, 30);
		frmUpdateAndDelete.getContentPane().add(btnExit);
		
		JButton btnMobile = new JButton("Mobile No");
		btnMobile.setForeground(Color.BLACK);
		btnMobile.setBackground(Color.MAGENTA);
		btnMobile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnMobile.setBounds(12, 28, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnMobile);
		
		JButton btnName = new JButton("StudentName");
		btnName.setBounds(12, 73, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnName);
		
		JButton btnParent = new JButton("Parent NAme");
		btnParent.setForeground(Color.BLACK);
		btnParent.setBackground(Color.MAGENTA);
		btnParent.setBounds(12, 118, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnParent);
		
		JButton btnEmail = new JButton("Email Address");
		btnEmail.setBounds(12, 167, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnEmail);
		
		JButton btnAdm = new JButton("ID No");
		btnAdm.setForeground(Color.BLACK);
		btnAdm.setBackground(Color.MAGENTA);
		btnAdm.setBounds(12, 219, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnAdm);
		
		JButton btnRoom = new JButton("Room No");
		btnRoom.setBounds(12, 274, 140, 28);
		frmUpdateAndDelete.getContentPane().add(btnRoom);
		
		JButton btnClear = new JButton("Delete");
		btnClear.setBackground(Color.RED);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnClear.setBounds(521, 403, 117, 30);
		frmUpdateAndDelete.getContentPane().add(btnClear);
		
		JButton btnsave = new JButton("Save");
		btnsave.setForeground(Color.WHITE);
		btnsave.setBackground(Color.GRAY);
		btnsave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					insert();
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
		btnsave.setBounds(364, 403, 117, 30);
		frmUpdateAndDelete.getContentPane().add(btnsave);
		
		JButton btnStatus = new JButton("Living Status");
		btnStatus.setBackground(Color.GREEN);
		btnStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnStatus.setBounds(12, 362, 140, 42);
		frmUpdateAndDelete.getContentPane().add(btnStatus);
		
		fldRoom = new JTextField();
		fldRoom.setBounds(200, 274, 250, 27);
		frmUpdateAndDelete.getContentPane().add(fldRoom);
		fldRoom.setColumns(10);
		
		fldAdm = new JTextField();
		fldAdm.setColumns(10);
		fldAdm.setBounds(200, 219, 250, 27);
		frmUpdateAndDelete.getContentPane().add(fldAdm);
		
		fldEmail = new JTextField();
		fldEmail.setColumns(10);
		fldEmail.setBounds(200, 167, 250, 27);
		frmUpdateAndDelete.getContentPane().add(fldEmail);
		
		fldParent = new JTextField();
		fldParent.setColumns(10);
		fldParent.setBounds(200, 119, 250, 27);
		frmUpdateAndDelete.getContentPane().add(fldParent);
		
		fldName = new JTextField();
		fldName.setColumns(10);
		fldName.setBounds(200, 76, 250, 27);
		frmUpdateAndDelete.getContentPane().add(fldName);
		
		fldMobile = new JTextField();
		fldMobile.setColumns(10);
		fldMobile.setBounds(200, 31, 140, 27);
		frmUpdateAndDelete.getContentPane().add(fldMobile);
		
		JButton btnExit_1 = new JButton("search");
		btnExit_1.setBackground(Color.GREEN);
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String mobile = fldMobile.getSelectedText();
				Connection con;
				PreparedStatement pst;
				try {
					con =Connector.getConnection();
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery("select * from Students where mobile = "+fldMobile.getText());
					while(rs.next())
					{
						fldMobile.setEditable(false);
						
						fldName.setText(rs.getString(3));
						fldParent.setText(rs.getString(4));
						fldEmail.setText(rs.getString(5));
						fldAdm.setText(rs.getInt(6)+"");
						fldRoom.setText(rs.getString(7));
						fldyear.setText(rs.getInt(8)+"");
					
						//fldStatus.setEditable(false);
						if(rs.getString(9).equals("living"))
						{
							comboBox.addItem("Living");
						//	fldStatus.setText("living");
						}
						else {
							comboBox.addItem("Leaved");
						}

					}
					if( stm.executeQuery(mobile) != null) {
						JOptionPane.showMessageDialog(null, "the Number does not Exict!!!");
					}
					
				}catch(Exception e) 
				{
//					JOptionPane.showMessageDialog(null, "");
					fldMobile.requestFocus();
				}
				
			}
		});
		btnExit_1.setBounds(360, 29, 90, 27);
		frmUpdateAndDelete.getContentPane().add(btnExit_1);
		
		JButton btnsave_1 = new JButton("Update");
		btnsave_1.setForeground(Color.WHITE);
		btnsave_1.setBackground(Color.MAGENTA);
		btnsave_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
	       Connection conn;
    	PreparedStatement pst;
		try {
			conn = Connector.getConnection();
			int id = comboBox.getSelectedIndex();
			String room	=fldRoom.getText();
			String AdmNo =fldAdm.getText();
			String Email =fldEmail.getText();
			String parent =fldParent.getText();
			String StudentName= fldName.getText();
			String mobile = fldMobile.getText();
		    String Status = comboBox.getItemAt(id)+"";
		    String comment=textArea.getText();
		    pst= conn.prepareStatement("update Students set email=?, roomNo=?, year=?, status=? ,comment=? where mobile = "+fldMobile.getText());
		    pst.setString(1, Email);
		    pst.setString(2, room);
		    pst.setInt(3, Integer.parseInt(fldyear.getText()));
		    pst.setString(4, Status);
		    pst.setString(5, comment);
		    pst.executeUpdate();
		
		    int i=pst.executeUpdate();
		    if(i>0) {
		    	JOptionPane.showMessageDialog(null, "Succefull Updated!!");
		    	clear();
		    	textArea.setText(null);
		    	textArea.requestFocus();
		    }else
		    {JOptionPane.showMessageDialog(null, "error UnSuccefull Update!!");}
			
		//	if(Status.equals("living"))''[
//		    ,?
//		    		""
//		    		""
//		    		"?""?"?";'"
//		    ";/.;/'"
//		    "?;/'[/'[/.,mnm,./"
		//	{
		//		pst.executeUpdate("Update roomset roomstatus='Booked'where number='\"+roomNo+\"'");
		//	}
		//	else
		//	{
		//		pst.executeUpdate("Update roomset roomstatus='Not Booked'where number='\"+roomNo+\"'");
		//	}
		}catch(Exception e) {
			System.out.println("Exception error"+e);
		}

			}
		});
		btnsave_1.setBounds(200, 403, 117, 30);
		frmUpdateAndDelete.getContentPane().add(btnsave_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"living", "leaved"}));
		comboBox.setBackground(Color.PINK);
		comboBox.setBounds(200, 361, 240, 30);
		frmUpdateAndDelete.getContentPane().add(comboBox);
		
		JButton btnYear = new JButton("Year");
		btnYear.setForeground(Color.BLACK);
		btnYear.setBackground(Color.MAGENTA);
		btnYear.setBounds(12, 314, 140, 36);
		frmUpdateAndDelete.getContentPane().add(btnYear);
		
		fldyear = new JTextField();
		fldyear.setBounds(203, 313, 247, 36);
		frmUpdateAndDelete.getContentPane().add(fldyear);
		fldyear.setColumns(10);
		
		JLabel lblCommentOnStudent = new JLabel("Comment on Student");
		lblCommentOnStudent.setBackground(Color.BLUE);
		lblCommentOnStudent.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCommentOnStudent.setBounds(468, 23, 220, 36);
		frmUpdateAndDelete.getContentPane().add(lblCommentOnStudent);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(478, 60, 210, 327);
		frmUpdateAndDelete.getContentPane().add(textArea);
		
		status = new String[] {"living","leaved"};
	}

	public void show() {
		frmUpdateAndDelete.setVisible(true);
	}
	
	private void insert() throws Exception{
    Connection con1;
    PreparedStatement ps;
    try {
    	con1 = Connector.getConnection();
    	String sql = "insert into Students(mobile,studentname,parent,email,idno,room,livingStatus,comment) VALUES(?,?,?,?,?,?,?,?)";
    	ps =con1.prepareStatement(sql);
    	ps.setInt(1, Integer.parseInt(fldMobile.getText()));
    	ps.setString(2, fldName.getText());
    	ps.setString(3, fldParent.getText());
    	ps.setString(4, fldEmail.getText());
    	ps.setString(6, fldAdm.getText());
    	ps.setString(7, fldRoom.getText());
    	ps.setString(8, textArea.getText());
    	int i = ps.executeUpdate();
    	if(i>0) {
    		JOptionPane.showMessageDialog(null, "Succefull update");
    		clear();
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, " error!!....inserting update");
    		clear();
    	}
    	
    }catch(SQLException e) {}
    }
	public void clear() {
		fldMobile.setEditable(true);
		fldRoom.setText(null);
		 fldAdm.setText(null);
		 fldEmail.setText(null);
	     fldParent.setText(null);
		 fldName.setText(null); 
		 fldyear.setText("");
		 fldMobile.setEditable(true);
		 

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
