package StudentPortal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class StudentLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	StudentOutput ob=new StudentOutput();
	private JPasswordField password;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentLogIn frame = new StudentLogIn();
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
	public StudentLogIn() {
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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogIn obj = new LogIn();
				obj.setVisible(true);
				dispose();
			}
		});
		
		password = new JPasswordField();
		password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		password.setBounds(231, 160, 230, 31);
		contentPane.add(password);
		btnBack.setFocusPainted(false);
		btnBack.setBounds(10, 40, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblStudenLogIn = new JLabel("Student Log In");
		lblStudenLogIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudenLogIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudenLogIn.setBounds(203, 32, 258, 31);
		contentPane.add(lblStudenLogIn);
		
		JButton btnForgetPassword = new JButton("Forget Password");
		btnForgetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForgatePassword obj = new ForgatePassword();
				obj.setVisible(true);
				dispose();
			}
		});
		btnForgetPassword.setBounds(231, 251, 170, 23);
		contentPane.add(btnForgetPassword);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String Email=email.getText();
			String Password=password.getText();
			try {
				ob.Output(Email);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
            if (Password.equals(ob.password)) {
				System.out.println("matched");
				StudentPage obj = new StudentPage();
				obj.setVisible(true);
				dispose();
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
		lblNewLabel.setBounds(0, 0, 672, 412);
		lblNewLabel.setIcon(new ImageIcon(HomePage.class.getResource("StudentPagePic1.jpg")));
		contentPane.add(lblNewLabel);
	}
}
