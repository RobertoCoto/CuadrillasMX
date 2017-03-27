package com.fyg.cuadrillas.controlador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
	/**
	 * campo contraseña
	 */
	private static JPasswordField campoContrasena;
	/**
	 * Metodo inicial loginController
	 */
	public LoginController() {
		this.setSize(600,450);
	}
	/**
	 * Creacion de la interfaz
	 */
	public static void interfazLogin() {
		//se crea la ventana
        final JFrame frame = new JFrame("Iniciar Sesión - Bienvenido TATEI");
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
        //Accion de boton login
        login.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		//se ponen los parametros
        		String usuario = campoUsuario.getText();
        		String pass = campoContrasena.getText();
        		//url para consumir WS
        		String url = "http://localhost:8080/CuadrillasWS/service/loginUsuario/user?usuario="+usuario+"&password="+pass;
        		System.out.println(url);
        		String output  = getUrlContents(url);
        	    System.out.println("aqui: "+output);
        		Menu menuPrincipal = new Menu();
        		menuPrincipal.setVisible(true);
        		frame.setVisible(false);
        	}
        });
        frame.add(login);
        frame.setLayout(null);
        frame.pack();
        frame.setVisible(true);
	}

	/**
	 * imagen de fondo
	 * @param g variable g
	 */
	public void paintComponent(Graphics g) {
		Dimension tamanio = getSize();
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/resources/back_Home_login.jpg"));
		ImageIcon logoTatei = new ImageIcon(getClass().getResource("/resources/banner_tatei.png"));
		g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		g.drawImage(logoTatei.getImage(), 0, 0, 250, 550, null);
		setOpaque(false);
		super.paintComponent(g);
		}
	/**
	 * Consume WS con los parametros enviados
	 * @param theUrl
	 * @return
	 */
	  private static String getUrlContents(String theUrl)
	  {
	    StringBuilder content = new StringBuilder();

	    // many of these calls can throw exceptions, so i've just
	    // wrapped them all in one try/catch statement.
	    try
	    {
	      // create a url object
	      URL url = new URL(theUrl);

	      // create a urlconnection object
	      URLConnection urlConnection = url.openConnection();

	      // wrap the urlconnection in a bufferedreader
	      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

	      String line;

	      // read from the urlconnection via the bufferedreader
	      while ((line = bufferedReader.readLine()) != null)
	      {
	        content.append(line + "\n");
	      }
	      bufferedReader.close();
	    }
	    catch(Exception e)
	    {
	      e.printStackTrace();
	    }
	    return content.toString();
	  }
		/**
		 * Metodo main
		 * @param args recibira argumentos
		 */
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	interfazLogin();
            }
        });
	}

}
