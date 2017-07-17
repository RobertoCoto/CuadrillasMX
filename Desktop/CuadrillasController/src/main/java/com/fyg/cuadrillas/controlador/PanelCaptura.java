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
import java.util.Date;
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
		private JLabel imagenHuella;
		/** label consulta huella*/
		JButton consultaHuella;
		/**
		 * panel de la tabla empleados
		 */
		private JPanel panelEmpleados;
		/**
		 * tabla empleados
		 */
		private JTable tablaEmpleados;
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
			        		String output  = getUrlContents(url);
			        		try {
			        			JSONParser parser = new JSONParser();
			        			Object obj = parser.parse(output);
			        			JSONObject jsonObject = (JSONObject) obj;
			        			JSONArray arrayEmpleado = (JSONArray) jsonObject.get("empleado");
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
			btnAltaHuella = new JButton("   Alta   ");
			btnAltaHuella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//*************** se activa panel de huella**************************/
					panelHuella.setVisible(true);
					inicioLector();
					inicializadorHuellas();
					btnAltaHuella.setEnabled(false);
					consultaHuella.setEnabled(false);
					try {
						  //si este ya tiene datos
						  cataMano.removeAllItems();
						  cataDedos.removeAllItems();
			        	  //Llenando combo
				    		String direccion =
				    				"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
				    		String salida  = getUrlContents(direccion);
				    		JSONParser parser = new JSONParser();
			    			Object obj = parser.parse(salida);
			    			JSONObject jsonCatalogoMano = (JSONObject) obj;
			    			JSONArray arrayCatalogoMano = (JSONArray) jsonCatalogoMano.get("catalogo");

			    			for (int j = 0; j < arrayCatalogoMano.size(); j++) {
			    				JSONObject mano = (JSONObject) arrayCatalogoMano.get(j);
			    				String descripcion = (String) mano.get("descripcion");
			    				cataMano.addItem(descripcion);
			    			}
			    			String direccionConsulta =
			    					"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
				    		String salidaCatalogo  = getUrlContents(direccionConsulta);
				    		JSONParser parseo = new JSONParser();
			    			Object objCatalogo = parseo.parse(salidaCatalogo);
			    			JSONObject jsonCatalogoDedo = (JSONObject) objCatalogo;
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
			consultaHuella = new JButton("Consulta");
			consultaHuella.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 //******************** panel de consulta huella**********************/
					consulta = new JPanel();
					consulta.setBorder(new TitledBorder(null,
							"Consultar Huella", TitledBorder.LEADING, TitledBorder.TOP, null, null));
                    
					//combo de la mano
					catalogoManoConsulta = new JComboBox();
					consulta.add(catalogoManoConsulta);

					//combo de los dedos
					catalogoDedosConsulta = new JComboBox();
					consulta.add(catalogoDedosConsulta);
					
					//consulta.setLayout(new SpringLayout()); 
					imagenHuellaD = new JLabel();
					Border borderD = BorderFactory.createLineBorder(Color.BLUE, 2);
					imagenHuellaD.setBorder(borderD);
					imagenHuellaD.setPreferredSize(new java.awt.Dimension(270, 270));
					imagenHuellaD.setLocation(700, 60);
					btnAltaHuella.setEnabled(false);
					consultaHuella.setEnabled(false);
					inicioLector();
		//************************* llenado de catalogo****************************//
					try {
						//si este ya tiene datos
						catalogoManoConsulta.removeAllItems();
						catalogoDedosConsulta.removeAllItems();
			        	  //Llenando combo
				    		String direccion =
				    				"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
				    		String salida  = getUrlContents(direccion);
				    		JSONParser parser = new JSONParser();
			    			Object obj = parser.parse(salida);
			    			JSONObject jsonCatalogoMano = (JSONObject) obj;
			    			JSONArray arrayCatalogoMano = (JSONArray) jsonCatalogoMano.get("catalogo");

			    			for (int j = 0; j < arrayCatalogoMano.size(); j++) {
			    				JSONObject mano = (JSONObject) arrayCatalogoMano.get(j);
			    				String descripcion = (String) mano.get("descripcion");
			    				catalogoManoConsulta.addItem(descripcion);
			    			}
			    			String direccionConsulta =
			    					"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
				    		String salidaCatalogo  = getUrlContents(direccionConsulta);
				    		JSONParser parseo = new JSONParser();
			    			Object objCatalogo = parseo.parse(salidaCatalogo);
			    			JSONObject jsonCatalogoDedo = (JSONObject) objCatalogo;
			    			JSONArray arrayCatalogoDedo = (JSONArray) jsonCatalogoDedo.get("catalogo");

			    			for	(int k = 0; k < arrayCatalogoDedo.size(); k++) {
			    				JSONObject dedo = (JSONObject) arrayCatalogoDedo.get(k);
			    				String descripcionDedo = (String) dedo.get("descripcion");
			    				catalogoDedosConsulta.addItem(descripcionDedo);
			    			}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					
					verificar = new JButton("Carga Template");
					verificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								cargaTemplate();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					
					btnVerificar = new JButton("Verifica Huella");
					btnVerificar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try {
								comparaHuellas();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
					btnVerificar.setEnabled(false);
					consulta.add(verificar);
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
					onSave();
					enroller.clear();
					JOptionPane.showMessageDialog(null, "La huella ha sido registrada correctamente.");
 			        imagenHuella.setIcon(null);
 			        altaHuella.setEnabled(false);
 			        panelHuella.setVisible(false);
 			        btnAltaHuella.setEnabled(true);
 			       consultaHuella.setEnabled(true);
 			       detieneLector();
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
        		String url = "http://localhost:8080/CuadrillasWS/service/loginUsuario/user?usuario="
        		+ usuario + "&password=" + pass;
        		String output  = getUrlContents(url);
        	    try {
        	    	JSONParser parser = new JSONParser();
        			Object obj = parser.parse(output);
        			JSONObject jsonObject = (JSONObject) obj;
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
  	/**
  	 * Consume WS con los parametros enviados
  	 * @param theUrl obtiene la url
  	 * @return regresa los datos
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
  	    catch (Exception e)
  	    {
  	      e.printStackTrace();
  	    }
  	    return content.toString();
    
  	  }
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
  	
  	
/*****************Inicio del lector********************/
  	
  	/** Inicializa el lector*/
  	private DPFPCapture capturer = DPFPGlobal.getCaptureFactory().createCapture();
  	
  	//inicializa el enrolamiento
    private DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    
    private DPFPVerification verificator = DPFPGlobal.getVerificationFactory().createVerification();
    /**
	 * metodo que crea las caracteristicas de la huella
	 */
	public DPFPFeatureSet featuresinscripcion;
	
    /**
     * template a almacenar
     */
  	public static String TEMPLATE_PROPERTY = "template";
  	/**
  	 * template
  	 */
	private DPFPTemplate template;
	DPFPTemplate t = DPFPGlobal.getTemplateFactory().createTemplate();
	//indica cuando el lector este activado
  	public void inicioLector()
	{
		capturer.startCapture();
		System.out.println("Lector Activado, Puede utilizar el lector de huellas.");
	}
  	//detiene el proceso de captura
  	public void detieneLector()
	{
		capturer.stopCapture();
		System.out.println("Lector de huellas desactivado.");
	}
  	/**
	  * comprueba el estado de las huellas
	  */
	public  void estadoHuellas() {
		System.out.println("Numero de Muestras para capturar: " + enroller.getFeaturesNeeded());
	}
	
  	//procesa la huella que se captura
  	protected void procesaHuella(DPFPSample sample)
	{
  	// Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
  	featuresinscripcion = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
  		
		
		if (featuresinscripcion != null) {
			try {
				System.out.println("Las Caracteristicas de la Huella han sido creada");
				enroller.addFeatures(featuresinscripcion);
				
				// Draw fingerprint sample image.
				drawPicture(convertSampleToBitmap(sample));
				
			} catch(Exception ex) {
			}
			 finally {
				    estadoHuellas();
		     }
			switch(enroller.getTemplateStatus())
		       {
		           case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
		        	   detieneLector();
		           setTemplate(enroller.getTemplate());
		           JOptionPane.showMessageDialog(null, "La operación ha sido completada.");
			    altaHuella.setEnabled(true);
		           break;

			    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
			    enroller.clear();
			    detieneLector();
			    estadoHuellas();
			    setTemplate(null);
			    JOptionPane.showMessageDialog(null,
			    		"El dedo no Coincide o a cambiado el dedo/ no se creo la huella, Repita el Proceso",
						   "Advertencia", JOptionPane.WARNING_MESSAGE);
			    inicioLector();
			    break;
			}
		}
	}
  	//pinta la imagen en nuestro template
  	public void drawPicture(Image image) {
  		imagenHuella.setIcon(new ImageIcon(
			image.getScaledInstance(imagenHuella.getWidth(), imagenHuella.getHeight(), Image.SCALE_DEFAULT)));
	}
  //pinta la imagen en nuestro template
  	public void dibujaHuella(Image image) {
  		imagenHuellaD.setIcon(new ImageIcon(
			image.getScaledInstance(imagenHuellaD.getWidth(), imagenHuellaD.getHeight(), Image.SCALE_DEFAULT)));
	}
	// convierte la imagen en mapa de bits
	protected Image convertSampleToBitmap(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}
	
	//extrae las caracteristicas de la huella
  	protected DPFPFeatureSet extractFeatures(DPFPSample sample, DPFPDataPurpose purpose)
	{
		DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}
  	
  	//inicializa la captura de huella
  	protected void inicializadorHuellas()
	{
		capturer.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					
					JOptionPane.showMessageDialog(null,"La huella digital ha sido capturada.");
					procesaHuella(e.getSample());
				}});
			}
		});
		capturer.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
		 			System.out.println("The fingerprint reader was connected.");
				}});
			}
			@Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					System.out.println("The fingerprint reader was disconnected.");
				}});
			}
		});
		capturer.addSensorListener(new DPFPSensorAdapter() {
			@Override public void fingerTouched(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					System.out.println("The fingerprint reader was touched.");
				}});
			}
			@Override public void fingerGone(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					System.out.println("The finger was removed from the fingerprint reader.");
				}});
			}
		});
		capturer.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					if (e.getFeedback().equals(DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
						System.out.println("The quality of the fingerprint sample is good.");
					else
						System.out.println("The quality of the fingerprint sample is poor.");
				}});
			}
		});
	}
  	//crea un filtro para guardar el archivo
  	public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {
		@Override public boolean accept(File f) {
			return f.getName().endsWith(".fpt");
		}
		@Override public String getDescription() {
			return "Fingerprint Template File (*.fpt)";
		}
	}
  	//obtiene el template 
  	public DPFPTemplate getTemplate() {
		return template;
	}
  	//setea el template
	public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		firePropertyChange(TEMPLATE_PROPERTY, old, template);
	}
	
	//guarda el template en un fichero
	private void onSave() {
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(new TemplateFileFilter());
		while (true) {
			String consulta = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
    		String result  = getUrlContents(consulta);
    		String codigoMano = null;
    		String codigoDedo = null;
    		
   			Integer idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());
			try {
				JSONParser parser = new JSONParser();
    			Object obj = parser.parse(result);
    			JSONObject jsonCatalogoManoWS = (JSONObject) obj;
    			JSONArray arrayCatalogoManoWS = (JSONArray) jsonCatalogoManoWS.get("catalogo");
    			
				for (int j = 0; j < arrayCatalogoManoWS.size(); j++) {
    				JSONObject manoWS = (JSONObject) arrayCatalogoManoWS.get(j);
    				String descripcionWS = (String) manoWS.get("descripcion");
    				if (descripcionWS.equals(cataMano.getSelectedItem())) {
    					codigoMano = (String) manoWS.get("codigo");
    					System.out.println("Seleccion Mano Codigo: " + codigoMano);
    				}
    			}
				String direccionConsultaWS =
						"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
	    		String salidaCatalogoWS  = getUrlContents(direccionConsultaWS);
	    		JSONParser parseoWS = new JSONParser();
    			Object objCatalogoWS = parseoWS.parse(salidaCatalogoWS);
    			JSONObject jsonCatalogoDedoWS = (JSONObject) objCatalogoWS;
    			JSONArray arrayCatalogoDedoWS = (JSONArray) jsonCatalogoDedoWS.get("catalogo");
    			
    			for	(int k = 0; k < arrayCatalogoDedoWS.size(); k++) {
    				JSONObject dedoWS = (JSONObject) arrayCatalogoDedoWS.get(k);
    				String descripcionDedoWS = (String) dedoWS.get("descripcion");

    				if (descripcionDedoWS.equals(cataDedos.getSelectedItem())) {
    					codigoDedo = (String) dedoWS.get("codigo");
    					System.out.println("Seleccion Dedo: " + codigoDedo);
    				}
    			}
			} catch(Exception f) {
				
			}
			
			//guarda huella
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					File file = chooser.getSelectedFile();
					if (!file.toString().toLowerCase().endsWith(".fpt"))
						file = new File( file.toString() + ".fpt");
					if (file.exists()) {
						int choice = JOptionPane.showConfirmDialog(this,
							String.format("File \"%1$s\" already exists.\nDo you want to replace it?", file.toString()),
							"Fingerprint saving", 
							JOptionPane.YES_NO_CANCEL_OPTION);
						if (choice == JOptionPane.NO_OPTION)
							continue;
						else if (choice == JOptionPane.CANCEL_OPTION)
							break;
					}
					FileOutputStream stream = new FileOutputStream(file);
					stream.write(getTemplate().serialize());
					stream.close();
					
					URL rut = file.toURI().toURL();
					String ruta = rut.toString();
					String registraHuella = "http://localhost:8080/CuadrillasWS/service/registraHuella/huella?idEmpleado=" + idEmpleado
	    					+ "&codigoMano=" + codigoMano + "&codigoDedo=" + codigoDedo + "&ruta=" + ruta;
		    		String resultHuella  = getUrlContents(registraHuella);
		    		System.out.println(resultHuella);
				
					
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Fingerprint saving", JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
		}
	}
	
	public void cargaTemplate() {
		String consulta = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
   		String resul  = getUrlContents(consulta);
   	    try {
   	    	JSONParser parser = new JSONParser();
   			Object obj = parser.parse(resul);
   			JSONObject jsonCatalogoManoWS = (JSONObject) obj;
   			JSONArray arrayCatalogoManoWS = (JSONArray) jsonCatalogoManoWS.get("catalogo");
   			String codigoMano = null;
				for (int j = 0; j < arrayCatalogoManoWS.size(); j++) {
   				JSONObject manoWS = (JSONObject) arrayCatalogoManoWS.get(j);
   				String descripcionWS = (String) manoWS.get("descripcion");
   				if (descripcionWS.equals(catalogoManoConsulta.getSelectedItem())) {
   					codigoMano = (String) manoWS.get("codigo");
   					System.out.println("Seleccion Mano Codigo: " + codigoMano);
   				}
   			}
				String direccionConsultaWS =
						"http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
	    		String salidaCatalogoWS  = getUrlContents(direccionConsultaWS);
	    		JSONParser parseoWS = new JSONParser();
   			Object objCatalogoWS = parseoWS.parse(salidaCatalogoWS);
   			JSONObject jsonCatalogoDedoWS = (JSONObject) objCatalogoWS;
   			JSONArray arrayCatalogoDedoWS = (JSONArray) jsonCatalogoDedoWS.get("catalogo");
   			String codigoDedo = null;
   			for	(int k = 0; k < arrayCatalogoDedoWS.size(); k++) {
   				JSONObject dedoWS = (JSONObject) arrayCatalogoDedoWS.get(k);
   				String descripcionDedoWS = (String) dedoWS.get("descripcion");

   				if (descripcionDedoWS.equals(catalogoDedosConsulta.getSelectedItem())) {
   					codigoDedo = (String) dedoWS.get("codigo");
   					System.out.println("Seleccion Dedo: " + codigoDedo);
   				}
   			}
   			
   			//para consultar la huella
   			Integer idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());
   			System.out.println("el id empleado es: " + idEmpleado);
   			String consultaHuella = "http://localhost:8080/CuadrillasWS/service/consultaHuella/empleado?idEmpleado=" + idEmpleado 
   					+ "&codigoMano=" + codigoMano + "&codigoDedo=" + codigoDedo;
      		    String salidaHuella  = getUrlContents(consultaHuella);
   			System.out.println(salidaHuella);
   			
   			BufferedImage imgHuella = null;
				JSONParser parseoHuella = new JSONParser();
				Object objHuella = parseoHuella.parse(salidaHuella);
				JSONObject jsonHuella = (JSONObject) objHuella;
				JSONObject arrayHuella = (JSONObject) jsonHuella.get("empleadoHuella");
				
				String rutImagen = (String) arrayHuella.get("huella");
				
				URL url= new URL(rutImagen);
				URI d = url.toURI();
				File rut = new File(d.getSchemeSpecificPart());
				
				FileInputStream stream = new FileInputStream(rut);
				byte[] data = new byte[stream.available()];
				stream.read(data);
				stream.close();
				
				t.deserialize(data);
				setTemplate(t);
				btnVerificar.setEnabled(true);
   			
   	    } catch (Exception ex) {
   	    	
   	    }
	}
	
	protected void comparaHuellas() {
		capturer.addDataListener(new DPFPDataAdapter() {
			@Override public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {	public void run() {
					
					JOptionPane.showMessageDialog(null,"La huella digital ha sido capturada.");
					verificaHuella(e.getSample());
				}});
			}
		});
	}
	
	public void verificaHuella(DPFPSample sample) {
		// Process the sample and create a feature set for the enrollment purpose.
				DPFPFeatureSet features = extractFeatures(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
				// Check quality of the sample and start verification if it's good
				dibujaHuella(convertSampleToBitmap(sample));
				String nombreEmpleado = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 2).toString();
				String appP = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 3).toString();
				if (features != null)
				{
					// Compare the feature set with our template
					DPFPVerificationResult result = 
						verificator.verify(features, getTemplate());
					
					if (result.isVerified()) {
						JOptionPane.showMessageDialog(null,"Se ha verificado su identidad: " + nombreEmpleado + " " + appP );
						btnAltaHuella.setEnabled(true);
						consultaHuella.setEnabled(true);
						imagenHuellaD.setIcon(null);
						consulta.setVisible(false);
					    detieneLector();
					}
					else
						JOptionPane.showMessageDialog(null,"La huella es incorrecta, revise por favor.");
				}
	}
  	
}