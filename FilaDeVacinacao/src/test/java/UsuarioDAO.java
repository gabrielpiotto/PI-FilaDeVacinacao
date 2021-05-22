
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * Classe que manipula objetos (CRUD) do Java e registros MySQL do tipo
 * 'Usuario'.
 *
 */
public class UsuarioDAO {

    // CRUD Usuario:
    
    // CREATE: Insere novos registros na tabela 'tb_usuario'
    public void cadastrarUsuario(Usuario usuario) {

        // 1° passo: criar comando SQL:
        String sql = "INSERT INTO tb_usuario (usuario, senha) VALUES (?, ?)";

        // 2° passo: abrir uma conexão com o bancode dados:
        try {
            Connection con = ConexaoDB.getConexao();

            // 3° passo: pré compilar o comando SQL:
            PreparedStatement pst = con.prepareStatement(sql);

            // 4° passo: preencher todas as interrogações:
            pst.setString(0, usuario.getUsuario());
            pst.setString(1, usuario.getSenha());

            // 5° passo: executar
            pst.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ: Exibe todos os registros da tabela 'tb_usuario'
    public void listarUsuario() {

        // 1°..
        String sql = "SELECT * FROM tb_usuarios";

        // 2°..
        try {
            Connection con = ConexaoDB.getConexao();

            // 3°..
            PreparedStatement pst = con.prepareStatement(sql);

            // 4° passo: Executar o comando e receber o resultado, armazenando num ResultSet
            ResultSet rs = pst.executeQuery();

            // Iterar sobre o ResultSet:
            // Gera resultados enquanto tiver um proximo a ser exibido
            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");

                // Formatantdp para exibição:
                String s = String.format("ID: $d\nUsuario: %s\nSenha: %s",id , usuario, senha);
                JOptionPane.showMessageDialog(null, s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // UPDATE: Atualiza os registros da tabela 'tb_usuario' 
    public void atualizarUsuario(Usuario usuario) {
        // 1°..
        String sql = "UPDATE tb_usuario SET usuario = ?, senha = ? WHERE id = ?";
        
        // 2°..
        try {
            Connection con = ConexaoDB.getConexao();
            
            // 3°..
            PreparedStatement pst = con.prepareStatement(sql);
            
            // 4° passo: preencher todas as interrogações:
            pst.setString(0, usuario.getUsuario());
            pst.setString(1, usuario.getSenha());
            pst.setInt(2, usuario.getId());
            
            // 5°..
            pst.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // DELETE:
    public void apagarUsuario(Usuario usuario) {
        // 1°..
        String sql = "DELETE FROM tb_usuario WHERE id = ?";
        
        // 2°..
        try {
            Connection con = ConexaoDB.getConexao();
            
            // 3°..
            PreparedStatement pst = con.prepareStatement(sql);
            
            // 4°..
            pst.setInt(0, usuario.getId());
        } catch (Exception e) {
        }
    }

    // Saber se existe determinado usuario e senha no banco de dados
    public boolean existeUsuario(Usuario usuario) {

        // 1° passo: criar comando SQL:
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";

        try {
            // Obtendo conexão com o banco de dados
            Connection con = ConexaoDB.getConexao();

            // pré-compilar o comando SQL (Segurança para seu banco de dados):
            PreparedStatement pst = con.prepareStatement(sql);

            // Preenchendo os '?':
            pst.setString(1, usuario.getUsuario());
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
