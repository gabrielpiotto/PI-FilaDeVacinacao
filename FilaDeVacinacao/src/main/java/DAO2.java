import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO2 {

    public boolean existe(Atendente atendente) throws Exception {
        String sql = "SELECT * FROM tb_atendente WHERE usuario = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao() ;
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, atendente.getUsuario());
            ps.setString(2, atendente.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}



