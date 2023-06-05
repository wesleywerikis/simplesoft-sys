package br.com.simplesoft.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu {

	private JFrame frameMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frameMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMenu = new JFrame();
		frameMenu.setTitle("· Menu");
		frameMenu.setResizable(false);
		frameMenu.getContentPane().setBackground(new Color(255, 255, 255));
		frameMenu.getContentPane().setLayout(null);
		
		JLabel lblMenu_Successfully = new JLabel("Logged in successfully.");
		lblMenu_Successfully.setForeground(new Color(45, 107, 37));
		lblMenu_Successfully.setBackground(new Color(255, 255, 255));
		lblMenu_Successfully.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMenu_Successfully.setBounds(96, 63, 242, 48);
		frameMenu.getContentPane().add(lblMenu_Successfully);
		
		JButton btnMenu_Exit = new JButton("Exit");
		btnMenu_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnMenu_Exit.setFocusable(false);
		btnMenu_Exit.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		btnMenu_Exit.setBackground(Color.WHITE);
		btnMenu_Exit.setBounds(155, 134, 124, 23);
		frameMenu.getContentPane().add(btnMenu_Exit);
		frameMenu.setBounds(100, 100, 450, 300);
		frameMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
