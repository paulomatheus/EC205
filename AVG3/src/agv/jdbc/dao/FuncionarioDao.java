/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.dao;

import agv.jdbc.model.Funcionario;
import agv.exceptions.ValorInvalidoException;
import agv.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 * DAO para a tabela funcionarios no banco de dados. Este DAO não valida os 
 * dados que recebe.
 * @author Bruno Almeida Rabelo
 */
public class FuncionarioDao {

    /**
     * Insere um funcionário na tabela funcionarios. O servidor fica responsável
     * por definir o atributo idFuncionario.
     * @param funcionario
     */
    public void adiciona(Funcionario funcionario) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "insert into funcionarios (nome,cpf,email,setor,cargo,"
                + "login,senha) values (?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSetor().getNomeSetor());
            stmt.setString(5, funcionario.getCargo().getNomeCargo());
            stmt.setString(6, funcionario.getLogin());
            stmt.setString(7, funcionario.getSenha());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    /**
     * Obtém todos os valores da tabela funcionarios.
     * @return Retorna uma ArrayList com os dados de todos os funcionários na 
     * tabela funcionarios.
     */
    public ArrayList<Funcionario> getLista() {
        Connection connection = new ConnectionFactory().getConnection();
        ArrayList<Funcionario> funcionarios = new ArrayList<>();

        try (PreparedStatement stmt = connection.
                prepareStatement("select * from funcionarios");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                try {
                    funcionario.setIdFuncionario(rs.getInt("id_funcionario"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setSetor(rs.getString("setor"));
                    funcionario.setCargo(rs.getString("cargo"));
                    funcionario.setLogin(rs.getString("login"));
                    funcionario.setSenha(rs.getString("senha"));
                    funcionario.setIdViagem(rs.getInt("id_viagem"));
                    funcionarios.add(funcionario);
                } catch (ValorInvalidoException ex) {
                    throw new RuntimeException();
                }
            }
            return funcionarios;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Altera os dados de um funcionário na tabela funcionarios. 
     * @param funcionario
     */
    public void altera(Funcionario funcionario) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "update funcionarios set nome=?, cpf=?, email=?, setor=?, "
                + "cargo=?, login=?, senha=?, id_viagem=? "
                + "where id_funcionario=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSetor().getNomeSetor());
            stmt.setString(5, funcionario.getCargo().getNomeCargo());
            stmt.setString(6, funcionario.getLogin());
            stmt.setString(7, funcionario.getSenha());
            if (funcionario.getIdViagem() == 0) {
                stmt.setNull(8, Types.INTEGER);
            } else {
                stmt.setInt(8, funcionario.getIdViagem());
            }
            stmt.setInt(9, funcionario.getIdFuncionario());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * Remove um funcionário da tabela funcionarios. 
     * @param funcionario
     */
    public void remove(Funcionario funcionario) {
        Connection connection = new ConnectionFactory().getConnection();

        try (PreparedStatement stmt = connection.prepareStatement(
                "delete from funcionarios where id_funcionario=?")) {
            stmt.setInt(1, funcionario.getIdFuncionario());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
