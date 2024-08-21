import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlocacaoEngenheiroDAO {

    public void inserir(int idProjeto, int idEngenheiro) throws SQLException {
        String sql = "INSERT INTO Alocacao_Engenheiro (ID_Projeto, ID_Engenheiro) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idEngenheiro);
            stmt.executeUpdate();
        }
    }

    public void excluir(int idProjeto, int idEngenheiro) throws SQLException {
        String sql = "DELETE FROM Alocacao_Engenheiro WHERE ID_Projeto = ? AND ID_Engenheiro = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.setInt(2, idEngenheiro);
            stmt.executeUpdate();
        }
    }

    public List<Engenheiro> listarEngenheirosPorProjeto(int idProjeto) throws SQLException {
        String sql = "SELECT e.* FROM Engenheiro e JOIN Alocacao_Engenheiro ae ON e.ID_Engenheiro = ae.ID_Engenheiro WHERE ae.ID_Projeto = ?";
        List<Engenheiro> engenheiros = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Engenheiro engenheiro = new Engenheiro(
                            rs.getInt("ID_Engenheiro"),
                            rs.getString("Nome_Engenheiro"),
                            rs.getString("Especialidade")
                    );
                    engenheiros.add(engenheiro);
                }
            }
        }
        return engenheiros;
    }
}
