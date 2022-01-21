package src;

import java.awt.CardLayout;
import java.awt.Container;
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

        return panel;
    }

    public static void crearDatosDePrueba() {
        List<Preset> listaPreset = new ArrayList<Preset>();

        Preset preset = new Preset("prueba", 20, 1, 1, 0, 0);
        Preset preset2 = new Preset("prueba2", 25, 2, 2, 0, 0);
        Preset preset3 = new Preset("prueba3", 30, 3, 1, 0, 0);
        Preset preset4 = new Preset("prueba4", 15, 0, 2, 0, 0);
        Preset preset5 = new Preset("prueba5", 10, 0, 1, 0, 0);
        Preset preset6 = new Preset("prueba6", 5, 0, 2, 0, 0);
        Preset preset7 = new Preset("prueba7", 0, 0, 1, 0, 0);

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

    public static void main(String[] args) throws ClassNotFoundException {
        Preset porDefecto = new Preset("UNO MAS UNO ES ILEGAL", 20, 2, 0, 1, 0);
        //crearDatosDePrueba();// si comentas esta linea los datos del fichero no se
        // sobreescriben
        // crea un thread
        oraingoa=porDefecto;
        Uart uart = new Uart(oraingoa);
        

        //inicia un thread para que el programa no se cierre
        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Consumo consumoEncendido=null;
                    Consumo consumoApagado=null;
                    Boolean comprobado = false;
                    while(true){
                    	uart.start(uart);
                        Thread.sleep(1000);
                        
                        

                        if(oraingoa.getIntensidad()>=1 && comprobado==false){
                            consumoEncendido= new Consumo();
                            comprobado=true;
                        }
                        if (oraingoa.getIntensidad() == 0 && comprobado==true){
                            consumoApagado= new Consumo();
                            comprobado = false;

                            consumoEncendido.mostarConsumo();
                            consumoApagado.mostarConsumo();
                            
                            consumoEncendido.getTiempoTotal();
                            consumoApagado.getTiempoTotal();

                            int diferencia =consumoEncendido.compare(consumoApagado);
                            System.out.println("consumo total "+consumoEncendido.compare(consumoApagado));
                            
                            Consumo total= new Consumo(diferencia);

                           ListaConsumo listaConsumos=ListaConsumo.getListaConsumo();
                           
                           listaConsumos.meterDatos(total);
                           listaConsumos.mostrarDatos();
                        }


                    }
                   
                } catch (Exception ex) {
                   System.out.println(ex);
                }
            }
        });

        hilo.start();

        Principal programa = new Principal(porDefecto);

    }

}
