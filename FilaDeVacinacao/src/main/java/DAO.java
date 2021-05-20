
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO {

    public boolean existe(Administrador administrador) throws Exception {
        String sql = "SELECT * FROM tb_administrador WHERE usuario = ? AND senha = ?";
        try (Connection conn = ConexaoBD.obtemConexao() ;
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, administrador.getUsuario());
            ps.setString(2, administrador.getSenha());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}



