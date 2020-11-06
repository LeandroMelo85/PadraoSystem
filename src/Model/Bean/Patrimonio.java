package Model.Bean;

/**
 *
 * @author Leandro Melo
 */
public class Patrimonio {
    
    private int id;
    private String numTombamento;
    private String descricao;
    private String marca;
    private String observacao;
    private Computador computador;
    private Setor setor;
    
    public Patrimonio(){
        
    }

    public Patrimonio(Patrimonio patrimonio) {
        this.id = patrimonio.getId();
        this.numTombamento = patrimonio.getNumTombamento();
        this.descricao = patrimonio.getDescricao();
        this.marca = patrimonio.getMarca();
        this.observacao = patrimonio.getObservacao();
        this.computador = patrimonio.getComputador();
        this.setor = patrimonio.getSetor();
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Computador getComputador() {
        return computador;
    }

    public void setComputador(Computador computador) {
        this.computador = computador;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    @Override
    public String toString() {
        return "ID PATRIMONIO: " + id + 
               "\nNUM TOMBAMENTO: " + numTombamento + 
               "\nDESCRIÇÃO: " + descricao + 
               "\nMARCA: " + marca + 
               "\nOBSEVAÇÃO: " + observacao + 
               "\nCOMPUTADOR: \n" + computador + 
               "\nSETOR: \n" + setor + '\n';
    }

    
}
