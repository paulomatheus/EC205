/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.lista.view;

import agencia.control.Listagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import agencia.control.ChecaInfoPessoas;
import projetolab.PaginaInicial;
import agencia.model.Pessoas;
import projetolab.Viagem;


/**
 *
 * @author Leo
 */
public class telaListarViagem extends javax.swing.JFrame {

    Viagem[] viagens;
    Pessoas[] pessoas;
    private String setor;
    private String cargo;
    private String login;
    //Variavel que controla a viagem que será mostrada
    private int controleListagem = 0;

    //listmodel em jList
    DefaultListModel model = new DefaultListModel();

    /**
     * Creates new form telaListarViagem
     */
    public telaListarViagem(String cargo, String login, String setor, Pessoas[] pessoas, Viagem[] viagens) {
        //Construtor recebe cargo,login,setor,pessoas e viagens para sempre o form atual ter essas informações
        this.viagens = viagens;
        this.cargo = cargo;
        this.setor = setor;
        this.login = login;
        this.pessoas = pessoas;
        this.setUndecorated(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Listagem de viagens");
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.listPessoasNaViagem.setModel(model);
    }

    private telaListarViagem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        buttonProximo = new javax.swing.JButton();
        buttonVoltar = new javax.swing.JButton();
        listPessoasNaViagem = new javax.swing.JList<>();
        labelFixoNome = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelFixoDestino = new javax.swing.JLabel();
        labelFixoPreco = new javax.swing.JLabel();
        labelFixoLimiteDePessoas = new javax.swing.JLabel();
        labelFixoDuração = new javax.swing.JLabel();
        labelDestino = new javax.swing.JLabel();
        labelPrecoPorPessoa = new javax.swing.JLabel();
        labelLimiteDePessoas = new javax.swing.JLabel();
        labelDuracao = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AGV - Listagem de viagens");

        buttonProximo.setText("Proximo");
        buttonProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProximoActionPerformed(evt);
            }
        });

        buttonVoltar.setText("Voltar");
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        listPessoasNaViagem.setBorder(javax.swing.BorderFactory.createTitledBorder("Pessoas nesta viagem"));
        listPessoasNaViagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listPessoasNaViagemMouseClicked(evt);
            }
        });

        labelFixoNome.setText("Nome:");

        labelNome.setText("Nome");

        labelFixoDestino.setText("Destino:");

        labelFixoPreco.setText("Preço por pessoa:");

        labelFixoLimiteDePessoas.setText("Limite de pessoas:");

        labelFixoDuração.setText("Duração:");

        labelDestino.setText("Destino");

        labelPrecoPorPessoa.setText("Preço");

        labelLimiteDePessoas.setText("Limite");

        labelDuracao.setText("Duração");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(listPessoasNaViagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelFixoNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelFixoDestino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(labelFixoDuração)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFixoLimiteDePessoas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelLimiteDePessoas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFixoPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPrecoPorPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(buttonProximo)
                        .addGap(34, 34, 34)
                        .addComponent(buttonVoltar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFixoNome)
                    .addComponent(labelNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFixoDestino)
                    .addComponent(labelDestino))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFixoDuração)
                    .addComponent(labelDuracao)
                    .addComponent(labelFixoLimiteDePessoas)
                    .addComponent(labelLimiteDePessoas)
                    .addComponent(labelFixoPreco)
                    .addComponent(labelPrecoPorPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(listPessoasNaViagem, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonProximo)
                    .addComponent(buttonVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        // Ação do botão voltar
        //Instancio minha classe
        PaginaInicial homePage = new PaginaInicial(cargo, login, setor, pessoas, viagens);
        //Torno meu form visivel
        homePage.setVisible(true);
        //Deixo meu form antigo invisivel
        this.setVisible(false);
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProximoActionPerformed
        //---------DELETAR CASO O PROJETO ESTEJA PRONTO------------
        // String dados para guardar os dados e pessoasNaViagem para guardar pessoas que estão em determinada viagem
        String[] dados;
        
        //Instancio a classe listar,que contem métodos para listagem
        Listagem listar = new Listagem();
        //Chamo o método para pegar os dados da viagem
        dados = listar.listaViagem(controleListagem);
        //Verifico se a ultima informação mostrada era a ultima da lista
        if (dados[0] == "nulo") {
            JOptionPane.showMessageDialog(null, "Todas as viagens já foram listadas");
            listPessoasNaViagem.removeAll();
            return;
        }
        //Array list para guardar os nomes na minha viagem
        List lista = new ArrayList();
        
        //Chamo o método que retorna os metodos naquela viagem
        lista = listar.retornaNomesNaViagem(controleListagem);
        
        //Incremento a variavel que controla qual viagem era mostrar na tela
        controleListagem++;
        
        //Preencho todos os dados dos label da minha tela
        labelNome.setText(dados[0]);
        labelDestino.setText(dados[1]);
        labelPrecoPorPessoa.setText(dados[4]);
        labelLimiteDePessoas.setText(dados[3]);
        labelDuracao.setText(dados[2]);
        
        //Removo todos as informaçoes da minha jList
        for (int i = 0; i < model.size(); i++) {
            model.removeElement(model.get(i));
        }
        //Rodo novamente para terminar de apagar
        for (int i = 0; i < model.size(); i++) {
            model.removeElement(model.get(i));
        }
        for (int i = 0; i < model.size(); i++) {
            model.removeElement(model.get(i));
        }
        //Adiciono todas as minhas informações na jList
        for (int i = 0; i < lista.size(); i++) {
            if (!model.contains(lista.get(i).toString())) {
                model.addElement(lista.get(i));
            }
        }
    }//GEN-LAST:event_buttonProximoActionPerformed

    private void listPessoasNaViagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listPessoasNaViagemMouseClicked
        // Ação se clicar em algum nome na jList
        //String para guardar dados da pessoa
        if (listPessoasNaViagem.getSelectedValue() == null) {
            return;
        }
        String[] dados = new String[3];
        dados[0] = new String();
        dados[1] = new String();
        dados[2] = new String();
        //Instancio a classe que checa pessoas
        ChecaInfoPessoas checa = new ChecaInfoPessoas();
        //Chamo o método que me retorna os dados
        dados = checa.checarInfo(listPessoasNaViagem.getSelectedValue());
        //Mostro na tela
        JOptionPane.showMessageDialog(null, "Nome: " + dados[0] + "\nCpf: " + dados[1] + "\nEmail: "
                + dados[2], "Informações da pessoa", 1);
    }//GEN-LAST:event_listPessoasNaViagemMouseClicked

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
            java.util.logging.Logger.getLogger(telaListarViagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaListarViagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaListarViagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaListarViagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaListarViagem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonProximo;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelDestino;
    private javax.swing.JLabel labelDuracao;
    private javax.swing.JLabel labelFixoDestino;
    private javax.swing.JLabel labelFixoDuração;
    private javax.swing.JLabel labelFixoLimiteDePessoas;
    private javax.swing.JLabel labelFixoNome;
    private javax.swing.JLabel labelFixoPreco;
    private javax.swing.JLabel labelLimiteDePessoas;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelPrecoPorPessoa;
    private javax.swing.JList<String> listPessoasNaViagem;
    // End of variables declaration//GEN-END:variables
}