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
public class Funcionario extends PessoaFisica {

    private int idFuncionario;
    private String email;
    private Setores setor;
    private Cargos cargo;
    private String login;
    private String senha;
    private int idViagem;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Setores getSetor() {
        return setor;
    }

    public void setSetor(Setores setor) {
        this.setor = setor;
    }

    public void setSetor(String nomeSetor) throws ValorInvalidoException {
        Setores setores[] = Setores.values();
        boolean setorEhValido = false;
        for (Setores set : setores) {
            if (set.getNomeSetor().equals(nomeSetor)) {
                this.setor = set;
                setorEhValido = true;
            }
        }
        if (!setorEhValido) {
            throw new ValorInvalidoException("Setor inválido.");
        }
    }

    public Cargos getCargo() {
        return cargo;
    }

    public void setCargo(Cargos cargo) {
        this.cargo = cargo;
    }

    public void setCargo(String nomeCargo) throws ValorInvalidoException {
        Cargos cargos[] = Cargos.values();
        boolean cargoEhValido = false;
        for (Cargos carg : cargos) {
            if (carg.getNomeCargo().equals(nomeCargo)) {
                this.cargo = carg;
                cargoEhValido = true;
            }
        }
        if (!cargoEhValido) {
            throw new ValorInvalidoException("Cargo inválido.");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdViagem() {
        return idViagem;
    }

    public void setIdViagem(int idViagem) {
        this.idViagem = idViagem;
    }

}
