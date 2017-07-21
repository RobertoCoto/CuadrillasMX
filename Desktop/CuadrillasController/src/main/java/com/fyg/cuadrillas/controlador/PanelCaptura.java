package com.fyg.cuadrillas.controlador;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.BorderLayout;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


/** se Cargan las librerias del lector*/
import com.digitalpersona.onetouch.*;
import com.digitalpersona.onetouch.capture.*;
import com.digitalpersona.onetouch.capture.event.*;
import com.digitalpersona.onetouch.processing.*;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.fyg.cuadrillas.controlador.ObtieneUrl;
import com.fyg.cuadrillas.controlador.ManejaJSON;

public class PanelCaptura extends JApplet
{
	  /**
		 * Serial UID
		 */
		private static final long serialVersionUID = 6586588784320650074L;
		/**campo usuario*/
		static JTextField campoUsuario;
		/**campo Contrasena*/
		static JPasswordField campoContrasena;
		/**Boton login*/
		static JButton login;
		/**Ventana Princioal*/
		static JFrame frame;
		/**Imagen*/
		static JLabel imagen;
		/**Label principal*/
		static JLabel label;
		/** label contrasena*/
		static JLabel psswd;
		/**Boton registrar Huella*/
		JButton btnRegistrarHuella;
		/**label menu*/
		static JLabel menuBar;
		/**Label nombre user*/
		static JLabel lblNombre;
		/**Label Perfil*/
		JLabel lblPerfil;
		/**Label nombre user*/
		JLabel nombreUser;
		/**panel de los botones*/
		JPanel panelBotones;
		/**panel de la huella*/
		JPanel panelHuella;
		/**combo catalogo manos*/
		JComboBox cataMano;
		/**combo catalogo dedos*/
		JComboBox cataDedos;
		/** boton alta huella*/
		JButton altaHuella;
		/** panel consulta*/
		JPanel consulta;
		/** label imagen huella*/
		JLabel imagenHuellaD;
		/** datos de la huella*/
		byte[] datosHuella1 = null;
		/** label imagen huella*/
		JLabel imagenHuella;
		/** label consulta huella*/
		JButton consultaHuella;
		/**
		 * panel de la tabla empleados
		 */
		private JPanel panelEmpleados;
		/**
		 * tabla empleados
		 */
		JTable tablaEmpleados;
		/** combo catalogo*/
		JComboBox catalogoManoConsulta;
		/** combo dedos*/
		JComboBox catalogoDedosConsulta;
		/** boton salida*/
		JButton btnSalir;
		JButton btnAltaHuella;
		JButton btnVerificar;
		JButton verificar;
		
	/**
	 * Metodo publico
	 */
	public PanelCaptura() {
	}
	
