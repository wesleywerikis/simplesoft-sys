package br.com.simplesoft.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.simplesoft.controller.LoginController;

public class Login {

	private JFrame frameLogin;
	private JTextField tfLogin_Usuario;
	private JPasswordField pfLogin_Senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameLogin = new JFrame();
		frameLogin.setResizable(false);
		frameLogin.setTitle("· Login");
		frameLogin.setBounds(100, 100, 314, 378);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.setLocationRelativeTo(null);
		frameLogin.getContentPane().setLayout(null);
		
		JLabel lblLogin_Usuario = new JLabel("Usuário:");
		lblLogin_Usuario.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblLogin_Usuario.setBounds(47, 43, 77, 23);
		frameLogin.getContentPane().add(lblLogin_Usuario);
		
		tfLogin_Usuario = new JTextField();
		tfLogin_Usuario.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		tfLogin_Usuario.setColumns(10);
		tfLogin_Usuario.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		tfLogin_Usuario.setBackground(Color.WHITE);
		tfLogin_Usuario.setBounds(47, 65, 203, 23);
		frameLogin.getContentPane().add(tfLogin_Usuario);
		
		JLabel lblLogin_Senha = new JLabel("Senha:");
		lblLogin_Senha.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
		lblLogin_Senha.setBounds(47, 99, 77, 23);
		frameLogin.getContentPane().add(lblLogin_Senha);
		
		pfLogin_Senha = new JPasswordField();
		pfLogin_Senha.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 13));
		pfLogin_Senha.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
		pfLogin_Senha.setBackground(Color.WHITE);
		pfLogin_Senha.setBounds(47, 120, 203, 23);
		frameLogin.getContentPane().add(pfLogin_Senha);
		
		JButton btnLogin_Login = new JButton("Login");
		btnLogin_Login.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        LoginController controller = new LoginController(Login.this);
		        controller.logar();
		    }
		});
		btnLogin_Login.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnLogin_Login.setBackground(Color.WHITE);
		btnLogin_Login.setBounds(47, 165, 203, 23);
		frameLogin.getContentPane().add(btnLogin_Login);
		
		JLabel lblLogin_Background = new JLabel("");
		lblLogin_Background.setIcon(new ImageIcon(Login.class.getResource("img/img-login/img-fnd.png")));
		lblLogin_Background.setBounds(0, 0, 300, 340);
		frameLogin.getContentPane().add(lblLogin_Background);
	}
	
	public String getUsername() {
		return tfLogin_Usuario.getText();
	}

	public char[] getPassword() {
		return pfLogin_Senha.getPassword();
	}

	public void dispose() {
		frameLogin.dispose();
	}
}
