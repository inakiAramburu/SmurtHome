package paneles;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import reconocimientoDeVoz.Escucha;
import reconocimientoDeVoz.Runee;
import src.Controlador;
import src.Preset;
import src.Uart;

public class PanelPrincipall extends JFrame {

        private JPanel panelHome;
        private JButton automaticoButton;
        private JButton bajarPButton;
        private JButton bajarTButton;
        private JFormattedTextField textTemperatura;
        public JButton luzButton;
        private JButton menuButon;
        private JButton microfonoButton;
        private JPanel panelPersiana;
        private JPanel panelRojo;
        private JPanel panelTemperatura;
        private JButton pararPButton;
        private JButton subirPButton;
        private JFormattedTextField titulo;
        private JButton upButton;

        Uart uart;
        String nombre;
        int temperatura = 20;
        int intensidad = 0;
        int persiana = 0;
        int microfono = 0;
        int automatico = 0;
        Controlador controlador;
        Preset preset;

        List<ImageIcon> luz;
        List<ImageIcon> automaticoIconList;
        List<ImageIcon> microfonoIconList;
        ImageIcon bombilla0, bombilla1, bombilla2, bombilla3, subirTemperatura, bajarTemperatua, subirPersiana,
                        bajarPersiana, pararPersiana;
        ImageIcon home, automaticoON, automaticoOFF, microfonoON, microfonoOFF, icono;

        Escucha escucha;
        Runnable r1;
        JLabel iconoLabel;
        Thread th1;

