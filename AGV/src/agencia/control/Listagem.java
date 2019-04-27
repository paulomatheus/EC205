package agencia.control;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Listagem {
    //variavel para saber se está no ultimo

    private static int auxx = 0;

    //Metodo para listar pessoas
    public List listaPessoa() {
        //Variavel para guardar os nomes,considerando no max 100
        String[] pessoas = new String[100];
        List<String> pessoasRetornadas = new ArrayList<>();

        //Variavel para saber o que está lendo no arquivo
        int situacao = 0, controle = 0;

        //Variavel para saber o que está lendo no arquivo
        int atual = 0;
        //Variavel para saber se determinada situação ocorreu ou não
        boolean entrou = false, ant = false;
        //diretorio contém o caminho do arquivo usuarios.txt
        String cpf = "", email = "";

        //diretorio contém o caminho do arquivo usuarios.txt
        String nome = "", texto = "", diretorio = "usuarios.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                //Se a linha tiver uma dessas palavras,sei que minha informação não está ali,então eu ignoro tudo abaixo
                if (texto.contains("Coordenador") || texto.contains(("Assessor")) || texto.contains("Cliente")) {
                    continue;
                }
                //se meu texto começa com **,sei que já passou uma pessoa,então posso limpar as variaveis
                if (texto.startsWith("**")) {
                    nome = "";
                    cpf = "";
                    email = "";
                    situacao = 0;
                    continue;
                } //Confirmo que estou na linha que contem os dados das pessoas
                else if (!texto.contains("Coordenador") && !texto.contains("Assessor") && !texto.contains("Cliente")) {
                    entrou = true;
                    for (int i = 0; i < texto.length(); i++) {
                        if (texto.charAt(i) == ':') { //Comparo cada posição da string,se for :,sei que será outra informação e aí devo deslocar meu ponteiro dentro do arquivo
                            situacao++;
                            continue;
                        }
                        if (situacao == 0) {
                            nome += texto.charAt(i); //Verifico se ainda o nome faz parte do login
                        } else if (situacao == 1) { //verifico se meu ponteiro no arquivo está lendo CPF
                            cpf += texto.charAt(i);
                        } else if (situacao == 2) { //verifico se meu ponteiro no arquivo está lendo email
                            email += texto.charAt(i);
                        }
                    }
                    //Coloco o nome da pessoa em uma posição
                    pessoas[controle] = nome;
                    //Aumento o indice
                    controle++;
                }
            }
            //Fecho meu arquivo
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        //Crio um array do tamanho de pessoas cadastradas
        //pessoasRetornadas = new String[controle];
        //Passo para a string que irá retornar,todo o conteudo que não seja null de pessoas
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                pessoasRetornadas.add(pessoas[i]);
            }
        }
        return pessoasRetornadas;
    }
    //Metodo para listar viagem

    public String[] listaViagem(int controle) {
        //---------DELETAR CASO O PROJETO ESTEJA PRONTO------------
        int aux = 0;
        String nomeLido = "";

        //Array que guardaram a info de pessoaNaViagem
        String[] pessoaNaViagem = new String[5];
        int situacao = 0;
        String texto = "", preco = "", nome = "", local = "", duracao = "", limite = "", diretorio = "viagens.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                if (texto.contains("/")) {
                    continue;
                }
                //Verifico se chegou o final do arquivo,então torno o nome nulo,para ser tratado na classe que chamou
                if (auxx == controle && controle > 0) {
                    pessoaNaViagem[0] = "nulo";
                    pessoaNaViagem[1] = "";
                    pessoaNaViagem[2] = "";
                    pessoaNaViagem[3] = "";
                    pessoaNaViagem[4] = "";
                    break;
                }
                //Faço essa lógica para sempre mostrar a próxima viagem na minha lista,pois sempre que tiver "-",sei que se 
                //trata outra viagem
                if (controle > 0) {
                    if (texto.startsWith("-")) {
                        controle--;
                        aux++;
                    }
                } //Sei que se a linha começa com * e controle == 0,estou na linha certa para leitura
                //portando preencho todos meus dados usando a variavel situacao para controlar o que estou lendo
                else if (texto.startsWith("*") && controle == 0) {
                    for (int i = 1; i < texto.length(); i++) {
                        if (texto.charAt(i) == ',') { //sei que a cada , trata-se de uma informação diferente
                            situacao++;
                            continue;
                        }
                        if (situacao > 4) {
                            situacao = 0;
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
                    pessoaNaViagem[0] = new String();
                    pessoaNaViagem[0] = nome;
                    pessoaNaViagem[1] = local;
                    pessoaNaViagem[2] = duracao;
                    pessoaNaViagem[3] = limite;
                    pessoaNaViagem[4] = preco;
                    nome = "";
                    local = "";
                    duracao = "";
                    limite = "";
                    preco = "";
                    break;
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }
        //System.out.println("chegou");
        return pessoaNaViagem;
    }
    //metodo para retornar nomes em determinada viagem

    public List retornaNomesNaViagem(int controle) {
        //---------DELETAR CASO O PROJETO ESTEJA PRONTO------------
        int situacao = 0;
        String preco = "", nome = "", local = "", duracao = "", limite = "";

        //List para guardar os nomes na viagem
        List lista = new ArrayList();
        String nomeLido = "", texto = "", diretorio = "viagens.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                //Faço essa lógica para sempre mostrar a próxima viagem na minha lista
                if (controle > 0) {
                    if (texto.contains("-")) {
                        controle--;
                    }
                    continue;
                } else if (controle == 0 && texto.contains("-")) {
                    break;
                }
                if (texto.contains(";")) { //verifico se a linha lida é a de nomes
                    nomeLido = "";
                    for (int i = 0; i < texto.length(); i++) { //se for,eu começo a guardar os nomes
                        if (texto.charAt(i) == ';') {
                            break;
                        } else {
                            nomeLido += texto.charAt(i);
                        }
                    }
                    lista.add(nomeLido); //adiciono o nome na minha list
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
            System.out.println(e);
        }
        //System.out.println("chegou");
        return lista;
    }
}
