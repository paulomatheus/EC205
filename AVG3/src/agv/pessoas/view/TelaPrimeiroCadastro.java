/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.pessoas.view;

import agv.jdbc.control.ManipuladorFuncionarios;
import agv.exceptions.ValorInvalidoException;
import agv.exceptions.ErroCadastroException;
import agv.jdbc.model.Cargos;
import agv.jdbc.model.Funcionario;
import agv.jdbc.model.Setores;
import agv.login.view.TelaLogin;
import javax.swing.JOptionPane;

/**
 * Tela onde é feito o cadastro do primeiro funcionário do setor de documentos.
 * @author Bruno Almeida Rabelo
 */
public class TelaPrimeiroCadastro extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroPessoas
     */
    public TelaPrimeiroCadastro() {
        initComponents();

        Cargos cargos[] = Cargos.values();
        cmbCargo.removeAllItems();
        cmbCargo.addItem("Selecionar");
        for (Cargos cargo : cargos) {
            cmbCargo.addItem(cargo.getNomeCargo());
        }
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
        lblCargo = new javax.swing.JLabel();
        cmbCargo = new javax.swing.JComboBox<>();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        lblConfirmarSenha = new javax.swing.JLabel();
        pswConfirmarSenha = new javax.swing.JPasswordField();
        txtEmail = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        lblValorSetor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de pessoas");

        lblNome.setText("Nome:");

        txtNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNome.setFocusCycleRoot(true);
        txtNome.setNextFocusableComponent(txtCpf);

        lblCpf.setText("CPF:");

        lblEmail.setText("Email:");

        lblSetor.setText("Setor:");

        lblCargo.setText("Cargo:");

        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCargo.setFocusCycleRoot(true);
        cmbCargo.setNextFocusableComponent(txtLogin);

        lblLogin.setText("Login:");

        txtLogin.setFocusCycleRoot(true);
        txtLogin.setNextFocusableComponent(pswSenha);

        lblSenha.setText("Senha:");

        pswSenha.setFocusCycleRoot(true);
        pswSenha.setNextFocusableComponent(pswConfirmarSenha);

        lblConfirmarSenha.setText("Confirmar senha:");

        pswConfirmarSenha.setFocusCycleRoot(true);
        pswConfirmarSenha.setNextFocusableComponent(btnCadastrar);

        txtEmail.setFocusCycleRoot(true);
        txtEmail.setNextFocusableComponent(cmbCargo);

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFocusCycleRoot(true);
        txtCpf.setNextFocusableComponent(txtEmail);

        lblValorSetor.setText("Documentos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(lblValorSetor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogin, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblConfirmarSenha, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin)
                            .addComponent(pswSenha)
                            .addComponent(pswConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)))
                .addContainerGap())
        );
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
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorSetor))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Inicia o processo de cadastro do funcionário.
     * @param evt 
     */
    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (passouNaPreValidacao()) {
            try {
                cadastrarFuncionarioDocs();
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setLocationRelativeTo(null);
                telaLogin.setVisible(true);
                dispose();
            } catch (ValorInvalidoException | ErroCadastroException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    /**
     * Verifica se o usuário deixou algum campo em branco, se esqueceu de
     * selecionar um cargo ou se digitou duas senhas diferentes nos campos
     * Senha e Confirmar senha.
     * @return 
     */
    private boolean passouNaPreValidacao() {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        String cargo = cmbCargo.getSelectedItem().toString();
        String login = txtLogin.getText();
        String senha = new String(pswSenha.getPassword());
        String confirm_senha = new String(pswConfirmarSenha.getPassword());

        if (nome.isEmpty() || cpf.isEmpty() || email.isEmpty()
                || login.isEmpty() || senha.isEmpty()
                || confirm_senha.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nem todos os campos foram "
                    + "preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (cargo.equals(cmbCargo.getItemAt(0))) { // A combobox está na posição Selecionar.
            JOptionPane.showMessageDialog(rootPane, "Escolha um cargo.", "Erro",
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
     * Funcionario e o envia para o método cadastra da classe ManipulaFuncionarios.
     * @throws ValorInvalidoException
     * @throws ErroCadastroException 
     */
    private void cadastrarFuncionarioDocs() throws ValorInvalidoException, ErroCadastroException {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String email = txtEmail.getText();
        Setores setor = Setores.DOCUMENTOS;
        String cargo = cmbCargo.getSelectedItem().toString();
        String login = txtLogin.getText();
        String senha = new String(pswSenha.getPassword());
        String confirm_senha = new String(pswConfirmarSenha.getPassword());
        Funcionario func = new Funcionario();

        func.setNome(nome);
        func.setCpf(cpf);
        func.setEmail(email);
        func.setSetor(setor);
        func.setCargo(cargo);
        func.setLogin(login);
        func.setSenha(senha);
        new ManipuladorFuncionarios().cadastra(func);
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
            java.util.logging.Logger.getLogger(TelaPrimeiroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrimeiroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrimeiroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrimeiroCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrimeiroCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblConfirmarSenha;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSetor;
    private javax.swing.JLabel lblValorSetor;
    private javax.swing.JPasswordField pswConfirmarSenha;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
