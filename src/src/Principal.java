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
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
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
    private javax.swing.JPanel panelHome;
    private javax.swing.JButton automaticoButton;
    private javax.swing.JButton bajarPButton;
    private javax.swing.JButton bajarTButton;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    public javax.swing.JButton luzButton;
    private javax.swing.JButton menuButon;
    private javax.swing.JButton microfonoButton;
    private javax.swing.JPanel panelPersiana;
    private javax.swing.JPanel panelRojo;
    private javax.swing.JPanel panelTemperatura;
    private javax.swing.JButton pararPButton;
    private javax.swing.JButton subirPButton;
    private javax.swing.JFormattedTextField titulo;
    private javax.swing.JButton upButton;
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

    private JPanel crearPanelPreset() {

        JPanel panel;
        PanelPreset panelPreset = new PanelPreset(controlador);
        panel = panelPreset.getPanel();

        return panel;
    }


    private void jFormattedTextField1ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void bajarTButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        if (temperatura > 17) {
            temperatura--;
            jFormattedTextField1.setText(temperatura + "");
        }
        System.out.println(temperatura);

    }

    private void upButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // TODO add your handling code here:
        if (temperatura < 30) {
            temperatura++;
            jFormattedTextField1.setText(temperatura + "");
        }
        System.out.println(temperatura);

    }

    private void luzButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        // TODO add your handling code here:

        // luzButton.setIcon(new ImageIcon(azul.getImage()));
        if (intensidad == 0) {
            intensidad = 1;
        } else if (intensidad != 0) {
            if (intensidad == 3) {
                intensidad = 0;
            } else {
                intensidad++;
            }
        } else if (false /* esterar dos segundos */) {
            intensidad = 0;
        }
        System.out.println("Intensidad: " + intensidad);
        switch (intensidad) {
            case 0:
                // luzButton.setBackground(new java.awt.Color(204, 204, 204));
                break;
            case 1:
                // luzButton.setBackground(new java.awt.Color(153, 255, 153));
                break;
            case 2:
                // luzButton.setBackground(new java.awt.Color(102, 255, 102));
                break;
            case 3:
                // luzButton.setBackground(new java.awt.Color(0, 255, 0));
                break;
            // luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));

        }
        luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));
    }

    private void bajarPButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        persiana = 2;
        System.out.println(persiana);
    }

    private void subirPButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        persiana = 1;
        System.out.println(persiana);

    }

    private void pararPButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        persiana = 0;
        System.out.println(persiana);
    }

    private void microfonoButtonActionPerformed(ActionEvent evt) {

        if (microfono == 0) {
            microfono = 1;
        } else {
            microfono = 0;
        }
        System.out.println("microfono: " + microfono);

    }

    private void automaticoButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:

        if (automatico == 0) {
            automatico = 1;
        } else {
            automatico = 0;
        }

        System.out.println("automatico: " + automatico);
    }

    private void borrarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("borrar preset");
    }

    private void atrasButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("atras");
    }
    ////

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
