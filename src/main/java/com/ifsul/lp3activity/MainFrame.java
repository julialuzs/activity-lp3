package com.ifsul.lp3activity;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JLabel labelName;
	private JLabel labelLastName;
	private JTextField txtLastName;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblSenha;
	private JTextField txtPassword;
	private JList listUsers;
	private UserRepository ur;
	private DefaultListModel<User> modelUser = new DefaultListModel<>();
	
	public MainFrame(UserRepository ur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ur = ur;
		setTitle("Cadastro de usuário");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelTitle = new JLabel("Cadastro de usuários");
		labelTitle.setBounds(139, 0, 171, 35);
		contentPane.add(labelTitle);
		
		txtName = new JTextField();
		txtName.setBounds(114, 50, 314, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		labelName = new JLabel("Nome");
		labelName.setBounds(22, 36, 85, 46);
		contentPane.add(labelName);
		
		labelLastName = new JLabel("Sobrenome");
		labelLastName.setBounds(22, 87, 121, 15);
		contentPane.add(labelLastName);
		
		txtLastName = new JTextField();
		txtLastName.setBounds(114, 85, 314, 19);
		contentPane.add(txtLastName);
		txtLastName.setColumns(10);
		
		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(29, 114, 70, 15);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(114, 112, 314, 19);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblUsername = new JLabel("Username");
		lblUsername.setBounds(29, 141, 85, 15);
		contentPane.add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(114, 143, 314, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(29, 168, 70, 19);
		contentPane.add(lblSenha);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(114, 168, 314, 19);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JList listUsers = new JList();
		listUsers.setBounds(42, 102, 343,148);
		listUsers.setModel(modelUser);
		
		
		JButton btnRegister = new JButton("Registrar usuário");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = new User();
				user.setFirstName(txtName.getText());
				user.setLastName(txtLastName.getText());
				user.setEmail(txtEmail.getText());
				user.setUsername(txtUsername.getText());
				user.setPassword(txtPassword.getText());
				user.setCreated(LocalDateTime.now());
				ur.save(user);
				JOptionPane.showMessageDialog(null, "Usuário cadastrado");
				updateList();
			}
		});
		btnRegister.setBounds(270, 208, 158, 25);
		contentPane.add(btnRegister);
		
		this.setVisible(true);
	}
	
	private void updateList() {
		modelUser.removeAllElements();
		List<User> users = ur.findAll();
		modelUser.addAll(users);
	}
}
