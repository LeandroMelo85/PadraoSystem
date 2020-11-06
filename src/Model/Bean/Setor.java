package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class Setor {
    private int id;
    private String setorNome;
    
    public Setor(){
    
    }
    
    public Setor(Setor setor){
        this.id = setor.getId();
        this.setorNome = setor.getSetorNome();
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSetorNome() {
        return setorNome;
    }

    public void setSetorNome(String setorNome) {
        this.setorNome = setorNome;
    }

    @Override
    public String toString() {
        return getSetorNome();
    }

}
