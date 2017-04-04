package com.fyg.cuadrillas.controlador;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Dimension;
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

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

public class PanelCaptura extends JApplet
{
	/**
	 * Metodo publico
	 */
	public PanelCaptura() {
	}
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
	/**
	 * panel de la tabla empleados
	 */
	private JPanel panelEmpleados;
	/**
	 * tabla empleados
	 */
	private JTable tablaEmpleados;
	/**
     * Create the GUI. For thread safety, this method should
     * be invoked from the event-dispatching thread.
     */
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
		));
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

		//panel de los botones
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBotones.setVisible(false);
		panelBotones.setPreferredSize(new java.awt.Dimension(140, 270));
		getContentPane().add(panelBotones, BorderLayout.EAST);

		JButton btnAltaHuella = new JButton("Alta Huella");
		btnAltaHuella.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				panelHuella.setVisible(true);
				if (consulta == null) {
					System.out.println("no esta activo");
				} else if (consulta.isVisible()) {
					consulta.setVisible(false);
				}
				try {
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

		//boton de consultar huella
		consultaHuella = new JButton("Consultar Huella");
		consultaHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//panel de la consulta
				consulta = new JPanel();
				consulta.setBorder(new TitledBorder(null,
						"Consultar Huella", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				consulta.setVisible(true);
				imagenHuellaD = new JLabel();
				Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
				imagenHuellaD.setBorder(border);
				imagenHuellaD.setPreferredSize(new java.awt.Dimension(250, 250));
				JButton verificar = new JButton("Verifica Huella");
				verificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							identificarHuella();
							Reclutador.clear();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
				consulta.add(imagenHuellaD);
				consulta.add(verificar);
				getContentPane().add(consulta, BorderLayout.CENTER);
				panelHuella.setVisible(false);
			    imagenHuellaD.setIcon(null);
			       //start();
			}
		});
		panelBotones.add(consultaHuella);

		//panel de la huella
		panelHuella = new JPanel();
		panelHuella.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHuella.setVisible(false);

		//combo de la mano
		cataMano = new JComboBox();
		panelHuella.add(cataMano);

		//combo de los dedos
		cataDedos = new JComboBox();
		panelHuella.add(cataDedos);

		//boton para dar de alta la huella
		altaHuella = new JButton("Guardar Huella");
		altaHuella.setEnabled(false);
		altaHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String consulta = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
	    		String result  = getUrlContents(consulta);
    			try {
    				JSONParser parser = new JSONParser();
        			Object obj = parser.parse(result);
        			JSONObject jsonCatalogoManoWS = (JSONObject) obj;
        			JSONArray arrayCatalogoManoWS = (JSONArray) jsonCatalogoManoWS.get("catalogo");
        			String codigoMano = null;
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
	    			String codigoDedo = null;
	    			for	(int k = 0; k < arrayCatalogoDedoWS.size(); k++) {
	    				JSONObject dedoWS = (JSONObject) arrayCatalogoDedoWS.get(k);
	    				String descripcionDedoWS = (String) dedoWS.get("descripcion");

	    				if (descripcionDedoWS.equals(cataDedos.getSelectedItem())) {
	    					codigoDedo = (String) dedoWS.get("codigo");
	    					System.out.println("Seleccion Dedo: " + codigoDedo);
	    				}
	    			}

	    			if (imagenHuella.getIcon() == null) {
	    				JOptionPane.showMessageDialog(null,
	    						"Es necesario capturar la huella", "Error Captura", JOptionPane.ERROR_MESSAGE);
	    			}
	    			Date fecha = new Date();
	    			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    			String fechaImagen = dateFormat.format(fecha);
	    			ImageIcon imagenH = (ImageIcon) imagenHuella.getIcon();
	    			BufferedImage image = new BufferedImage(imagenH.getIconWidth(),
	    					imagenH.getIconHeight(), BufferedImage.TYPE_INT_RGB);
	    			Graphics2D g2 = image.createGraphics();
	    			g2.drawImage(imagenH.getImage(), 0, 0, imagenH.getImageObserver());
	    			g2.dispose();
	    			Integer idEmp = Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString()); 
	    			File imagenRuta = new File("C:\\Huella\\" + fechaImagen +"_id_"+ idEmp + codigoDedo +".jpg");
	    			ImageIO.write(image, "jpg", imagenRuta);
	    			String ruta = fechaImagen +"_id_"+ idEmp + codigoDedo +".jpg";
	    			String registraHuella = "http://localhost:8080/CuadrillasWS/service/registraHuella/huella?idEmpleado="+idEmp
	    					+"&codigoMano="+codigoMano+"&codigoDedo="+codigoDedo+"&ruta="+ruta;
		    		String resultHuella  = getUrlContents(registraHuella);
		    		System.out.println(resultHuella);
		    		JSONParser p = new JSONParser();
	    			Object phuella = p.parse(resultHuella);
	    			JSONObject jsonResult = (JSONObject) phuella;
	    			Boolean estatus = (Boolean) jsonResult.get("estatus");
	    			String mensajeFuncional = (String) jsonResult.get("mensaje funcional");
	    			if (estatus.equals(false)) {
	    				JOptionPane.showMessageDialog(null, mensajeFuncional, "Error registro huella", JOptionPane.ERROR_MESSAGE);
	    			} else {
	    				JOptionPane.showMessageDialog(null, "La huella ha sido registrada correctamente.");
	    				   Reclutador.clear();
	    			       imagenHuella.setIcon(null);
	    			       altaHuella.setEnabled(false);
	    			       start();
	    			}
    			} catch (Exception x) {
    				x.printStackTrace();
    			}
			}
		});
		panelHuella.add(altaHuella);
		getContentPane().add(panelHuella,BorderLayout.CENTER);
		
		imagenHuella = new JLabel();
		Border border = BorderFactory.createLineBorder(Color.BLUE, 2);
		imagenHuella.setBorder(border);
		imagenHuella.setPreferredSize(new java.awt.Dimension(250, 250));
		panelHuella.add(imagenHuella);
		//Acciones de las filas
		
		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            
	            panelBotones.setVisible(true);
	            panelHuella.setVisible(false);
	            cataMano.removeAllItems();
	            cataDedos.removeAllItems();
	        }
	    });
		

    }

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
                    Iniciar();
                    //start();
                    EstadoHuellas();
                }
            });
        }
        catch (Exception e)
        {
            System.err.println("createGUI didn't successfully complete: " + e);
        }
    }

    public static void main(String[] args)
    {
        
 
        frame = new JFrame("TATEI - Reclutamiento y Enrolamiento");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setBounds(100, 100, 1124, 668);
		 frame.setLocationRelativeTo( null );
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
        
        lblNombre = new JLabel("Nombre: ");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNombre.setBounds(160, 15, 450, 30);
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
        		//
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
    				if (estatus.equals(false)) {
        				JOptionPane.showMessageDialog(null, msg, "Error Sesión", JOptionPane.ERROR_MESSAGE);
        			} else if(estatus.equals(true)) {
        				//Se manda datos a la nueva pantalla
        				String nombreUser = (String) datosUsuario.get("nombre")
        						+ " " + datosUsuario.get("apellidoPat") + " " + datosUsuario.get("apellidoMat");
        				String perfil = (String) datosUsuario.get("nombrePerfil");
        				//System.out.println(nombreUser);
        				lblNombre.setText(lblNombre.getText()+ nombreUser + " Perfil: " + perfil);
        				//JOptionPane.showMessageDialog(null, msg);
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
        
        menuBar = new JLabel();
        ImageIcon bar = new ImageIcon(PanelCaptura.class.getResource("/resources/banner_tatei.png"));
        menuBar.setBounds(0,0,250,550);//posicion (x,y,ancho,largo)
        menuBar.setIcon(bar);
        frame.getContentPane().add(menuBar);
        
        imagen = new JLabel();
        ImageIcon img = new ImageIcon(PanelCaptura.class.getResource("/resources/back_Home_login.jpg"));
        imagen.setBounds(0,0,700,550);//posicion (x,y,ancho,largo)
        imagen.setIcon(img);
        frame.getContentPane().add(imagen);
        
        
        frame.pack();
        frame.setVisible( true );
  
        
    }

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
	//Varible que permite iniciar el dispositivo de lector de huella conectado
	//con sus distintos metodos.
	private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

	//Varible que permite establecer las capturas de la huellas, para determina sus caracteristicas
	//y poder estimar la creacion de un template de la huella para luego poder guardarla
	private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

	//Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
	//o verificarla con alguna guardada en la BD
	private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

	//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
	//necesarias de la huella si no ha ocurrido ningun problema
	private DPFPTemplate template;
	public static String TEMPLATE_PROPERTY = "template";

	protected void Iniciar(){
	  Lector.addDataListener(new DPFPDataAdapter() {
	   @Override public void dataAcquired(final DPFPDataEvent e) {
	   SwingUtilities.invokeLater(new Runnable() {	public void run() {
	   System.out.println("La Huella Digital ha sido Capturada");
	   ProcesarCaptura(e.getSample());
	   }});}
	  });

	  Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
	   @Override public void readerConnected(final DPFPReaderStatusEvent e) {
	   SwingUtilities.invokeLater(new Runnable() {	public void run() {
		   System.out.println("El Sensor de Huella Digital esta Activado o Conectado");
	   }});}
	   @Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
	   SwingUtilities.invokeLater(new Runnable() {	public void run() {
		   JOptionPane.showMessageDialog(null,"El Sensor de Huella Digital esta Desactivado o no Conectado",
				   "Advertencia", JOptionPane.WARNING_MESSAGE);
	   }});}
	  });

	  Lector.addSensorListener(new DPFPSensorAdapter() {
	   @Override public void fingerTouched(final DPFPSensorEvent e) {
	   SwingUtilities.invokeLater(new Runnable() {	public void run() {
		   System.out.println("El dedo ha sido colocado sobre el Lector de Huella");
	   }});}
	   @Override public void fingerGone(final DPFPSensorEvent e) {
	   SwingUtilities.invokeLater(new Runnable() {	public void run() {
		   System.out.println("El dedo ha sido quitado del Lector de Huella");
	   }});}
	  });

	  Lector.addErrorListener(new DPFPErrorAdapter(){
	   public void errorReader(final DPFPErrorEvent e){
	   SwingUtilities.invokeLater(new Runnable() {  public void run() {
		   System.out.println("Error: "+e.getError());
	   }});}
	  });
	}

	public DPFPFeatureSet featuresinscripcion;
	public DPFPFeatureSet featuresverificacion;

	public  void ProcesarCaptura(DPFPSample sample)
	{
	// Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
	featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

	// Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
	featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

	// Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
	if (featuresinscripcion != null)
	    try{
	    System.out.println("Las Caracteristicas de la Huella han sido creada");
	    Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

	    // Dibuja la huella dactilar capturada.
	    Image image=CrearImagenHuella(sample);
	    DibujarHuella(image);
	    
	    
	    //btnIdentificar.setEnabled(true);

	    }catch (DPFPImageQualityException ex) {
	    System.err.println("Error: "+ex.getMessage());
	    }

	    finally {
	    EstadoHuellas();
	    // Comprueba si la plantilla se ha creado.
		switch(Reclutador.getTemplateStatus())
	       {
	           case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
		    stop();
	           setTemplate(Reclutador.getTemplate());
	           JOptionPane.showMessageDialog(null,"La operación ha sido completada.");
		    //btnIdentificar.setEnabled(false);
	           //btnVerificar.setEnabled(false);
	           /*btnGuardar.setEnabled(true);
	           btnGuardar.grabFocus();*/
		    altaHuella.setEnabled(true);
	           break;

		    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
		    Reclutador.clear();
	           stop();
		    EstadoHuellas();
		    setTemplate(null);
		    JOptionPane.showMessageDialog(null,"El dedo no Coincide o a cambiado el dedo/ no se creo la huella, Repita el Proceso",
					   "Advertencia", JOptionPane.WARNING_MESSAGE);
		    //start();
		    break;
		}
		     }
	}

	public  DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose){
	    DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
	    try {
	     return extractor.createFeatureSet(sample, purpose);
	    } catch (DPFPImageQualityException e) {
	     return null;
	    }
	}

	 public  Image CrearImagenHuella(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}

	 public void DibujarHuella(Image image) {
		 imagenHuella.setIcon(new ImageIcon(
	       image.getScaledInstance(imagenHuella.getWidth(), imagenHuella.getHeight(), Image.SCALE_DEFAULT)));
		 
		 imagenHuellaD.setIcon(new ImageIcon(
			       image.getScaledInstance(imagenHuellaD.getWidth(), imagenHuellaD.getHeight(), Image.SCALE_DEFAULT)));
	       repaint();
	}

	public  void EstadoHuellas(){
		System.out.println("Numero de Muestras para capturar: "+ Reclutador.getFeaturesNeeded());
	}

	public void EnviarTexto(String string) {
	       //txtArea.append(string + "\n");
	}

	public  void start(){
		Lector.startCapture();
		System.out.println("Utilizando el Lector de Huella Dactilar ");
	}

	public  void stop(){
	       Lector.stopCapture();
	       System.out.println("No se está usando el Lector de Huella Dactilar ");
	}

	   public DPFPTemplate getTemplate() {
	       return template;
	   }

	   public void setTemplate(DPFPTemplate template) {
	       DPFPTemplate old = this.template;
		this.template = template;
		firePropertyChange(TEMPLATE_PROPERTY, old, template);
	   }
	   public void identificarHuella() throws IOException{
		 //para consultar la huella
			Integer idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());
			System.out.println("el id empleado es: "+ idEmpleado);
			String consultaHuella = "http://localhost:8080/CuadrillasWS/service/consultaHuella/empleado?idEmpleado="+idEmpleado;
   		String salidaHuella  = getUrlContents(consultaHuella);
			System.out.println(salidaHuella);
			
			try {
				BufferedImage imgHuella=null;
				JSONParser parseoHuella = new JSONParser();
				Object objHuella = parseoHuella.parse(salidaHuella);
				JSONObject jsonHuella = (JSONObject) objHuella;
				JSONArray arrayHuella = (JSONArray) jsonHuella.get("empleadoHuella");
   			
   			for(int j=0; j < arrayHuella.size(); j++) {
   				JSONObject huellaEmpleado = (JSONObject) arrayHuella.get(j);
   				String rutImagen = (String) huellaEmpleado.get("huella");
   				File imagenRuta = new File("C:\\Huella\\" + rutImagen);
   				imgHuella = ImageIO.read(imagenRuta);
   				
   				ByteArrayOutputStream baos = new ByteArrayOutputStream();
   				ImageIO.write( imgHuella, "jpg", baos );
   				baos.flush();
   				byte templateBuffer[] = baos.toByteArray();
   			//Crea una nueva plantilla a partir de la guardada en la base de datos
   		       DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
   		       //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
   		       setTemplate(referenceTemplate);

   		       // Compara las caracteriticas de la huella recientemente capturda con la
   		       // alguna plantilla guardada en la base de datos que coincide con ese tipo
   		       DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());
   				 if (result.isVerified()){
   				      //crea la imagen de los datos guardado de las huellas guardadas en la base de datos
   				      JOptionPane.showMessageDialog(null, "Las huella capturada es de ","Verificacion de Huella", JOptionPane.INFORMATION_MESSAGE);
   				      return;
   				                              }
   				      }
   				      //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
   				      JOptionPane.showMessageDialog(null, "No existe ningún registro que coincida con la huella", "Verificacion de Huella", JOptionPane.ERROR_MESSAGE);
   				      setTemplate(null);
   			}
		 catch(Exception ex) {
				
			}
	   }
	byte datosHuella1[] = null;
	private JLabel imagenHuella;
	private JButton consultaHuella;
}
