package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Controlador implements ActionListener {

	static boolean presetBool = false, BorrarPresetBool = false;
	final static String PANEL_MENU = "menu",
			PANEL_HOME = "home",
			PANEL_PRESET = "preset",
			PANEL_GRAFICOS = "graficos",
			PANEL_CREAR_PRESET = "crearPreset",
			BORRAR_PRESET = "borrarPreset";
	PropertyChangeSupport conector;

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
			BorrarPresetBool = false;

			System.out.println("homee");
			conector.firePropertyChange(PANEL_HOME, false, 12);

		}
		if (comando.equals(PANEL_MENU)) {
			presetBool = false;
			BorrarPresetBool = false;

			System.out.println("menu");
			conector.firePropertyChange(PANEL_MENU, false, 12);
		}

		if (comando.equals(PANEL_PRESET)) {
			presetBool = true;
			BorrarPresetBool = false;
			System.out.println("preset");
			conector.firePropertyChange(PANEL_PRESET, false, 12);
		}
		if (comando.equals(PANEL_GRAFICOS)) {
			presetBool = false;
			BorrarPresetBool = false;
			System.out.println("graficoss");
			conector.firePropertyChange(PANEL_GRAFICOS, false, 12);

		}
		if (comando.equals(PANEL_CREAR_PRESET)) {
			presetBool = false;
			BorrarPresetBool = false;
			System.out.println("crearPreset");
			conector.firePropertyChange(PANEL_CREAR_PRESET, false, 12);

		}
		if (comando.equals(BORRAR_PRESET)) {
			presetBool = false;
			BorrarPresetBool = true;
			System.out.println("borrarPreset");
			conector.firePropertyChange(BORRAR_PRESET, false, 12);
		}
<<<<<<< HEAD
		// esto es para cuando le das a un boton de un preset
=======
		if (comando.equals("cambiar")) {
			presetBool = false;
			BorrarPresetBool = true;
			System.out.println("cabiar");
			
		}
		//esto es para cuando le das a un boton de un preset
>>>>>>> branch 'reconnocimiento' of https://github.com/inakiAramburu/SmurtHome.git
		if (presetBool) {
			List<Preset> listaPreset = null;
			BorrarPresetBool = false;
			try {
				listaPreset = presetGuardados();
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

			for (int i = 0; i < listaPreset.size(); i++) {
				if (comando.equals(listaPreset.get(i).getNombre())) {
					presetBool = false;
					System.out.println("EL GANADORE ES: " + listaPreset.get(i).getNombre());
					conector.firePropertyChange("CambioDePanel", false, listaPreset.get(i));

				}
			}
			
		}
		// esto es para borrar el preset
		if (BorrarPresetBool) {
			System.out.println("entras en lo de borrar");
			BorrarPresetBool = true;

			List<Preset> listaPreset = null;
			try {
				listaPreset = presetGuardados();
			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}

			for (int i = 0; i < listaPreset.size(); i++) {
				if (comando.equals(listaPreset.get(i).getNombre())) {

					System.out.println("se borrar el: " + listaPreset.get(i).getNombre());
					listaPreset.remove(i);
					anadirDatos(listaPreset);
					conector.firePropertyChange(BORRAR_PRESET, false, 12);

				}
			}

		}

	}

	public PropertyChangeSupport getconector() {
		return this.conector;
	}

	private void anadirDatos(List<Preset> listaPreset) {

		FileOutputStream fichero = null;

		try {
			fichero = new FileOutputStream("datos.txt");
			ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
			tuberia.writeObject(listaPreset);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {

			ex.printStackTrace();
		} finally {
			try {
				fichero.close();
			} catch (IOException ex) {
				ex.printStackTrace();
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



	public PropertyChangeSupport getConector() {
		 
		return this.conector;
	}
}