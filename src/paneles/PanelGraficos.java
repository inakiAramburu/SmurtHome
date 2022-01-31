package paneles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import src.Controlador;

public class PanelGraficos extends JFrame {

    JButton homeButon;
    JPanel panelGraficos;
    JPanel panelRojo;
    JFormattedTextField titulo;
    Controlador controlador;
    ImageIcon home, icono;
    JLabel iconoLabel;
    JPanel panelGraficoDias;

    JPanel jPanel1;

    public PanelGraficos(Controlador controlador) {
        this.controlador = controlador;

        panelGraficos = new javax.swing.JPanel();
        homeButon = new javax.swing.JButton();
        titulo = new javax.swing.JFormattedTextField();
        panelRojo = new javax.swing.JPanel();
        panelGraficoDias = new javax.swing.JPanel();
        iconoLabel = new javax.swing.JLabel();

        jPanel1 = createDemoPanel();
        jPanel1.setPreferredSize(new java.awt.Dimension(1304, 500));
        icono = new ImageIcon("iconos/icono.png");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        homeButon.setBackground(new java.awt.Color(36, 36, 36));
        homeButon.setFont(new java.awt.Font("Product San", 0, 20));
        home = new ImageIcon("iconos/PanelPrincipal/casa.png");
        homeButon.setIcon(new ImageIcon(home.getImage()));
        homeButon.setBorder(null);
        homeButon.setBorderPainted(false);
        homeButon.setActionCommand("home");
        homeButon.addActionListener(controlador);

        titulo.setEditable(false);
        titulo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        titulo.setText("Horas de consumo");
        titulo.setFont(new java.awt.Font("Product San", 0, 60));
        titulo.setBackground(new java.awt.Color(58, 58, 58));
        titulo.setForeground(new java.awt.Color(255, 255, 255));

        //////////////////////
        panelRojo.setBackground(new java.awt.Color(36, 36, 36));
        panelRojo.setPreferredSize(new java.awt.Dimension(150, 150));

        iconoLabel.setIcon(icono);

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRojoLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelRojoLayout.setVerticalGroup(
                panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRojoLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(iconoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));
        //////////////////////

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1304, Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 500, Short.MAX_VALUE));

        javax.swing.GroupLayout panelGraficoDiasLayout = new javax.swing.GroupLayout(panelGraficoDias);
        panelGraficoDias.setLayout(panelGraficoDiasLayout);
        panelGraficoDiasLayout.setHorizontalGroup(
                panelGraficoDiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        panelGraficoDiasLayout.setVerticalGroup(
                panelGraficoDiasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        javax.swing.GroupLayout panelGraficosLayout = new javax.swing.GroupLayout(panelGraficos);
        panelGraficos.setBackground(new java.awt.Color(36, 36, 36));
        panelGraficos.setLayout(panelGraficosLayout);
        panelGraficosLayout.setHorizontalGroup(
                panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelGraficosLayout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86,
                                        Short.MAX_VALUE)
                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 999,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90))
                        .addGroup(panelGraficosLayout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(panelGraficoDias, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        panelGraficosLayout.setVerticalGroup(
                panelGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                panelGraficosLayout.createSequentialGroup()
                                        .addGap(80, 80, 80)
                                        .addGroup(panelGraficosLayout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(homeButon, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 150,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(91, 91, 91)
                                        .addComponent(panelGraficoDias, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(109, 109, 109)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelGraficos, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panelGraficos, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();

    }

    public JPanel getPanel() {
        return panelGraficos;
    }

    public static JPanel createDemoPanel() {

        final CategoryDataset dataset1 = createDataset1();

        final JFreeChart chart = createChart(dataset1);
        final JPanel chartPanel = new ChartPanel(chart);

        return chartPanel;
    }

    private static CategoryDataset createDataset1() {

        // row keys...
        final String series1 = "Consumo";

        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<LocalDate, Integer> datosConsumo = null;
        try {
            datosConsumo = leerDatosConsumo();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // optener las ultimas 7 dias
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaInicio = fechaActual.minusDays(6);
        LocalDate fechaFin = fechaActual;

        while (fechaInicio.isBefore(fechaFin.plusDays(1))) {
            if (datosConsumo.containsKey(fechaInicio)) {
                dataset.addValue((datosConsumo.get(fechaInicio) / 60) / 60, series1,
                        traducirDia(fechaInicio.getDayOfWeek().toString()));
            } else {
                dataset.addValue(0, series1, traducirDia(fechaInicio.getDayOfWeek().toString()));
            }
            fechaInicio = fechaInicio.plusDays(1);

        }

        return dataset;

    }

    private static Comparable traducirDia(String string) {

        // traduce los dias de la semana
        switch (string) {
            case "MONDAY":
                return "Lunes";
            case "TUESDAY":
                return "Martes";
            case "WEDNESDAY":
                return "Miercoles";
            case "THURSDAY":
                return "Jueves";
            case "FRIDAY":
                return "Viernes";
            case "SATURDAY":
                return "Sabado";
            case "SUNDAY":
                return "Domingo";
            default:
                return "";

        }

    }

    private static JFreeChart createChart(final CategoryDataset dataset1) {

        final CategoryAxis domainAxis = new CategoryAxis();
        final NumberAxis rangeAxis = new NumberAxis();
        final BarRenderer renderer1 = new BarRenderer();
        final CategoryPlot plot = new CategoryPlot(dataset1, domainAxis, rangeAxis, renderer1) {

            /**
             * Override the getLegendItems() method to handle special case.
             *
             * @return the legend items.
             */
            public LegendItemCollection getLegendItems() {

                final LegendItemCollection result = new LegendItemCollection();

                final CategoryDataset data = getDataset();
                if (data != null) {
                    final CategoryItemRenderer r = getRenderer();
                    if (r != null) {
                        final LegendItem item = r.getLegendItem(0, 0);
                        result.add(item);
                    }
                }

                // the JDK 1.2.2 compiler complained about the name of this
                // variable
                final CategoryDataset dset2 = getDataset(1);
                if (dset2 != null) {
                    final CategoryItemRenderer renderer2 = getRenderer(1);
                    if (renderer2 != null) {
                        final LegendItem item = renderer2.getLegendItem(1, 1);
                        result.add(item);
                    }
                }

                return result;

            }

        };

        final JFreeChart chart = new JFreeChart(plot);
        chart.setBackgroundPaint(new java.awt.Color(36, 36, 36));
        // chart.getLegend().setAnchor(Legend.SOUTH);
        plot.setBackgroundPaint(new java.awt.Color(36, 36, 36));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

        // cabiar el color de letra del plot
        plot.getDomainAxis().setLabelPaint(new java.awt.Color(255, 255, 255));

        // (new java.awt.Color(255, 255, 255));
        plot.getRangeAxis().setLabelPaint(new java.awt.Color(255, 255, 255));

        plot.getRangeAxis().setTickLabelPaint(new java.awt.Color(255, 255, 255));
        plot.getDomainAxis().setTickLabelPaint(new java.awt.Color(255, 255, 255));
        plot.getRangeAxis().setTickLabelFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 15));
        plot.getDomainAxis().setTickLabelFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 15));

        plot.mapDatasetToRangeAxis(1, 1);

        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        final BarRenderer renderer2 = new BarRenderer();
        plot.setRenderer(1, renderer2);

        return chart;
    }

    private static Map<LocalDate, Integer> leerDatosConsumo() throws ClassNotFoundException {

        FileInputStream ficheroEntrada = null;
        Map<LocalDate, Integer> listaConsumos = new HashMap<LocalDate, Integer>();
        try {
            ficheroEntrada = new FileInputStream("datosConsumo.bin");
            try (ObjectInputStream tuberia = new ObjectInputStream(ficheroEntrada)) {
                listaConsumos = (Map<LocalDate, Integer>) tuberia.readObject();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {

            ex.printStackTrace();
        }

        return listaConsumos;
    }

}
