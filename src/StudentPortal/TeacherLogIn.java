package StudentPortal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class TeacherLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	Teacheroutput ob=new Teacheroutput();
	private JPasswordField password;
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherLogIn frame = new TeacherLogIn();
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
	public TeacherLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(123, 159, 70, 22);
		contentPane.add(lblPassword);
		
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
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgatePassword obj = new ForgatePassword();
				obj.setVisible(true);
				dispose();
				
			}
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogIn obj = new LogIn();
				obj.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Teacher Log In");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(184, 29, 287, 29);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(231, 160, 230, 29);
		contentPane.add(password);
		btnBack.setFocusPainted(false);
		btnBack.setBounds(10, 40, 89, 23);
		contentPane.add(btnBack);
		btnForgetPassword.setBounds(231, 251, 170, 23);
		contentPane.add(btnForgetPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Email=email.getText();
				String Password=password.getText();
				try {
					ob.Output(Email);
				} catch (Exception c) {
					System.err.println(c.getMessage());
				}
	            if (Password.equals(ob.password)) {
					System.out.println("matched");
					
				}
	            else {
	            	JOptionPane.showMessageDialog(null,"The emaail or the password that you've entered is incorrect.");
	            }
			}
			
		});
		btnLogIn.setBounds(231, 217, 89, 23);
		contentPane.add(btnLogIn);
		
		email = new JTextField();
		email.setBounds(231, 120, 230, 29);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(123, 123, 70, 22);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(5, 5, 646, 363);
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("StudentPagePic1.jpg")));
		contentPane.add(lblNewLabel);
		
	}
}
