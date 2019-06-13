/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agv.jdbc.dao;

import agv.exceptions.ValorInvalidoException;
import agv.jdbc.ConnectionFactory;
import agv.jdbc.model.Viagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author barab
 */
public class ViagemDao {

    public void adiciona(Viagem viagem) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "insert into viagens (nome,destino,duracao,"
                + "limite_pessoas,preco_por_pessoa) "
                + "values (?,?,?,?,?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, viagem.getNome());
            stmt.setString(2, viagem.getDestino());
            stmt.setInt(3, viagem.getDuracao());
            stmt.setInt(4, viagem.getLimitePessoas());
            stmt.setDouble(5, viagem.getPrecoPorPessoa());
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

    public ArrayList<Viagem> getLista() {
        Connection connection = new ConnectionFactory().getConnection();
        ArrayList<Viagem> viagens = new ArrayList<>();

        try (PreparedStatement stmt = connection.
                prepareStatement("select * from viagens");
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Viagem viagem = new Viagem();
                viagem.setIdViagem(rs.getInt("id_viagem"));
                viagem.setNome(rs.getString("nome"));
                viagem.setDestino(rs.getString("destino"));
                viagem.setDuracao(rs.getInt("duracao"));
                viagem.setLimitePessoas(rs.getInt("limite_pessoas"));
                viagem.setPrecoPorPessoa(rs.getDouble("preco_por_pessoa"));
                viagens.add(viagem);
            }
            return viagens;
        } catch (SQLException | ValorInvalidoException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public void altera(Viagem viagem) {
        Connection connection = new ConnectionFactory().getConnection();
        String sql = "update viagens set nome=?, destino=?, duracao=?, "
                + "limite_pessoas=?, preco_por_pessoa=? "
                + "where id_viagem=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, viagem.getNome());
            stmt.setString(2, viagem.getDestino());
            stmt.setInt(3, viagem.getDuracao());
            stmt.setInt(4, viagem.getLimitePessoas());
            stmt.setDouble(5, viagem.getPrecoPorPessoa());
            stmt.setInt(6, viagem.getIdViagem());
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

    public void remove(Viagem viagem) {
        Connection connection = new ConnectionFactory().getConnection();

        try (PreparedStatement stmt = connection
                .prepareStatement("delete from viagens where nome=?")) {
            stmt.setString(1, viagem.getNome());
            stmt.execute();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
