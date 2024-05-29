package gui.page;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import gui.dialog.ThuocTinhDanhMucDialog;
import gui.dialog.ThuocTinhDonViTinhDialog;
import gui.dialog.ThuocTinhXuatXuDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;

/**
 *
 * @author atuandev
 */
public class ThuocTinhPage extends javax.swing.JPanel {
    
    List<JButton> listItem;

    public ThuocTinhPage() {
        initComponents();
        initLayout();
    }
    
    private void initLayout() {
        listItem = new ArrayList<>();
        listItem.add(danhMucItem);
        listItem.add(donViTinhItem);
        listItem.add(xuatXuItem);
        
        // Border radius
        for (JButton item : listItem) {
            item.putClientProperty(FlatClientProperties.STYLE, "arc: 15");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablePanel = new javax.swing.JPanel();
        danhMucItem = new javax.swing.JButton();
        donViTinhItem = new javax.swing.JButton();
        xuatXuItem = new javax.swing.JButton();

        setBackground(new java.awt.Color(230, 245, 245));
        setMinimumSize(new java.awt.Dimension(1130, 800));
        setPreferredSize(new java.awt.Dimension(1130, 800));
        setLayout(new java.awt.BorderLayout());

        tablePanel.setBackground(new java.awt.Color(230, 245, 245));
        tablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 245, 245), 40));
        tablePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablePanel.setLayout(new java.awt.GridLayout(3, 4, 20, 20));

        danhMucItem.setFont(new java.awt.Font("Roboto Mono Medium", 0, 36)); // NOI18N
        danhMucItem.setForeground(new java.awt.Color(51, 51, 51));
        danhMucItem.setIcon(new FlatSVGIcon("./icon/category.svg"));
        danhMucItem.setText("DANH MỤC THUỐC");
        danhMucItem.setBorder(null);
        danhMucItem.setBorderPainted(false);
        danhMucItem.setFocusPainted(false);
        danhMucItem.setIconTextGap(16);
        danhMucItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                danhMucItemActionPerformed(evt);
            }
        });
        tablePanel.add(danhMucItem);

        donViTinhItem.setFont(new java.awt.Font("Roboto Mono Medium", 0, 36)); // NOI18N
        donViTinhItem.setForeground(new java.awt.Color(51, 51, 51));
        donViTinhItem.setIcon(new FlatSVGIcon("./icon/unit.svg"));
        donViTinhItem.setText("ĐƠN VỊ TÍNH");
        donViTinhItem.setBorder(null);
        donViTinhItem.setBorderPainted(false);
        donViTinhItem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        donViTinhItem.setFocusPainted(false);
        donViTinhItem.setIconTextGap(16);
        donViTinhItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                donViTinhItemActionPerformed(evt);
            }
        });
        tablePanel.add(donViTinhItem);

        xuatXuItem.setFont(new java.awt.Font("Roboto Mono Medium", 0, 36)); // NOI18N
        xuatXuItem.setForeground(new java.awt.Color(51, 51, 51));
        xuatXuItem.setIcon(new FlatSVGIcon("./icon/map.svg"));
        xuatXuItem.setText("XUẤT XỨ");
        xuatXuItem.setBorder(null);
        xuatXuItem.setBorderPainted(false);
        xuatXuItem.setFocusPainted(false);
        xuatXuItem.setIconTextGap(16);
        xuatXuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xuatXuItemActionPerformed(evt);
            }
        });
        tablePanel.add(xuatXuItem);

        add(tablePanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void danhMucItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_danhMucItemActionPerformed
        ThuocTinhDanhMucDialog dialog = new ThuocTinhDanhMucDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_danhMucItemActionPerformed

    private void donViTinhItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_donViTinhItemActionPerformed
        ThuocTinhDonViTinhDialog dialog = new ThuocTinhDonViTinhDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_donViTinhItemActionPerformed

    private void xuatXuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xuatXuItemActionPerformed
        ThuocTinhXuatXuDialog dialog = new ThuocTinhXuatXuDialog(null, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_xuatXuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton danhMucItem;
    private javax.swing.JButton donViTinhItem;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton xuatXuItem;
    // End of variables declaration//GEN-END:variables
}
