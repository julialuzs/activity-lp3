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

public class ListFrame extends JFrame {

	private JPanel contentPane;
	private JList listUsers;
	private UserRepository ur;
	private CarRepository cr;
	private DefaultListModel<User> modelUser = new DefaultListModel<>();


	public ListFrame(UserRepository ur, CarRepository cr) {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.ur = ur;
		setTitle("Lista de usuário");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList listUsers = new JList();
		listUsers.setBounds(26, 12, 382, 185);
		contentPane.add(listUsers);
		listUsers.setModel(modelUser);
		
		
		ListSelectionModel listSelectionModel = listUsers.getSelectionModel();
		listSelectionModel.addListSelectionListener(new SharedListSelectionHandler(ur, cr, listUsers));
			
		
		JButton btnNovoUsurio = new JButton("Novo Usuário");
		btnNovoUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame(ur);
//				CarFrame cf = new CarFrame(ur, cr);
			}
		});
		btnNovoUsurio.setBounds(248, 209, 169, 25);
		contentPane.add(btnNovoUsurio);
				
		updateList();
		this.setVisible(true);
	}
	
	
	private void updateList() {
		modelUser.removeAllElements();
		List<User> users = ur.findAll();
		modelUser.addAll(users);
	}
}
