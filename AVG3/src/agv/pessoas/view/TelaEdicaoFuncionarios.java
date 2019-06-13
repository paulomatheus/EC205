/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.pessoas.view;

import agv.jdbc.control.ManipuladorFuncionarios;
import agv.exceptions.ErroCadastroException;
import agv.exceptions.ValorInvalidoException;
import agv.jdbc.model.Cargos;
import agv.jdbc.model.Funcionario;
import agv.jdbc.model.Setores;
import javax.swing.JOptionPane;

/**
 * Tela onde o usuário pode editar os dados de um funcionário.
 * @author Bruno Almeida Rabelo
 */
public class TelaEdicaoFuncionarios extends javax.swing.JFrame {

    private final Funcionario funcLogado;
    private Funcionario funcAEditar;

    /**
     * Creates new form TelaCadastroPessoas
     *
     * @param funcLogado
     */
    public TelaEdicaoFuncionarios(Funcionario funcLogado, Funcionario funcAEditar) {
        initComponents();
        this.funcLogado = funcLogado;
        this.funcAEditar = funcAEditar;

        Setores setores[] = Setores.values();
        cmbSetor.removeAllItems();
        cmbSetor.addItem("Selecionar");
        for (Setores setor : setores) {
            cmbSetor.addItem(setor.getNomeSetor());
        }
        Cargos cargos[] = Cargos.values();
        cmbCargo.removeAllItems();
        cmbCargo.addItem("Selecionar");
        for (Cargos cargo : cargos) {
            cmbCargo.addItem(cargo.getNomeCargo());
        }

        this.txtNome.setText(funcAEditar.getNome());
        this.txtCpf.setText(funcAEditar.getCpf());
        this.txtEmail.setText(funcAEditar.getEmail());
        this.txtLogin.setText(funcAEditar.getLogin());
        this.pswSenha.setText(funcAEditar.getSenha());
        this.pswConfirmarSenha.setText(funcAEditar.getSenha());
        this.cmbSetor.selectWithKeyChar(funcAEditar.getSetor().getNomeSetor().charAt(0));
        this.cmbCargo.selectWithKeyChar(funcAEditar.getCargo().getNomeCargo().charAt(0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblCpf = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSetor = new javax.swing.JLabel();
        cmbSetor = new javax.swing.JComboBox<>();
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        pswConfirmarSenha = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        btnSalvarAlteracoes = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de pessoas");

        lblNome.setText("Nome:");

        lblCpf.setText("CPF:");

        lblEmail.setText("Email:");

        lblSetor.setText("Setor:");

        cmbSetor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCargo.setText("Cargo:");

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblLogin.setText("Login:");

        lblSenha.setText("Senha:");

        lblConfirmarSenha.setText("Confirmar senha:");

        btnSalvarAlteracoes.setText("Salvar alterações");
        btnSalvarAlteracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarAlteracoesActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalvarAlteracoes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNome, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCpf, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblEmail)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEmail))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblSetor, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblCargo, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblConfirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtLogin)
                                    .addComponent(pswSenha)
                                    .addComponent(pswConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnSalvarAlteracoes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCpf)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSetor)
                    .addComponent(cmbSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargo)
                    .addComponent(cmbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSenha)
                    .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirmarSenha)
                    .addComponent(pswConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarAlteracoes)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        TelaInicialDocumentos telaIniDocs;
        telaIniDocs = new TelaInicialDocumentos(funcLogado);
        telaIniDocs.setLocationRelativeTo(null);
        telaIniDocs.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarAlteracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarAlteracoesActionPerformed
        if (passouNaPreValidacao()) {
            try {
                editaFuncionario();
                JOptionPane.showMessageDialog(rootPane, "Alterações salvas "
                        + "com sucesso!", "Edição",
                        JOptionPane.INFORMATION_MESSAGE);
                TelaBuscaParaEdicaoPessoas telaBusca;
                telaBusca = new TelaBuscaParaEdicaoPessoas(funcLogado);
                telaBusca.setLocationRelativeTo(null);
                telaBusca.setVisible(true);
                dispose();
            } catch (ValorInvalidoException | ErroCadastroException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarAlteracoesActionPerformed

    /**
     * Verifica se o usuário deixou algum campo em branco, deixou de selecionar
     * um setor e um cargo ou se digitou duas senhas diferentes nos campos
     * Senha e Confirmar senha.
     * @return 
     */
    private boolean passouNaPreValidacao() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String setor = cmbSetor.getSelectedItem().toString();
        String cargo = cmbCargo.getSelectedItem().toString();
        String login = txtLogin.getText();
        String senha = new String(pswSenha.getPassword());
        String confirm_senha = new String(pswConfirmarSenha.getPassword());

        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty()
                || login.isEmpty() || senha.isEmpty() || confirm_senha.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nem todos os campos foram "
                    + "preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (cargo.equals(cmbCargo.getItemAt(0))) { // A combobox está na posição Selecionar.
            JOptionPane.showMessageDialog(rootPane, "Escolha um cargo.", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (setor.equals(cmbSetor.getItemAt(0))) { // A combobox está na posição Selecionar.
            JOptionPane.showMessageDialog(rootPane, "Escolha um setor.", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!senha.equals(confirm_senha)) {
            JOptionPane.showMessageDialog(rootPane, "Foram digitadas duas "
                    + "senhas diferentes nos campos senha e confirmar senha!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }

    /**
     * Lê os dados inserido pelo usuário, coloca os valores obtidos em um objeto
     * Funcionario e o envia para o método edita da classe ManipulaFuncionarios.
     * @throws ValorInvalidoException
     * @throws ErroCadastroException 
     */
    private void editaFuncionario() throws ValorInvalidoException, ErroCadastroException {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String setor = cmbSetor.getSelectedItem().toString();
        String cargo = cmbCargo.getSelectedItem().toString();
        String login = txtLogin.getText();
        String senha = new String(pswSenha.getPassword());
        String confirm_senha = new String(pswConfirmarSenha.getPassword());

        funcAEditar.setNome(nome);
        funcAEditar.setCpf(cpf);
        funcAEditar.setEmail(email);
        funcAEditar.setSetor(setor);
        funcAEditar.setCargo(cargo);
        funcAEditar.setLogin(login);
        funcAEditar.setSenha(senha);
        new ManipuladorFuncionarios().edita(funcAEditar);
    }

    private void limpaCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtEmail.setText("");
        cmbSetor.selectWithKeyChar('s');
        cmbCargo.selectWithKeyChar('s');
        txtLogin.setText("");
        pswSenha.setText("");
        pswConfirmarSenha.setText("");
    }

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
            java.util.logging.Logger.getLogger(TelaEdicaoFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEdicaoFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEdicaoFuncionarios(new Funcionario(), new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvarAlteracoes;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbSetor;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JPasswordField pswConfirmarSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
