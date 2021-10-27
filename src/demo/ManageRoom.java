package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import java.awt.Color;
import java.awt.Font;

public class ManageRoom {

	public JFrame frmManageRoom;
	private JTextField JTextRoom;
	private JTextField textField_1;
	private JTable tblRoom;
	private JCheckBox box1;
	private JCheckBox box2;
	String activated,activate,RoomStatus;

	/**
	 * Launch the application.
	 */
	
	public ManageRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManageRoom = new JFrame();
		frmManageRoom.getContentPane().setForeground(Color.WHITE);
		frmManageRoom.getContentPane().setBackground(Color.CYAN);
		frmManageRoom.setTitle("MANAGE ROOM");
		frmManageRoom.setBounds(100, 100, 703, 444);
		frmManageRoom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageRoom.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD NEW ROOM");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel.setBackground(Color.YELLOW);
		lblNewLabel.setBounds(33, 12, 141, 35);
		frmManageRoom.getContentPane().add(lblNewLabel);
		
		JLabel lblAddRoom = new JLabel("Room Number");
		lblAddRoom.setBounds(33, 78, 98, 15);
		frmManageRoom.getContentPane().add(lblAddRoom);
		
		JTextRoom = new JTextField();
		JTextRoom.setBounds(136, 76, 114, 19);
		frmManageRoom.getContentPane().add(JTextRoom);
		JTextRoom.setColumns(10);
		
		JLabel lblActivateOrDeactivate = new JLabel("Activate or Deactivate");
		lblActivateOrDeactivate.setBounds(288, 78, 167, 13);
		frmManageRoom.getContentPane().add(lblActivateOrDeactivate);
		
	     box1 = new JCheckBox();
		box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(box1.isSelected()) {
					activate ="Yes";
				}else
				{
					activate = "No";
				}
			}
		});
		box1.setBounds(469, 74, 71, 23);
		frmManageRoom.getContentPane().add(box1);
		
		JButton btnSave = new JButton("save");
		btnSave.setBackground(Color.PINK);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String room_no=JTextRoom.getText();
//				String status=box1.getText();
				 RoomStatus = "NOT BOOKED";
				if(box1.isSelected()) {
					activate ="Yes";
				}else
				{
					activate = "No";
				}
				Connection con;
				PreparedStatement pst;
				try{
					con=Connector.getConnection();
					String sql1="select * from manage_room where room_no=?";
					pst=con.prepareStatement(sql1);
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						if(rs.getString('1').equals(JTextRoom.getText()));
						{
							JOptionPane.showMessageDialog(null, "Room_NO already exit in the System"+"\n"+"Please try Again!");
						} 
							
					}else {
						{
							String sql="insert into manage_room values(?,?)";
							PreparedStatement ps= con.prepareStatement(sql);
							while(rs.next())
							{
								ps.setString(1, room_no);
								ps.setString(2, RoomStatus);
								ps.setString(3, activate);
								ps.executeUpdate();
							}
						}
					}
					
				}catch(Exception e) {
					System.out.println("Error" + e);
				}
				tableshow();
