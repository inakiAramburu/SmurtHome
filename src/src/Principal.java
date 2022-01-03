package src;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import paneles.PanelGraficos;
import paneles.PanelMenu;
import paneles.PanelPreset;
import paneles.PanelPrincipall;

public class Principal extends JFrame implements ActionListener, PropertyChangeListener {
    final static int MAX_PANELES = 5;
    final static String COM_CHANGE = "cambiar";
    JPanel panelVisual;

    // Variables declaration - do not modify



    // End of variables declaration

    String nombre;
    int temperatura = 20;
    int intensidad = 0;
    int persiana = 0;
    int microfono = 0;
    int automatico = 0;
    Preset oraingoa;
    List<ImageIcon> luz;
    ImageIcon bombilla0, bombilla1, bombilla2, bombilla3;
    ImageIcon home;
    Controlador controlador;

    public Principal(Preset porDefecrto) {
        super("Smurt House");
        controlador = new Controlador();
        controlador.addPropertyChangeListener(this);

        luz = new ArrayList<ImageIcon>();

        bombilla0 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla0.png");
        bombilla1 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla1.png");
        bombilla2 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla2.png");
        bombilla3 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla3.png");
        luz.add(bombilla0);
        luz.add(bombilla1);
        luz.add(bombilla2);
        luz.add(bombilla3);

        panelVisual = new JPanel(new CardLayout());
        this.setSize(1600, 900);// 1600 900
        this.setLocation(100, 50);
        this.setContentPane(panelVisual);
        cambiarPanel(crearPanelPrincipal(porDefecrto));
        // cambiarPanel(crearPanelPreset());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public Container cambiarPanel(JPanel panelActual) {
        panelVisual.removeAll();
        panelVisual.add(panelActual);
        panelVisual.repaint();
        panelVisual.revalidate();
        return panelVisual;
    }

    private JPanel crearPanelPrincipal(Preset preset) {
        oraingoa = preset;

        JPanel panel;
        PanelPrincipall panelPrincipal = new PanelPrincipall(preset, controlador);
        panel = panelPrincipal.getPanel();

        return panel;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.equals("menu")) {
            // cambiarPanel(crearPanelMenu());
        }
        if (comando.equals("home")) {
            cambiarPanel(crearPanelPrincipal(oraingoa));
        }
        /*
         * if (comando.equals("preset")) { try { cambiarPanel(crearPanelPreset()); }
         * catch (ClassNotFoundException e1) { // TODO Auto-generated catch block
         * e1.printStackTrace(); } }
         */
        if (comando.equals("graficos")) {
            // cambiarPanel(crearPanelGraficos());
        }
        if (comando.equals("crearPreset")) {
            // cambiarPanel(crearPanelPresetCreator());
        }
    }

    public static void crearDatosDePrueba() {
        List<Preset> listaPreset = new ArrayList<Preset>();

        Preset preset = new Preset("prueba", 20, 0, 1, 0, 0);
        Preset preset2 = new Preset("prueba2", 25, 0, 2, 0, 0);
        listaPreset.add(preset);
        listaPreset.add(preset2);

        FileOutputStream fichero = null;
        preset.mostrarDatos();

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
        System.out.println("-------------------------------------------------------");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final String PANEL_HOME = "home", PANEL_MENU = "menu", PANEL_PRESET = "preset", PANEL_GRAFICOS = "graficos",
                PANEL_CREAR_PRESET = "crearPreset";

        String propiedad = evt.getPropertyName();
       

        JPanel panel;

        switch (propiedad) {
            case PANEL_HOME:
                PanelPrincipall panelPrincipal = new PanelPrincipall(oraingoa, controlador);
                panel = panelPrincipal.getPanel();
                cambiarPanel(panel);
                break;
            case PANEL_MENU:
                PanelMenu panelMenu = new PanelMenu(controlador);
                panel = panelMenu.getPanel();
                cambiarPanel(panel);
                break;
            case PANEL_PRESET:
                PanelPreset panelPreset = new PanelPreset(controlador);
                panel = panelPreset.getPanel();
                cambiarPanel(panel);
                break;
            case PANEL_GRAFICOS:
                PanelGraficos panelGraficos = new PanelGraficos(controlador);
                panel = panelGraficos.getPanel();
                cambiarPanel(panel);
                break;

            default:
                System.out.println("cagaste");

        }

    }

    public static void main(String[] args) throws ClassNotFoundException {
        Preset porDefecto = new Preset("UNO MAS UNO ES ILEGALISIMO", 20, 0, 0, 0, 0);
        crearDatosDePrueba();
        Principal programa = new Principal(porDefecto);

    }

}
