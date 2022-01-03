package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements ActionListener {

	static boolean presetBool = false;
	final static String PANEL_MENU = "menu",
			PANEL_HOME = "home",
			PANEL_PRESET = "preset",
			PANEL_GRAFICOS = "graficos",
			PANEL_CREAR_PRESET = "crearPreset";
	PropertyChangeSupport conector;

	// final static PanelMenu panelMenu=new PanelMenu();

	public Controlador() {
		conector = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {

		conector.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		conector.removePropertyChangeListener(listener);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(PANEL_HOME)) {
			presetBool = false;
			// cambiarPanel(crearPanelPrincipal(horaingoa));
			System.out.println("homee");
			conector.firePropertyChange(PANEL_HOME, false, 12);

		}
		if (comando.equals(PANEL_MENU)) {
			presetBool = false;
			// cambiarPanel(crearPanelMenu());
			System.out.println("menu");
			conector.firePropertyChange(PANEL_MENU, false, 12);
		}

		if (comando.equals(PANEL_PRESET)) {
			presetBool = true;
			System.out.println("preset");
			conector.firePropertyChange(PANEL_PRESET, false, 12);
		}
		if (comando.equals(PANEL_GRAFICOS)) {
			presetBool = false;
			System.out.println("graficoss");
			conector.firePropertyChange(PANEL_GRAFICOS, false, 12);
			// cambiarPanel(crearPanelGraficos());
		}
		if (comando.equals(PANEL_CREAR_PRESET)) {
			presetBool = false;
			System.out.println("crearPreset");
			conector.firePropertyChange(PANEL_CREAR_PRESET, false, 12);

			// cambiarPanel(crearPanelPresetCreator());
		}

		if (presetBool) {
			List<Preset> listaPreset=null;
			try {
				listaPreset = presetGuardados();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			for (int i = 0; i < listaPreset.size(); i++) {
				if (comando.equals(listaPreset.get(i).getNombre())) {
					presetBool = false;
					System.out.println("EL GANADORE ES: " + listaPreset.get(i).getNombre());
					conector.firePropertyChange("CambioDePanel", false, listaPreset.get(i));
					// cambiarPanel(crearPanelPreset(preset));
				}
			}


		}

	}

	private List<Preset> presetGuardados() throws ClassNotFoundException {

		FileInputStream ficheroEntrada = null;
		List<Preset> listaPreset = new ArrayList<Preset>();
		try {
			ficheroEntrada = new FileInputStream("datos.txt");
			try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
				listaPreset = (List<Preset>) tuberia.readObject();
			}
			for (Preset p : listaPreset) {
				p.mostrarDatos();
			}

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {

			ex.printStackTrace();
		}

		return listaPreset;
	}

}