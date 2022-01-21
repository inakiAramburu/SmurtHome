
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import src.Controlador;
import src.Preset;

public class PanelBorrarPreset extends JFrame {

        JButton atrasButton;
        JButton homeButon;
        JPanel jPanel2;
        JScrollPane jScrollPane2;
        JPanel panelBorrarPreset;
        JPanel panelRojo;
        JFormattedTextField titulo;
        ImageIcon home, atrasIcon, icono;
        Controlador controlador;
        JLabel iconoLabel;

        public PanelBorrarPreset(Controlador controlador) {
                this.controlador = controlador;
                panelBorrarPreset = new javax.swing.JPanel();
                homeButon = new javax.swing.JButton();
                titulo = new javax.swing.JFormattedTextField();
                panelRojo = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                jPanel2 = new javax.swing.JPanel();
                atrasButton = new javax.swing.JButton();
                iconoLabel = new javax.swing.JLabel();

                atrasIcon = new ImageIcon("iconos/Preset/back.png");
                icono = new ImageIcon("iconos/icono.png");
                List<JButton> botones = new ArrayList<JButton>();

                List<Preset> listaPreset = null;
                try {
                        listaPreset = presetGuardados();
                } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelBorrarPreset.setBackground(new java.awt.Color(36, 36, 36));

                homeButon.setBackground(new java.awt.Color(36, 36, 36));
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
                        botone.setFont(new java.awt.Font("Product San", 0, 50));
                        botone.setText(listaPreset.get(i).getNombre());

                        botone.setForeground(new java.awt.Color(255, 255, 255));
                        botone.setBackground(new java.awt.Color(57, 58, 80));

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
                titulo.setText("Borrar Preset");
                titulo.setFont(new java.awt.Font("Product San", 0, 60));
                titulo.setForeground(new java.awt.Color(255, 255, 255));
                titulo.setBackground(new java.awt.Color(58, 58, 58));
////////////
                panelRojo.setBackground(new java.awt.Color(36, 36, 36));
                panelRojo.setPreferredSize(new java.awt.Dimension(150, 150));

                iconoLabel.setIcon(icono);

                javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
                panelRojo.setLayout(panelRojoLayout);
                panelRojoLayout.setHorizontalGroup(
                                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRojoLayout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(iconoLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                panelRojoLayout.setVerticalGroup(
                                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelRojoLayout.createSequentialGroup()
                                                                .addGap(0, 0, 0)
                                                                .addComponent(iconoLabel,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                150,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));
//////////////
                jScrollPane2.setBorder(null);
                jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

                jPanel2.setBackground(new java.awt.Color(36, 36, 36));
                jPanel2.setLayout(new java.awt.GridLayout(1, 3));
                jScrollPane2.setViewportView(jPanel2);

                // atrasButton.setText("Atras");

                atrasButton.setIcon(new ImageIcon(atrasIcon.getImage()));

                atrasButton.setBackground(new java.awt.Color(58, 58, 58));

                atrasButton.setActionCommand("preset");
                atrasButton.addActionListener(controlador);

                javax.swing.GroupLayout panelBorrarPresetLayout = new javax.swing.GroupLayout(panelBorrarPreset);
                panelBorrarPreset.setLayout(panelBorrarPresetLayout);
                panelBorrarPresetLayout.setHorizontalGroup(
                                panelBorrarPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelBorrarPresetLayout.createSequentialGroup()
                                                                .addGroup(panelBorrarPresetLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelBorrarPresetLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(90, 90, 90)
                                                                                                .addComponent(homeButon,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(titulo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                999,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(panelRojo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(panelBorrarPresetLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(130, 130, 130)
                                                                                                .addComponent(jScrollPane2,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1339,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(92, Short.MAX_VALUE))
                                                .addComponent(atrasButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                panelBorrarPresetLayout.setVerticalGroup(
                                panelBorrarPresetLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                panelBorrarPresetLayout.createSequentialGroup()
                                                                                .addGap(80, 80, 80)
                                                                                .addGroup(panelBorrarPresetLayout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(homeButon,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(panelRojo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(titulo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(50, 50, 50)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                350,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(100, 100, 100)
                                                                                .addComponent(atrasButton,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                170,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addContainerGap(
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelBorrarPreset, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addComponent(panelBorrarPreset,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
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

                } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                } catch (IOException ex) {

                        ex.printStackTrace();
                }

                return listaPreset;
        }

        public JPanel getPanel() {
                return panelBorrarPreset;
        }

}
