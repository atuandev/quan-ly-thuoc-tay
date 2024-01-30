package gui.panel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;

/**
 *
 * @author atuandev
 */
public class SanPhamPage extends javax.swing.JPanel {

    public SanPhamPage() {
        initComponents();
        headerLayout();
        FlatIntelliJLaf.registerCustomDefaultsSource("style");
        FlatIntelliJLaf.setup();
    }

    private void headerLayout() {
        headerPanel.putClientProperty(FlatClientProperties.STYLE, "arc: 80");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(230, 245, 245));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(255, 255, 255));
        headerPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 10));

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(headerPanel, java.awt.BorderLayout.PAGE_START);

        tablePanel.setBackground(new java.awt.Color(255, 255, 255));
        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 10));
        tablePanel.setLayout(new java.awt.BorderLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ád", "ấdasd", "ád", "ádasd"},
                {"ádasd", "zxcxzc", "qưeqwe", "qưeqw"},
                {"ádasd", "qưeqwe", "qưeqwe", ""},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFocusable(false);
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setHeaderValue("Title 1");
            table.getColumnModel().getColumn(1).setHeaderValue("Title 2");
            table.getColumnModel().getColumn(2).setHeaderValue("Title 3");
            table.getColumnModel().getColumn(3).setHeaderValue("Title 4");
        }

        tablePanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables
}
