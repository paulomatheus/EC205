/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.model;

import agv.exceptions.ValorInvalidoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author barab
 */
public class Viagem {

    private int idViagem;
    private String nome;
    private String destino;
    private int duracao;
    private int limitePessoas;
    private double precoPorPessoa;

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) throws ValorInvalidoException {
        if (duracao >= 1) {
            this.duracao = duracao;
        } else {
            throw new ValorInvalidoException("A duração da viagem deve ser um "
                    + "valor maior ou igual a um.");
        }
    }

    public void setDuracao(String duracao) throws ValorInvalidoException {
        try {
            setDuracao(Integer.parseUnsignedInt(duracao));
        } catch (NumberFormatException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValorInvalidoException("A duração da viagem deve ser "
                    + "um valor numérico maior ou igual a um.");
        }
    }

    public int getLimitePessoas() {
        return limitePessoas;
    }

    public void setLimitePessoas(int limitePessoas) throws ValorInvalidoException {
        if (limitePessoas >= 1) {
            this.limitePessoas = limitePessoas;
        } else {
            throw new ValorInvalidoException("O limite de clientes deve ser "
                    + "um valor maior ou igual a um.");
        }
    }

    public void setLimitePessoas(String limiteClientes) throws ValorInvalidoException {
        try {
            setLimitePessoas(Integer.parseUnsignedInt(limiteClientes));
        } catch (NumberFormatException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValorInvalidoException("O limite de clientes deve ser "
                    + "um valor numérico maior ou igual a um.");
        }
    }

    public double getPrecoPorPessoa() {
        return precoPorPessoa;
    }

    public void setPrecoPorPessoa(double precoPorPessoa) throws ValorInvalidoException {
        if (precoPorPessoa > 0) {
            this.precoPorPessoa = precoPorPessoa;
        } else {
            throw new ValorInvalidoException("O preço por pessoa deve ser um "
                    + "valor numérico maior do que zero");
        }
    }

    public void setPrecoPorPessoa(String precoPorPessoa) throws ValorInvalidoException {
        try {
            setPrecoPorPessoa(Double.parseDouble(precoPorPessoa));
        } catch (NumberFormatException ex) {
            Logger.getLogger(Viagem.class.getName()).log(Level.SEVERE, null, ex);
            throw new ValorInvalidoException("O preço por pessoa deve ser um "
                    + "valor numérico maior do que zero.");
        }
    }

    public void adicionaClienteNaViagem(Cliente cliente) {
        //...
    }

    public void removeClienteDaViagem(Cliente cliente) {
        //...
    }

    public void removeTodosOsClientesDaViagem() {
        //...
    }
    
    public boolean clienteJaEstaNaViagem(Cliente cliente) {
        //...
        return true;
    }
    
    public void adicionaFuncNaViagem(Funcionario func) {
        //...
    }
    
    public void removeFuncDaViagem(Funcionario func) {
        //...
    }
    
    public void removeTodosOsFuncsDaViagem(Funcionario func) {
        
    }
    
    public boolean funcJaEstaNaViagem(Funcionario func) {
        //...
        return true;
    }
}
