package src;

import java.awt.CardLayout;
import java.awt.Container;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import consumo.Consumo;
import consumo.ListaConsumo;
import paneles.PanelBorrarPreset;
import paneles.PanelCrearPreset;
import paneles.PanelGraficos;
import paneles.PanelMenu;
import paneles.PanelPreset;
import paneles.PanelPrincipall;
import uart.Uart;

public class Principal extends JFrame implements PropertyChangeListener {
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
    static Preset oraingoa;
    List<ImageIcon> luz;
    ImageIcon bombilla0, bombilla1, bombilla2, bombilla3;
    ImageIcon home;
    Controlador controlador;
    static Uart uart;
    static Hilo hilo;

    public Principal(Preset porDefecrto) {
        super("Smurt House");
        oraingoa = porDefecrto;
        controlador = Controlador.getcontrolador();
        controlador.addPropertyChangeListener(this);

        panelVisual = new JPanel(new CardLayout());
        this.setSize(1600, 950);// 1600 900
        this.setLocation(100, 50);
        this.setContentPane(panelVisual);
        cambiarPanel(crearPanelPrincipal(porDefecrto));
        // cambiarPanel(crearPanelPreset());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
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
        System.out.println("principal: " + oraingoa.hashCode());

        return panel;
    }

    public static void crearDatosDePrueba() {
        List<Preset> listaPreset = new ArrayList<Preset>();

        Preset preset = new Preset("Qing Yu", 20, 1, 1, 0, 0);
        Preset preset2 = new Preset("Ainhoa", 25, 2, 2, 0, 0);
        Preset preset3 = new Preset("Iñaki", 30, 3, 1, 0, 0);
        Preset preset4 = new Preset("Aritz", 15, 0, 2, 0, 0);

        listaPreset.add(preset);
        listaPreset.add(preset2);
        listaPreset.add(preset3);
        listaPreset.add(preset4);

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final String PANEL_HOME = "home", PANEL_MENU = "menu", PANEL_PRESET = "preset", PANEL_GRAFICOS = "graficos",
                PANEL_CREAR_PRESET = "crearPreset", BORRAR_PRESET = "borrarPreset";

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
            case "CambioDePanel":

                Preset preset = (Preset) evt.getNewValue();
                oraingoa = preset;
                actualizarPreset(preset);
                panelPrincipal = new PanelPrincipall(oraingoa, controlador);
                panel = panelPrincipal.getPanel();
                cambiarPanel(panel);
                break;
            case PANEL_CREAR_PRESET:
                PanelCrearPreset panelCrearPreset = new PanelCrearPreset(controlador);
                panel = panelCrearPreset.getPanel();
                cambiarPanel(panel);
                break;
            case BORRAR_PRESET:
                PanelBorrarPreset PanelBorrarPreset = new PanelBorrarPreset(controlador);
                panel = PanelBorrarPreset.getPanel();
                cambiarPanel(panel);
                break;
            case "recarga":

                if (evt.getOldValue().equals("temperatura")) {// temperatura

                    oraingoa.setTemperatura((int) evt.getNewValue());
                }

                if (evt.getOldValue().equals("intensidad")) {// intensidad

                    oraingoa.setIntensidad((int) evt.getNewValue());

                }
                if (evt.getOldValue().equals("luz")) {// intensidad
                    if (oraingoa.getIntensidad() == 0) {
                        oraingoa.setIntensidad(1);
                    } else {
                        System.out.println("la luz esta encendida");
                    }
                }
                if (evt.getOldValue().equals("persiana")) {// persiana

                    switch ((String) evt.getNewValue()) {
                        case "subir":
                            oraingoa.setPersiana(1);
                            break;
                        case "parar":
                            oraingoa.setPersiana(0);
                            break;
                        case "bajar":
                            oraingoa.setPersiana(2);
                            break;
                    }
                    System.out.println("persiana por micro: " + oraingoa.getPersiana());

                }

                PanelPrincipall panelPrincipal2 = new PanelPrincipall(oraingoa, controlador);

                panel = panelPrincipal2.getPanel();
                cambiarPanel(panel);
                break;
            default:
                System.out.println("cagaste");
                break;

        }

    }

    private void actualizarPreset(Preset preset) {
        
        uart.setPreset(preset);
        hilo.setPreset(preset);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Preset porDefecto = new Preset("Salón", 20, 2, 0, 0, 0);
        oraingoa = porDefecto;
        crearDatosDePrueba();// si comentas esta linea los datos del fichero no se
        crearDatosDeConsumo();

        uart = new Uart();
        uart.start(uart, oraingoa);

        // inicia un thread para que el programa no se cierre
        hilo = new Hilo(oraingoa);

        Principal programa = new Principal(porDefecto);

    }

    private static void crearDatosDeConsumo() {

        Map<LocalDate, Integer> listaConsumos = new HashMap<LocalDate, Integer>();

        // crear datos inventados de hace 7 dias

        // generar un numero aleatorio entre 0 y 100
        Random r = new Random();
        int numero;

        for (int i = 0; i < 7; i++) {
            numero = r.nextInt(86400);
            LocalDate fecha = LocalDate.now().minusDays(i);

            listaConsumos.put(fecha, numero);

        }

        FileOutputStream fichero = null;

        try {
            fichero = new FileOutputStream("datosConsumo.bin");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(listaConsumos);

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

}
