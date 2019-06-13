/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.dao;

import agv.exceptions.ValorInvalidoException;
import agv.jdbc.ConnectionFactory;
import agv.jdbc.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 * DAO para a tabela clientes no banco de dados. Ele não valida os dados que 
 * recebe.
 * @author Bruno Almeida Rabelo
 */
public class ClienteDao {

    /**
     * Insere um cliente na tabela clientes. O servidor fica responsável por 
     * definir o atributo idCliente.
     * @param cliente Um cliente.
     */
    public void adiciona(Cliente cliente) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "insert into clientes (nome,cpf,email) "
                + "values (?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
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
     * Obtém todos os valores da tabela clientes.
     * @return Retorna uma ArrayList com os dados de todos os clientes na
     * tabela clientes.
     */
    public ArrayList<Cliente> getLista() {
        Connection connection = new ConnectionFactory().getConnection();
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (PreparedStatement stmt = connection.
                prepareStatement("select * from clientes");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                try {
                    cliente.setCpf(rs.getString("cpf"));
                } catch (ValorInvalidoException ex) {
                    throw new RuntimeException();
                }
                cliente.setEmail(rs.getString("email"));
                cliente.setIdViagem(rs.getInt("id_viagem"));
                clientes.add(cliente);
            }
            return clientes;
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
     * Altera os dados de um cliente na tabela clientes.
     * @param cliente 
     */
    public void altera(Cliente cliente) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "update clientes set nome=?, cpf=?, email=?, id_viagem=?"
                + " where id_cliente=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getEmail());
            if (cliente.getIdViagem() == 0) {
                stmt.setNull(4, Types.INTEGER);
            } else {
                stmt.setInt(4, cliente.getIdViagem());
            }
            stmt.setInt(5, cliente.getIdCliente());
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
     * Remove um cliente da tabela clientes.
     * @param cliente 
     */
    public void remove(Cliente cliente) {
        Connection connection = new ConnectionFactory().getConnection();

        try (PreparedStatement stmt = connection
                .prepareStatement("delete from clientes where id_cliente=?")) {
            stmt.setInt(1, cliente.getIdCliente());
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
