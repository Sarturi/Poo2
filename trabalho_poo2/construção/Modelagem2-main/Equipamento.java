public class Equipamento {
    private int idEquipamento;
    private String nomeEquipamento;
    private String tipo;

    public Equipamento(int idEquipamento, String nomeEquipamento, String tipo) {
        this.idEquipamento = idEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.tipo = tipo;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public String getTipo() {
        return tipo;
    }
    
}
