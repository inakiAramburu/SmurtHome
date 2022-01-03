package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import paneles.PanelMenu;


public class Controlador implements ActionListener {
	final static String PANEL_MENU = "menu",
	PANEL_HOME="home",
	PANEL_PRESET="preset",
	PANEL_GRAFICOS="graficos",
	PANEL_CREAR_PRESET="crearPreset";
	PropertyChangeSupport conector;
	
	//final static PanelMenu panelMenu=new PanelMenu();

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
       
		if(comando.equals(PANEL_HOME)) {
			//cambiarPanel(crearPanelPrincipal(horaingoa));
			System.out.println("homee");
			conector.firePropertyChange(PANEL_HOME, false, 12);

		}
		if(comando.equals(PANEL_MENU)) {
			//cambiarPanel(crearPanelMenu());
			System.out.println("menu");
			conector.firePropertyChange(PANEL_MENU, false, 12);
		}
		
		if(comando.equals(PANEL_PRESET)) {
			System.out.println("preset");
			conector.firePropertyChange(PANEL_PRESET, false, 12);

		
			System.out.println("preset");
		}
        if(comando.equals("graficos")) {
			System.out.println("graficoss");
			//cambiarPanel(crearPanelGraficos());
		}
		if(comando.equals("crearPreset")) {
			System.out.println("crearPreset");
			//cambiarPanel(crearPanelPresetCreator());
		}
	}


	



}