	private void createGUI()
    {
		 setSize(1124, 668);

	        //se crea panel inicial
	        JPanel panel = new JPanel();
			panel.setBackground(new Color(138, 43, 226));
			panel.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setPreferredSize(new java.awt.Dimension(130, 270));
	        getContentPane().add(panel, BorderLayout.WEST);
	        
	      //boton de las huellas
	        btnRegistrarHuella = new JButton("Huella");
			btnRegistrarHuella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Habilitando tabla empleados");
					String url = "http://localhost:8080/CuadrillasWS/service/consultaEmpleado/";
			        		String output  = new ObtieneUrl().getUrlContents(url);
			        		try {
			        			//llamada a la clase que convierte json
			        		
			        			JSONObject empleadoRegistro = new ManejaJSON().recibeJSON(output);
			        			JSONArray arrayEmpleado = (JSONArray) empleadoRegistro.get("empleado");
			        			
			        			DefaultTableModel modelo = (DefaultTableModel) tablaEmpleados.getModel();
			        			Object[] filas = new Object[modelo.getColumnCount()];
			        			for (int i = 0; i < arrayEmpleado.size(); i++) {

			        				 JSONObject empleado = (JSONObject) arrayEmpleado.get(i);
			        				 Long idEmpleado = (Long) empleado.get("idEmpleado");
			        				 String numEmpleado = (String) empleado.get("noEmpleado");
			        				 String nombre = (String) empleado.get("nombre");
			        				 String apellidoPaterno = (String) empleado.get("apellidoPat");
			        				 String apellidoMaterno = (String) empleado.get("apellidoMat");
			        				 String puesto = (String) empleado.get("descripcionPuesto");
			        				 filas[0] = idEmpleado;
			        				 filas[1] = numEmpleado;
			        				 filas[2] = nombre;
			        				 filas[3] = apellidoPaterno;
			        				 filas[4] = apellidoMaterno;
			        				 filas[5] = puesto;
			        				 modelo.addRow(filas);
			        			}
			        			btnRegistrarHuella.setEnabled(false);
			        		} catch (Exception ex) {
			        			ex.printStackTrace();
			        		}
					panelEmpleados.setVisible(true);
				}
			});
			panel.add(btnRegistrarHuella);
			
			btnSalir = new JButton(" Salir  ");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
				}
			});
			panel.add(btnSalir);

			//panel de las huellas
			panelEmpleados = new JPanel();
			panelEmpleados.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelEmpleados.setVisible(false);
			panelEmpleados.setPreferredSize(new java.awt.Dimension(70, 170));
			getContentPane().add(panelEmpleados, BorderLayout.SOUTH);

			//tabla de los empleados
			tablaEmpleados = new JTable();
			tablaEmpleados.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Numero Empleado", "Nombre", "Apellido Paterno", "Apellido Materno", "Puesto"
				}
				
				
			) {/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
			      return false;}});
			
			
			tablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(106);
			tablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(141);
			tablaEmpleados.getColumnModel().getColumn(3).setPreferredWidth(167);
			tablaEmpleados.getColumnModel().getColumn(4).setPreferredWidth(142);
			tablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(123);
			JTableHeader header = tablaEmpleados.getTableHeader();
			tablaEmpleados.setBorder(new LineBorder(new Color(0, 0, 0)));
			tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			panelEmpleados.add(header, BorderLayout.NORTH);
			panelEmpleados.add(tablaEmpleados);
            
			/**** huellas */
			
			//panel de los botones
			panelBotones = new JPanel();
			panelBotones.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelBotones.setVisible(false);
			panelBotones.setPreferredSize(new java.awt.Dimension(140, 270));
			getContentPane().add(panelBotones, BorderLayout.EAST);
			
			//Acciones de las filas
			tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		        public void valueChanged(ListSelectionEvent event) {
		            panelBotones.setVisible(true);
		            btnAltaHuella.setEnabled(true);
					consultaHuella.setEnabled(true);
		        }
		    });
			
			//****************** Alta de Huella********************* */
			btnAltaHuella = new JButton("Registra Huella");
			btnAltaHuella.addActionListener(new ActionListener() {
				@SuppressWarnings("unchecked")
				public void actionPerformed(ActionEvent arg0) {
					
					//*************** se activa panel de huella**************************/
					panelHuella.setVisible(true);
					new OperacionLector().inicioLector();
					new OperacionLector().inicializadorHuellas();
					btnAltaHuella.setEnabled(false);
					consultaHuella.setEnabled(false);
					try {
						  //si este ya tiene datos
						  cataMano.removeAllItems();
						  cataDedos.removeAllItems();
						  
			        	  //Llenando combo
				    		String direccion = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
				    		String salida  = new ObtieneUrl().getUrlContents(direccion);
				    		
			    			JSONObject jsonCatalogoMano =  new ManejaJSON().recibeJSON(salida);
			    			JSONArray arrayCatalogoMano = (JSONArray) jsonCatalogoMano.get("catalogo");

			    			for (int j = 0; j < arrayCatalogoMano.size(); j++) {
			    				JSONObject mano = (JSONObject) arrayCatalogoMano.get(j);
			    				String descripcion = (String) mano.get("descripcion");
			    				cataMano.addItem(descripcion);
			    			}
			    			String direccionConsulta = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
				    		String salidaCatalogo  = new ObtieneUrl().getUrlContents(direccionConsulta);

			    			JSONObject jsonCatalogoDedo = new ManejaJSON().recibeJSON(salidaCatalogo);
			    			JSONArray arrayCatalogoDedo = (JSONArray) jsonCatalogoDedo.get("catalogo");

			    			for	(int k = 0; k < arrayCatalogoDedo.size(); k++) {
			    				JSONObject dedo = (JSONObject) arrayCatalogoDedo.get(k);
			    				String descripcionDedo = (String) dedo.get("descripcion");
			    				cataDedos.addItem(descripcionDedo);
			    			}
			    			JOptionPane.showMessageDialog(null, "Numero de Muestras para Capturar Huella: 4");
			    			
			          } catch (Exception ex) {
			        	  ex.printStackTrace();
			          }
					
				}
			});
			panelBotones.add(btnAltaHuella);
			
			//******************** Consulta de Huella ****************************/
			consultaHuella = new JButton(" Verifica Huella ");
			consultaHuella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					 //******************** panel de consulta huella**********************/
					consulta = new JPanel();
					consulta.setBorder(new TitledBorder(null,
							"Consultar Huella", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                    
					imagenHuellaD = new JLabel();
					Border borderD = BorderFactory.createLineBorder(Color.BLUE, 2);
					imagenHuellaD.setBorder(borderD);
					imagenHuellaD.setPreferredSize(new java.awt.Dimension(270, 270));
					imagenHuellaD.setLocation(700, 60);
					btnAltaHuella.setEnabled(false);
					consultaHuella.setEnabled(false);
									
					btnVerificar = new JButton("Iniciar");
					
					
					btnVerificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								JOptionPane.showMessageDialog(null,"Coloque su huella en el lector.");
								new OperacionLector().inicioLector();
								new OperacionLector().verificaHuella();							
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					consulta.add(btnVerificar);
					consulta.add(imagenHuellaD);
					getContentPane().add(consulta, BorderLayout.CENTER);
					
					consulta.setVisible(true);
					frame.pack();
					frame.setSize(1164, 698);
            		frame.setResizable(false);
            		frame.repaint();
				}
			});
			panelBotones.add(consultaHuella);
			
	 /*---------------------------------------------------------------------------*/
		
	
			//panel de la huella
			panelHuella = new JPanel();
			panelHuella.setBorder(new TitledBorder(null, "Registro Huella del Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelHuella.setVisible(false);
			
			//combo de la mano
			cataMano = new JComboBox();
			panelHuella.add(cataMano);

			//combo de los dedos
			cataDedos = new JComboBox();
			panelHuella.add(cataDedos);

			//boton para dar de alta la huella
			altaHuella = new JButton("Guardar Huella");
			altaHuella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new OperacionLector().onSave();
					new OperacionLector().enroller.clear();
					JOptionPane.showMessageDialog(null, "La huella ha sido registrada correctamente.");
 			        imagenHuella.setIcon(null);
 			        altaHuella.setEnabled(false);
 			        panelHuella.setVisible(false);
 			        btnAltaHuella.setEnabled(true);
 			       consultaHuella.setEnabled(true);
 			      new OperacionLector().detieneLector();
				}
			});
			altaHuella.setEnabled(false);
			
			//huella
			imagenHuella = new JLabel();
			Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
			imagenHuella.setBorder(border);
			imagenHuella.setPreferredSize(new java.awt.Dimension(250, 250));
			
			panelHuella.add(altaHuella);
			panelHuella.add(imagenHuella);
			getContentPane().add(panelHuella, BorderLayout.CENTER);
    }


	/**
     * Metodo main
     * @param args recibe valores
     */
    public static void main(String[] args)
    {
    	//Carga del frame
        frame = new JFrame("TATEI - Reclutamiento y Enrolamiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setBounds(100, 100, 1224, 768);
		frame.setLocationRelativeTo(null);
	    frame.getContentPane().setLayout(null);
        frame.setResizable(false);

      //se agrega un label
        label = new JLabel("Usuario");
        label.setFont(new Font("Courier New", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        label.setSize(300, 30);
        label.setLocation(10, 280);
        frame.getContentPane().add(label);
        frame.setPreferredSize(new Dimension(700, 550));

      //se agrega el primer input
        campoUsuario = new JTextField(10);
        //create new Font
        Font font = new Font("Courier New", Font.BOLD,15);
        campoUsuario.setFont(font);
        campoUsuario.setBounds(10, 305, 200, 35);
        frame.getContentPane().add(campoUsuario);

        //se agrega un segundo Label
        final JLabel psswd = new JLabel("Contraseña");
        psswd.setFont(new Font("Courier New", Font.BOLD, 18));
        psswd.setForeground(Color.BLACK);
        psswd.setSize(300, 30);
        psswd.setLocation(10, 370);
        frame.getContentPane().add(psswd);

        //se agrega el segundo input
        campoContrasena = new JPasswordField(15);
        campoContrasena.setBounds(10, 395, 200, 35);
        frame.getContentPane().add(campoContrasena);

        //label del nombre
        lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(530, 3, 420, 10);
		lblNombre.setBackground(null);
		lblNombre.setVisible(false);
		frame.getContentPane().add(lblNombre);

        //Se agrega boton personalizado
       login = new JButton("Iniciar Sesión");
       login.setBounds(35, 445, 150, 35);

        //Accion de boton login
        login.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		//se ponen los parametros
        		String usuario = campoUsuario.getText();
        		String pass = campoContrasena.getText();
        		//url para consumir WS
        		String url = "http://localhost:8080/CuadrillasWS/service/loginUsuario/user?usuario=" + usuario + "&password=" + pass;
        		String output  = new ObtieneUrl().getUrlContents(url);
        	    try {
        	    	
        			JSONObject jsonObject = new ManejaJSON().recibeJSON(output);
        			System.out.println(jsonObject);
        			
        			//Desglosando json
        			JSONObject arrayUsuario = (JSONObject) jsonObject.get("header");
        			JSONObject datosUsuario = (JSONObject) jsonObject.get("usuario");
        			
    				Boolean estatus = (boolean) arrayUsuario.get("estatus");
    				String msg = (String) arrayUsuario.get("mensajeFuncional");
    				
    				if (usuario.equals("") && pass.equals("")) {
            			JOptionPane.showMessageDialog(null, "Usuario y /o Contraseña Obligatorios", "Error Sesión", JOptionPane.ERROR_MESSAGE);
            		} else if (estatus.equals(false)) {
        				JOptionPane.showMessageDialog(null, msg, "Error Sesión", JOptionPane.ERROR_MESSAGE);
        			} else if (estatus.equals(true)) {
        				//Se manda datos a la nueva pantalla
        				String nombreUser = (String) datosUsuario.get("nombre")
        						+ " " + datosUsuario.get("apellidoPat") + " " + datosUsuario.get("apellidoMat");
        				String perfil = (String) datosUsuario.get("nombrePerfil");
        				//System.out.println(nombreUser);
        				lblNombre.setText(lblNombre.getText() + nombreUser + "                    Perfil: " + perfil);
        				//JOptionPane.showMessageDialog(null, msg);
        				lblNombre.setBackground(null);
                		lblNombre.setVisible(true);
                		imagen.setVisible(false);
                		menuBar.setVisible(false);
                		campoUsuario.setVisible(false);
                		campoContrasena.setVisible(false);
                		login.setVisible(false);
                		label.setVisible(false);
                		psswd.setVisible(false);

                		//se muestra menuHuella applet
               		 	frame.pack();
                		final JApplet applet = new PanelCaptura();
                		applet.init();
                		frame.getContentPane().add( applet );
                		frame.setSize(1164, 698);
                		frame.setResizable(false);
                		frame.repaint();
                		applet.start();
        			}
        	    } catch (Exception ex) {
        	    ex.printStackTrace();
        	    }
        	}
        });
        //login.setPreferredSize(new Dimension(5, 5));
        frame.getContentPane().add(login);
        

        
        //barra de menu
        menuBar = new JLabel();
        ImageIcon bar = new ImageIcon(PanelCaptura.class.getResource("banner_tatei.png"));
        menuBar.setBounds(0, 0, 250, 550);
        menuBar.setIcon(bar);
        frame.getContentPane().add(menuBar);

        //imagen de fondo
        imagen = new JLabel();
        ImageIcon img = new ImageIcon(PanelCaptura.class.getResource("back_Home_login.jpg"));
        imagen.setBounds(0, 0, 700, 550);
        imagen.setIcon(img);
        frame.getContentPane().add(imagen);
        frame.pack();
        frame.setVisible( true );
    }
    
  //-----------------------------------------------------------------------------------------------------------------------------------------
    //-----------------------------------------------------------------------------------------------------------------------------------------
  	
 /* iniciar desktop huellas*/
  	@Override
    public void init()
    {
        try
        {
            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    createGUI();
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("createGUI didn't successfully complete: " + e);
        }
    }
  	
}