import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {

    public void inserir(Material material) throws SQLException {
        String sql = "INSERT INTO Material (Nome_Material, Quantidade) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getNomeMaterial());
            stmt.setInt(2, material.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Material material) throws SQLException {
        String sql = "UPDATE Material SET Nome_Material = ?, Quantidade = ? WHERE ID_Material = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, material.getNomeMaterial());
            stmt.setInt(2, material.getQuantidade());
            stmt.setInt(3, material.getIdMaterial());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idMaterial) throws SQLException {
        String sql = "DELETE FROM Material WHERE ID_Material = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
        }
    }

    public List<Material> listar() throws SQLException {
        String sql = "SELECT * FROM Material";
        List<Material> materiais = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Material material = new Material(
                        rs.getInt("ID_Material"),
                        rs.getString("Nome_Material"),
                        rs.getInt("Quantidade")
                );
                materiais.add(material);
            }
        }
        return materiais;
    }
}
