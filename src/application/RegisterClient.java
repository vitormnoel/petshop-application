/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javax.swing.JOptionPane;
import model.Client;
import models.dao.ClientDao;
import models.dao.DaoFactory;

/**
 *
 * @author Vitor Manoel
 */
public class RegisterClient extends javax.swing.JFrame{
    
    private String pass;
    
    public RegisterClient() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        button_signin = new javax.swing.JToggleButton();
        button_register = new javax.swing.JToggleButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        label_name = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_pass = new javax.swing.JLabel();
        label_cpf = new javax.swing.JLabel();
        label_tel = new javax.swing.JLabel();
        label_adress = new javax.swing.JLabel();
        text_conf_password = new javax.swing.JPasswordField();
        text_password = new javax.swing.JPasswordField();
        text_email = new javax.swing.JTextField();
        text_tel = new javax.swing.JTextField();
        text_adress = new javax.swing.JTextField();
        text_name = new javax.swing.JTextField();
        text_cpf = new javax.swing.JTextField();
        init_button = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(770, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator2.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 340, 30));

        jSeparator3.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator3.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 340, 30));

        jSeparator4.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator4.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 340, 30));

        jSeparator5.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator5.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 340, 30));

        jSeparator6.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator6.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 410, 340, 30));

        jSeparator7.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator7.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 160, 340, 30));

        jSeparator1.setBackground(new java.awt.Color(209, 155, 52));
        jSeparator1.setForeground(new java.awt.Color(209, 155, 52));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 340, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(209, 155, 52));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CADASTRO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 350, 40));

        button_signin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bottom---login.png"))); // NOI18N
        button_signin.setBorderPainted(false);
        button_signin.setContentAreaFilled(false);
        button_signin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_signin.setFocusPainted(false);
        button_signin.setFocusable(false);
        button_signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_signinActionPerformed(evt);
            }
        });
        getContentPane().add(button_signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 120, -1));

        button_register.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bottom-cadastrar.png"))); // NOI18N
        button_register.setBorderPainted(false);
        button_register.setContentAreaFilled(false);
        button_register.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button_register.setFocusPainted(false);
        button_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_registerActionPerformed(evt);
            }
        });
        getContentPane().add(button_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 440, 130, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(209, 155, 52));
        jLabel7.setText("Confirmar senha:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, -1, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(209, 155, 52));
        jLabel1.setText("Já possui conta?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 130, 40));

        label_name.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_name.setForeground(new java.awt.Color(209, 155, 52));
        label_name.setText("Nome:");
        getContentPane().add(label_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 60, 40));

        label_email.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_email.setForeground(new java.awt.Color(209, 155, 52));
        label_email.setText("Email:");
        getContentPane().add(label_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 70, 40));

        label_pass.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_pass.setForeground(new java.awt.Color(209, 155, 52));
        label_pass.setText("Senha:");
        getContentPane().add(label_pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, 80, 40));

        label_cpf.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_cpf.setForeground(new java.awt.Color(209, 155, 52));
        label_cpf.setText("CPF:");
        getContentPane().add(label_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 60, 40));

        label_tel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_tel.setForeground(new java.awt.Color(209, 155, 52));
        label_tel.setText("Telefone:");
        getContentPane().add(label_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, 80, 40));

        label_adress.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        label_adress.setForeground(new java.awt.Color(209, 155, 52));
        label_adress.setText("Endereço:");
        getContentPane().add(label_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 90, 40));

        text_conf_password.setBackground(new java.awt.Color(254, 232, 231));
        text_conf_password.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_conf_password.setForeground(new java.awt.Color(209, 155, 52));
        text_conf_password.setBorder(null);
        text_conf_password.setCaretColor(new java.awt.Color(209, 155, 52));
        text_conf_password.setMinimumSize(new java.awt.Dimension(138, 26));
        text_conf_password.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_conf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 190, 40));

        text_password.setBackground(new java.awt.Color(254, 232, 231));
        text_password.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_password.setForeground(new java.awt.Color(209, 155, 52));
        text_password.setBorder(null);
        text_password.setCaretColor(new java.awt.Color(209, 155, 52));
        text_password.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 280, 40));

        text_email.setBackground(new java.awt.Color(254, 232, 231));
        text_email.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_email.setForeground(new java.awt.Color(209, 155, 52));
        text_email.setToolTipText("email");
        text_email.setBorder(null);
        text_email.setCaretColor(new java.awt.Color(209, 155, 52));
        text_email.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 280, 40));

        text_tel.setBackground(new java.awt.Color(254, 232, 231));
        text_tel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_tel.setForeground(new java.awt.Color(209, 155, 52));
        text_tel.setToolTipText("tel");
        text_tel.setBorder(null);
        text_tel.setCaretColor(new java.awt.Color(209, 155, 52));
        text_tel.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 250, 40));

        text_adress.setBackground(new java.awt.Color(254, 232, 231));
        text_adress.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_adress.setForeground(new java.awt.Color(209, 155, 52));
        text_adress.setToolTipText("endereço");
        text_adress.setBorder(null);
        text_adress.setCaretColor(new java.awt.Color(209, 155, 52));
        text_adress.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_adress, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 250, 40));

        text_name.setBackground(new java.awt.Color(254, 232, 231));
        text_name.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_name.setForeground(new java.awt.Color(209, 155, 52));
        text_name.setToolTipText("nome");
        text_name.setBorder(null);
        text_name.setCaretColor(new java.awt.Color(209, 155, 52));
        text_name.setSelectionColor(new java.awt.Color(255, 255, 255));
        text_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_nameActionPerformed(evt);
            }
        });
        getContentPane().add(text_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 280, 40));

        text_cpf.setBackground(new java.awt.Color(254, 232, 231));
        text_cpf.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        text_cpf.setForeground(new java.awt.Color(209, 155, 52));
        text_cpf.setToolTipText("cpf");
        text_cpf.setBorder(null);
        text_cpf.setCaretColor(new java.awt.Color(209, 155, 52));
        text_cpf.setSelectionColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(text_cpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 300, 40));

        init_button.setForeground(new java.awt.Color(255, 255, 255));
        init_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/bottom-inicio.png"))); // NOI18N
        init_button.setBorderPainted(false);
        init_button.setContentAreaFilled(false);
        init_button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        init_button.setFocusPainted(false);
        init_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                init_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(init_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 130, 40));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N
        getContentPane().add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 330, 490));

        background.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/FUNDO-ROSA.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_signinActionPerformed
        dispose();
        
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_button_signinActionPerformed

    private void button_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_registerActionPerformed
        ClientDao clientDao = DaoFactory.createClientDao();
        Client client = new Client();
        
        if(text_password.getText().equals(text_conf_password.getText())){
            client.setName(text_name.getText());
            int cpf = Integer.parseInt(text_cpf.getText());
            client.setId(cpf);
            client.setAdress(text_adress.getText());
            client.setTel(Integer.parseInt(text_tel.getText()));
            client.setEmail(text_email.getText());
            client.setPass(text_password.getText());
            client.setControler(1);
                    
            clientDao.insert(client);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!", "", 1);
            
            dispose();
            
            Login login = new Login();
            login.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null, "As senhas não são iguais", "ERRO", 0);
        }
    }//GEN-LAST:event_button_registerActionPerformed

    private void text_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_nameActionPerformed
        
    }//GEN-LAST:event_text_nameActionPerformed

    private void init_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_init_buttonActionPerformed
        dispose();
        
        InitialScreen init = new InitialScreen();
        init.setVisible(true);
    }//GEN-LAST:event_init_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new RegisterClient().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JToggleButton button_register;
    private javax.swing.JToggleButton button_signin;
    private javax.swing.JButton init_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel label_adress;
    private javax.swing.JLabel label_cpf;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_name;
    private javax.swing.JLabel label_pass;
    private javax.swing.JLabel label_tel;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField text_adress;
    private javax.swing.JPasswordField text_conf_password;
    private javax.swing.JTextField text_cpf;
    private javax.swing.JTextField text_email;
    private javax.swing.JTextField text_name;
    private javax.swing.JPasswordField text_password;
    private javax.swing.JTextField text_tel;
    // End of variables declaration//GEN-END:variables
}
