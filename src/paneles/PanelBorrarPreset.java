
package paneles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

import src.Controlador;
import src.Preset;

public class PanelBorrarPreset extends JFrame {

    JButton anadirButton;
    JButton atrasButton;
    JButton borrarButton;
    JButton homeButon;
    JPanel jPanel2;
    javax.swing.JScrollPane jScrollPane2;
    JPanel panelPreset;
    JPanel panelRojo;
    JFormattedTextField titulo;
    Controlador controlador;
    ImageIcon home;

    public PanelBorrarPreset(Controlador controlador) {
        this.controlador = controlador;

        List<JButton> botones = new ArrayList<JButton>();

        List<Preset> listaPreset = null;
        try {
            listaPreset = presetGuardados();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        panelPreset = new javax.swing.JPanel();
        homeButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        panelRojo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        anadirButton = new javax.swing.JButton();
        borrarButton = new javax.swing.JButton();
        atrasButton = new javax.swing.JButton();

        atrasButton.setActionCommand("menu");
        atrasButton.addActionListener(controlador);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPreset.setBackground(new java.awt.Color(255, 255, 255));

        homeButon.setBackground(new java.awt.Color(51, 255, 255));
        homeButon.setFont(new java.awt.Font("Product San", 0, 20));
        home = new ImageIcon("iconos/PanelPrincipal/casa.png");
        homeButon.setIcon(new ImageIcon(home.getImage()));
        homeButon.setBorder(null);
        homeButon.setBorderPainted(false);
        homeButon.setActionCommand("home");
        homeButon.addActionListener(controlador);

        // añadir botones en el panel2

        for (int i = 0; i < listaPreset.size(); i++) {

            JButton botone = new JButton();
            botone.setFont(new java.awt.Font("Product San", 0, 20));
            botone.setText(listaPreset.get(i).getNombre());
            //poner el botone con fondo rojo
            botone.setBackground(new java.awt.Color(255, 0, 0));

            
            // urrengoa=(listaPreset.get(i));

            // a�adir propertichange listener al boton
            // botone.addPropertyChangeListener(controlador);
            botone.setActionCommand(listaPreset.get(i).getNombre());
            botone.addActionListener(controlador);
            jPanel2.add(botone);
            botones.add(botone);

        }

        titulo.setEditable(false);
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("BORRAR Preset");
        titulo.setFont(new java.awt.Font("Product San", 0, 60));
        JButton boton = new JButton("Boton");

        panelRojo.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(panelRojoLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 149, Short.MAX_VALUE));
        panelRojoLayout.setVerticalGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 150, Short.MAX_VALUE));

        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 3));
        jScrollPane2.setViewportView(jPanel2);

        anadirButton.setText("+");
        anadirButton.setActionCommand("crearPreset");
        anadirButton.addActionListener(controlador);

        borrarButton.setText("-");

        borrarButton.setActionCommand("borrarPreset");
        borrarButton.addActionListener(controlador);

        atrasButton.setText("Atras");

        javax.swing.GroupLayout panelPresetLayout = new javax.swing.GroupLayout(panelPreset);
        panelPreset.setLayout(panelPresetLayout);
        panelPresetLayout
                .setHorizontalGroup(panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPresetLayout.createSequentialGroup()
                                .addComponent(anadirButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(borrarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 534,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(atrasButton, javax.swing.GroupLayout.PREFERRED_SIZE, 533,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(panelPresetLayout.createSequentialGroup().addGroup(panelPresetLayout
                                .createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelPresetLayout.createSequentialGroup().addGap(90, 90, 90)
                                        .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60).addComponent(panelRojo,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(panelPresetLayout.createSequentialGroup().addGap(130, 130, 130).addComponent(
                                        jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1339,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelPresetLayout.setVerticalGroup(panelPresetLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPresetLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350,
                                javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addGroup(panelPresetLayout
                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(anadirButton, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                .addComponent(borrarButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(atrasButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(panelPreset,
                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                layout.createSequentialGroup()
                                        .addComponent(panelPreset, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(0, 0, 0)));

        pack();

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

    public JPanel getPanel() {
        return panelPreset;
    }

}
