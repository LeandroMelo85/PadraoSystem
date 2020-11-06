package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class User {
    
    private int id;
    private String userNome;
    private int idSetor;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public int getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(int idSetor) {
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return getUserNome();
    }

}
