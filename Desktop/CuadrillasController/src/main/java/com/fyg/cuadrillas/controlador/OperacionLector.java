package com.fyg.cuadrillas.controlador;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.digitalpersona.onetouch.DPFPCaptureFeedback;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPImageQualityEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;

@SuppressWarnings("serial")
public class OperacionLector extends PanelCaptura {

	/** Inicializa el lector */
	private DPFPCapture capturer = DPFPGlobal.getCaptureFactory()
			.createCapture();

	// inicializa el enrolamiento
	public DPFPEnrollment enroller = DPFPGlobal.getEnrollmentFactory()
			.createEnrollment();
   /**
    * Verifica que la huella sea correcta
    */
	private DPFPVerification verificator = DPFPGlobal.getVerificationFactory()
			.createVerification();
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

	// indica cuando el lector este activado
	public void inicioLector() {
		capturer.startCapture();
		System.out
				.println("Lector Activado, Puede utilizar el lector de huellas.");
	}

	// detiene el proceso de captura
	public void detieneLector() {
		capturer.stopCapture();
		System.out.println("Lector de huellas desactivado.");
	}

	/**
	 * comprueba el estado de las huellas
	 */
	public void estadoHuellas() {
		System.out.println("Numero de Muestras para capturar: "
				+ enroller.getFeaturesNeeded());
	}

