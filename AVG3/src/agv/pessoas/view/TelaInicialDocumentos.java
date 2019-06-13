/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.pessoas.view;

import agv.jdbc.model.Funcionario;
import agv.login.view.TelaLogin;

/**
 * Tela inicial para os funcionários do setor de documentos.
 * @author Bruno Almeida Rabelo
 */
public class TelaInicialDocumentos extends javax.swing.JFrame {

    private final Funcionario funcLogado;
    
    /**
     * Creates new form TelaInicialDocumentos
     *
     * @param funcLogado
     */
    public TelaInicialDocumentos(Funcionario funcLogado) {
        initComponents();
        this.funcLogado = funcLogado;
        lblValorNome.setText(funcLogado.getNome() + ",");
        lblValorSetorECargo.setText(
                funcLogado.getCargo().getNomeCargo().toLowerCase()
                + " do setor de "
                + funcLogado.getSetor().getNomeSetor().toLowerCase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblValorNome = new javax.swing.JLabel();
        pnlCadastros = new javax.swing.JPanel();
        btnCriar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnDeslogar = new javax.swing.JButton();
        lblValorSetorECargo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela inicial");

        lblValorNome.setText("Bruno Almeida Rabelo,");

        pnlCadastros.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastros de clientes e funcionários"));

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCadastrosLayout = new javax.swing.GroupLayout(pnlCadastros);
        pnlCadastros.setLayout(pnlCadastrosLayout);
        pnlCadastrosLayout.setHorizontalGroup(
            pnlCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrosLayout.createSequentialGroup()
                .addComponent(btnCriar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover))
        );

        pnlCadastrosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCriar, btnEditar, btnListar, btnRemover});

        pnlCadastrosLayout.setVerticalGroup(
            pnlCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnCriar)
                .addComponent(btnEditar)
                .addComponent(btnListar)
                .addComponent(btnRemover))
        );

        btnDeslogar.setText("Deslogar");
        btnDeslogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeslogarActionPerformed(evt);
            }
        });

        lblValorSetorECargo.setText("coordenador do setor de documentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorNome)
                            .addComponent(lblValorSetorECargo))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeslogar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnlCadastros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValorNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValorSetorECargo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCadastros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDeslogar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Abre a tela onde pode ser feito o cadastro de pessoas.
     * @param evt 
     */
    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        TelaCadastroPessoas telaCadP = new TelaCadastroPessoas(funcLogado);
        telaCadP.setLocationRelativeTo(null);
        telaCadP.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCriarActionPerformed
    
    /**
     * Abre a tela onde pode ser feita a busca de uma pessoa para, depois, 
     * editar os seus dados.
     * @param evt 
     */
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        TelaBuscaParaEdicaoPessoas telaBusca;
        telaBusca = new TelaBuscaParaEdicaoPessoas(funcLogado);
        telaBusca.setLocationRelativeTo(null);
        telaBusca.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * Abre a tela onde se pode ver todas as pessoas cadastradas.
     * @param evt 
     */
    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        TelaListagemPessoas telaList = new TelaListagemPessoas(funcLogado);
        telaList.setLocationRelativeTo(null);
        telaList.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnListarActionPerformed
    
    /**
     * Abre a tela onde se pode remover pessoas.
     * @param evt 
     */
    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        TelaRemocaoPessoas telaRem = new TelaRemocaoPessoas(funcLogado);
        telaRem.setLocationRelativeTo(null);
        telaRem.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnRemoverActionPerformed

    /**
     * Desloga o funcionário do sistema e volta para a tela de login.
     * @param evt 
     */
    private void btnDeslogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeslogarActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnDeslogarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicialDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicialDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicialDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicialDocumentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicialDocumentos(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnDeslogar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel lblValorNome;
    private javax.swing.JLabel lblValorSetorECargo;
    private javax.swing.JPanel pnlCadastros;
    // End of variables declaration//GEN-END:variables
}