package Classe_Usuario;

import Core.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriel Piotto
 */
public class UsuarioDAO {

    /**
     * Classe que manipula objetos (CRUD) do Java e registros MySQL do tipo
     * 'Usuario'.
     *
     */
    // CRUD Usuario:
    // CREATE: Insere novos registros na tabela 'tb_usuario'
    public void cadastrarUsuario(Usuario usuario) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "INSERT INTO tb_usuario (usuario, senha, nivelAcesso) VALUES (?, ?, ?)";

        // 2° passo: abrir uma conexão com o bancode dados:
        try (Connection con = ConexaoDB.getConexao();
                // 3° passo: pré compilar o comando SQL:
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getNivelAcesso());

            // 5° passo: executar
            pst.execute();
        }
    }

    // READ: Exibe todos os registros da tabela 'tb_usuario'
    public void listarUsuario() throws Exception {

        // 1°..
        String sql = "SELECT * FROM tb_usuarios";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: Executar o comando e receber o resultado, armazenando num ResultSet
            ResultSet rs = pst.executeQuery();

            // Iterar sobre o ResultSet:
            // Gera resultados enquanto tiver um proximo a ser exibido
            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String nivelAcesso = rs.getString("nivelAcesso");

                // Formatando para exibição:
                String s = String.format("ID: $d\nUsuario: %s\nSenha: %s\nNivel de Acesso: %s", id, usuario, senha, nivelAcesso);
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }

    // UPDATE: Atualiza os registros da tabela 'tb_usuario' 
    public void atualizarUsuario(Usuario usuario) throws Exception {
        // 1°..
        String sql = "UPDATE tb_usuario SET usuario = ?, senha = ?, nivelAcesso = ? WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getNivelAcesso());
            pst.setInt(4, usuario.getId());

            // 5°..
            pst.execute();
        }
    }

    // DELETE:
    public void apagarUsuario(Usuario usuario) throws Exception {
        // 1°..
        String sql = "DELETE FROM tb_usuario WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4°..
            pst.setInt(1, usuario.getId());
        }
    }

    // Saber se existe determinado usuario e senha no banco de dados
    public boolean existeUsuario(Usuario usuario) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "SELECT * FROM tb_usuario WHERE usuario = ? AND senha = ?";
        // Obtendo conexão com o banco de dados
        try (Connection con = ConexaoDB.getConexao();
                // pré-compilar o comando SQL (Segurança para seu banco de dados):
                PreparedStatement pst = con.prepareStatement(sql)) {

            // Preenchendo os '?':
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());

            // Executando o comando 'SELECT' e recebendo o retorno:
            ResultSet resultado = pst.executeQuery();

            // Tenta acessar os resultados:
            return resultado.next();
        }
    }

    public Usuario[] getUsuario() throws Exception {
        String sql = "SELECT * FROM tb_usuario";

        try (Connection con = ConexaoDB.getConexao();
                PreparedStatement pst = con.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Indica que esse objeto é navegavel e não é sensivel a mudanças
                        ResultSet.CONCUR_READ_ONLY)) { // Não pode ser alterado enquanto estiver sendo usado
            ResultSet rs = pst.executeQuery();

            // Tem elementos na tabela ? se sim quero a linha que vc parou : senão devolve 0                
            int totalDeUsuarios = rs.last() ? rs.getRow() : 0;

            // Instanciando o vetor:
            Usuario[] u = new Usuario[totalDeUsuarios];

            // Volta pro inicio da tabela:
            rs.beforeFirst();

            // Buscando dados na tabela e armazenando nas variaveis locais:
            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String usuario = rs.getString("usuario");
                String senha = rs.getString("senha");
                String nivelAcesso = rs.getString("nivelAcesso");
                u[contador] = new Usuario(id, usuario, senha, nivelAcesso);
                contador++;
            }
            // Retornar os dados buscados:
            return u;
        }
    }

    public List<Usuario> buscarUsuario(Usuario u) throws Exception {
        String sql = "SELECT id, usuario, senha, nivelAcesso FROM tb_usuario";

        List<Usuario> usuarios = new ArrayList<>();

        try (Connection con = ConexaoDB.getConexao();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, u.getId());
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String usuario = rs.getString("usuario");
                    String senha = rs.getString("senha");
                    String nivelAcesso = rs.getString("nivelAcesso");
                    usuarios.add(new Usuario(id, usuario, senha, nivelAcesso));
                }
            }
        }
        return usuarios;
    }
}
