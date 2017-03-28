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
		setBounds(100, 100, 1024, 668);
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
		btnRegistrarHuella = new JButton("Registrar Huella");
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
		sl_contentPane.putConstraint(SpringLayout.NORTH, panelEmpleados, -205, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panelEmpleados, 6, SpringLayout.EAST, panel);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panelEmpleados, -29, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panelEmpleados, -10, SpringLayout.EAST, contentPane);
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
