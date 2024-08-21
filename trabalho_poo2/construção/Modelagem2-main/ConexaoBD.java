import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instancia;
    private Connection conexao;

    private ConexaoBD() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/dust2";
        String usuario = "1144006432";
        String senha = "0000";
        this.conexao = DriverManager.getConnection(url, usuario, senha);
    }

    public static ConexaoBD getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new ConexaoBD();
        } else if (instancia.getConexao().isClosed()) {
            instancia = new ConexaoBD();
        }

        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}
