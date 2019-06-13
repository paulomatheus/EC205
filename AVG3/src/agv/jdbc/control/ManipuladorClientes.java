/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.control;

import agv.exceptions.ErroCadastroException;
import agv.jdbc.model.Cliente;
import agv.jdbc.dao.ClienteDao;
import agv.jdbc.dao.FuncionarioDao;
import agv.jdbc.model.Funcionario;
import java.util.ArrayList;

/**
 * Classe que manipula cadastros de clientes usando a classe ClienteDao.
 * @author Bruno Almeida Rabelo
 */
public class ManipuladorClientes {

    private final ClienteDao clienteDao = new ClienteDao();
    private final FuncionarioDao funcDao = new FuncionarioDao();
    private final ArrayList<Cliente> listaClientes;
    private final ArrayList<Funcionario> listaFuncionarios;

    public ManipuladorClientes() {
        listaClientes = clienteDao.getLista();
        listaFuncionarios = funcDao.getLista();
    }

    /**
     * Usa a classe ClienteDao para retornar uma ArrayList com todos os clientes
     * cadastrados no sistema.
     * @return Uma lista com todos os clientes cadastrados no sistema ou null
     * se não houverem clientes cadastrados.
     */
    public ArrayList<Cliente> getListaClientes() {
        if (listaClientes.isEmpty()) {
            return null;
        } else {
            return listaClientes;
        }
    }

    /**
     * Cadastra um cliente no sistema usando a classe ClienteDao.
     * @param cliente
     * @throws ErroCadastroException Retorna esta exceção se já houver no
     * sistema um cliente ou um funcionário com o mesmo nome, CPF ou email.
     */
    public void cadastra(Cliente cliente) throws ErroCadastroException {
        for (Cliente clienteNaLista : listaClientes) {
            if (clienteNaLista.getNome().equals(cliente.getNome())) {
                throw new ErroCadastroException("Já existe um cliente com o "
                        + "mesmo nome cadastrado no sistema.");
            } else if (clienteNaLista.getCpf().equals(cliente.getCpf())) {
                throw new ErroCadastroException("Já existe um cliente com o "
                        + "mesmo CPF cadastrado no sistema.");
            } else if (clienteNaLista.getEmail().equals(cliente.getEmail())) {
                throw new ErroCadastroException("Já existe um cliente com o "
                        + "mesmo email cadastrado no sistema.");
            }
        }
        for (Funcionario funcNaLista : listaFuncionarios) {
            if (funcNaLista.getNome().equals(cliente.getNome())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo nome cadastrado no sistema.");
            } else if (funcNaLista.getCpf().equals(cliente.getCpf())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo CPF cadastrado no sistema.");
            } else if (funcNaLista.getEmail().equals(cliente.getEmail())) {
                throw new ErroCadastroException("Já existe um funcionario com "
                        + "o mesmo email cadastrado no sistema.");
            }
        }
        clienteDao.adiciona(cliente);
    }

    /**
     * Edita o cadastro de um cliente no sistema. Usa a classe ClienteDao.
     * @param cliente
     * @throws ErroCadastroException Retorna esta exeção se as alterações forem
     * inválidas, ou seja, se elas implicarem que este cliente terá o mesmo 
     * nome, o mesmo CPF ou o mesmo email de outro cliente ou funcionário
     * cadastrado no sistema.
     */
    public void edita(Cliente cliente) throws ErroCadastroException {
        if (listaClientes.isEmpty()) {
            throw new ErroCadastroException("Não há clientes cadastrados no "
                    + "sistema.");
        } else {
            for (Cliente clienteNaLista : listaClientes) {
                if (clienteNaLista.getIdCliente() != cliente.getIdCliente()) {
                    if (clienteNaLista.getNome().equals(cliente.getNome())) {
                        throw new ErroCadastroException("Já existe um cliente "
                                + "com o mesmo nome cadastrado no sistema.");
                    } else if (clienteNaLista.getCpf().equals(cliente.getCpf())) {
                        throw new ErroCadastroException("Já existe um cliente "
                                + "com o mesmo CPF cadastrado no sistema.");
                    } else if (clienteNaLista.getEmail().equals(cliente.getEmail())) {
                        throw new ErroCadastroException("Já existe um cliente "
                                + "com o mesmo email cadastrado no sistema.");
                    }
                }
            }
            for (Funcionario funcNaLista : listaFuncionarios) {
                if (funcNaLista.getNome().equals(cliente.getNome())) {
                    throw new ErroCadastroException("Já existe um funcionario "
                            + "com o mesmo nome cadastrado no sistema.");
                } else if (funcNaLista.getCpf().equals(cliente.getCpf())) {
                    throw new ErroCadastroException("Já existe um funcionario "
                            + "com o mesmo CPF cadastrado no sistema.");
                } else if (funcNaLista.getEmail().equals(cliente.getEmail())) {
                    throw new ErroCadastroException("Já existe um funcionario "
                            + "com o mesmo email cadastrado no sistema.");
                }
            }
            clienteDao.altera(cliente);
        }
    }
    /**
     * Remove um cliente do sistema usando o ClienteDao.
     * @param cliente 
     * @throws ErroCadastroException Retorna esta exceção se não houverem 
     * clientes cadastrados no sistema ou se o cliente que se deseja remover
     * não estiver cadastrado no sistema.
     */
    public void remove(Cliente cliente) throws ErroCadastroException {
        boolean clienteExisteNaLista = false;
        if (listaClientes.isEmpty()) {
            throw new ErroCadastroException("Não há clientes cadastrados no "
                    + "sistema.");
        } else {
            for (Cliente clienteNaLista : listaClientes) {
                if (clienteNaLista.getIdCliente() == cliente.getIdCliente()) {
                    clienteDao.remove(cliente);
                    clienteExisteNaLista = true;
                }
            }
            if (!clienteExisteNaLista) {
                throw new ErroCadastroException("Este cliente não está "
                        + "cadastrado no sistema.");
            }
        }
    }
    
    /**
     * Busca um cliente no sistema pelo nome.
     * @param nome O nome completo do cliente.
     * @return Retorna um cliente ou null, se não o encontrar.
     */
    public Cliente buscaPorNome(String nome) {
        if (listaClientes.isEmpty()) {
            return null;
        } else {
            for (Cliente clienteNaLista : listaClientes) {
                if (clienteNaLista.getNome().equals(nome)) {
                    return clienteNaLista; // Encontrado.
                }
            }
            return null; // Não encontrado.
        }
    }
}
