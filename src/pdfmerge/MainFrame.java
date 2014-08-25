/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdfmerge;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.util.PDFMergerUtility;

/**
 *
 * @author Paul
 */
public class MainFrame extends javax.swing.JFrame {

    private final DefaultListModel<String> pdfModel;
    private String sLastLoc;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        pdfModel = new DefaultListModel<>();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bMerge = new javax.swing.JButton();
        bClose = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bAddPdf = new javax.swing.JButton();
        bRemovePdf = new javax.swing.JButton();
        lStatus = new javax.swing.JLabel();
        bMoveUp = new javax.swing.JButton();
        bMoveDown = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_Close = new javax.swing.JMenu();
        menClose = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PDF Merge");
        setMinimumSize(new java.awt.Dimension(350, 250));

        bMerge.setText("Merge PDFs");
        bMerge.setEnabled(false);
        bMerge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMergeActionPerformed(evt);
            }
        });

        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });

        pdfList.setModel(pdfModel);
        pdfList.setDragEnabled(true);
        pdfList.setDropMode(javax.swing.DropMode.INSERT);
        pdfList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                pdfListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(pdfList);

        bAddPdf.setText("Add PDF");
        bAddPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddPdfActionPerformed(evt);
            }
        });

        bRemovePdf.setText("Remove Selected");
        bRemovePdf.setEnabled(false);
        bRemovePdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemovePdfActionPerformed(evt);
            }
        });

        lStatus.setText("PDFs will be appended in the order shown above");

        bMoveUp.setText("Move Up");
        bMoveUp.setEnabled(false);
        bMoveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMoveUpActionPerformed(evt);
            }
        });

        bMoveDown.setText("Move Down");
        bMoveDown.setEnabled(false);
        bMoveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMoveDownActionPerformed(evt);
            }
        });

        menu_Close.setText("File");

        menClose.setText("Close");
        menClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCloseActionPerformed(evt);
            }
        });
        menu_Close.add(menClose);

        jMenuBar1.add(menu_Close);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bMerge)
                        .addGap(18, 18, 18)
                        .addComponent(lStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                        .addComponent(bClose))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bAddPdf)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bRemovePdf)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bMoveDown, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bMoveUp, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bMoveUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bMoveDown)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bAddPdf)
                    .addComponent(bRemovePdf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bMerge)
                    .addComponent(bClose)
                    .addComponent(lStatus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menCloseActionPerformed

    private void bMergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMergeActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        //fc.setCurrentDirectory(new File(System.getProperty("user.home")));

        if (sLastLoc != null) {
            fc.setCurrentDirectory(new File(sLastLoc));
        }

        fc.setSelectedFile(new File("MyMerge.pdf"));
        boolean isMerged = false;
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fOut = fc.getSelectedFile();
            if (fOut.getName().endsWith(".pdf")) {
                isMerged = mergePDFs(fOut.getPath());
            } else {
                isMerged = mergePDFs(fOut.getPath() + ".pdf");
            }
            lStatus.setText("Done!");
            try {
                Desktop.getDesktop().open(fOut);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bMergeActionPerformed

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_bCloseActionPerformed

    private void bAddPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddPdfActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files",
                "pdf");
        fc.setFileFilter(filter);
        fc.setMultiSelectionEnabled(true);

        if (sLastLoc != null) {
            fc.setCurrentDirectory(new File(sLastLoc));
        }

        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            sLastLoc = fc.getSelectedFile().getPath();
            for (File f : fc.getSelectedFiles()) {
                pdfModel.addElement(f.getPath());
            }
            bMerge.setEnabled(true);
        }        
    }//GEN-LAST:event_bAddPdfActionPerformed

    private void bRemovePdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemovePdfActionPerformed
        // TODO add your handling code here:
        while (pdfList.getSelectedIndex() >= 0) {
            pdfModel.remove(pdfList.getSelectedIndex());
        }
        if(pdfModel.getSize() == 0)
            bMerge.setEnabled(false);
    }//GEN-LAST:event_bRemovePdfActionPerformed

    private void bMoveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoveUpActionPerformed
        // TODO add your handling code here:
        int nIndex = pdfList.getSelectedIndex();
        pdfModel.add(nIndex-1, pdfModel.get(nIndex));
        pdfModel.remove(nIndex+1);
        pdfList.setSelectedIndex(nIndex-1);
    }//GEN-LAST:event_bMoveUpActionPerformed

    private void pdfListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_pdfListValueChanged
        // TODO add your handling code here:
        int index = pdfList.getSelectedIndex();
        if(index >= 0)
        {
            if(index == pdfModel.size()-1)
                bMoveDown.setEnabled(false);
            else
                bMoveDown.setEnabled(true);
            
            if(index == 0)
                bMoveUp.setEnabled(false);
            else
                bMoveUp.setEnabled(true);
            
            bRemovePdf.setEnabled((true));
        }
        else
            bRemovePdf.setEnabled(false);
    }//GEN-LAST:event_pdfListValueChanged

    private void bMoveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoveDownActionPerformed
        // TODO add your handling code here:
        int nIndex = pdfList.getSelectedIndex();
        pdfModel.add(nIndex+2, pdfModel.get(nIndex));
        pdfModel.remove(nIndex);
        pdfList.setSelectedIndex(nIndex+1);
    }//GEN-LAST:event_bMoveDownActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAddPdf;
    private javax.swing.JButton bClose;
    private javax.swing.JButton bMerge;
    private javax.swing.JButton bMoveDown;
    private javax.swing.JButton bMoveUp;
    private javax.swing.JButton bRemovePdf;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lStatus;
    private javax.swing.JMenuItem menClose;
    private javax.swing.JMenu menu_Close;
    private final javax.swing.JList pdfList = new javax.swing.JList();
    // End of variables declaration//GEN-END:variables

    private boolean mergePDFs(String sDest) {
        PDFMergerUtility ut = new PDFMergerUtility();
        for (Object s : pdfModel.toArray()) {
            System.out.println("Merging " + s);
            ut.addSource((String) s);
        }

        ut.setDestinationFileName(sDest);
        System.out.println("Output Location: " + sDest);
        try {
            ut.mergeDocuments();
        } catch (IOException | COSVisitorException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
