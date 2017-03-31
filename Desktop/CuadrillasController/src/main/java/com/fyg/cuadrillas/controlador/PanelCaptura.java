package com.fyg.cuadrillas.controlador;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

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

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PanelCaptura extends JApplet
{
	public PanelCaptura() {
	}
    /**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6586588784320650074L;
	static JTextField campoUsuario;
	static JPasswordField campoContrasena;
	 static JButton login;
	 static JFrame frame;
	 static JLabel imagen;
	 static JLabel label;
	 static JLabel psswd;
	 JButton btnRegistrarHuella;
	 static JLabel menuBar;
	 static JLabel lblNombre;
	 JLabel lblPerfil;
	 JLabel nombreUser;
	 JPanel panelBotones;
	 JPanel panelHuella;
	 JComboBox cataMano;
	 JComboBox cataDedos;
	 JButton altaHuella;
	 JTextArea txtArea;
	 /**
		 * panel principal
		 */
		private JPanel contentPane;
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
        
        JPanel panel = new JPanel();
		panel.setBackground(new Color(138, 43, 226));
		panel.setBorder(new TitledBorder(null, "Menu", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setPreferredSize(new java.awt.Dimension(130, 270));
        getContentPane().add(panel, BorderLayout.WEST);
        
        btnRegistrarHuella = new JButton("Huella");
		btnRegistrarHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Habilitando tabla empleados");
				String url = "http://localhost:8080/CuadrillasWS/service/consultaEmpleado/";
		        		String output  = getUrlContents(url);
		        		try {
		        			JSONParser parser = new JSONParser();
		        			Object obj = parser.parse(output);
		        			JSONObject jsonObject = (JSONObject) obj;
		        			JSONArray arrayEmpleado = (JSONArray) jsonObject.get("empleado");
		        			DefaultTableModel modelo = (DefaultTableModel)tablaEmpleados.getModel();
		        			Object[] filas = new Object[modelo.getColumnCount()];
		        			for (int i = 0; i < arrayEmpleado.size(); i++) {

		        				 JSONObject empleado = (JSONObject) arrayEmpleado.get(i);
		        				 //System.out.println(empleado);
		        				 Long idEmpleado = (Long) empleado.get("idEmpleado");
		        				 String numEmpleado = (String) empleado.get("noEmpleado");
		        				 String nombre= (String) empleado.get("nombre");
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
		panelEmpleados = new JPanel();
		panelEmpleados.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleados.setVisible(false);
		panelEmpleados.setPreferredSize(new java.awt.Dimension(70, 170));
		getContentPane().add(panelEmpleados, BorderLayout.SOUTH);
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
		//new JScrollPane(tablaEmpleados, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		tablaEmpleados.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panelEmpleados.add(header, BorderLayout.NORTH);
		panelEmpleados.add(tablaEmpleados);
		
		
		
		nombreUser = new JLabel("A");
		nombreUser.setPreferredSize(new java.awt.Dimension(130, 270));
		//getContentPane().add(nombreUser,BorderLayout.NORTH);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBotones.setVisible(false);
		getContentPane().add(panelBotones,BorderLayout.EAST);
		
		JButton btnAltaHuella = new JButton("Alta Huella");
		btnAltaHuella.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				panelHuella.setVisible(true);
				try {
		        	  //Llenando combo
			    		String direccion = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
			    		String salida  = getUrlContents(direccion);
			    		JSONParser parser = new JSONParser();
		    			Object obj = parser.parse(salida);
		    			JSONObject jsonCatalogoMano = (JSONObject) obj;
		    			JSONArray arrayCatalogoMano = (JSONArray) jsonCatalogoMano.get("catalogo");
		    			
		    			for (int j=0; j < arrayCatalogoMano.size(); j++) {
		    				JSONObject mano = (JSONObject) arrayCatalogoMano.get(j);
		    				String descripcion = (String) mano.get("descripcion");
		    				cataMano.addItem(descripcion);
		    			}
		    			String direccionConsulta = "http://localhost:8080/CuadrillasWS/service/consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
			    		String salidaCatalogo  = getUrlContents(direccionConsulta);
			    		JSONParser parseo = new JSONParser();
		    			Object objCatalogo = parseo.parse(salidaCatalogo);
		    			JSONObject jsonCatalogoDedo = (JSONObject) objCatalogo;
		    			JSONArray arrayCatalogoDedo = (JSONArray) jsonCatalogoDedo.get("catalogo");
		    			
		    			for	(int k=0; k < arrayCatalogoDedo.size(); k++) {
		    				JSONObject dedo = (JSONObject) arrayCatalogoDedo.get(k);
		    				String descripcionDedo = (String) dedo.get("descripcion");
		    				cataDedos.addItem(descripcionDedo);
		    			}
		          } catch (Exception ex) {
		        	  ex.printStackTrace();
		          }
			}
		});
		panelBotones.add(btnAltaHuella);
		
		panelHuella = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelHuella.getLayout();
		panelHuella.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHuella.setVisible(false);
		
		
		cataMano = new JComboBox();
		panelHuella.add(cataMano);
		
		cataDedos = new JComboBox();
		panelHuella.add(cataDedos);
		
		altaHuella = new JButton("Guardar Huella");
		altaHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelHuella.add(altaHuella);
		getContentPane().add(panelHuella,BorderLayout.CENTER);
		
		imagenHuella = new JLabel();
		imagenHuella.setPreferredSize(new java.awt.Dimension(250, 250));
		panelHuella.add(imagenHuella);
		//Acciones de las filas
		
		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            System.out.println(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());
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
		frame.add(lblNombre);
		
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
		   System.out.println("El Sensor de Huella Digital esta Desactivado o no Conectado");
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
	    
	    //btnVerificar.setEnabled(true);
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
		    EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
		    //btnIdentificar.setEnabled(false);
	           //btnVerificar.setEnabled(false);
	           /*btnGuardar.setEnabled(true);
	           btnGuardar.grabFocus();*/
	           break;

		    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
		    Reclutador.clear();
	           stop();
		    EstadoHuellas();
		    setTemplate(null);
		    System.out.println("La Plantilla de la Huella no pudo ser creada, Repita el Proceso");
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
	       repaint();
	}

	public  void EstadoHuellas(){
		System.out.println("Muestra de Huellas Necesarias para Guardar Template "+ Reclutador.getFeaturesNeeded());
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
	byte datosHuella1[] = null;
	private JLabel imagenHuella;
}
