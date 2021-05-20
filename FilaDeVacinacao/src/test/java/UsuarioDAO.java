
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe que manipula objetos (CRUD) do Java e registros MySQL do tipo
 * 'Usuario'.
 *
 */
public class UsuarioDAO {

    /**
     * Saber se existe determinado usuario e senha no banco de dados
     *
     * @param usuario a ser buscado
     * @return
     */
    public boolean existe(Usuario usuario) {

        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";

        try {
            // Obtendo conexão com o banco de dados
            Connection con = ConexaoDB.obtemConexao();

            //
            PreparedStatement pst = con.prepareStatement(sql);

            // Preenchendo o primeiro '?'
            pst.setString(1, usuario.getUsuario());

            // Preenchendo o segundo '?'
            pst.setString(2, usuario.getSenha());

            // Executando o comando 'SELECT' e recebendo o retorno:
            ResultSet resultado = pst.executeQuery();

            // Tenta acessar os resultados:
            return resultado.next();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