//				clear();
			}
			
		});
		btnSave.setBounds(548, 73, 85, 25);
		frmManageRoom.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmManageRoom.setVisible(false);
				}
			}
		});
		btnExit.setBounds(599, 7, 104, 44);
		frmManageRoom.getContentPane().add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.YELLOW);
		separator.setBounds(12, 106, 679, 20);
		frmManageRoom.getContentPane().add(separator);
		
		JLabel lblUpdateDelete = new JLabel("UPDATE & DELETE ROOM");
		lblUpdateDelete.setForeground(Color.RED);
		lblUpdateDelete.setBackground(Color.GREEN);
		lblUpdateDelete.setBounds(22, 118, 191, 23);
		frmManageRoom.getContentPane().add(lblUpdateDelete);
		
		JLabel lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(32, 153, 99, 15);
		frmManageRoom.getContentPane().add(lblRoomNumber);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(167, 151, 114, 19);
		frmManageRoom.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(object->{
			String Room_number = textField_1.getText();
		int i=0;
		Connection con;
		Statement st;
		try {
			con = Connector.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from manage_room where room_no= "+Room_number);
			if(rs.next())
			
			{
			DefaultTableModel tb = (DefaultTableModel)tblRoom.getModel();
			tb.setRowCount(0);
			Object Row[];
			Row = new Object[4];
			Row[0]=rs.getString(1);
			Row[1]=rs.getString(2);
			Row[2]=rs.getString(3);
			Row[3]=rs.getString(4);
			tb.addRow(Row);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The Room Number Does not Exist!!");
				tableshow();
				box1.setSelected(false);
				textField_1.setRequestFocusEnabled(true);
		
			}
		}catch(Exception e) {
			System.out.println("search error!!"+e);
		}
		});
		btnSearch.setBackground(Color.BLUE);
		btnSearch.setBounds(301, 148, 85, 25);
		frmManageRoom.getContentPane().add(btnSearch);
		
		JLabel lblActivateOrDeactivate_1 = new JLabel("Activate or Deactivate");
		lblActivateOrDeactivate_1.setBounds(399, 153, 167, 13);
		frmManageRoom.getContentPane().add(lblActivateOrDeactivate_1);
		
	   box2 = new JCheckBox();
		box2.addActionListener(object->{
			if(box2.isSelected()) {
				activated = "yes";
			}
			else {
				activated =  "no";
			}
		});
		box2.setBounds(573, 149, 71, 23);
		frmManageRoom.getContentPane().add(box2);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Room_number = textField_1.getText();
				if(box2.isSelected())
				{
					activated ="Yes";
				}else
				{
					activated ="No";
				}
				try {
					Connection conn = Connector.getConnection();
					  PreparedStatement ps = conn.prepareStatement("update manage_room set activate = ?,RoomStatus=? where room_no=?");
					  ps.setString(1, activated);
					  ps.setString(2,"BOOKED" );
					  ps.setInt(3, Integer.parseInt(Room_number));
					  ps.execute();
					JOptionPane.showMessageDialog(null, "Succefull update!!");
					textField_1.setText("");
					textField_1.requestFocus();
					box2.isSelected();
					tableshow();
					textField_1.requestFocus();
//					
				}catch(SQLException | ClassNotFoundException e) {
					System.out.println(""+e.getStackTrace());
					textField_1.requestFocus();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.setBounds(456, 178, 98, 25);
		frmManageRoom.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(object->{
			String Room_number = textField_1.getText();
			
			try {
				Connection conn = Connector.getConnection();
				Statement st = conn.createStatement();
				st.executeUpdate("delete from manage_room where room_no= '"+Room_number+"'");
				tableshow();
//				clear();
				JOptionPane.showMessageDialog(null, "Succefull Deleted!!");
				textField_1.setText("");
				textField_1.requestFocus();
				tableshow();
//				clear();
			}catch(Exception e) {}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(579, 178, 98, 25);
		frmManageRoom.getContentPane().add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(12, 223, 679, 20);
		frmManageRoom.getContentPane().add(separator_1);
		
		JLabel lblAllRooms = new JLabel("ALL ROOMS");
		lblAllRooms.setBounds(183, 220, 141, 23);
		frmManageRoom.getContentPane().add(lblAllRooms);
		
		String[] names =new String[] {
				"Number", "Room Satus", "Activate"
			};
		
		tblRoom = new JTable();
		tblRoom.setForeground(Color.WHITE);
		tblRoom.setBackground(Color.BLACK);
		tblRoom.setColumnSelectionAllowed(true);
		tblRoom.setFillsViewportHeight(true);
		tblRoom.setBorder(new CompoundBorder());
		tblRoom.setVisible(true);
		
		tblRoom.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "room_no", "Roomstatus", "activate"
			}
		));
		tblRoom.setBounds(70, 255, 480, 141);
		frmManageRoom.getContentPane().add(tblRoom);
		
		JLabel lblStatus = new JLabel("status");
		lblStatus.setBounds(456, 223, 70, 15);
		frmManageRoom.getContentPane().add(lblStatus);
		
	}
	public void show() {
		frmManageRoom.setVisible(true);
	}
	private void clear() {
		JTextRoom.setText(null);
		box1.setSelected(false);
		box2.setSelected(false);
		textField_1.setText(null);
		box1.setText(null);
		tblRoom.setVisible(false);
		
	}
	private void tableshow() {
		Connection conn;
		PreparedStatement ps;
		
		try {
			DefaultTableModel dtm = (DefaultTableModel)tblRoom.getModel();
			dtm.setRowCount(0);
			Object Row[];
			String sql ="select * from manage_room";
			conn = Connector.getConnection();
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Row = new Object[4];
				Row[0]=rs.getInt(1);
				Row[1]=rs.getString(2);
				Row[2]=rs.getString(3);
				Row[3]=rs.getString(4);
				dtm.addRow(Row);
			}
			
		}catch(Exception e) {}
	}

}
