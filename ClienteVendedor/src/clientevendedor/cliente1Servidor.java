
package clientevendedor;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;





public class cliente1Servidor extends javax.swing.JFrame {

   private static Socket cliente;
   
    public cliente1Servidor() {
        initComponents();
        iniciaCliente();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PrecoVenda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PrecoVenda.setText("Valor da venda");
        PrecoVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrecoVendaActionPerformed(evt);
            }
        });
        getContentPane().add(PrecoVenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 110, -1));

        jButton1.setText("Enviar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, -1, -1));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 110, 20));

        setSize(new java.awt.Dimension(416, 253));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       enviaPreco(PrecoVenda.getText());
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PrecoVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrecoVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PrecoVendaActionPerformed


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
            java.util.logging.Logger.getLogger(cliente1Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cliente1Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cliente1Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cliente1Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cliente1Servidor().setVisible(true);
            }
        });
    }

    private static void iniciaCliente(){
       try {
           cliente = new Socket("127.0.0.1",4027);
           System.out.println("Conectado ao servidor");
                   } catch (IOException ex) {
                       System.out.println("ERRO,servidor nao conectado");
       }
    }
    
    private void enviaPreco (String valor){
        PrintStream saida;
       try {
           saida = new PrintStream(cliente.getOutputStream());
           saida.println(valor);
           status.setText("OK");
       } catch (IOException ex) {
           status.setText("Erro");
       }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PrecoVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}
