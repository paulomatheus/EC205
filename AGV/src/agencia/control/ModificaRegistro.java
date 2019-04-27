package agencia.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JOptionPane;

public class ModificaRegistro {

    public void apagaViagem(String localBusca) {
        String nomeLido = "", texto = "", preco = "", nome = "", local = "", duracao = "", limite = "";

        String  diretorio = "viagens.txt";
		//Array que guardaram a info de pessoaNaViagem
        String[] pessoaNaViagem = new String[5];
        //Inicio a string para a classe que chama identificar se for retornado 0
        pessoaNaViagem[0] = "";
        int situacao = 0;
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            OutputStream arquivo2 = new FileOutputStream("viagensAux.txt", false);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                //portando preencho todos meus dados usando a variavel situacao para controlar o que estou lendo
                local = "";
                if (texto.startsWith("*" + localBusca)) {
                    for (int i = 1; i < texto.length(); i++) {
                        if (texto.charAt(i) == ',') { //sei que a cada "," trata-se de uma informação diferente
                            situacao++;
                            //continue;
                        }
                        if (situacao > 4) {
                            situacao = 0;
                            continue;
                        }
                        if (situacao == 0) {
                            local += texto.charAt(i);
                        } else if (situacao == 1) {
                            duracao += texto.charAt(i);
                        } else if (situacao == 2) {
                            limite += texto.charAt(i);
                        } else if (situacao == 3) {
                            nome += texto.charAt(i);
                        } else if (situacao == 4) {
                            preco += texto.charAt(i);
                        }
                    }

                }
                //Caso a busca seja igual a viagem procurada
                if (!local.equalsIgnoreCase(localBusca)) {
                    local = "";
                    buffW.write(texto);
                    buffW.newLine();
                } else {
                    while (!texto.contains("-")) {
                        texto = buffR.readLine();
                    }
                }
            }
            buffR.close();
            buffW.close();
            this.atualizaArquivoViagem();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
    }

    public void atualizaArquivoViagem() {
        String texto, diretorio = "viagensAux.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            OutputStream arquivo2 = new FileOutputStream("viagens.txt", false);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                buffW.write(texto);
                buffW.newLine();
            }
            buffR.close();
            buffW.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar arquivo de viagens");
        }
    }

    public void apagaPessoa(String nomeDaPessoa) {
        int situacao = 0;
        String texto = "", texto2 = "", nome = "", diretorio = "usuarios.txt";
        boolean anterior = false;
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            OutputStream arquivo2 = new FileOutputStream("usuariosAux.txt", false);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                //se meu texto começa com **,sei que já passou uma pessoa,então posso limpar as variaveis
                nome = "";
                situacao = 0;
                //Confirmo que estou na linha que contem os dados das pessoas
                if (texto.contains("Cliente") || texto.contains("Coordenador")
                        || texto.contains("Assessor")) {
                    anterior = true;
                    texto2 = buffR.readLine();
                } else if (!texto.contains("*")) {
                    anterior = false;
                }
                for (int i = 0; i < texto2.length(); i++) {
                    if (texto2.charAt(i) == ':') { //Comparo cada posição da string,se for :,sei que será outra informação e aí devo deslocar meu ponteiro dentro do arquivo
                        situacao++;
                        continue;
                    }
                    if (situacao == 0) {
                        nome += texto2.charAt(i); //Verifico se ainda o nome faz parte do login
                    }
                }
                if (texto.contains("*")) {
                    buffW.write(texto);
                    buffW.newLine();
                    continue;
                }
                if (anterior == true) {
                    if (!nome.equals(nomeDaPessoa)) {
                        buffW.write(texto);
                        buffW.newLine();
                        buffW.write(texto2);
                        buffW.newLine();
                    }
                    anterior = false;

                }
            }
            //Fecho meu arquivo
            buffR.close();
            buffW.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        this.atualizaArquivoPessoa();
    }

    public void atualizaArquivoPessoa() {
        String texto, diretorio = "usuariosAux.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            OutputStream arquivo2 = new FileOutputStream("usuarios.txt", false);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                buffW.write(texto);
                buffW.newLine();
            }
            buffR.close();
            buffW.close();
        } catch (Exception e) {
            System.out.println("Erro ao atualizar arquivo de pessoas");
        }
    }
}
