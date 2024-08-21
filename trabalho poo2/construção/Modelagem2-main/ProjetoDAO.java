import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {

    public void inserir(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO Projeto (Nome_Projeto, Local, Data_Inicio, Data_Termino) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setDate(3, new java.sql.Date(projeto.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(projeto.getDataTermino().getTime()));
            stmt.executeUpdate();
        }
    }

    public void atualizar(Projeto projeto) throws SQLException {
        String sql = "UPDATE Projeto SET Nome_Projeto = ?, Local = ?, Data_Inicio = ?, Data_Termino = ? WHERE ID_Projeto = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNomeProjeto());
            stmt.setString(2, projeto.getLocal());
            stmt.setDate(3, new java.sql.Date(projeto.getDataInicio().getTime()));
            stmt.setDate(4, new java.sql.Date(projeto.getDataTermino().getTime()));
            stmt.setInt(5, projeto.getIdProjeto());
            stmt.executeUpdate();
        }
    }

    public void excluir(int idProjeto) throws SQLException {
        String sql = "DELETE FROM Projeto WHERE ID_Projeto = ?";
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.executeUpdate();
        }
    }

    public List<Projeto> listar() throws SQLException {
        String sql = "SELECT * FROM Projeto";
        List<Projeto> projetos = new ArrayList<>();
        try (Connection conn = ConexaoBD.getInstancia().getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Projeto projeto = new Projeto(
                        rs.getInt("ID_Projeto"),
                        rs.getString("Nome_Projeto"),
                        rs.getString("Local"),
                        rs.getDate("Data_Inicio"),
                        rs.getDate("Data_Termino")
                );
                projetos.add(projeto);
            }
        }
        return projetos;
    }
}
