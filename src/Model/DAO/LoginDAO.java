package Model.DAO;

import Connection.ConnectionFactory;
import Model.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leandro Melo
 */
public class LoginDAO {

    public boolean read(Usuario user) {
        boolean ok = false;

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usu = new Usuario();
        try {
            stmt = con.prepareStatement("SELECT * FROM PASSWD WHERE LOGIN = ? AND SENHA = ? AND DELET = ?");
            stmt.setString(1, user.getLOGIN());
            //System.out.println("Login vindo do objeto: " + user.getLOGIN());
            stmt.setString(2, user.getSENHA());
            //System.out.println("Senha vinda do objeto: " + user.getSENHA());
            stmt.setString(3, "");
            rs = stmt.executeQuery();
            //System.out.println("Executou query");

            if (rs.next()) {
                usu.setLOGIN(rs.getString("LOGIN"));
                usu.setSENHA(rs.getString("SENHA"));
                //System.out.println("Voltou Preenchido");
                ok = user.getLOGIN().equals(rs.getString("LOGIN")) && user.getSENHA().equals(rs.getString("SENHA"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return ok;
    }

}
