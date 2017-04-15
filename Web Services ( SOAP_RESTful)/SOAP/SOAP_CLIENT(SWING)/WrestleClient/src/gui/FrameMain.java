package gui;

import ws.SearchClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import models.BoxModel;
import models.TableModels;
import ws.Fight;
import ws.GetAllFightsPpvResponse;
/**
 *
 * @author Serhii Khaliavin
 */
public class FrameMain extends javax.swing.JFrame {

      private static SearchClient searchClient = new SearchClient();
      private ArrayList<String> ppvList;
      public static int index_ppv;
      public static int index;
      public static ArrayList<Fight> fightList = new ArrayList<>();
       /**
     * Creates new form FrameMain
     */
    public FrameMain() {
       initComponents();
        fillPpv();
        fillCountries();
        fillTable();
        this.setResizable(false);
        this.setTitle("Purchase of tickets");
        
        jXBusyLabel1.setVisible(false);
        dateFlight.setDate(new Date());
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXImageView1 = new org.jdesktop.swingx.JXImageView();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jLabel1 = new javax.swing.JLabel();
        wppv = new javax.swing.JComboBox();
        wcity = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResult = new org.jdesktop.swingx.JXTable();
        dateFlight = new org.jdesktop.swingx.JXDatePicker();
        jLabel3 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        check = new org.jdesktop.swingx.JXButton();
        buy = new org.jdesktop.swingx.JXButton();
        jXBusyLabel1 = new org.jdesktop.swingx.JXBusyLabel();

        javax.swing.GroupLayout jXImageView1Layout = new javax.swing.GroupLayout(jXImageView1);
        jXImageView1.setLayout(jXImageView1Layout);
        jXImageView1Layout.setHorizontalGroup(
            jXImageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jXImageView1Layout.setVerticalGroup(
            jXImageView1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jXLabel1.setText("jXLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusTraversalPolicyProvider(true);

        jLabel1.setText("PPV-show");

        jLabel2.setText("Country");

        tableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableResult.setSortable(false);
        jScrollPane1.setViewportView(tableResult);

        jLabel3.setText("Date");

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo.png"))); // NOI18N
        check.setText("Check reservation");
        check.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        buy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buy.png"))); // NOI18N
        buy.setText("Buy");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(wppv, 0, 198, Short.MAX_VALUE)
                            .addComponent(wcity, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnSearch)
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(jXBusyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85)
                        .addComponent(buy, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(wppv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateFlight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(btnSearch))
                        .addGap(2, 2, 2)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(buy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jXBusyLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
 jXBusyLabel1.setVisible(true);
 jXBusyLabel1.setBusy(true);
 
 String ppv = (String) wppv.getSelectedItem();
 String country=(String)wcity.getSelectedItem();
String [] str=dateFlight.getDate().toString().split(" ");
String date=str[0]+" "+str[1]+" "+str[2]+" "+str[5];
 
 
 
 Future<?> searchCall = 
          searchClient.getAllFightPpvAsyncCallback(ppv, country, date, new AsyncHandler<GetAllFightsPpvResponse>() {
    @Override
    public void handleResponse(Response<GetAllFightsPpvResponse> res) {
        try {
            System.out.println(res.get().getReturn().size());
            fightList.clear();
            fightList.addAll(res.get().getReturn());
            
            tableResult.setModel(new TableModels(fightList) {});
            ((TableModels) tableResult.getModel()).fireTableDataChanged();
         
 
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage().replaceAll("ws.Exceptions_Exception: ", "") , "Error", JOptionPane.ERROR_MESSAGE);
        }
           jXBusyLabel1.setVisible(false);
 jXBusyLabel1.setBusy(false);
    
    }
});
      
    }//GEN-LAST:event_btnSearchActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed

if(tableResult.getSelectedRow()==-1){
  JOptionPane.showMessageDialog(null,"Choose the show!" , "Error", JOptionPane.ERROR_MESSAGE);
}else{
     index_ppv=tableResult.getSelectedRow();
     index=fightList.get(index_ppv).getId();
   
DialogBuy dialogbuy=new DialogBuy();
dialogbuy.setResizable(false);
dialogbuy.setTitle("Buy");
dialogbuy.setVisible(true);

}


    }//GEN-LAST:event_buyActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
   
        Check check=new Check();
        check.setResizable(false);
        check.setVisible(true);
        check.setTitle("Check");
      
    }//GEN-LAST:event_checkActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameMain().setVisible(true);
            }
        });
    }
    

    
     private void fillPpv() {
        ppvList = searchClient.getAllPpvs();      
        wppv.setModel(new BoxModel<String>(ppvList));
    }
     
     
     private void fillCountries() {
        ppvList = searchClient.getAllCountries();
        wcity.setModel(new BoxModel<String>(ppvList));
        
    }
     
     public static  void fillTable(){
     fightList.clear();
     fightList.addAll(searchClient.getAllFight());
     tableResult.setModel(new TableModels(fightList) {});
    ((TableModels) tableResult.getModel()).fireTableDataChanged();
        
     }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private org.jdesktop.swingx.JXButton buy;
    private org.jdesktop.swingx.JXButton check;
    private org.jdesktop.swingx.JXDatePicker dateFlight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXBusyLabel jXBusyLabel1;
    private org.jdesktop.swingx.JXImageView jXImageView1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private static org.jdesktop.swingx.JXTable tableResult;
    private javax.swing.JComboBox wcity;
    private javax.swing.JComboBox wppv;
    // End of variables declaration//GEN-END:variables

    
}
