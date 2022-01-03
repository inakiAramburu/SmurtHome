package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import paneles.PanelMenu;


public class Controlador implements ActionListener {
	final static String PANEL_MENU = "menu",PANEL_HOME="home",PANEL_PRESET="preset",PANEL_GRAFICOS="graficos",PANEL_CREAR_PRESET="crearPreset";
	PropertyChangeSupport conector;
	
	final static PanelMenu panelMenu=new PanelMenu();

	public Controlador() {
		conector = new PropertyChangeSupport(this);
	}

	//añadir propertichange liesener
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		
		conector.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		conector.removePropertyChangeListener(listener);

	}




    @Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
        
		if(comando.equals(PANEL_MENU)) {
			//cambiarPanel(crearPanelMenu());
			System.out.println("menu");
			conector.firePropertyChange(comando, -1, panelMenu.getPanel());
		}
		if(comando.equals("home")) {
			//cambiarPanel(crearPanelPrincipal(horaingoa));
			System.out.println("home");
		}
		if(comando.equals("preset")) {
			System.out.println("preset");
			/*try {
                cambiarPanel(crearPanelPreset());
            } catch (ClassNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }*/
		}
        if(comando.equals("graficos")) {
			System.out.println("graficos");
			//cambiarPanel(crearPanelGraficos());
		}
		if(comando.equals("crearPreset")) {
			System.out.println("crearPreset");
			//cambiarPanel(crearPanelPresetCreator());
		}
	}


	



}