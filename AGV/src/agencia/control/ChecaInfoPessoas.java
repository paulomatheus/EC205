package agencia.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class ChecaInfoPessoas {
	
    //Retorna os dados da pessoa usando o nome
    public String[] checarInfo(String nomeRecebido) {
		//Array de string para guardar as informações das pessoas
        String[] dados = new String[3];
        dados[0] = new String();
        dados[1] = new String();
        dados[2] = new String();

        int situacao = 0;
		boolean entrou = false;

        String nome = "", cpf = "", email = "", texto = "", diretorio = "usuarios.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
				//Verifico se a linha que estou lendo é a que realmente preciso tratar informações
                if (texto.contains("Coordenador") || texto.contains(("Assessor")) || texto.contains("Cliente")) {
                    continue;
                }
				//Verifico se a linha começa com "*"(operador utilizado para separar contatos
                if (texto.startsWith("**")) {
                    nome = "";
                    dados[0] = "";
                    dados[1] = "";
                    dados[2] = "";
                    cpf = "";
                    email = "";
                    situacao = 0;
                    continue;
                } else if (texto.contains(nomeRecebido)
                        && !texto.contains("Coordenador") && !texto.contains("Assessor") && !texto.contains("Cliente")) {
                    entrou = true;
                    for (int i = 0; i < texto.length(); i++) {
                        //System.out.print(texto.charAt(i));
                        if (texto.charAt(i) == ':') { //Comparo cada posição da string
                            situacao++;
                            continue;
                        }
                        if (situacao == 0) {
                            nome += texto.charAt(i); //Verifico se ainda o nome faz parte do login
                        } else if (situacao == 1) {
                            cpf += texto.charAt(i);
                        } else if (situacao == 2) {
                            email += texto.charAt(i);
                        }
                    }
                    break;
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
            System.out.println(e);
        }
        dados[0] = nome;
        dados[1] = cpf;
        dados[2] = email;
        return dados;
    }
    //Método que retorna se tem o nome ou não

    public boolean checarNome(String nomeRecebido) {
        String[] dados = new String[3];
        dados[0] = new String();
        dados[1] = new String();
        dados[2] = new String();

        int situacao = 0;

        boolean entrou = false;
        String nome = "", texto = "", diretorio = "usuarios.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                if (texto.contains("Documentos") || texto.contains(("Assessor")) || texto.contains("Cliente")) {
                    continue;
                }
                if (texto.startsWith("**")) {
                    nome = "";
                    situacao = 0;
                    continue;
                } else if (texto.contains(nomeRecebido)
                        && !texto.contains("Coordenador") && !texto.contains("Assessor") && !texto.contains("Cliente")) {
                    entrou = true;
                    for (int i = 0; i < texto.length(); i++) {
                        //System.out.print(texto.charAt(i));
                        if (texto.charAt(i) == ':') { //Comparo cada posição da string
                            situacao++;
                            continue;
                        }
                        if (situacao == 0) {
                            nome += texto.charAt(i); //Verifico se ainda o nome faz parte do login
                        }
                    }
                    break;
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //Verifico se o nome recebido é igual ao nome
        if (nome.equals(nomeRecebido)) {
            entrou = true;
        }
        return entrou;
    }

}
