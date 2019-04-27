package agencia.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class ValidarLogin {

    public String[] validaLogin(String nome, String senha) {
        int situacao = 0;

        String[] dados = new String[4];
        boolean entrou = false, ant = false;
        String setor = "", cargo = "", loginLido = "", senhaLida = "", texto = "", /*DIRETÓRIO*/ diretorio = "usuarios.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                if (texto.startsWith("**")) {
                    senhaLida = "";
                    loginLido = "";
                    cargo = "";
                    setor = "";
                    situacao = 0;
                    continue;
                } else if (texto.contains("Cliente")) {
                    ant = true;
                    continue;
                } else if (!texto.startsWith("**") && ant == false) { //Verifico se estou lendo uma linha que contém login e senha
                    for (int i = 0; i < texto.length(); i++) {
                        //System.out.print(texto.charAt(i));
                        if (texto.charAt(i) == ':') { //Comparo cada posição da string
                            situacao++;
                            continue;
                        }
                        if (situacao == 0) {
                            loginLido += texto.charAt(i); //Verifico se ainda o nome faz parte do login
                        } else if (situacao == 1) {
                            senhaLida += texto.charAt(i);
                        } else if (situacao == 2) {
                            cargo += texto.charAt(i);
                        } else if (situacao == 3) {
                            setor += texto.charAt(i);
                        }
                    }
                    dados[0] = loginLido;
                    dados[1] = senhaLida;
                    dados[2] = cargo;
                    dados[3] = setor;
                }
                //Verifico se o LOGIN e SENHA estão cadastrados
                if (loginLido.equals(nome) && senhaLida.equals(senha) && !senhaLida.equals("")) {
                    entrou = true;
                    break;
                }
                ant = false;
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        if (entrou == false) {
            dados[0] = "nulo";
        }
        return dados;
    }
}
