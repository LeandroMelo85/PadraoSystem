package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class Cadastro {
    private int ID;
    private String NOME;
    private String TELEFONE;
    private String CELULAR;
    private String PRODUTO;
    private String FABRICANTE;
    private String CODIGO;
    private String EMAIL;
    private String DT_INCLUSAO;
    private String DELET;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getTELEFONE() {
        return TELEFONE;
    }

    public void setTELEFONE(String TELEFONE) {
        this.TELEFONE = TELEFONE;
    }
    
    public String getCELULAR() {
        return CELULAR;
    }

    public void setCELULAR(String CELULAR) {
        this.CELULAR = CELULAR;
    }

    public String getPRODUTO() {
        return PRODUTO;
    }

    public void setPRODUTO(String PRODUTO) {
        this.PRODUTO = PRODUTO;
    }
    
    public String getFABRICANTE() {
        return FABRICANTE;
    }

    public void setFABRICANTE(String FABRICANTE) {
        this.FABRICANTE = FABRICANTE;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDT_INCLUSAO() {
        return DT_INCLUSAO;
    }

    public void setDT_INCLUSAO(String DT_INCLUSAO) {
        this.DT_INCLUSAO = DT_INCLUSAO;
    }

    public String getDELET() {
        return DELET;
    }

    public void setDELET(String DELET) {
        this.DELET = DELET;
    }
}
