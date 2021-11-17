package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class STUDENTDETAILS {

	private JFrame frmLeavedStudent;
	private JTable table;
	private int id;
	private String currentStatus;

	/**
	 * Create the application.
	 */
	public STUDENTDETAILS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLeavedStudent = new JFrame();
		frmLeavedStudent.getContentPane().setBackground(Color.MAGENTA);
		frmLeavedStudent.setFont(new Font("DejaVu Sans Condensed", Font.BOLD | Font.ITALIC, 16));
		frmLeavedStudent.setTitle("LEAVED STUDENT");
		frmLeavedStudent.setBounds(300, 300, 750, 500);
		frmLeavedStudent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLeavedStudent.getContentPane().setLayout(null);
		String jcomboBoxOption;
		String []status = {"Living","Leaved"};
		JComboBox<?> comboBox;
		comboBox = new JComboBox(status);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.addItemListener((args)->{
			id = comboBox.getSelectedIndex();
		     switch(id) {
		     case 0:
		    	 currentStatus= "Living";
		    	 break;
		     case 1:
		    	 currentStatus = "leaved";
		    	 break;
		    	 
		     }
			});
		
		comboBox.setFont(new Font("Dialog", Font.BOLD, 25));
		comboBox.setBounds(245, 12, 299, 47);
		frmLeavedStudent.getContentPane().add(comboBox);
		jcomboBoxOption=comboBox.getItemAt(id).toString();
		table = new JTable();
		table.setBackground(Color.BLACK);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "New column", "New column", "New column", "New column", "New column", "New column"
			
			}
			
		));
		table.setVisible(true);
		table.setBounds(39, 184, 687, 274);
		frmLeavedStudent.getContentPane().add(table);
		
		JButton btnView = new JButton("View");
		btnView.setForeground(Color.WHITE);
		btnView.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		btnView.setBackground(Color.BLUE);
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String leaved=comboBox.getItemAt(id).toString();
				Connection con;
				PreparedStatement pst;
				try {
					con = Connector.getConnection();
					String sql = "select * from Students where status='"+leaved+"'";
					pst = con.prepareStatement(sql);
					ResultSet rs = pst.executeQuery();
					Object row[];
					DefaultTableModel dtm = (DefaultTableModel)table.getModel();
					dtm.setRowCount(0);
					while(rs.next())
					{
						row = new Object[7];
						
						
						row[0]=rs.getInt(1);
						row[1]=rs.getString(2);
						row[2]=rs.getString(3);
						row[3]=rs.getString(4);
						row[4]=rs.getString(5);
						row[5]=rs.getString(6);
						row[6]=rs.getString(7);
						dtm.addRow(row);
						
					}
				}
				catch(Exception e) {}
			}
		});
		btnView.setBounds(34, 101, 117, 37);
		frmLeavedStudent.getContentPane().add(btnView);
		
		JLabel lblNewLabel = new JLabel("Student/\nStatus\n");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 25));
		lblNewLabel.setBounds(12, 12, 237, 47);
		frmLeavedStudent.getContentPane().add(lblNewLabel);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmLeavedStudent.setVisible(false);
				}
				DASHBOARD DC =new DASHBOARD();
				DC.show();
				
			}
		});
		btnExit.setBounds(620, 0, 106, 45);
		frmLeavedStudent.getContentPane().add(btnExit);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(44, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblId);
		
		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(143, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblPhone);
		
		JLabel lblName = new JLabel("name");
		lblName.setBounds(244, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblName);
		
		JLabel lblParent = new JLabel("parent");
		lblParent.setBounds(328, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblParent);
		
		JLabel lblEmail = new JLabel("email");
		lblEmail.setBounds(400, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblEmail);
		
		JLabel lblNatioanId = new JLabel("Natioan id");
		lblNatioanId.setBounds(471, 150, 85, 22);
		frmLeavedStudent.getContentPane().add(lblNatioanId);
		
		JLabel lblRoom = new JLabel("room");
		lblRoom.setBounds(584, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblRoom);
		
		JLabel lblStatus = new JLabel("status");
		lblStatus.setBounds(667, 150, 59, 22);
		frmLeavedStudent.getContentPane().add(lblStatus);
		
		
	}

	public void Show() {
		// TODO Auto-generated method stub
		frmLeavedStudent.setVisible(true);	
	}
}
