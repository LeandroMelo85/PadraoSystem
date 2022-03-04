package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class Computador {
    
    private int id;
    private String numTombamento;
    private String processador;
    private String memoria;
    private String hd;
    private boolean ssd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNumTombamento() {
        return numTombamento;
    }

    public void setNumTombamento(String numTombamento) {
        this.numTombamento = numTombamento;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    public boolean getSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    @Override
    public String toString() {
        return "   ID: " + id + 
               "\n   NUM TOMBAMENTO: " + numTombamento + 
               "\n   PROCESSADOR: " + processador + 
               "\n   MEMÓRIA: " + memoria + 
               "\n   HD: " + hd + 
               "\n   SSD: " + ssd;
    }

}
