/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.control;

import agv.exceptions.ErroCadastroException;
import agv.jdbc.dao.FuncionarioDao;
import agv.jdbc.dao.ClienteDao;
import agv.jdbc.model.Funcionario;
import agv.jdbc.model.Cliente;
import agv.jdbc.model.Setores;
import java.util.ArrayList;

/**
 * Classe que manipula cadastros de funcionários usando a classe FuncionarioDao.
 * @author Bruno Almeida Rabelo
 */
public class ManipuladorFuncionarios {

    private final ClienteDao clienteDao = new ClienteDao();
    private final FuncionarioDao funcDao = new FuncionarioDao();
    private final ArrayList<Funcionario> listaFuncionarios;
    private final ArrayList<Cliente> listaClientes;

    public ManipuladorFuncionarios() {
        listaFuncionarios = funcDao.getLista();
        listaClientes = clienteDao.getLista();
    }
    
    /**
     * Usa a classe FuncionarioDao para obter uma lista com todos os 
     * funcionários cadastrados no sistema.
     * @return Retorna uma ArrayList com todos os funcionários cadastrados no
     * sistema ou null, se não houver nenhum.
     */
    public ArrayList<Funcionario> getListaFuncionarios() {
        if (listaFuncionarios.isEmpty()) {
            return null;
        } else {
            return listaFuncionarios;
        }
    }
    
    /**
     * Cadastra um funcionário no sistema usando a classe FuncionárioDao.
     * @param funcionario
     * @throws ErroCadastroException Retorna esta exceção se já houver um 
     * funcionário com o mesmo nome, CPF, email ou login cadastrado no sistema
     * ou se já houver um cliente com o mesmo nome, CPF ou email cadastrado
     * no sistema.
     */
    public void cadastra(Funcionario funcionario) throws ErroCadastroException {
        for (Funcionario funcNaLista : listaFuncionarios) {
            if (funcNaLista.getNome().equals(funcionario.getNome())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo nome cadastrado no sistema.");
            } else if (funcNaLista.getCpf().equals(funcionario.getCpf())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo CPF cadastrado no sistema.");
            } else if (funcNaLista.getEmail().equals(funcionario.getEmail())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo email cadastrado no sistema.");
            } else if (funcNaLista.getLogin().equals(funcionario.getLogin())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo login cadastrado no sistema.");
            }
        }
        for (Cliente clienteNaLista : listaClientes) {
            if (clienteNaLista.getNome().equals(funcionario.getNome())) {
                throw new ErroCadastroException("Já existe um cliente com "
                        + "o mesmo nome cadastrado no sistema.");
            } else if (clienteNaLista.getCpf().equals(funcionario.getCpf())) {
                throw new ErroCadastroException("Já existe um cliente com "
                        + "o mesmo CPF cadastrado no sistema.");
            } else if (clienteNaLista.getEmail().equals(funcionario.getEmail())) {
                throw new ErroCadastroException("Já existe um cliente com "
                        + "o mesmo email cadastrado no sistema.");
            }
        }
        funcDao.adiciona(funcionario);
    }
    
