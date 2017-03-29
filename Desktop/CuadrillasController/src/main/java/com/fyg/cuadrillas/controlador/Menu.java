package com.fyg.cuadrillas.controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fyg.cuadrillas.dto.empleado.EmpleadoDTO;

import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;

public class Menu extends JFrame {

	/**
	 * serial uid
	 */
	private static final long serialVersionUID = -3010529671062853579L;
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
	 * label del nombre usuario
	 */
	JLabel nombreUser;
	/**
	 * label del perfil
	 */
	JLabel perfilUsuario;
	/**
	 * Boton registra huella
	 */
	JButton btnRegistrarHuella;
	JPanel panelHuella;
	JPanel panelBotones;
	JComboBox cataMano;
	JTabbedPane huellaImage;
	private JComboBox cataDedos;
	/**
	 * Launch the application.
	 * @param args recibe valores
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
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setBounds(100, 100, 1124, 668);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);
		setLocationRelativeTo(null);
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
		        				 System.out.println(empleado);
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, panelEmpleados, -201, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panelEmpleados, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panelEmpleados, -25, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panelEmpleados, -15, SpringLayout.EAST, lblPerfil);
		panelEmpleados.setBorder(new TitledBorder(null, "Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpleados.setVisible(false);
		contentPane.add(panelEmpleados);
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
		nombreUser = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.WEST, nombreUser, 15, SpringLayout.EAST, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, nombreUser, 0, SpringLayout.SOUTH, lblNombre);
		contentPane.add(nombreUser);
		perfilUsuario = new JLabel("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, perfilUsuario, 0, SpringLayout.NORTH, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.WEST, perfilUsuario, 6, SpringLayout.EAST, lblPerfil);
		contentPane.add(perfilUsuario);
		
		panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "Operaciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sl_contentPane.putConstraint(SpringLayout.NORTH, panelBotones, 0, SpringLayout.NORTH, panelEmpleados);
		sl_contentPane.putConstraint(SpringLayout.WEST, panelBotones, 6, SpringLayout.EAST, panelEmpleados);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panelBotones, 0, SpringLayout.SOUTH, panelEmpleados);
		sl_contentPane.putConstraint(SpringLayout.EAST, panelBotones, 157, SpringLayout.EAST, panelEmpleados);
		panelBotones.setVisible(false);
		contentPane.add(panelBotones);
		
		JButton btnAltaHuella = new JButton("Alta Huella");
		btnAltaHuella.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				panelHuella.setVisible(true);
				huellaImage.setVisible(true);
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
		
		huellaImage = new JTabbedPane(JTabbedPane.TOP);
		sl_contentPane.putConstraint(SpringLayout.NORTH, huellaImage, 7, SpringLayout.SOUTH, lblNombre);
		sl_contentPane.putConstraint(SpringLayout.WEST, huellaImage, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, huellaImage, -104, SpringLayout.NORTH, panelEmpleados);
		sl_contentPane.putConstraint(SpringLayout.EAST, huellaImage, 240, SpringLayout.EAST, panel);
		huellaImage.setBorder(new TitledBorder(null, "Capturando Huella", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		huellaImage.setVisible(false);
		contentPane.add(huellaImage);
		
		panelHuella = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panelHuella, 31, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panelHuella, 44, SpringLayout.EAST, huellaImage);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panelHuella, 130, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panelHuella, 310, SpringLayout.EAST, huellaImage);
		FlowLayout flowLayout = (FlowLayout) panelHuella.getLayout();
		panelHuella.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelHuella.setVisible(false);
		contentPane.add(panelHuella);
		
		cataMano = new JComboBox();
		panelHuella.add(cataMano);
		
		cataDedos = new JComboBox();
		panelHuella.add(cataDedos);
		
		JButton altaHuella = new JButton("Guardar Huella");
		altaHuella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelHuella.add(altaHuella);
		
		//Acciones de las filas
		
		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	            System.out.println(tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0).toString());
	            panelBotones.setVisible(true);
	            panelHuella.setVisible(false);
	            huellaImage.setVisible(false);
	            cataMano.removeAllItems();
	            cataDedos.removeAllItems();
	        }
	    });
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
