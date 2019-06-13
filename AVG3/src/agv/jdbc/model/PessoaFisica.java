/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.model;

import agv.exceptions.ValorInvalidoException;

/**
 *
 * @author barab
 */
public abstract class PessoaFisica {

    private String nome;
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws ValorInvalidoException {
        if (cpf.length() == "xxx.xxx.xxx-xx".length()
                && cpf.charAt(3) == '.'
                && cpf.charAt(7) == '.'
                && cpf.charAt(11) == '-'
                && Character.isDigit(cpf.charAt(0))
                && Character.isDigit(cpf.charAt(1))
                && Character.isDigit(cpf.charAt(2))
                && Character.isDigit(cpf.charAt(4))
                && Character.isDigit(cpf.charAt(5))
                && Character.isDigit(cpf.charAt(6))
                && Character.isDigit(cpf.charAt(8))
                && Character.isDigit(cpf.charAt(9))
                && Character.isDigit(cpf.charAt(10))
                && Character.isDigit(cpf.charAt(12))
                && Character.isDigit(cpf.charAt(13))) {
            this.cpf = cpf;
        } else {
            throw new ValorInvalidoException("CPF inválido. Por favor, insira "
                    + "um CPF no formato xxx.xxx.xxx-xx");
        }
    }
}
