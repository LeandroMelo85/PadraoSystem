package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import View.TelaPrincipal;

/**
 *
 * @author Leandro Melo
 */
public class ConnectionFactory {

//SQL SERVER PADRAO
    public static Connection connection;
    public static String classDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String URL = "jdbc:sqlserver://10.10.0.201:1433;databaseName=tombamento;";
    public static String URLHome = "jdbc:sqlserver://;databaseName=tombamento;";
    public static String USER = "usertomb";
    public static String PASS = "123@Abcd";
    
    //MYSQL
    /*private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://21.21.0.201/test";
    private static final String USER = "root";
    private static final String PASS = "135128Lm";*/

   //CONEXÃO MYSQL
    /*public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao conectar: ", ex);
        }
    }*/

    public static Connection getConnection() {
        if(TelaPrincipal.cbSelecionaLocal.isSelected()){
            
            try {
                Class.forName(classDriver);
                connection = DriverManager.getConnection(URL, USER, PASS);
    //          JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!!");
                return connection;
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
                return null;
            }
            
        } else {
            
            try {
                Class.forName(classDriver);
                connection = DriverManager.getConnection(URLHome, USER, PASS);
    //          JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!!");
                return connection;
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Erro: " + erro.getMessage());
                return null;
            }
        }

    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection (con);
        
        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        
        closeConnection (con, stmt);
        
        try {
            if (rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

