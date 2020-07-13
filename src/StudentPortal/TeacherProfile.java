package StudentPortal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TeacherProfile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherProfile frame = new TeacherProfile();
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
	public TeacherProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblStudentProfile = new JLabel("Teacher Profile");
		lblStudentProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentProfile.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudentProfile.setForeground(new Color(0, 0, 0));
		lblStudentProfile.setBounds(218, 11, 215, 32);
		contentPane.add(lblStudentProfile);
		
		JButton btnHome = new JButton("Log Out");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage obj = new HomePage();
				obj.setVisible(true);
				dispose();
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentPage obj = new StudentPage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 18, 89, 23);
		contentPane.add(btnBack);
		btnHome.setBounds(10, 49, 89, 23);
		contentPane.add(btnHome);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 672, 373);
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("StudentPagePic1.jpg")));
		contentPane.add(lblNewLabel);
	}

}
