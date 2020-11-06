package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class Usuario {
    private int ID;
    private String LOGIN;
    private String SENHA;
    private String ADM;
    private String DELET;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public void setLOGIN(String LOGIN) {
        this.LOGIN = LOGIN;
    }

    public String getSENHA() {
        return SENHA;
    }

    public void setSENHA(String SENHA) {
        this.SENHA = SENHA;
    }

    public String getADM() {
        return ADM;
    }

    public void setADM(String ADM) {
        this.ADM = ADM;
    }

    public String getDELET() {
        return DELET;
    }

    public void setDELET(String DELET) {
        this.DELET = DELET;
    }
}
