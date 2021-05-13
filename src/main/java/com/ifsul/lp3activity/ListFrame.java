package com.ifsul.lp3activity;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ListFrame extends JFrame {

	private JPanel contentPane;
	private JList listUsers;
	private UserRepository ur;
	private CarRepository cr;
	private DefaultListModel<User> modelUser = new DefaultListModel<>();
	private JTextField txtUsername;


	public ListFrame(UserRepository ur, CarRepository cr) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ur = ur;
		setTitle("Lista de usuário");
		
		setBounds(100, 100, 486, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listUsers = new JList();
		listUsers.setBounds(26, 12, 267, 294);
		contentPane.add(listUsers);
		listUsers.setModel(modelUser);
		
		
		ListSelectionModel listSelectionModel = listUsers.getSelectionModel();
		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler(ur, cr, listUsers));
			
		
		JButton btnNovoUsurio = new JButton("Novo Usuário");
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame(ur);
			}
		});
		btnNovoUsurio.setBounds(323, 259, 141, 25);
		contentPane.add(btnNovoUsurio);
		
		JButton btnFilter = new JButton("Filtrar");
		btnFilter.setBounds(318, 103, 146, 25);
		contentPane.add(btnFilter);
		btnFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelUser.removeAllElements();							
				List<User> users = ur.findByUsernameContaining(txtUsername.getText());
				modelUser.addAll(users);
			}
		});
		
		
		txtUsername = new JTextField();
		txtUsername.setBounds(318, 72, 146, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(323, 45, 96, 15);
		contentPane.add(lblUsername);
		
		JButton btnCleanFIlter = new JButton("Limpar FIltro");
		btnCleanFIlter.setBounds(318, 140, 146, 25);
		contentPane.add(btnCleanFIlter);
		btnCleanFIlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateList();
			}
		});
		
				
		updateList();
		this.setVisible(true);
	}
	
	
	private void updateList() {
		modelUser.removeAllElements();
		List<User> users = ur.findAll();
		modelUser.addAll(users);
	}
}
