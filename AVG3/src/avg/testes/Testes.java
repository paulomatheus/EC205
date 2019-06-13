/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avg.testes;

import agv.exceptions.ErroCadastroException;
import agv.exceptions.ValorInvalidoException;
import agv.jdbc.control.ManipuladorClientes;
import agv.jdbc.control.ManipuladorFuncionarios;
import agv.jdbc.model.Cliente;
import agv.jdbc.model.Funcionario;

/**
 *
 * @author barab
 */
public class Testes {

    public static void main(String[] args) throws ValorInvalidoException, ErroCadastroException {
//        Viagem viagem = new Viagem();
//        viagem.setDestino("Casa do Bruno");
//        viagem.setDuracao(5);
//        viagem.setLimitePessoas(9);
//        viagem.setNome("Pacote premium Casa do Bruno");
//        viagem.setPrecoPorPessoa(25.88);
//        new ManipuladorViagens().cadastra(viagem);
        
        ManipuladorClientes manipClientes = new ManipuladorClientes();
        ManipuladorFuncionarios manipFunc = new ManipuladorFuncionarios();
        Cliente cliente = manipClientes.buscaPorNome("Joaquim da Silva");
        cliente.setIdViagem(0);
        manipClientes.edita(cliente);
        
        Funcionario func = manipFunc.buscaPorNome("Bruno Almeida Rabelo");
        func.setIdViagem(0);
        manipFunc.edita(func);
        
        func = manipFunc.buscaPorNome("Paulo Martins Araujo");
        func.setIdViagem(0);
        manipFunc.edita(func);
        
    }
}
