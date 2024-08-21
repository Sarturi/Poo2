import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EngenheiroDAO {

    public void inserir(Engenheiro engenheiro) throws SQLException {
        String sql = "INSERT INTO Engenheiro (Nome_Engenheiro, Especialidade) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Engenheiro engenheiro) throws SQLException {
        String sql = "UPDATE Engenheiro SET Nome_Engenheiro = ?, Especialidade = ? WHERE ID_Engenheiro = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, engenheiro.getNomeEngenheiro());
            stmt.setString(2, engenheiro.getEspecialidade());
            stmt.setInt(3, engenheiro.getIdEngenheiro());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idEngenheiro) throws SQLException {
        String sql = "DELETE FROM Engenheiro WHERE ID_Engenheiro = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idEngenheiro);
            stmt.executeUpdate();
        }
    }

    public List<Engenheiro> listar() throws SQLException {
        String sql = "SELECT * FROM Engenheiro";
        List<Engenheiro> engenheiros = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Engenheiro engenheiro = new Engenheiro(
                        rs.getInt("ID_Engenheiro"),
                        rs.getString("Nome_Engenheiro"),
                        rs.getString("Especialidade")
                );
                engenheiros.add(engenheiro);
            }
        }
        return engenheiros;
    }
}
