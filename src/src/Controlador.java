package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener {









    @Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
        
		if(comando.equals("menu")) {
			//cambiarPanel(crearPanelMenu());
			System.out.println("menu");
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