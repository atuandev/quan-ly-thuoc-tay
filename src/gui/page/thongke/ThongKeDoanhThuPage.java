package gui.page.thongke;

import gui.barchart.ModelChart;
import java.awt.Color;

/**
 *
 * @author atuandev
 */
public class ThongKeDoanhThuPage extends javax.swing.JPanel {

    public ThongKeDoanhThuPage() {
        initComponents();
        initChart();
    }

    private void initChart() {
        chart.addLegend("Doanh thu", new Color(245, 189, 135));
        chart.addLegend("Chi phí", new Color(135, 189, 245));
        chart.addLegend("Lợi nhuận", new Color(189, 135, 245));
        chart.addData(new ModelChart("Tháng 1", new double[]{1200, 200, 80}));
        chart.addData(new ModelChart("Tháng 2", new double[]{600, 750, 90}));
        chart.addData(new ModelChart("Tháng 3", new double[]{200, 350, 460}));
        chart.addData(new ModelChart("Tháng 4", new double[]{480, 150, 750}));
        chart.addData(new ModelChart("Tháng 5", new double[]{350, 540, 300}));
        chart.addData(new ModelChart("Tháng 6", new double[]{190, 280, 81}));
        chart.addData(new ModelChart("Tháng 7", new double[]{350, 540, 300}));
        chart.addData(new ModelChart("Tháng 8", new double[]{190, 280, 81}));
        chart.addData(new ModelChart("Tháng 9", new double[]{350, 540, 300}));
        chart.addData(new ModelChart("Tháng 10", new double[]{190, 280, 81}));
        chart.addData(new ModelChart("Tháng 11", new double[]{350, 540, 300}));
        chart.addData(new ModelChart("Tháng 12", new double[]{190, 280, 81}));
        
        chart.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        chart = new gui.barchart.Chart();

        setBackground(new java.awt.Color(230, 245, 245));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(230, 245, 245), 6, true));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout(0, 6));

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 200));
        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(chart, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.barchart.Chart chart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
