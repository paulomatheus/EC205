/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.login.view;

import agencia.control.ValidarLogin;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import projetolab.PaginaInicial;
import agencia.model.Pessoas;
import projetolab.Viagem;


/**
 *
 * @author Leo
 */
public class TelaDeLogin extends javax.swing.JFrame {

    Pessoas[] pessoas = new Pessoas[100];
    Viagem[] viagens = new Viagem[100];

    /**
     * Creates new form TelaDeLogin
     */
    public TelaDeLogin() {
        //Construtor
        //Deixo sem permissão para maximizar o form(questão de estética)
        this.setResizable(false);
        //Abro meu form no meu da tela
        this.setLocationRelativeTo(null);
        this.setTitle("Projeto P.O.O.");
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

        labelLogin = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        textFieldLogin = new javax.swing.JTextField();
        passwordFieldLogin = new javax.swing.JPasswordField();
        buttonEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGV - Login");

        labelLogin.setText("Login:");

        labelSenha.setText("Senha:");

        textFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLoginActionPerformed(evt);
            }
        });

        passwordFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldLoginActionPerformed(evt);
            }
        });
        passwordFieldLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldLoginKeyPressed(evt);
            }
        });

        buttonEntrar.setText("Entrar");
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSenha)
                    .addComponent(labelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldLogin)
                    .addComponent(passwordFieldLogin))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(buttonEntrar)
                .addGap(86, 86, 86))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin)
                    .addComponent(textFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSenha)
                    .addComponent(passwordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonEntrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        // Ação do botão clicar
        ValidarLogin valida = new ValidarLogin();
        String[] dados = new String[4];
        String setor = "", cargo = "", loginLido = textFieldLogin.getText(), senhaLida = passwordFieldLogin.getText();

        boolean entrou = false;

        //Chamo o método para validar login
        dados = valida.validaLogin(textFieldLogin.getText(), passwordFieldLogin.getText());
        //Passo os retornos para as variaveis que guardem as caracteristicas do meu funcionario
        cargo = dados[2];
        setor = dados[3];
        //Verifico os dados retornados
        if (loginLido.equals(dados[0]) && senhaLida.equals(dados[1]) && !senhaLida.equals("")) {
            entrou = true;
            textFieldLogin.setText("");
            passwordFieldLogin.setText("");
            PaginaInicial home = new PaginaInicial(cargo, loginLido, setor, pessoas, viagens);
            home.setVisible(true);
            this.setVisible(false);
        }
        //Verifico se não está cadastrado
        if (dados[0] == "nulo") {
            JOptionPane.showMessageDialog(null, "Login ou senha invalido");
            textFieldLogin.setText("");
            passwordFieldLogin.setText("");
        }
    }//GEN-LAST:event_buttonEntrarActionPerformed

    private void passwordFieldLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldLoginKeyPressed
        // Ação caso seja pressionado Enter no campo de senha
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonEntrar.doClick();
        }
    }//GEN-LAST:event_passwordFieldLoginKeyPressed

    private void passwordFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldLoginActionPerformed

    private void textFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldLoginActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JPasswordField passwordFieldLogin;
    private javax.swing.JTextField textFieldLogin;
    // End of variables declaration//GEN-END:variables
}
