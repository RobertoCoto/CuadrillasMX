package com.fyg.cuadrillas.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Pantalla Inicio Session
 * @author rcoto
 * 24/03/2017
 */
public class LoginController extends javax.swing.JPanel {
	
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 3337743831319711587L;
	/**
	 * campo usuario
	 */
	private static JTextField campoUsuario;
	private static JPasswordField campoContrasena;
	public LoginController() {
		this.setSize(600,450);
	}
	public static void interfazLogin() {
		//se crea la ventana
        JFrame frame = new JFrame("Iniciar Sesión - Bienvenido TATEI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
      //se llama al metodo donde esta nuestra imagen.
        LoginController p = new LoginController();
        frame.setContentPane(p);
        frame.setResizable(false);
       
        //se agrega un label
        JLabel label = new JLabel("Usuario");
        label.setFont(new Font("Courier New", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        label.setSize(300, 30);
        label.setLocation(10, 280);
        frame.getContentPane().add(label);
        frame.setPreferredSize(new Dimension(700, 550)); 
        
        //se agrega el primer input
        campoUsuario = new JTextField(10);
        campoUsuario.setBounds(10, 305, 200, 35);
        frame.add(campoUsuario);
        
        //se agrega un segundo Label
        JLabel psswd = new JLabel("Contraseña");
        psswd.setFont(new Font("Courier New", Font.BOLD, 18));
        psswd.setForeground(Color.BLACK);
        psswd.setSize(300, 30);
        psswd.setLocation(10, 370);
        frame.getContentPane().add(psswd);
        
        //se agrega el segundo input
        campoContrasena = new JPasswordField(15);
        campoContrasena.setBounds(10, 395, 200, 35);
        frame.add(campoContrasena);
        
        //Se agrega boton personalizado
        JButton login = new JButton("Iniciar Sesión");
        login.setBounds(35, 445, 150, 35);
        frame.add(login);
        
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
	}
	
	//imagen fondo
	public void paintComponent (Graphics g){
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/back_Home_login.jpg"));
		ImageIcon logoTatei = new ImageIcon(getClass().getResource("/resources/banner_tatei.png"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
		g.drawImage(logoTatei.getImage(), 0, 0, 250, 550, null);
		setOpaque(false);
		super.paintComponent(g);
		}
	
	//Accion de boton login
	
		//metodo principal
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	interfazLogin();
            }
        });
	}

}
