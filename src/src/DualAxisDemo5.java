/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc. 
 * in the United States and other countries.]
 *
 * ------------------
 * DualAxisDemo5.java
 * ------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited and Contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * $Id: DualAxisDemo5.java,v 1.12 2004/04/29 07:54:56 mungady Exp $
 *
 * Changes
 * -------
 * 19-Sep-2003 : Version 1 (DG);
 * 06-Feb-2004 : Modified to correct legend (DG);
 *
 */

package src;
import java.awt.Color;

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
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * This demo shows how to create a dual axis bar chart.  A workaround is used because the
 * {@link BarRenderer} and {@link CategoryAxis} classes will overlap the bars for the two 
 * datasets - to get around this, an an additional series (containing 'null' values) is added 
 * to each dataset, and the getLegendItems() method in the plot is overridden.
 *
 */
public class DualAxisDemo5 extends ApplicationFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title  the frame title.
     */
    public DualAxisDemo5(final String title) {
        super(title);
        final CategoryDataset dataset1 = createDataset1();
        
        final JFreeChart chart = createChart(dataset1);
        final JPanel chartPanel = new ChartPanel(chart);
        
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset1() {

        // row keys...
        final String series1 = "Consumo";
        

        // column keys...
        final String category1 = "Lunes";
        final String category2 = "Martes";
        final String category3 = "Miercoles";
        final String category4 = "Jueves";
        final String category5 = "Viernes";
        final String category6 = "Sabado";
        final String category7 = "Domingo";


        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(1.0, series1, category1);
        dataset.addValue(4.0, series1, category2);
        dataset.addValue(3.0, series1, category3);
        dataset.addValue(5.0, series1, category4);
        dataset.addValue(5.0, series1, category5);
        dataset.addValue(5.0, series1, category6);
        dataset.addValue(5.0, series1, category7);
        return dataset;

    }

    
    private JFreeChart createChart(final CategoryDataset dataset1) {

        final CategoryAxis domainAxis = new CategoryAxis("Dias de la semana");
        final NumberAxis rangeAxis = new NumberAxis("Consumo");
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
        chart.setBackgroundPaint(new Color(36, 36, 36));
//        chart.getLegend().setAnchor(Legend.SOUTH);
        plot.setBackgroundPaint(new Color(36, 36, 36));
        plot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
       
        
        //cabiar el color de letra del plot
        plot.getDomainAxis().setLabelPaint(new Color(255, 255, 255));
        //(new java.awt.Color(255, 255, 255));
        plot.getRangeAxis().setLabelPaint(new Color(255, 255, 255));

        plot.getRangeAxis().setTickLabelPaint(new Color(255, 255, 255));
        plot.getDomainAxis().setTickLabelPaint(new Color(255, 255, 255));
        plot.getRangeAxis().setTickLabelFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 15));
        plot.getDomainAxis().setTickLabelFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 15));


        plot.mapDatasetToRangeAxis(1, 1);

        Byte bd[]=new Byte[7];

        

        
        
      
        plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        final BarRenderer renderer2 = new BarRenderer();
        plot.setRenderer(1, renderer2);
        
        return chart;
    }
    
    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final DualAxisDemo5 demo = new DualAxisDemo5("Dual Axis Demo 5");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}