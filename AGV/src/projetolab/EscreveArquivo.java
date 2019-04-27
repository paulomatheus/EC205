package projetolab;

import agencia.model.Pessoas;
import agencia.model.Funcionario;
import agencia.model.Cliente;
import agencia.control.ChecaInfoPessoas;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EscreveArquivo {
    //Metodo para escrever no arquivo usuarios.txt

    Pessoas[] pessoas = new Pessoas[100];
    Viagem[] viagens = new Viagem[100];
    String[] dados = new String[3];
    int controle = 0;

    public EscreveArquivo(Pessoas[] pessoas, Viagem[] viagens) {
        this.pessoas = pessoas;
        this.viagens = viagens;
    }

    public void escreverArquivo(Pessoas pessoa) {
        try {
            OutputStream arquivo2 = new FileOutputStream("usuarios.txt", true);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            for (int i = 0; i < pessoas.length; i++) {
                if (pessoas[i] == null) {
                    controle = i;
                    break;
                }
            }
            if (pessoa instanceof Funcionario) {
                Funcionario f1 = new Funcionario();
                f1 = (Funcionario) (pessoa);
                pessoas[controle] = f1;
                buffW.newLine();
                buffW.write("*****");
                buffW.newLine();
                buffW.write(f1.getLogin());
                buffW.write(":");
                buffW.write(f1.getSenha());
                buffW.write(":");
                buffW.write(f1.getCargo());
                buffW.write(":");
                buffW.write(f1.getSetor());
                buffW.newLine();
                buffW.write(f1.getNome());
                buffW.write(":");
                buffW.write(f1.getCpf());
                buffW.write(":");
                buffW.write(f1.getEmail());
                controle++;
            } else if (pessoa instanceof Cliente) {
                Cliente c1 = new Cliente();
                c1 = (Cliente) pessoa;
                buffW.newLine();
                buffW.write("*****");
                buffW.newLine();
                buffW.write("Cliente");
                buffW.newLine();
                buffW.write(c1.getNome());
                buffW.write(":");
                buffW.write(c1.getCpf());
                buffW.write(":");
                buffW.write(c1.getEmail());
                pessoas[controle] = c1;
                controle++;
            }
            buffW.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar pessoa no arquivo");
            System.out.println(e);
        }
    }
    //Metodo para escrever no arquivo viagens.txt
    public void escreveDadosViagem(String nome, String local, String duracao, String preco, String limite, String[] pessoasNaLista) {
        dados[0] = new String();
        dados[1] = new String();
        dados[2] = new String();
        ChecaInfoPessoas ch = new ChecaInfoPessoas();
        int controleViagem = 0;
        try {
            OutputStream arquivo2 = new FileOutputStream("viagens.txt", true);
            OutputStreamWriter fileW = new OutputStreamWriter(arquivo2);
            BufferedWriter buffW = new BufferedWriter(fileW);
            for (int i = 0; i < viagens.length; i++) {
                if (viagens[i] == null) {
                    controleViagem = i;
                    break;
                }
            }
            viagens[controleViagem] = new Viagem();
            viagens[controleViagem].setNome(nome);
            viagens[controleViagem].setLocal(local);
            viagens[controleViagem].setDuracao(duracao);
            viagens[controleViagem].setPreco(preco);
            viagens[controleViagem].setCapacidadePessoas(limite);
            buffW.newLine();
            buffW.write("*");
            buffW.write(nome);
            buffW.write(",");
            buffW.write(local);
            buffW.write(",");
            buffW.write(duracao);
            buffW.write(",");
            buffW.write(preco);
            buffW.write(",");
            buffW.write(limite);      

            buffW.newLine();
            for (int i = 0; i < pessoasNaLista.length; i++) {
                dados = ch.checarInfo(pessoasNaLista[i]);
                viagens[controleViagem].pessoas[i] = new Cliente();
                viagens[controleViagem].pessoas[i].setEmail(dados[2]);
                viagens[controleViagem].pessoas[i].setCpf(dados[1]);
                viagens[controleViagem].pessoas[i].setNome(dados[0]);
            }
            for (int i = 0; i < pessoasNaLista.length; i++) {
                dados = ch.checarInfo(pessoasNaLista[i]);
                buffW.write(dados[0]);
                buffW.write(";");
                buffW.write(dados[1]);
                buffW.write(";");
                buffW.write(dados[2]);
                buffW.write(";");
                buffW.newLine();
            }
            buffW.write("--------------------");
            buffW.close();
        } catch (Exception e) {
            System.out.println("Erro ao escrever dados da viagem");
        }

    }
}
