package gui.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author atuandev
 */
public class ThuocTinhPage extends javax.swing.JPanel {
    
    List<JPanel> listItem;

    public ThuocTinhPage() {
        initComponents();
        initLayout();
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
    }
    
    private void initLayout() {
        listItem = new ArrayList<>();
        listItem.add(danhMucItem);
        listItem.add(donViDoItem);
        listItem.add(xuatXuItem);
        listItem.add(nhaSanXuatItem);
        listItem.add(jPanel5);
        listItem.add(jPanel6);
        
        for (JPanel item : listItem) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePanel = new javax.swing.JPanel();
        danhMucItem = new javax.swing.JPanel();
        donViDoItem = new javax.swing.JPanel();
        xuatXuItem = new javax.swing.JPanel();
        nhaSanXuatItem = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(230, 245, 245));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout());

        tablePanel.setBackground(new java.awt.Color(230, 245, 245));
        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 40));
        tablePanel.setLayout(new java.awt.GridLayout(3, 4, 20, 20));

        danhMucItem.setBackground(new java.awt.Color(255, 255, 255));
        danhMucItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout danhMucItemLayout = new javax.swing.GroupLayout(danhMucItem);
        danhMucItem.setLayout(danhMucItemLayout);
        danhMucItemLayout.setHorizontalGroup(
            danhMucItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        danhMucItemLayout.setVerticalGroup(
            danhMucItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(danhMucItem);

        donViDoItem.setBackground(new java.awt.Color(255, 255, 255));
        donViDoItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout donViDoItemLayout = new javax.swing.GroupLayout(donViDoItem);
        donViDoItem.setLayout(donViDoItemLayout);
        donViDoItemLayout.setHorizontalGroup(
            donViDoItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        donViDoItemLayout.setVerticalGroup(
            donViDoItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(donViDoItem);

        xuatXuItem.setBackground(new java.awt.Color(255, 255, 255));
        xuatXuItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout xuatXuItemLayout = new javax.swing.GroupLayout(xuatXuItem);
        xuatXuItem.setLayout(xuatXuItemLayout);
        xuatXuItemLayout.setHorizontalGroup(
            xuatXuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        xuatXuItemLayout.setVerticalGroup(
            xuatXuItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(xuatXuItem);

        nhaSanXuatItem.setBackground(new java.awt.Color(255, 255, 255));
        nhaSanXuatItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout nhaSanXuatItemLayout = new javax.swing.GroupLayout(nhaSanXuatItem);
        nhaSanXuatItem.setLayout(nhaSanXuatItemLayout);
        nhaSanXuatItemLayout.setHorizontalGroup(
            nhaSanXuatItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        nhaSanXuatItemLayout.setVerticalGroup(
            nhaSanXuatItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(nhaSanXuatItem);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        tablePanel.add(jPanel6);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel danhMucItem;
    private javax.swing.JPanel donViDoItem;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel nhaSanXuatItem;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JPanel xuatXuItem;
    // End of variables declaration//GEN-END:variables
}
