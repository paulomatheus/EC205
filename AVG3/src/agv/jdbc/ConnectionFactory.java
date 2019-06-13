package agv.jdbc;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Cria uma conexão com o banco de dados bdagv.
 * @author Bruno Almeida Rabelo
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            //alterar o usuario e senha de acordo com o banco de dados
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/BDAGV?useSSL=false&use"
                    + "Timezone=true&serverTimezone=Brazil/East", "root",/*senha do Bruno*/"root"
                    /*senha do Paulo/"admin1234"*/);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
