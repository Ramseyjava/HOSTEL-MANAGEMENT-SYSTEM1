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

import com.mysql.cj.protocol.Resultset;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class ManageRoom {

	public JFrame frmManageRoom;
	private JTextField JTextRoom;
	private JTable tblRoom;
	private JCheckBox box1;
	private JCheckBox box2;
	String activated,activate,RoomStatus;
	private JTextField fldstatus;
	String Room_number;
	String BOOKED;
	private JTextField textField_1;

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
					pst.setString(1, JTextRoom.getText());
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						if(rs.getString(1).equals(JTextRoom.getText()));
						{
							JOptionPane.showMessageDialog(null, "Room_NO already exit in the System"+"\n"+"Please try Again!",room_no, JOptionPane.WARNING_MESSAGE);
						JTextRoom.setText(null);
							JTextRoom.setRequestFocusEnabled(true);
						} 	
				}else {

					con= Connector.getConnection();
					String sql="insert into manage_room(room_no,RoomStatus,activate)values(?,?,?)";
					PreparedStatement ps= con.prepareStatement(sql);
						ps.setString(1, room_no);
						ps.setString(2, RoomStatus);
						ps.setString(3, activate);
//						ps.executeUpdate();
						int i=ps.executeUpdate();
						if(i>0) {
							tableshow();
							JOptionPane.showMessageDialog(null, "Succefull inserted!!!welcome");
							tblRoom.setSelectionBackground(Color.blue);
							JTextRoom.setText(null);
							JTextRoom.setRequestFocusEnabled(true);
							textField_1.requestFocus();
						tblRoom.clearSelection();
						}else {JOptionPane.showInputDialog(null, room_no);
							}
				}
					
				}catch(Exception e) {
					System.out.println("Error" + e);
				}
	
			}
			
		});
		btnSave.setBounds(548, 73, 85, 25);
		frmManageRoom.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					frmManageRoom.setVisible(false);
					DASHBOARD BB= new DASHBOARD();
					
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
				
				i=1;
				if(rs.getString(3).equals("BOOKED")){
					JOptionPane.showMessageDialog(null, "This Room is Booked!!");
					textField_1.setText(null);
					textField_1.setEditable(false);
					textField_1.requestFocus();
					tblRoom.clearSelection();
					tblRoom.setEditingColumn(0);
					fldstatus.setText(null);
					fldstatus.setSelectedTextColor(Color.blue);
					DefaultTableModel tb = (DefaultTableModel)tblRoom.getModel();
					tb.setRowCount(0);
			
					
				}else{
					textField_1.setBackground(Color.pink);
					if(rs.getString(2).equals("YES")) {
						box2.setSelected(true);
						
					}else {
						box2.setSelected(false);
						
					}
				}
					
				
				fldstatus.setText(rs.getString(3));
			DefaultTableModel tb = (DefaultTableModel)tblRoom.getModel();
			tb.setRowCount(0);
			Object Row[];
			Row = new Object[4];
			Row[0]=rs.getString(1);
			Row[1]=rs.getString(2);
			Row[2]=rs.getString(3);
			Row[3]=rs.getString(4);
			tb.addRow(Row);
			
			textField_1.setText(null);
			textField_1.setRequestFocusEnabled(true);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The Room Number Does not Exist!!");
				textField_1.setText(null);
				box1.setSelected(false);
				textField_1.setRequestFocusEnabled(true);
				tblRoom.clearSelection();
		
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
				activated = "YES";
			}
			else {
				activated =  "NO";
			}
		});
		box2.setBounds(573, 149, 71, 23);
		frmManageRoom.getContentPane().add(box2);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(object->{
			String Room_number = textField_1.getText();
			
			try {
				Connection conn = Connector.getConnection();
				Statement st = conn.createStatement();
				st.executeUpdate("delete from manage_room where room_no= '"+Room_number+"'");
				int i=st.executeUpdate(Room_number);
//				clear();
				if(i>0) {
					tableshow();
					textField_1.setText("");
					JOptionPane.showMessageDialog(null, "Succefull Deleted!!",Room_number, JOptionPane.YES_NO_OPTION);
					
					textField_1.requestFocus();
					tblRoom.clearSelection();
				}else {
					JOptionPane.showMessageDialog(null, "error occured while Delecting");
				}
					
					
					clear();
				
			}catch(Exception e) {}
		});
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(579, 178, 98, 25);
		frmManageRoom.getContentPane().add(btnDelete);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(Color.BLUE);
		separator_1.setBounds(24, 215, 679, 20);
		frmManageRoom.getContentPane().add(separator_1);
		
		JLabel lblAllRooms = new JLabel("ALL ROOMS");
		lblAllRooms.setBounds(33, 226, 141, 23);
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
		tblRoom.setBounds(12, 261, 480, 141);
		frmManageRoom.getContentPane().add(tblRoom);
		
		JLabel lblStatus = new JLabel("status");
		lblStatus.setBounds(255, 230, 70, 15);
		frmManageRoom.getContentPane().add(lblStatus);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null,"Toilets/Stores", TitledBorder.LEADING, TitledBorder.TOP));
		panel.setBounds(527, 230, 176, 177);
		frmManageRoom.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(obj->{
		washRoom wr= new washRoom();
		wr.show();
		frmManageRoom.setVisible(false);
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 22));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setBounds(32, 46, 117, 50);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/school2.jpeg"));
		lblNewLabel_1.setBounds(12, 12, 152, 165);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("STATUS");
		lblNewLabel_2.setBounds(42, 180, 71, 44);
		frmManageRoom.getContentPane().add(lblNewLabel_2);
		
		fldstatus = new JTextField();
		fldstatus.setForeground(Color.BLACK);
		fldstatus.setColumns(10);
		fldstatus.setBounds(118, 182, 128, 32);
		frmManageRoom.getContentPane().add(fldstatus);
		
		JButton btnUpdate = new JButton("update");
		btnUpdate.addActionListener(obj->{

		try {
			update();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
		btnUpdate.setBackground(Color.RED);
		btnUpdate.setBounds(442, 178, 98, 40);
		frmManageRoom.getContentPane().add(btnUpdate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 138, 114, 34);
		frmManageRoom.getContentPane().add(textField_1);
		textField_1.setColumns(10);
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
	private void update()throws Exception, ClassNotFoundException{
		 Room_number=textField_1.getText();
		String RoomStatus="BOOKED";
		int i=0;
		if(box2.isSelected()) {
			activate="YES";
		}else
		{
			activate="NO";
		}
		
		try {
			Connection conn;
			conn=Connector.getConnection();
			
PreparedStatement pst= conn.prepareStatement("Update manage_room set RoomStatus='"+RoomStatus+"',activate='"+activate+"' where room_no='007'");

pst.setInt(3, Integer.parseInt(textField_1.getText()));
//pst.setString(1, Room_number);

		
			int a=pst.executeUpdate();
			if(a>0) {
				JOptionPane.showMessageDialog(null, "succefully updated!!!");
				tblRoom.clearSelection();
				clear();
			}else {
				JOptionPane.showMessageDialog(null, "Unsuccefully updated!!!");
				tblRoom.setToolTipText(null);
				tblRoom.clearSelection();
				
			}
		}catch(Exception e) {
			System.out.println("error updating"+e.getMessage());
			e.printStackTrace();
			
			textField_1.requestFocus();
		}
	}
}