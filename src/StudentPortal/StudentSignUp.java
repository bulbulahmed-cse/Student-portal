package StudentPortal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentSignUp extends JFrame {
	

	private JPanel contentPane;
	private JTextField name;
	private JTextField id;
	private JTextField dept;
	private JTextField email;
	private JTextField password;
	private JTextField pin;

	/**
	 * Launch the application.
	 */
	StudentInput inp = new StudentInput();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSignUp frame = new StudentSignUp();
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
	public StudentSignUp() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(243, 105, 217, 23);
		contentPane.add(id);
		
		JLabel lblStudentName = new JLabel("Name :");
		lblStudentName.setBounds(125, 70, 108, 23);
		contentPane.add(lblStudentName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(125, 208, 108, 23);
		contentPane.add(lblPassword);
		
		pin = new JTextField();
		pin.setColumns(10);
		pin.setBounds(243, 243, 217, 23);
		contentPane.add(pin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Id=id.getText();
				String Name= name.getText();
				String Email = email.getText();
				String Password = password.getText();
				String Dept = dept.getText();
				int Pin = Integer.parseInt(pin.getText());
				inp.Insert(Name, Id, Email, Password, Pin, Dept);
				if (inp.counter==1) {
					StudentLogIn obj = new StudentLogIn();
					obj.setVisible(true);
					dispose();	
				}
				
				
			}
		});
		btnSignUp.setBounds(243, 288, 89, 23);
		contentPane.add(btnSignUp);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HomePage obj = new HomePage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnHome.setFocusPainted(false);
		btnHome.setBounds(10, 11, 89, 23);
		contentPane.add(btnHome);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(243, 176, 217, 23);
		contentPane.add(email);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(243, 209, 217, 23);
		contentPane.add(password);
		
		JLabel lblStudentSignUp = new JLabel("Student Sign Up");
		lblStudentSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentSignUp.setBounds(238, 15, 222, 14);
		contentPane.add(lblStudentSignUp);
		
		dept = new JTextField();
		dept.setColumns(10);
		dept.setBounds(243, 142, 217, 23);
		contentPane.add(dept);
		
		JLabel lblHidepin = new JLabel("Security Pin :");
		lblHidepin.setBounds(125, 242, 108, 23);
		contentPane.add(lblHidepin);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(125, 141, 108, 23);
		contentPane.add(lblDepartment);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SignUp obj = new SignUp();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setFocusPainted(false);
		btnBack.setBounds(10, 40, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(125, 175, 108, 23);
		contentPane.add(lblEmail);
		
		JLabel lblStudentEmail = new JLabel("Id :");
		lblStudentEmail.setBounds(125, 104, 108, 23);
		contentPane.add(lblStudentEmail);
		
		name = new JTextField();
		name.setBounds(243, 71, 217, 23);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("StudentPagePic1.jpg")));
		lblNewLabel.setBounds(0, 0, 646, 373);
		contentPane.add(lblNewLabel);
	}
}