    /**
     * Altera o cadastro de um funcionário usando a classe FuncionarioDao.
     * @param funcionario
     * @throws ErroCadastroException Lança esta exceção, se as alterações 
     * implicarem na existência de duas pessoas com o mesmo nome, CPF, email ou
     * login no sistema. Também lança esta exceção, se for requisitado a mudança
     * de setor do último funcionário restante do setor de documentos.
     */
    public void edita(Funcionario funcionario) throws ErroCadastroException {
        int quantFuncsDocs = calcQuantFuncDocs();
        if (listaFuncionarios.isEmpty()) {
            throw new ErroCadastroException("Não há funcionarios cadastrados no "
                    + "sistema.");
        } else {
            for (Cliente clienteNaLista : listaClientes) {
                if (clienteNaLista.getNome().equals(funcionario.getNome())) {
                    throw new ErroCadastroException("Já existe um cliente com "
                            + "o mesmo nome cadastrado no sistema.");
                } else if (clienteNaLista.getCpf().equals(funcionario.getCpf())) {
                    throw new ErroCadastroException("Já existe um cliente com "
                            + "o mesmo CPF cadastrado no sistema.");
                } else if (clienteNaLista.getEmail().equals(funcionario.getEmail())) {
                    throw new ErroCadastroException("Já existe um cliente com "
                            + "o mesmo email cadastrado no sistema.");
                }
            }
            for (Funcionario funcNaLista : listaFuncionarios) {
                if (funcNaLista.getIdFuncionario() != funcionario.getIdFuncionario()) {
                    if (funcNaLista.getNome().equals(funcionario.getNome())) {
                        throw new ErroCadastroException("Já existe um "
                                + "funcionario com o mesmo nome cadastrado no "
                                + "sistema.");
                    } else if (funcNaLista.getCpf().equals(funcionario.getCpf())) {
                        throw new ErroCadastroException("Já existe um "
                                + "funcionario com o mesmo CPF cadastrado no "
                                + "sistema.");
                    } else if (funcNaLista.getEmail().equals(funcionario.getEmail())) {
                        throw new ErroCadastroException("Já existe um "
                                + "funcionario com o mesmo email cadastrado no "
                                + "sistema.");
                    } else if (funcNaLista.getLogin().equals(funcionario.getLogin())) {
                        throw new ErroCadastroException("Já existe um "
                                + "funcionario com o mesmo login cadastrado no "
                                + "sistema.");
                    }
                } else {
                    if (quantFuncsDocs <= 1
                            && funcNaLista.getSetor().equals(Setores.DOCUMENTOS)
                            && !funcionario.getSetor().equals(Setores.DOCUMENTOS)) {
                        throw new ErroCadastroException("Impossível mudar o "
                                + "setor. É necessário que haja ao menos um "
                                + "funcionário do setor de documentos "
                                + "cadastrado no sistema.");
                    } else {
                        funcDao.altera(funcionario);
                    }
                }
            }
        }
        
    }

    /**
     * Remove um funcionário do sistema usando a classe FuncionarioDao. Ela não
     * permite que se remova o último funcionário do setor de documentos
     * restante.
     * @param func O funcionário que se deseja remover.
     * @throws ErroCadastroException Lança esta excessão se não houverem 
     * funcionários cadastrados no sistema ou se o funcionário que se deseja 
     * remover for o último funcionário do setor de documentos restante.
     */
    public void remove(Funcionario func) throws ErroCadastroException {
        int quantFuncsDocs = calcQuantFuncDocs();
        boolean funcExisteNaLista = false;
        if (listaFuncionarios.isEmpty()) {
            throw new ErroCadastroException("Não há funcionários cadastrados "
                    + "no sistema.");
        } else {
            for (Funcionario funcNaLista : listaFuncionarios) {
                if (funcNaLista.getIdFuncionario() == func.getIdFuncionario()) {
                    if (quantFuncsDocs <= 1
                            && funcNaLista.getSetor().equals(Setores.DOCUMENTOS)) {
                        throw new ErroCadastroException("Impossível remover. "
                                + "É necessário que haja ao menos um "
                                + "funcionário do setor de documentos "
                                + "cadastrado no sistema.");
                    } else {
                        funcDao.remove(func);
                        funcExisteNaLista = true;
                    }
                }
            }
            if (!funcExisteNaLista) {
                throw new ErroCadastroException("Este funcionário não está "
                        + "cadastrado no sistema.");
            }
        }
    }
    
    /**
     * Busca um funcionário pelo seu nome usando a classe FuncionarioDao.
     * @param nome
     * @return Retorna uma referência para um Funcionario ou null, se não o 
     * encontrar.
     */
    public Funcionario buscaPorNome(String nome) {
        if (listaFuncionarios.isEmpty()) {
            return null;
        } else {
            for (Funcionario funcNaLista : listaFuncionarios) {
                if (funcNaLista.getNome().equals(nome)) {
                    return funcNaLista; // Encontrado.
                }
            }
            return null; // Não encontrado.
        }
    }
    
    /**
     * Calcula a quantidade de funcionários do setor de documentos existentes
     * no sistema. Para isso, usa a classe FuncionarioDao.
     * @return Retorna a quantidade de funcionários no setor de documentos.
     */
    public int calcQuantFuncDocs() {
        int quant = 0;
        for (Funcionario funcNaLista : listaFuncionarios) {
            if (funcNaLista.getSetor().equals(Setores.DOCUMENTOS)) {
                quant++;
            }
        }
        return quant;
    }

}
