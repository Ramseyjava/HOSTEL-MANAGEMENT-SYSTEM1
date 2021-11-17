package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class washRoom {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public washRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
	
		lblNewLabel.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/toilet.jpg"));
		lblNewLabel.setBounds(22, 12, 650, 470);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Exict");
		btnNewButton.addActionListener(obj->{
			int a=JOptionPane.showConfirmDialog(null, "do what to Exit application", "select", JOptionPane.YES_NO_OPTION);
			if(a==0)
			{
				frame.setVisible(false);
				ManageRoom vb = new ManageRoom();
			}
		});
		btnNewButton.setBounds(510, 0, 117, 48);
		frame.getContentPane().add(btnNewButton);
	}

	public void show() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
