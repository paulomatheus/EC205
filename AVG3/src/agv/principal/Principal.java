/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.principal;

import agv.jdbc.control.ManipuladorFuncionarios;
import agv.login.view.TelaLogin;
import agv.pessoas.view.TelaPrimeiroCadastro;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Classe que inicia o programa.
 * @author Bruno Almeida Rabelo
 */
public class Principal {

    public static void main(String[] args) {
        // Seleciona o tema Nimbus.
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    throw new RuntimeException();
                }
            }
        }
        
        ManipuladorFuncionarios manipFunc = new ManipuladorFuncionarios();
        if (manipFunc.calcQuantFuncDocs() >= 1) {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setLocationRelativeTo(null);
            telaLogin.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Bem vindo ao software de "
                    + "genciamento de viagens da AGV!\nPara usar o programa, "
                    + "será necessário cadastrar um funcionário da seção de "
                    + "documentos.\nA tela de cadastro será exibida assim que "
                    + "o botão OK for pressionado.", "",
                    JOptionPane.INFORMATION_MESSAGE);
            TelaPrimeiroCadastro telaPrimCad = new TelaPrimeiroCadastro();
            telaPrimCad.setLocationRelativeTo(null);
            telaPrimCad.setVisible(true);
        }
    }
}
