package demo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HOME{

	private JFrame frmHome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HOME window = new HOME();
					window.frmHome.setVisible(true);
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
	 */
	private void initialize() {
		frmHome = new JFrame();
		frmHome.getContentPane().setForeground(Color.GREEN);
		frmHome.getContentPane().setBackground(SystemColor.desktop);
		frmHome.setTitle("HOME");
		frmHome.setBounds(100, 100, 804, 490);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHome.getContentPane().setLayout(null);
		
		JTextArea txtrCoursesOffered = new JTextArea();
		txtrCoursesOffered.setEditable(false);
		txtrCoursesOffered.setFont(new Font("Courier 10 Pitch", Font.PLAIN, 15));
		txtrCoursesOffered.setForeground(Color.GREEN);
		txtrCoursesOffered.setText("RULES / REGULATIONS -->\n *MANAGEMENT*\n\t*ID REGESTRATION*\n\t*ADMIS*\n\t*TIME SHEDULE*\n\t*CLEANNESS*\n\t*SECURITY*\n\t*MAINTANACE OF HOSTEL TOOLS*\n\t*NO SMOKING *\n\t*NO STEALLING*\n\t*PAYMENTS SERVICES*");
		txtrCoursesOffered.setBackground(SystemColor.menuText);
		txtrCoursesOffered.setBounds(12, 75, 268, 381);
		frmHome.getContentPane().add(txtrCoursesOffered);
		
		JLabel lblWelcomeToGatwe = new JLabel("WELCOME TO ST PHILIPS HOSTEL MANAGEMENT SYSTEM");
		lblWelcomeToGatwe.setBackground(Color.BLUE);
		lblWelcomeToGatwe.setForeground(Color.WHITE);
		lblWelcomeToGatwe.setFont(new Font("Z003", Font.BOLD | Font.ITALIC, 25));
		lblWelcomeToGatwe.setBounds(24, 12, 714, 51);
		frmHome.getContentPane().add(lblWelcomeToGatwe);
		
		JToggleButton tglbtnContinue = new JToggleButton("NEXT");
		tglbtnContinue.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/right.png"));
		tglbtnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login lg = new Login();
				lg.show();
				frmHome.setVisible(false);
			}
		});
		tglbtnContinue.setBackground(Color.MAGENTA);
		tglbtnContinue.setBounds(603, 412, 167, 32);
		frmHome.getContentPane().add(tglbtnContinue);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/employees.jpeg"));
		lblNewLabel.setBounds(298, 70, 224, 156);
		frmHome.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("EMPLOYEES");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1.setBounds(308, 238, 224, 32);
		frmHome.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/index.png"));
		lblNewLabel_2.setBounds(298, 277, 224, 156);
		frmHome.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("/home/ramsey/eclipse-workspace/HOSTLE MANAGEMENT SYSTEM/HOSTEL-MANAGEMENT SYSTEM1/icons/staff2.jpg"));
		lblNewLabel_3.setBounds(534, 70, 270, 330);
		frmHome.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("STUDENT");
		lblNewLabel_4.setFont(new Font("eufm10", Font.BOLD, 21));
		lblNewLabel_4.setBounds(282, 421, 240, 51);
		frmHome.getContentPane().add(lblNewLabel_4);
		
		;
	}

	public void show() {
		// TODO Auto-generated method stub
		frmHome.setVisible(true);
	}
}

