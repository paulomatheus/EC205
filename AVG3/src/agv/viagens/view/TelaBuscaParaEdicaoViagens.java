/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.viagens.view;

import agv.jdbc.control.ManipuladorClientes;
import agv.jdbc.control.ManipuladorFuncionarios;
import agv.jdbc.control.ManipuladorViagens;
import agv.jdbc.model.Cliente;
import agv.jdbc.model.Funcionario;
import agv.jdbc.model.Viagem;
import javax.swing.JOptionPane;

/**
 *
 * @author barab
 */
public class TelaBuscaParaEdicaoViagens extends javax.swing.JFrame {

    private final Funcionario funcLogado;
    private Funcionario funcEncontrado;
    private Viagem viagemEncontrado;
    
    /**
     * Creates new form TelaBuscaParaEdicaoViagens
     * @param funcLogado
     */
    public TelaBuscaParaEdicaoViagens(Funcionario funcLogado) {
        initComponents();
        this.funcLogado = funcLogado;
        btnEditar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBusca = new javax.swing.JPanel();
        lblNomeBusca = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        pnlResultadoBusca = new javax.swing.JPanel();
        lblNomeResultado = new javax.swing.JLabel();
        lblValorNome = new javax.swing.JLabel();
        lblDestino = new javax.swing.JLabel();
        lblDuracao = new javax.swing.JLabel();
        lblValorDestino = new javax.swing.JLabel();
        lblValorDuracao = new javax.swing.JLabel();
        lblLimitePessoas = new javax.swing.JLabel();
        lblValorLimitePessoas = new javax.swing.JLabel();
        lblPrecoPessoa = new javax.swing.JLabel();
        lblValorPrecoPessoa = new javax.swing.JLabel();
        scrPessoasNaViagem = new javax.swing.JScrollPane();
        lstPessoasNaViagem = new javax.swing.JList<>();
        btnVoltar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Busca para edição de viagens");

        pnlBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Busca"));

        lblNomeBusca.setText("Nome:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");

        javax.swing.GroupLayout pnlBuscaLayout = new javax.swing.GroupLayout(pnlBusca);
        pnlBusca.setLayout(pnlBuscaLayout);
        pnlBuscaLayout.setHorizontalGroup(
            pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNomeBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addContainerGap())
        );

        pnlBuscaLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnBuscar, btnLimpar});

        pnlBuscaLayout.setVerticalGroup(
            pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeBusca)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlResultadoBusca.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultado da busca"));

        lblNomeResultado.setText("Nome:");

        lblValorNome.setText("Nome");

        lblDestino.setText("Destino:");

        lblDuracao.setText("Duração:");

        lblValorDestino.setText("Destino");

        lblValorDuracao.setText("Duração");

        lblLimitePessoas.setText("Limite de pessoas:");

        lblValorLimitePessoas.setText("Limite de pessoas");

        lblPrecoPessoa.setText("Preço por pessoa:");

        lblValorPrecoPessoa.setText("Preço por pessoa");

        lstPessoasNaViagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoas na viagem"));
        lstPessoasNaViagem.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scrPessoasNaViagem.setViewportView(lstPessoasNaViagem);

        javax.swing.GroupLayout pnlResultadoBuscaLayout = new javax.swing.GroupLayout(pnlResultadoBusca);
        pnlResultadoBusca.setLayout(pnlResultadoBuscaLayout);
        pnlResultadoBuscaLayout.setHorizontalGroup(
            pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                        .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                                .addComponent(lblNomeResultado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorNome))
                            .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                                .addComponent(lblDestino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorDestino))
                            .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                                .addComponent(lblDuracao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblValorDuracao))
                            .addComponent(lblLimitePessoas)
                            .addComponent(lblPrecoPessoa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValorLimitePessoas)
                            .addComponent(lblValorPrecoPessoa))
                        .addGap(0, 531, Short.MAX_VALUE))
                    .addComponent(scrPessoasNaViagem))
                .addContainerGap())
        );
        pnlResultadoBuscaLayout.setVerticalGroup(
            pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlResultadoBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeResultado)
                    .addComponent(lblValorNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDestino)
                    .addComponent(lblValorDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDuracao)
                    .addComponent(lblValorDuracao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLimitePessoas)
                    .addComponent(lblValorLimitePessoas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlResultadoBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecoPessoa)
                    .addComponent(lblValorPrecoPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrPessoasNaViagem, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlResultadoBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVoltar)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEditar, btnVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlResultadoBusca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ManipuladorViagens manipViagens = new ManipuladorViagens();
        ManipuladorFuncionarios manipFunc = new ManipuladorFuncionarios();
        String nome = txtNome.getText();

        if (nome.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Digite um nome.",
                    "Busca", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Viagem viagem = manipViagens.buscaPorNome(nome);
            Funcionario func = manipFunc.buscaPorNome(nome);
            if (viagem != null && func != null) {
                throw new RuntimeException(); // Nomes no banco de dados.
            } else if (viagem != null) {
                viagemEncontrado = viagem;
                mostraDados();
                btnEditar.setEnabled(true);
            } else if (func != null) {
                funcEncontrado = func;
                mostraDados();
                btnEditar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Não encontrado!",
                        "Busca", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
        private void mostraDados() {
        if (viagemEncontrado != null) {
            lblValorNome.setText(viagemEncontrado.getNome());
            lblValorDestino.setText(viagemEncontrado.getDestino());
            String destinoString =  Integer.toString(viagemEncontrado.getDuracao());
            lblValorDuracao.setText(destinoString);
            String limiteString =  Integer.toString(viagemEncontrado.getLimitePessoas());
            lblValorLimitePessoas.setText(limiteString);
            String precoString =  Double.toString(viagemEncontrado.getPrecoPorPessoa());
            lblValorPrecoPessoa.setText(precoString);
            
        } else {
            throw new RuntimeException();
        }
    }
        
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
       TelaInicialEventos homeScreen = new TelaInicialEventos(funcLogado);
       homeScreen.setLocationRelativeTo(null);
       homeScreen.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaBuscaParaEdicaoViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaParaEdicaoViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaParaEdicaoViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaBuscaParaEdicaoViagens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaBuscaParaEdicaoViagens(new Funcionario()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel lblDestino;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblLimitePessoas;
    private javax.swing.JLabel lblNomeBusca;
    private javax.swing.JLabel lblNomeResultado;
    private javax.swing.JLabel lblPrecoPessoa;
    private javax.swing.JLabel lblValorDestino;
    private javax.swing.JLabel lblValorDuracao;
    private javax.swing.JLabel lblValorLimitePessoas;
    private javax.swing.JLabel lblValorNome;
    private javax.swing.JLabel lblValorPrecoPessoa;
    private javax.swing.JList<String> lstPessoasNaViagem;
    private javax.swing.JPanel pnlBusca;
    private javax.swing.JPanel pnlResultadoBusca;
    private javax.swing.JScrollPane scrPessoasNaViagem;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
