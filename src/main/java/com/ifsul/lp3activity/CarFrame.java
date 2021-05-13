package com.ifsul.lp3activity;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CarFrame extends JFrame {

	private JPanel contentPane;
	private CarRepository cr;
	private UserRepository ur;
	private DefaultListModel<Car> modelCar = new DefaultListModel<>();
	private JTextField txtLicense;
	private JTextField txtModel;
	private JTextField txtColor;
	public User selected;
	private JTextField txtFIlter;
	

	public CarFrame(UserRepository ur, CarRepository cr, User selected) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Carros");
		this.cr = cr;
		this.ur = ur;
		this.selected = selected;
		setBounds(100, 100, 509, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JList listCars = new JList();
		listCars.setBounds(13, 12, 281, 172);
		contentPane.add(listCars);
		listCars.setModel(modelCar);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(58, 250, 70, 15);
		contentPane.add(lblPlaca);
		
		txtLicense = new JTextField();
		txtLicense.setBounds(40, 277, 114, 19);
		contentPane.add(txtLicense);
		txtLicense.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(196, 250, 70, 15);
		contentPane.add(lblModelo);
		
		txtModel = new JTextField();
		txtModel.setBounds(180, 277, 114, 19);
		contentPane.add(txtModel);
		txtModel.setColumns(10);
		
		JLabel lblCor = new JLabel("Cor:");
		lblCor.setBounds(334, 250, 70, 15);
		contentPane.add(lblCor);
		
		txtColor = new JTextField();
		txtColor.setBounds(325, 277, 114, 19);
		contentPane.add(txtColor);
		txtColor.setColumns(10);
		
		
		JButton btnNovoCarro = new JButton("Adicionar Carro");
		btnNovoCarro.setBounds(111, 308, 203, 25);
		contentPane.add(btnNovoCarro);
		btnNovoCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car car = new Car();
				car.setCarLicensePlate(txtLicense.getText());
				car.setModel(txtModel.getText());
				car.setColor(txtColor.getText());
				car.setUser(selected);
				
				cr.save(car);
				JOptionPane.showMessageDialog(null, "Novo carro cadastrado");
				updateList();
			}
		});
		

		
		JButton btnLicenseFilter = new JButton("Filtrar por Placa");
		btnLicenseFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelCar.removeAllElements();							
				List<Car> cars = cr.findByCarLicensePlate(txtFIlter.getText());
				modelCar.addAll(cars);
			}
		});
		
		btnLicenseFilter.setBounds(306, 52, 178, 25);
		contentPane.add(btnLicenseFilter);
		
		JButton btnCleanFIlter = new JButton("Limpar filtro");
		btnCleanFIlter.setBounds(306, 97, 178, 25);
		contentPane.add(btnCleanFIlter);
		btnCleanFIlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateList();
			}
		});
		
		txtFIlter = new JTextField();
		txtFIlter.setBounds(310, 21, 174, 19);
		contentPane.add(txtFIlter);
		txtFIlter.setColumns(10);
		
		JLabel lblCadastrar = new JLabel("Cadastrar carros");
		lblCadastrar.setBounds(184, 208, 130, 15);
		contentPane.add(lblCadastrar);
		
		
		updateList();
		this.setVisible(true);
	}
	
	private void updateList() {
		modelCar.removeAllElements();
		List<Car> cars = cr.findByUserId(selected.getId());
		modelCar.addAll(cars);
	}
}
