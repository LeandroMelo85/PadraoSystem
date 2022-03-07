package Model.DAO;

import Connection.ConnectionFactory;
import Model.Bean.User;
import Model.Bean.Setor;
import Model.Bean.Computador;
import Model.Bean.Patrimonio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro Melo
 */
public class CadastroDAO {

    // Cadastrar um usuário.
    public static void createUser(User u) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO USUARIO (USER_NOME, ID_SETOR, DELET) VALUES(?,?,?)");
            stmt.setString(1, u.getUserNome());
            stmt.setInt(2, u.getIdSetor());
            stmt.setString(3, "");

            stmt.executeUpdate();

            //JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Cadastrar um setor.
    public static void createSetor(Setor s) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO SETOR (SETOR_NOME, DELET) VALUES(?,?)");
            stmt.setString(1, s.getSetorNome());
            stmt.setString(2, "");

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Cadastrar um computador. Retorna o ID que foi cadastrado.
    // Essa função é chamada automáticamente na criação de um patrimônio
    // onde está marcada a opção: É um PC?.
    public static int createComputador(Computador c) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO COMPUTADOR (NUM_TOMBAMENTO, PROCESSADOR, MEMORIA, HD, SSD, DELET) VALUES(?,?,?,?,?,?)");
            stmt.setString(1, c.getNumTombamento());
            stmt.setString(2, c.getProcessador());
            stmt.setString(3, c.getMemoria());
            stmt.setString(4, c.getHd());
            stmt.setBoolean(5, c.getSsd());
            stmt.setString(6, "");

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Computador cadastrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