        public PanelPrincipall(Preset preset, Controlador controlador) {

                this.preset = preset;
                this.controlador = controlador;

                escucha = Escucha.getEscucha(controlador);
                System.out.println("hashcode: " + escucha.hashCode());

                // uart=new Uart(preset);
                // uart.start();
                luz = new ArrayList<ImageIcon>();
                automaticoIconList = new ArrayList<ImageIcon>();
                microfonoIconList = new ArrayList<ImageIcon>();
                /*
                 * r1 = new Runee(preset);
                 * th1 = new Thread(r1, "My new thread");
                 * th1.start();
                 */
                bombilla0 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla0.png");
                bombilla1 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla1.png");
                bombilla2 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla2.png");
                bombilla3 = new ImageIcon("iconos/PanelPrincipal/luz/bombilla3.png");
                subirTemperatura = new ImageIcon("iconos/PanelPrincipal/Temperatura/more.png");
                bajarTemperatua = new ImageIcon("iconos/PanelPrincipal/Temperatura/less.png");

                subirPersiana = new ImageIcon("iconos/PanelPrincipal/Persiana/up.png");
                bajarPersiana = new ImageIcon("iconos/PanelPrincipal/Persiana/down.png");
                pararPersiana = new ImageIcon("iconos/PanelPrincipal/Persiana/stop.png");

                automaticoON = new ImageIcon("iconos/PanelPrincipal/botones/automaticoON.png");
                automaticoOFF = new ImageIcon("iconos/PanelPrincipal/botones/automaticoOFF.png");

                microfonoON = new ImageIcon("iconos/PanelPrincipal/botones/microfonoON.png");
                microfonoOFF = new ImageIcon("iconos/PanelPrincipal/botones/microfonoOFF.png");

                icono = new ImageIcon("iconos/icono.png");
                iconoLabel = new javax.swing.JLabel();
                luz.add(bombilla0);
                luz.add(bombilla1);
                luz.add(bombilla2);
                luz.add(bombilla3);

                automaticoIconList.add(automaticoOFF);
                automaticoIconList.add(automaticoON);

                microfonoIconList.add(microfonoOFF);
                microfonoIconList.add(microfonoON);

                // horaingoa=preset;
                this.nombre = preset.getNombre();
                this.temperatura = preset.getTemperatura();
                this.intensidad = preset.getIntensidad();
                this.persiana = preset.getPersiana();
                this.microfono = preset.getMicrofono();
                // this.microfono=1;
                this.automatico = preset.getAutomatico();

                panelHome = new javax.swing.JPanel();
                panelTemperatura = new javax.swing.JPanel();
                upButton = new javax.swing.JButton();
                bajarTButton = new javax.swing.JButton();
                textTemperatura = new javax.swing.JFormattedTextField();
                luzButton = new javax.swing.JButton();
                panelPersiana = new javax.swing.JPanel();
                subirPButton = new javax.swing.JButton();
                pararPButton = new javax.swing.JButton();
                bajarPButton = new javax.swing.JButton();
                menuButon = new javax.swing.JButton();
                titulo = new javax.swing.JFormattedTextField();
                automaticoButton = new javax.swing.JButton();
                panelRojo = new javax.swing.JPanel();
                microfonoButton = new javax.swing.JButton();

                panelHome.setBackground(new java.awt.Color(36, 36, 36));
                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                panelTemperatura.setPreferredSize(new java.awt.Dimension(400, 260));
                panelTemperatura.setBackground(new java.awt.Color(36, 36, 36));

                upButton.setBackground(new java.awt.Color(58, 57, 80));
                upButton.setFont(new java.awt.Font("Product San", 0, 60));
                // upButton.setText("+");

                upButton.setIcon(new ImageIcon(subirTemperatura.getImage()));
                upButton.setToolTipText("");
                upButton.setBorder(null);
                upButton.setBorderPainted(false);
                upButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                upButtonActionPerformed(evt);
                        }
                });

                bajarTButton.setBackground(new java.awt.Color(58, 57, 80));
                bajarTButton.setFont(new java.awt.Font("Product San", 0, 60));
                // bajarTButton.setText("-");
                bajarTButton.setIcon(new ImageIcon(bajarTemperatua.getImage()));

                bajarTButton.setBorder(null);
                bajarTButton.setBorderPainted(false);
                bajarTButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bajarTButtonActionPerformed(evt);
                        }
                });

                textTemperatura.setEditable(false);
                textTemperatura.setBorder(null);
                textTemperatura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                textTemperatura.setText(temperatura + "");
                textTemperatura.setFont(new java.awt.Font("Product San", 0, 60));
                textTemperatura.setBackground(new java.awt.Color(36, 36, 36));
                textTemperatura.setForeground(new java.awt.Color(255, 255, 255));

                textTemperatura.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jFormattedTextField1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelTemperaturaLayout = new javax.swing.GroupLayout(panelTemperatura);
                panelTemperatura.setLayout(panelTemperaturaLayout);
                panelTemperaturaLayout.setHorizontalGroup(
                                panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(textTemperatura, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                400, Short.MAX_VALUE)
                                                .addComponent(bajarTButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE)
                                                .addComponent(upButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                Short.MAX_VALUE));
                panelTemperaturaLayout.setVerticalGroup(
                                panelTemperaturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelTemperaturaLayout.createSequentialGroup()
                                                                .addComponent(upButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                70,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(textTemperatura,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                120,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(bajarTButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                70,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                luzButton.setBackground(new java.awt.Color(58, 57, 80));
                luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));
                luzButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                luzButtonActionPerformed(evt);
                        }
                });

                panelPersiana.setPreferredSize(new java.awt.Dimension(400, 260));

                subirPButton.setFont(new java.awt.Font("Product San", 0, 60));
                // subirPButton.setText("Subir");
                subirPButton.setBorderPainted(false);
                subirPButton.setBackground(new java.awt.Color(58, 57, 80));
                subirPButton.setIcon(new ImageIcon(subirPersiana.getImage()));

                subirPButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                subirPButtonActionPerformed(evt);
                        }
                });

                pararPButton.setFont(new java.awt.Font("Product San", 0, 60));
                // pararPButton.setText("||");
                pararPButton.setIcon(new ImageIcon(pararPersiana.getImage()));
                pararPButton.setBorderPainted(false);
                pararPButton.setBackground(new java.awt.Color(58, 57, 80));

                pararPButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                pararPButtonActionPerformed(evt);
                        }
                });

                bajarPButton.setFont(new java.awt.Font("Product San", 0, 60));
                // bajarPButton.setText("Bajar");
                bajarPButton.setIcon(new ImageIcon(bajarPersiana.getImage()));
                bajarPButton.setBorderPainted(false);
                bajarPButton.setBackground(new java.awt.Color(58, 57, 80));

                bajarPButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                bajarPButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelPersianaLayout = new javax.swing.GroupLayout(panelPersiana);
                panelPersiana.setLayout(panelPersianaLayout);
                panelPersianaLayout.setHorizontalGroup(
                                panelPersianaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(pararPButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(bajarPButton, javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, 400,
                                                                Short.MAX_VALUE)
                                                .addComponent(subirPButton, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                panelPersianaLayout.setVerticalGroup(
                                panelPersianaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelPersianaLayout.createSequentialGroup()
                                                                .addComponent(subirPButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                86,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(pararPButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                86,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)
                                                                .addComponent(bajarPButton,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                86,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                menuButon.setBackground(new java.awt.Color(36, 36, 36));
                menuButon.setFont(new java.awt.Font("Product San", 0, 20));
                home = new ImageIcon("iconos/PanelPrincipal/casa.png");
                menuButon.setIcon(new ImageIcon(home.getImage()));
                menuButon.setBorder(null);
                menuButon.setBorderPainted(false);
                menuButon.setActionCommand("menu");
                menuButon.addActionListener(controlador);

                titulo.setEditable(false);
                titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                titulo.setText(nombre);
                titulo.setFont(new java.awt.Font("Product San", 0, 60));
                titulo.setBackground(new java.awt.Color(58, 58, 58));
                titulo.setForeground(new java.awt.Color(255, 255, 255));

                automaticoButton.setFont(new java.awt.Font("Product San", 0, 60));
                // automaticoButton.setText("Automatico");

                automaticoButton.setIcon(new ImageIcon(automaticoOFF.getImage()));
                automaticoButton.setIcon(new ImageIcon(automaticoIconList.get(preset.getAutomatico()).getImage()));

                automaticoButton.setBorderPainted(false);
                automaticoButton.setBackground(new java.awt.Color(36, 36, 36));

                automaticoButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                automaticoButtonActionPerformed(evt);
                        }
                });

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

                microfonoButton.setFont(new java.awt.Font("Product San", 0, 60));
                // microfonoButton.setText("Microfono");

                microfonoButton.setIcon(new ImageIcon(microfonoIconList.get(0).getImage()));
                microfonoButton.setBorderPainted(false);
                microfonoButton.setBackground(new java.awt.Color(36, 36, 36));

                microfonoButton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                microfonoButtonActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
                panelHome.setLayout(panelHomeLayout);
                panelHomeLayout.setHorizontalGroup(
                                panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelHomeLayout.createSequentialGroup()
                                                                .addGroup(panelHomeLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(90, 90, 90)
                                                                                                .addComponent(menuButon,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                150,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(titulo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                1000,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(panelRojo,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(160, 160, 160)
                                                                                                .addComponent(panelTemperatura,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(luzButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                360,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(60, 60, 60)
                                                                                                .addComponent(panelPersiana,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(250, 250, 250)
                                                                                                .addComponent(automaticoButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                350,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(400, 400, 400)
                                                                                                .addComponent(microfonoButton,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                350,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(90, 90, 90)));
                panelHomeLayout.setVerticalGroup(
                                panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout
                                                                .createSequentialGroup()
                                                                .addGap(80, 80, 80)
                                                                .addGroup(panelHomeLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(menuButon,
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
                                                                .addGroup(panelHomeLayout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(panelPersiana,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                258,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(panelHomeLayout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(panelHomeLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(panelTemperatura,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addGroup(panelHomeLayout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(luzButton,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                260,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)))
                                                                                                .addGap(100, 100, 100)
                                                                                                .addGroup(panelHomeLayout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(automaticoButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                140,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(microfonoButton,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                140,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(110, 110,
                                                                                                                110)))));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(panelHome,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, 0)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }

        private void bajarTButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
                if (temperatura > 17) {
                        temperatura--;
                        textTemperatura.setText(temperatura + "");
                }
                System.out.println(temperatura);
                preset.setTemperatura(temperatura);

        }

        private void upButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
                // TODO add your handling code here:
                if (temperatura < 30) {
                        temperatura++;
                        textTemperatura.setText(temperatura + "");

                }
                System.out.println(temperatura);
                preset.setTemperatura(temperatura);

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
                } else {
                        intensidad = 0;
                }
                System.out.println("Intensidad: " + intensidad);

                luzButton.setIcon(new ImageIcon(luz.get(intensidad).getImage()));
                preset.setIntensidad(intensidad);

        }

        private void bajarPButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
                persiana = 2;
                System.out.println(persiana);
                preset.setPersiana(persiana);
        }

        private void subirPButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
                persiana = 1;
                System.out.println(persiana);
                preset.setPersiana(persiana);

        }

        private void pararPButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
                persiana = 0;
                System.out.println(persiana);
                preset.setPersiana(persiana);
        }

        private void microfonoButtonActionPerformed(ActionEvent evt) {

                if (preset.getMicrofono() == 0) {
                        preset.setMicrofono(1);

                } else {
                        preset.setMicrofono(0);

                }
                microfonoButton.setIcon(new ImageIcon(microfonoIconList.get(preset.getMicrofono()).getImage()));

                System.out.println("microfono: " + preset.getMicrofono());
                microfono = preset.getMicrofono();

                escucha.escucha(microfono);

        }

        private void automaticoButtonActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:

                if (preset.getAutomatico() == 0) {
                        automatico = 1;
                        preset.setAutomatico(automatico);
                } else {
                        automatico = 0;
                        preset.setAutomatico(automatico);
                }

                automaticoButton.setIcon(new ImageIcon(automaticoIconList.get(preset.getAutomatico()).getImage()));

                System.out.println("automatico: " + automatico);
                preset.setAutomatico(automatico);
        }

        private void jFormattedTextField1ActionPerformed(ActionEvent evt) {
                // TODO add your handling code here:
        }

        public JPanel getPanel() {
                return panelHome;
        }

}
