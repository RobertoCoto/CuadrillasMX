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

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class PanelCapturaFyG extends JApplet
{
	public PanelCapturaFyG() {
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
	 JButton btnRegistrarHuella;
	 static JLabel menuBar;
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
		panelEmpleados.setPreferredSize(new java.awt.Dimension(130, 170));
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
        //frame.setResizable(false);
        
        
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
        frame.getContentPane().add(campoUsuario);

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
        frame.getContentPane().add(campoContrasena);
        
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
                		imagen.setVisible(false);
                		menuBar.setVisible(false);
                		campoUsuario.setVisible(false);
                		campoContrasena.setVisible(false);
                		final JApplet applet = new PanelCapturaFyG();
                		
                		applet.init();
        				frame.add( applet );
                		JOptionPane.showMessageDialog(null, msg);
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
        ImageIcon bar = new ImageIcon(PanelCapturaFyG.class.getResource("/resources/banner_tatei.png"));
        menuBar.setBounds(0,0,250,550);//posicion (x,y,ancho,largo)
        menuBar.setIcon(bar);
        frame.getContentPane().add(menuBar);
        
        imagen = new JLabel();
        ImageIcon img = new ImageIcon(PanelCapturaFyG.class.getResource("/resources/back_Home_login.jpg"));
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
}
