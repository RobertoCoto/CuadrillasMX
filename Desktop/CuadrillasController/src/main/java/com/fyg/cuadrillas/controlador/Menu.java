package com.fyg.cuadrillas.controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.UIManager;

public class Menu extends JFrame {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = -3010529671062853579L;
	private JPanel contentPane;
	private JPanel panelEmpleados;
	private JTable tablaEmpleados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resources/logo_tatei_home.png")));
		setResizable(false);
		setTitle("Menu Principal - TATEI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 513);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNombre = new JLabel("Nombre:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombre, 0, SpringLayout.NORTH, contentPane);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblNombre);
		
		JLabel lblPerfil = new JLabel("Perfil:");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblPerfil, 0, SpringLayout.SOUTH, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPerfil, -152, SpringLayout.EAST, contentPane);
		lblPerfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblPerfil);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombre, 40, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 137, SpringLayout.WEST, contentPane);
		panel.setBackground(new Color(138, 43, 226));
		panel.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		
		JButton btnRegistrarHuella = new JButton("Registrar Huella");
		btnRegistrarHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Habilitando tabla empleados");
				panelEmpleados.setVisible(true);
			}
		});
		panel.add(btnRegistrarHuella);

		panelEmpleados = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panelEmpleados, -205, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panelEmpleados, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panelEmpleados, -29, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panelEmpleados, -10, SpringLayout.EAST, contentPane);
		panelEmpleados.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleados.setVisible(false);
		contentPane.add(panelEmpleados);

		tablaEmpleados = new JTable();
		JTableHeader header = tablaEmpleados.getTableHeader();
		tablaEmpleados.setBorder(new LineBorder(new Color(0, 0, 0)));
		tablaEmpleados.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "ee", "ee", null},
				{null, null, null, null},
			},
			new String[] {
				"ID ", "Nombre", "Apellido Paterno", "Apellido Materno"
			}
		));
		tablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(141);
		tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(178);
		tablaEmpleados.getColumnModel().getColumn(3).setPreferredWidth(179);
		panelEmpleados.add(header, BorderLayout.NORTH);
		panelEmpleados.add(tablaEmpleados);
	}
}
