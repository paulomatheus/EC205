/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.viagens.view;

import agv.exceptions.ErroCadastroException;
import agv.exceptions.ValorInvalidoException;
import agv.jdbc.control.ManipuladorClientes;
import agv.jdbc.control.ManipuladorFuncionarios;
import agv.jdbc.control.ManipuladorViagens;
import agv.jdbc.model.Cliente;
import agv.jdbc.model.Funcionario;
import agv.jdbc.model.Viagem;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author barab
 */
public class TelaCadastroViagens extends javax.swing.JFrame {

   private final Funcionario funcLogado;
    private Funcionario funcEncontrado;
    private Viagem viagemEncontrado;
    
    /**
     * Creates new form TelaCadastroViagens
     */
    public TelaCadastroViagens(Funcionario funcLogado) {
        initComponents();
        this.funcLogado = funcLogado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDadosViagem = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblDestino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        lblDuracao = new javax.swing.JLabel();
        lblLimitePessoas = new javax.swing.JLabel();
        lblPrecoPessoa = new javax.swing.JLabel();
        txtLimitePessoas = new javax.swing.JTextField();
        txtPrecoPessoa = new javax.swing.JTextField();
        txtDuracao = new javax.swing.JTextField();
        pnlClientes = new javax.swing.JPanel();
        lblNomeParaAdicionar = new javax.swing.JLabel();
        txtNomeParaAdicionar = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        scrPessoasNaViagem = new javax.swing.JScrollPane();
        lstPessoasNaViagem = new javax.swing.JList<>();
        btnRemover = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de viagens");

        pnlDadosViagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados da viagem"));

        lblNome.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblDestino.setText("Destino:");

        lblDuracao.setText("Duração (dias):");

        lblLimitePessoas.setText("Limite de pessoas:");

        lblPrecoPessoa.setText("Preço por pessoa: R$");

        javax.swing.GroupLayout pnlDadosViagemLayout = new javax.swing.GroupLayout(pnlDadosViagem);
        pnlDadosViagem.setLayout(pnlDadosViagemLayout);
        pnlDadosViagemLayout.setHorizontalGroup(
            pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosViagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDuracao)
                    .addComponent(lblDestino)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosViagemLayout.createSequentialGroup()
                        .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLimitePessoas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLimitePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecoPessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecoPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                    .addComponent(txtNome)
                    .addComponent(txtDestino))
                .addContainerGap())
        );

        pnlDadosViagemLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDuracao, txtLimitePessoas});

        pnlDadosViagemLayout.setVerticalGroup(
            pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosViagemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosViagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracao)
                    .addComponent(lblLimitePessoas)
                    .addComponent(lblPrecoPessoa)
                    .addComponent(txtLimitePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecoPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlClientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes na viagem"));

        lblNomeParaAdicionar.setText("Nome:");

        btnAdicionar.setText("Adicionar na viagem");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        lstPessoasNaViagem.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrPessoasNaViagem.setViewportView(lstPessoasNaViagem);

        btnRemover.setText("Remover da viagem");

        javax.swing.GroupLayout pnlClientesLayout = new javax.swing.GroupLayout(pnlClientes);
        pnlClientes.setLayout(pnlClientesLayout);
        pnlClientesLayout.setHorizontalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrPessoasNaViagem)
                    .addGroup(pnlClientesLayout.createSequentialGroup()
                        .addComponent(lblNomeParaAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNomeParaAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemover)))
                .addContainerGap())
        );

        pnlClientesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdicionar, btnRemover});

        pnlClientesLayout.setVerticalGroup(
            pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeParaAdicionar)
                    .addComponent(txtNomeParaAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPessoasNaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRemover)
                .addContainerGap())
        );

        btnCadastrar.setText("Cadastrar viagem");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosViagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCadastrar, btnVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosViagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnCadastrar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        
        String nomeAdiciona = txtNomeParaAdicionar.getText();
        String lista = lstPessoasNaViagem.getSelectedValue();
        if (passouNaPreValidacaoViagem()) { 
            try {
                cadastraViagem();
            } catch (ValorInvalidoException ex) {
                Logger.getLogger(TelaCadastroViagens.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ErroCadastroException ex) {
                Logger.getLogger(TelaCadastroViagens.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        TelaInicialEventos homeScreen = new TelaInicialEventos(funcLogado);
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
        this.setVisible(false);
        }
        
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        TelaInicialEventos homeScreen = new TelaInicialEventos(funcLogado);
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
     
        ManipuladorViagens manipViagem = new ManipuladorViagens();
        ManipuladorFuncionarios manipFunc = new ManipuladorFuncionarios();
        String nome = txtNome.getText();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Digite um nome.",
                    "Busca", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Viagem viagem = manipViagem.buscaPorNome(nome);
            Funcionario func = manipFunc.buscaPorNome(nome);
            if (viagem != null && func != null) {
                throw new RuntimeException(); // Nomes no banco de dados.
            } else if (viagem != null) {
                viagemEncontrado = viagem;
                mostraDados();
                
            } else if (func != null) {
                funcEncontrado = func;
                mostraDados();
               
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não encontrado!",
                        "Busca", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private boolean passouNaPreValidacaoViagem() {
        String nome = txtNome.getText();
        String destino = txtDestino.getText();
        String duracao = txtDuracao.getText();
        String limite = txtLimitePessoas.getText();
        String preco = txtPrecoPessoa.getText();
        

        if (nome.isEmpty() || destino.isEmpty() || duracao.isEmpty()|| limite.isEmpty()|| preco.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nem todos os campos foram "
                    + "preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
    
    private void mostraDados() {
        DefaultListModel modeloLista = new DefaultListModel();
        this.lstPessoasNaViagem.setModel(modeloLista);
        if (viagemEncontrado != null) {
            lstPessoasNaViagem.setModel(modeloLista);
            lblDestino.setText(viagemEncontrado.getDestino());
            String destinoString =  Integer.toString(viagemEncontrado.getDuracao());
            lblDuracao.setText(destinoString);
            String limiteString =  Integer.toString(viagemEncontrado.getLimitePessoas());
            lblLimitePessoas.setText(limiteString);
            String precoString =  Double.toString(viagemEncontrado.getPrecoPorPessoa());
            lblPrecoPessoa.setText(precoString);
            
        } else {
            throw new RuntimeException();
        }
    }
    
     private void cadastraViagem() throws ValorInvalidoException, ErroCadastroException {
        String nome = txtNome.getText();
        String destino = txtDestino.getText();
        String duracao = txtDuracao.getText();
        String limite = txtLimitePessoas.getText();
        String preco = txtPrecoPessoa.getText();
        String nomeAdiciona = txtNomeParaAdicionar.getText();
        String lista = lstPessoasNaViagem.getSelectedValue();
        
        Viagem via= new Viagem();
        via.setNome(nome);
        via.setDestino(destino);
        via.setDuracao(duracao);
        via.setIdViagem(HEIGHT);
        via.setLimitePessoas(limite);
        via.setPrecoPorPessoa(preco);
        new ManipuladorViagens().cadastra(via);
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
            java.util.logging.Logger.getLogger(TelaCadastroViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroViagens(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblLimitePessoas;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeParaAdicionar;
    private javax.swing.JLabel lblPrecoPessoa;
    private javax.swing.JList<String> lstPessoasNaViagem;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlDadosViagem;
    private javax.swing.JScrollPane scrPessoasNaViagem;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtLimitePessoas;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNomeParaAdicionar;
    private javax.swing.JTextField txtPrecoPessoa;
    // End of variables declaration//GEN-END:variables
}