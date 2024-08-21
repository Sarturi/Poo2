public class Material {
    private int idMaterial;
    private String nomeMaterial;
    private int quantidade;

    public Material(int idMaterial, String nomeMaterial, int quantidade) {
        this.idMaterial = idMaterial;
        this.nomeMaterial = nomeMaterial;
        this.quantidade = quantidade;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public String getNomeMaterial() {
        return nomeMaterial;
    }

    public int getQuantidade() {
        return quantidade;
    }

}
