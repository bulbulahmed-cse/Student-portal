package StudentPortal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProfile = new JButton("Home");
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePage obj = new HomePage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnProfile.setFocusPainted(false);
		btnProfile.setBackground(new Color(0, 0, 51));
		btnProfile.setForeground(new Color(255, 255, 204));
		btnProfile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnProfile.setBounds(22, 15, 89, 23);
		contentPane.add(btnProfile);
		
		JButton btnHostel = new JButton("Hostel");
		btnHostel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hostel obj = new Hostel();
				obj.setVisible(true);
				dispose();
			}
		});
		btnHostel.setForeground(new Color(255, 255, 204));
		btnHostel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHostel.setFocusPainted(false);
		btnHostel.setBackground(Color.BLACK);
		btnHostel.setBounds(22, 48, 89, 23);
		contentPane.add(btnHostel);
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogIn obj = new LogIn();
				obj.setVisible(true);
				dispose();
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 204));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogOut.setFocusPainted(false);
		btnLogOut.setBackground(Color.BLACK);
		btnLogOut.setBounds(314, 49, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnSubmission = new JButton("Submission");
		btnSubmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Submission obj = new Submission();
				obj.setVisible(true);
				dispose();
			}
		});
		btnSubmission.setForeground(new Color(255, 255, 204));
		btnSubmission.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSubmission.setFocusPainted(false);
		btnSubmission.setBackground(Color.BLACK);
		btnSubmission.setBounds(207, 48, 104, 23);
		contentPane.add(btnSubmission);
		
		JButton btnSearchStudent = new JButton("Search Student");
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchStudent obj = new SearchStudent();
				obj.setVisible(true);
				dispose();
			}
		});
		btnSearchStudent.setForeground(new Color(255, 255, 204));
		btnSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchStudent.setFocusPainted(false);
		btnSearchStudent.setBackground(Color.BLACK);
		btnSearchStudent.setBounds(457, 16, 149, 23);
		contentPane.add(btnSearchStudent);
		
		JButton btnP = new JButton("Payment");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Payment obj = new Payment();
				obj.setVisible(true);
				dispose();
			}
		});
		btnP.setForeground(new Color(255, 255, 204));
		btnP.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnP.setFocusPainted(false);
		btnP.setBackground(Color.BLACK);
		btnP.setBounds(114, 48, 89, 23);
		contentPane.add(btnP);
		
		JButton btnLiveResult = new JButton("Live Result");
		btnLiveResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentLiveResult obj = new StudentLiveResult();
				obj.setVisible(true);
				dispose();
			}
		});
		btnLiveResult.setForeground(new Color(255, 255, 204));
		btnLiveResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLiveResult.setFocusPainted(false);
		btnLiveResult.setBackground(Color.BLACK);
		btnLiveResult.setBounds(206, 16, 104, 23);
		contentPane.add(btnLiveResult);
		
		JButton btnAcademicResult = new JButton("Academic Result");
		btnAcademicResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentAcademicResult obj = new StudentAcademicResult();
				obj.setVisible(true);
				dispose();
			}
		});
		btnAcademicResult.setForeground(new Color(255, 255, 204));
		btnAcademicResult.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAcademicResult.setFocusPainted(false);
		btnAcademicResult.setBackground(Color.BLACK);
		btnAcademicResult.setBounds(313, 16, 141, 23);
		contentPane.add(btnAcademicResult);
		
		JButton button = new JButton("Profile");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentProfile obj = new StudentProfile();
				obj.setVisible(true);
				dispose();
			}
		});
		button.setForeground(new Color(255, 255, 204));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setFocusPainted(false);
		button.setBackground(Color.BLACK);
		button.setBounds(114, 16, 89, 23);
		contentPane.add(button);
		
		JLabel lblTitellabel = new JLabel("");
		lblTitellabel.setBounds(18, 9, 613, 75);
		lblTitellabel.setIcon(new ImageIcon(HomePage.class.getResource("TitelPic.jpg")));
		contentPane.add(lblTitellabel);
		
		JLabel Piclabel = new JLabel("");
		Piclabel.setBounds(0, 0, 672, 412);
		Piclabel.setIcon(new ImageIcon(HomePage.class.getResource("StudentPagePic1.jpg")));
		contentPane.add(Piclabel);
	}

}