        return readIdComputador(c);
    }

    // Cadastro de patrimônio quando a opção É um computador? está marcada
    public static void createPatrimonio(Patrimonio p) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PATRIMONIO (NUM_TOMBAMENTO, DESCRICAO, MARCA, OBSERVACAO, ID_SETOR, ID_PC, DELET) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNumTombamento());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getObservacao());
            stmt.setInt(5, p.getSetor().getId());
            stmt.setInt(6, createComputador(p.getComputador()));
            stmt.setString(7, "");

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Cadastro de patrimônio quando a opção É um computador? não está marcada.
    // É passado via parâmetro o valor 0 para a variável id.
    public void createPatrimonio(Patrimonio p, int id) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO PATRIMONIO (NUM_TOMBAMENTO, DESCRICAO, MARCA, OBSERVACAO, ID_SETOR, ID_PC, DELET) VALUES(?,?,?,?,?,?,?)");
            stmt.setString(1, p.getNumTombamento());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getMarca());
            stmt.setString(4, p.getObservacao());
            stmt.setInt(5, p.getSetor().getId());
            stmt.setInt(6, id);
            stmt.setString(7, "");

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    // Consulta dos usuários cadastrados no BD retornando tudo em uma lista.
    public List<User> readUser() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE DELET = ? ORDER BY USER_NOME");
            stmt.setString(1, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                User user = new User();
                user.setUserNome(rs.getString("USER_NOME"));
                usuarios.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuarios;
    }
    
    // Consulta de um usuário por id.
    public static User readUser(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        User user = new User();

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE ID = ? AND DELET = ?");
            stmt.setInt(1, id);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                user.setId(rs.getInt("ID"));
                user.setUserNome(rs.getString("USER_NOME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return user;
    }
    
    // Verificação da versão registrada no BD.
    public static String readVersion() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String versao = "";
        
        try {
            stmt = con.prepareStatement("SELECT * FROM VERSION");
            rs = stmt.executeQuery();
            
            while(rs.next()){
             versao = rs.getString("SYS_VERSION");   
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return versao;
    }
    
    public static boolean readVersion(String versao) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        String resultado = "";
        
        try {
            stmt = con.prepareStatement("SELECT * FROM VERSION");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                resultado = rs.getString("SYS_VERSION");
            }

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return versao.equals(resultado);
    }
    
    public List<Setor> readSetor() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Setor> setores = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM SETOR WHERE DELET = ?  ORDER BY SETOR_NOME");
            stmt.setString(1, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Setor setor = new Setor();
                setor.setId(rs.getInt("ID"));
                setor.setSetorNome(rs.getString("SETOR_NOME"));
                setores.add(setor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return setores;
    }

    public static Setor readSetor(int id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Setor setor = new Setor();

        try {
            stmt = con.prepareStatement("SELECT * FROM SETOR WHERE ID = ? AND DELET = ?");
            stmt.setInt(1, id);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                setor.setId(rs.getInt("ID"));
                setor.setSetorNome(rs.getString("SETOR_NOME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return setor;
    }

    public static Computador readComputador(String numTombamento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Computador computador = new Computador();

        try {
            stmt = con.prepareStatement("SELECT * FROM COMPUTADOR WHERE NUM_TOMBAMENTO = ? AND DELET = ?");
            stmt.setString(1, numTombamento);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {
                computador.setId(rs.getInt("ID"));
                computador.setNumTombamento(rs.getString("NUM_TOMBAMENTO"));
                computador.setProcessador(rs.getString("PROCESSADOR"));
                computador.setMemoria(rs.getString("MEMORIA"));
                computador.setHd(rs.getString("HD"));
                computador.setSsd(rs.getBoolean("SSD"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return computador;
    }

    public static int readIdSetor(Setor setor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM SETOR WHERE SETOR_NOME = ? AND DELET = ?");
            stmt.setString(1, setor.getSetorNome());
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                setor.setId(rs.getInt("ID"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return setor.getId();
    }

    public static int readIdUsuario(User usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USER_NOME = ? AND DELET = ?");
            stmt.setString(1, usuario.getUserNome());
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario.setId(rs.getInt("ID"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return usuario.getId();
    }

    public static int readIdComputador(Computador computador) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM COMPUTADOR WHERE NUM_TOMBAMENTO = ? AND DELET = ?");
            stmt.setString(1, computador.getNumTombamento());
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                computador.setId(rs.getInt("ID"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return computador.getId();
    }

    public static boolean verificaNumTombamento(String numTombamento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int contador = 0;
        boolean numTombExiste = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM PATRIMONIO WHERE NUM_TOMBAMENTO = ? AND DELET = ?");
            stmt.setString(1, numTombamento);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                contador++;

            }
            numTombExiste = contador > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return numTombExiste;
    }

    public static boolean verificaSetor(String nomeSetor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int contador = 0;
        boolean setorExiste = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM SETOR WHERE SETOR_NOME = ? AND DELET = ?");
            stmt.setString(1, nomeSetor);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                contador++;

            }
            setorExiste = contador > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return setorExiste;
    }

    public static boolean verificaUsuario(User usuario) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int contador = 0;
        boolean userExiste = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM USUARIO WHERE USER_NOME =  ? AND ID_SETOR = ? AND DELET = ?");
            stmt.setString(1, usuario.getUserNome());
            stmt.setInt(2, usuario.getIdSetor());
            stmt.setString(3, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                contador++;

            }
            userExiste = contador > 0;

        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return userExiste;
    }

    public static List<Patrimonio> readPatrimonio() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Patrimonio> patrimonio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PATRIMONIO WHERE DELET = ? ORDER BY NUM_TOMBAMENTO");
            stmt.setString(1, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Patrimonio pat = new Patrimonio();
                pat.setId(rs.getInt("ID"));
                pat.setNumTombamento(rs.getString("NUM_TOMBAMENTO"));
                pat.setDescricao(rs.getString("DESCRICAO"));

                pat.setMarca(rs.getString("MARCA"));
                pat.setObservacao(rs.getString("OBSERVACAO"));
                pat.setSetor(readSetor(rs.getInt("ID_SETOR")));
                pat.setComputador(new Computador());
                if(rs.getInt("ID_PC") > 0) {
                    pat.setComputador(readComputador(rs.getString("NUM_TOMBAMENTO")));
                }
//                System.out.println(pat);
                patrimonio.add(pat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return patrimonio;
    }

    public static List<Patrimonio> readPatrimonio(String numTombamento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Patrimonio> patrimonio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PATRIMONIO WHERE NUM_TOMBAMENTO LIKE ? AND DELET = ?");
            stmt.setString(1, "%" + numTombamento + "%");
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Patrimonio pat = new Patrimonio();
                pat.setId(rs.getInt("ID"));
                pat.setNumTombamento(rs.getString("NUM_TOMBAMENTO"));
                pat.setDescricao(rs.getString("DESCRICAO"));

                pat.setMarca(rs.getString("MARCA"));
                pat.setObservacao(rs.getString("OBSERVACAO"));
                pat.setSetor(readSetor(rs.getInt("ID_SETOR")));
                pat.setComputador(new Computador());
                if(rs.getInt("ID_PC") > 0) {
                    pat.setComputador(readComputador(rs.getString("NUM_TOMBAMENTO")));
                }
//                System.out.println(pat);
                patrimonio.add(pat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return patrimonio;
    }

    public static Patrimonio readPatrimonio2(String numTombamento) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Patrimonio pat = new Patrimonio();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM PATRIMONIO WHERE NUM_TOMBAMENTO = ? AND DELET = ?");
            stmt.setString(1, numTombamento);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                pat.setId(rs.getInt("ID"));
                pat.setNumTombamento(rs.getString("NUM_TOMBAMENTO"));
                pat.setDescricao(rs.getString("DESCRICAO"));

                pat.setMarca(rs.getString("MARCA"));
                pat.setObservacao(rs.getString("OBSERVACAO"));
                pat.setSetor(readSetor(rs.getInt("ID_SETOR")));
                pat.setComputador(new Computador());
                if(rs.getInt("ID_PC") > 0) {
                    pat.setComputador(readComputador(rs.getString("NUM_TOMBAMENTO")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pat;
    }

    public static List<Patrimonio> readPatrimonio(int idSetor) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Patrimonio> patrimonio = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PATRIMONIO WHERE ID_SETOR = ? AND DELET = ?");
            stmt.setInt(1, idSetor);
            stmt.setString(2, "");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Patrimonio pat = new Patrimonio();
                pat.setId(rs.getInt("ID"));
                pat.setNumTombamento(rs.getString("NUM_TOMBAMENTO"));
                pat.setDescricao(rs.getString("DESCRICAO"));

                pat.setMarca(rs.getString("MARCA"));
                pat.setObservacao(rs.getString("OBSERVACAO"));
                pat.setSetor(readSetor(rs.getInt("ID_SETOR")));
                pat.setComputador(new Computador());
                if(rs.getInt("ID_PC") > 0) {
                    pat.setComputador(readComputador(rs.getString("NUM_TOMBAMENTO")));
                }
//                System.out.println(pat);
                patrimonio.add(pat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return patrimonio;
    }

    public static void updatePatrimonio(Patrimonio p){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        if(p.getComputador() == null){
            try {
                stmt = con.prepareStatement("UPDATE PATRIMONIO SET DESCRICAO = ?, MARCA = ?, OBSERVACAO = ?, ID_SETOR = ? WHERE NUM_TOMBAMENTO = ?");
                stmt.setString(1, p.getDescricao());
                stmt.setString(2, p.getMarca());
                stmt.setString(3, p.getObservacao());
                stmt.setInt(4, p.getSetor().getId());
                stmt.setString(5, p.getNumTombamento());

                stmt.executeUpdate();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        } else {
            try {
                stmt = con.prepareStatement("UPDATE PATRIMONIO SET DESCRICAO = ?, MARCA = ?, OBSERVACAO = ?, ID_SETOR = ? WHERE NUM_TOMBAMENTO = ?");
                stmt.setString(1, p.getDescricao());
                stmt.setString(2, p.getMarca());
                stmt.setString(3, p.getObservacao());
                stmt.setInt(4, p.getSetor().getId());
                stmt.setString(5, p.getNumTombamento());

                stmt.executeUpdate();
                
                stmt = con.prepareStatement("UPDATE COMPUTADOR SET PROCESSADOR = ?, MEMORIA = ?, HD = ?, SSD = ? WHERE NUM_TOMBAMENTO =?");
                stmt.setString(1, p.getComputador().getProcessador());
                stmt.setString(2, p.getComputador().getMemoria());
                stmt.setString(3, p.getComputador().getHd());
                stmt.setBoolean(4, p.getComputador().getSsd());
                stmt.setString(5, p.getComputador().getNumTombamento());

                stmt.executeUpdate();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
        }
    }
    
    public static void updatePatrimonio(Computador c){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE COMPUTADOR SET PROCESSADOR = ?, MEMORIA = ?, HD = ?, SSD = ? WHERE NUM_TOMBAMENTO =?");
            stmt.setString(1, c.getProcessador());
            stmt.setString(2, c.getMemoria());
            stmt.setString(3, c.getHd());
            stmt.setBoolean(4, c.getSsd());
            stmt.setString(5, c.getNumTombamento());

            stmt.executeUpdate();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Cadastrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
    
}
