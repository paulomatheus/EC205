/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agencia.control;

//* @author PauloMatheus 
import agencia.model.Pessoas;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import projetolab.Viagem;


public class EditaViagem {

    Pessoas[] pessoas = new Pessoas[100];
    Viagem[] viagens = new Viagem[100];
    String[] dados = new String[3];
    int controle = 0;
    
    //---------DELETAR CASO O PROJETO ESTEJA PRONTO------------
    //variavel para saber se está no ultimo
    private static int auxx = 0;
    private int controleBusca = 0;

    public EditaViagem(Pessoas[] pessoas, Viagem[] viagens) {
        this.pessoas = pessoas;
        this.viagens = viagens;
    }

    public EditaViagem() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Métodos
    public String[] ProcuraViagem(String localBusca) {
        //Array que guardaram a info de pessoaNaViagem
        String[] pessoaNaViagem = new String[5];
        //Inicio a string para a classe que chama identificar se for retornado 0
        pessoaNaViagem[0] = "";
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
                //Faço essa lógica para sempre mostrar a próxima viagem na minha lista,pois sempre que tiver "-",sei que se 
                //trata outra viagem
                if (texto.startsWith("-") || texto.contains("/")) {
                    continue;
                } //portando preencho todos meus dados usando a variavel situacao para controlar o que estou lendo
                else if (texto.startsWith("*" + localBusca)) {
                    for (int i = 1; i < texto.length(); i++) {

                        if (texto.charAt(i) == ',') { //sei que a cada "," trata-se de uma informação diferente
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
                    //Caso a busca seja igual a viagem procurada
                    if (local.equalsIgnoreCase(localBusca)) {
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
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
        }

        return pessoaNaViagem;
    }

    public List retornaNomesNaViagem(String nomeViagem) {
        boolean viagemCorreta = false;
        //List para guardar os nomes na viagem
        List<String> lista = new ArrayList();
        
        //---------DELETAR CASO O PROJETO ESTEJA PRONTO------------
        int situacao = 0;
        String preco = "", nome = "", local = "", duracao = "", limite = "";
        
        String nomeLido = "", texto = "", diretorio = "viagens.txt";
        try {
            //Tento abrir meu arquivo para leitura
            InputStream file = new FileInputStream(diretorio);
            InputStreamReader fileUsuarios = new InputStreamReader(file);
            BufferedReader buffR = new BufferedReader(fileUsuarios);
            //Percorro todo o arquivo
            while (buffR.ready()) {
                texto = buffR.readLine();
                if (viagemCorreta == true && texto.contains("-")) {
                    break;
                }
                if (texto.startsWith("*" + nomeViagem)) {
                    viagemCorreta = true;
                }
                if (texto.contains("-") && viagemCorreta == false) {
                    lista.clear();
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
                    //System.out.println(nomeLido);
                    if (viagemCorreta == true) {
                        lista.add(nomeLido); //adiciono o nome na minha list					
                    }
                }
            }
            buffR.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo");
            System.out.println(e);
        }
        return lista;
    }

}
