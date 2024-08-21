import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    public void inserir(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO Equipamento (Nome_Equipamento, Tipo) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Equipamento equipamento) throws SQLException {
        String sql = "UPDATE Equipamento SET Nome_Equipamento = ?, Tipo = ? WHERE ID_Equipamento = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNomeEquipamento());
            stmt.setString(2, equipamento.getTipo());
            stmt.setInt(3, equipamento.getIdEquipamento());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEquipamento) throws SQLException {
        String sql = "DELETE FROM Equipamento WHERE ID_Equipamento = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            stmt.executeUpdate();
        }
    }

    public List<Equipamento> listar() throws SQLException {
        String sql = "SELECT * FROM Equipamento";
        List<Equipamento> equipamentos = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Equipamento equipamento = new Equipamento(
                        rs.getInt("ID_Equipamento"),
                        rs.getString("Nome_Equipamento"),
                        rs.getString("Tipo")
                );
                equipamentos.add(equipamento);
            }
        }
        return equipamentos;
    }
}
