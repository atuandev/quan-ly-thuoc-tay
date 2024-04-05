package gui.page.thongke;

/**
 *
 * @author atuandev
 */
public class ThongKePage extends javax.swing.JPanel {

    public ThongKePage() {
        initComponents();
        initLayout();
    }

    private void initLayout() {

        tabPane.addTab("Tổng quan", new ThongKeTongQuanPage());
        tabPane.addTab("Doanh thu", new ThongKeDoanhThuPage());
        
        this.add(tabPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(230, 245, 245));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout(0, 6));

        tabPane.setBackground(new java.awt.Color(255, 255, 255));
        tabPane.setPreferredSize(new java.awt.Dimension(100, 30));
        add(tabPane, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}