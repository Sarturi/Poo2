import java.util.Date;

public class Projeto {
    private int idProjeto;
    private String nomeProjeto;
    private String local;
    private Date dataInicio;
    private Date dataTermino;

   
    public Projeto(int idProjeto, String nomeProjeto, String local, Date dataInicio, Date dataTermino) {
        this.idProjeto = idProjeto;
        this.nomeProjeto = nomeProjeto;
        this.local = local;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
    }


    public int getIdProjeto() {
        return idProjeto;
    }


    public String getNomeProjeto() {
        return nomeProjeto;
    }


    public String getLocal() {
        return local;
    }


    public Date getDataInicio() {
        return dataInicio;
    }


    public Date getDataTermino() {
        return dataTermino;
    }

}