	// procesa la huella que se captura
	@SuppressWarnings("incomplete-switch")
	protected void procesaHuella(DPFPSample sample) {
		// Procesar la muestra de la huella y crear un conjunto de
		// características con el propósito de inscripción.
		featuresinscripcion = extractFeatures(sample,
				DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

		if (featuresinscripcion != null) {
			try {
				System.out
						.println("Las Caracteristicas de la Huella han sido creada");
				enroller.addFeatures(featuresinscripcion);

				// Draw fingerprint sample image.
				drawPicture(convertSampleToBitmap(sample));

			} catch (Exception ex) {
			} finally {
				estadoHuellas();
			}
			switch (enroller.getTemplateStatus()) {
			case TEMPLATE_STATUS_READY: // informe de éxito y detiene la captura
										// de huellas
				detieneLector();
				setTemplate(enroller.getTemplate());
				JOptionPane.showMessageDialog(null,
						"La operación ha sido completada.");
				altaHuella.setEnabled(true);
				break;

			case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la
											// captura de huellas
				enroller.clear();
				detieneLector();
				estadoHuellas();
				setTemplate(null);
				JOptionPane
						.showMessageDialog(
								null,
								"El dedo no Coincide o a cambiado el dedo/ no se creo la huella, Repita el Proceso",
								"Advertencia", JOptionPane.WARNING_MESSAGE);
				inicioLector();
				break;
			}
		}
	}

	// pinta la imagen en nuestro template
	public void drawPicture(Image image) {
		imagenHuella.setIcon(new ImageIcon(image.getScaledInstance(
				imagenHuella.getWidth(), imagenHuella.getHeight(),
				Image.SCALE_DEFAULT)));
	}

	// pinta la imagen en nuestro template
	public void dibujaHuella(Image image) {
		imagenHuellaD.setIcon(new ImageIcon(image.getScaledInstance(
				imagenHuellaD.getWidth(), imagenHuellaD.getHeight(),
				Image.SCALE_DEFAULT)));
	}

	// convierte la imagen en mapa de bits
	protected Image convertSampleToBitmap(DPFPSample sample) {
		return DPFPGlobal.getSampleConversionFactory().createImage(sample);
	}

	// extrae las caracteristicas de la huella
	protected DPFPFeatureSet extractFeatures(DPFPSample sample,
			DPFPDataPurpose purpose) {
		DPFPFeatureExtraction extractor = DPFPGlobal
				.getFeatureExtractionFactory().createFeatureExtraction();
		try {
			return extractor.createFeatureSet(sample, purpose);
		} catch (DPFPImageQualityException e) {
			return null;
		}
	}

	// inicializa la captura de huella
	protected void inicializadorHuellas() {
		capturer.addDataListener(new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {

						JOptionPane.showMessageDialog(null,
								"La huella digital ha sido capturada.");
						procesaHuella(e.getSample());
					}
				});
			}
		});
		capturer.addReaderStatusListener(new DPFPReaderStatusAdapter() {
			@Override
			public void readerConnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out
								.println("The fingerprint reader was connected.");
					}
				});
			}

			@Override
			public void readerDisconnected(final DPFPReaderStatusEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out
								.println("The fingerprint reader was disconnected.");
					}
				});
			}
		});
		capturer.addSensorListener(new DPFPSensorAdapter() {
			@Override
			public void fingerTouched(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out
								.println("The fingerprint reader was touched.");
					}
				});
			}

			@Override
			public void fingerGone(final DPFPSensorEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						System.out
								.println("The finger was removed from the fingerprint reader.");
					}
				});
			}
		});
		capturer.addImageQualityListener(new DPFPImageQualityAdapter() {
			@Override
			public void onImageQuality(final DPFPImageQualityEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						if (e.getFeedback().equals(
								DPFPCaptureFeedback.CAPTURE_FEEDBACK_GOOD))
							System.out
									.println("The quality of the fingerprint sample is good.");
						else
							System.out
									.println("The quality of the fingerprint sample is poor.");
					}
				});
			}
		});
	}

	// crea un filtro para guardar el archivo
	public class TemplateFileFilter extends javax.swing.filechooser.FileFilter {
		@Override
		public boolean accept(File f) {
			return f.getName().endsWith(".fpt");
		}

		@Override
		public String getDescription() {
			return "Fingerprint Template File (*.fpt)";
		}
	}

	// obtiene el template
	public DPFPTemplate getTemplate() {
		return template;
	}

	// setea el template
	public void setTemplate(DPFPTemplate template) {
		DPFPTemplate old = this.template;
		this.template = template;
		firePropertyChange(TEMPLATE_PROPERTY, old, template);
	}

	// guarda el template en un fichero
	public void onSave() {
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(new TemplateFileFilter());
		while (true) {
			String consulta = "consultaCatalogo/catalogo?tipoCatalogo=LADO_MAN";
			String result = new ObtieneUrl().getUrlContents(consulta);
			String codigoMano = null;
			String codigoDedo = null;

			Integer idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(
					tablaEmpleados.getSelectedRow(), 0).toString());
			try {
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(result);
				JSONObject jsonCatalogoManoWS = (JSONObject) obj;
				JSONArray arrayCatalogoManoWS = (JSONArray) jsonCatalogoManoWS
						.get("catalogo");

				for (int j = 0; j < arrayCatalogoManoWS.size(); j++) {
					JSONObject manoWS = (JSONObject) arrayCatalogoManoWS.get(j);
					String descripcionWS = (String) manoWS.get("descripcion");
					if (descripcionWS.equals(cataMano.getSelectedItem())) {
						codigoMano = (String) manoWS.get("codigo");
						System.out.println("Seleccion Mano Codigo: "
								+ codigoMano);
					}
				}
				String direccionConsultaWS = "consultaCatalogo/catalogo?tipoCatalogo=TIPO_DEDO";
				String salidaCatalogoWS = new ObtieneUrl()
						.getUrlContents(direccionConsultaWS);
				JSONParser parseoWS = new JSONParser();
				Object objCatalogoWS = parseoWS.parse(salidaCatalogoWS);
				JSONObject jsonCatalogoDedoWS = (JSONObject) objCatalogoWS;
				JSONArray arrayCatalogoDedoWS = (JSONArray) jsonCatalogoDedoWS
						.get("catalogo");

				for (int k = 0; k < arrayCatalogoDedoWS.size(); k++) {
					JSONObject dedoWS = (JSONObject) arrayCatalogoDedoWS.get(k);
					String descripcionDedoWS = (String) dedoWS
							.get("descripcion");

					if (descripcionDedoWS.equals(cataDedos.getSelectedItem())) {
						codigoDedo = (String) dedoWS.get("codigo");
						System.out.println("Seleccion Dedo: " + codigoDedo);
					}
				}
			} catch (Exception f) {
				f.printStackTrace();
			}
			// guarda huella
			if (chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
				try {
					File file = chooser.getSelectedFile();
					//if (!file.toString().toLowerCase().endsWith(".fpt"))
						file = new File(file.toString());
					if (file.exists()) {
						int choice = JOptionPane
								.showConfirmDialog(
										this,
										String.format(
												"File \"%1$s\" already exists.\nDo you want to replace it?",
												file.toString()),
										"Huella Guardada",
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
					String registraHuella = "registraHuella/huella?idEmpleado="
							+ idEmpleado + "&codigoMano=" + codigoMano
							+ "&codigoDedo=" + codigoDedo + "&ruta=" + ruta;
					String resultHuella = new ObtieneUrl()
							.getUrlContents(registraHuella);
					System.out.println(resultHuella);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(this,
							ex.getLocalizedMessage(), "Fingerprint saving",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			break;
		}
	}

	boolean algo = false;
 /**
  * Listener que activa el metodo de verificar Huella
  */
	protected void verificaHuella() {

		algo = true;

		System.out.println("addDataListener "
				+ capturer.getListeners(DPFPDataAdapter.class).length);

		DPFPDataAdapter dataAdapter = new DPFPDataAdapter() {
			@Override
			public void dataAcquired(final DPFPDataEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {

						if (algo) {
							algo = false;
							JOptionPane.showMessageDialog(null,
									"La huella digital ha sido capturada.");
							comparaHuella(e.getSample());
						} else {
							return;
						}
					}
				});
			}
		};
		capturer.addDataListener(dataAdapter);

		capturer.removeDataListener(dataAdapter);
		System.out.println("remove listener");
	}
   /**
    * Metodo que compara la huella
    * @param sample recibe datos del lector
    */
	public void comparaHuella(DPFPSample sample) {

		System.out.println("**************** Entra comparaHuella ");
		// Process the sample and create a feature set for the enrollment
		// purpose.
		DPFPFeatureSet features = extractFeatures(sample,
				DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
		// Check quality of the sample and start verification if it's good
		dibujaHuella(convertSampleToBitmap(sample));
		DPFPVerificationResult result = null;
		setTemplate(null);
		String nombreEmpleado = tablaEmpleados.getValueAt(
				tablaEmpleados.getSelectedRow(), 2).toString();
		String appP = tablaEmpleados.getValueAt(
				tablaEmpleados.getSelectedRow(), 3).toString();
		try {
			// para consultar la huella
			Integer idEmpleado = Integer.parseInt(tablaEmpleados.getValueAt(
					tablaEmpleados.getSelectedRow(), 0).toString());
			System.out.println("el id empleado es: " + idEmpleado);
			String consultaHuellas = "consultaHuella/empleado?idEmpleado="
					+ idEmpleado;
			String salidaHuella = new ObtieneUrl()
					.getUrlContents(consultaHuellas);
			//boolean stats = false;
			// System.out.println(salidaHuella);

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(salidaHuella);
			JSONObject jsonHuellasWS = (JSONObject) obj;
			JSONArray arrayHuellasWS = (JSONArray) jsonHuellasWS
					.get("empleadoHuella");

			System.out.println("arrayHuellasWS size: " + arrayHuellasWS.size());

			for (int h = 0; h < arrayHuellasWS.size(); h++) {
				JSONObject huellaWS = (JSONObject) arrayHuellasWS.get(h);
				String tipoHuellaWS = (String) huellaWS.get("huella");

				URL url = new URL(tipoHuellaWS);
				URI d = url.toURI();
				File rut = new File(d.getSchemeSpecificPart());

				List<String> rutas = new ArrayList<String>();
				rutas.add(rut.toString());
				System.out.println("rutas size: " + rutas.size());

				for (int r = 0; r < rutas.size(); r++) {

					FileInputStream stream = new FileInputStream(new File(
							rutas.get(r)));
					byte[] data = new byte[stream.available()];
					stream.read(data);
					stream.close();
					t.deserialize(data);
					setTemplate(t);
					if (features != null) {
						// Compare the feature set with our template
						result = verificator.verify(features, getTemplate());

						if (result.isVerified()) {
							JOptionPane.showMessageDialog(null,
									"Se ha verificado su identidad: "
											+ nombreEmpleado + " " + appP);
							btnAltaHuella.setEnabled(true);
							consultaHuella.setEnabled(true);
							imagenHuellaD.setIcon(null);
							consulta.setVisible(false);
							detieneLector();
							setTemplate(null);
							features = null;
							//stats = true;
							break;
						}
					}
					if (!result.isVerified()) {
						JOptionPane.showMessageDialog(null,
								"La huella es incorrecta, revise por favor.");

						btnAltaHuella.setEnabled(true);
						consultaHuella.setEnabled(true);
						imagenHuellaD.setIcon(null);

						consulta.setVisible(false);
						detieneLector();
						return;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
