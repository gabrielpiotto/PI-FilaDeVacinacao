
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class PessoaDAO {

    // CRUD Usuario:
    // CREATE: Insere novos registros na tabela 'tb_fila'
    public void cadastrarPessoa(Pessoa pessoa) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "INSERT INTO tb_fila (nome, endereco, idade, areaSaude) VALUES (?, ?, ?, ?)";

        // 2° passo: abrir uma conexão com o bancode dados:
        try (Connection con = ConexaoDB.getConexao();
                // 3° passo: pré compilar o comando SQL:
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setString(3, pessoa.getIdade());
            pst.setString(4, pessoa.getAreaSaude());

            // 5° passo: executar
            pst.execute();

        }
    }

    // READ: Exibe todos os registros da tabela 'tb_fila'
    public void listarPessoa() throws Exception {

        // 1°..
        String sql = "SELECT * FROM tb_fila";

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
                String nome = rs.getString("nome");
                int idade = rs.getInt("idade");
                String endereco = rs.getString("endereco");
                String areaSaude = rs.getString("areaSaude");
                String dataVacinacao = rs.getString("dataVacinacao");

                // Formatantdp para exibição:
                String s = String.format("ID: $d\nNome: %d\nIdade: %d\nEndereço: %s\nArea Saude: %d"
                        + "\nData de vacinação: %s", id, nome, idade, endereco, areaSaude, dataVacinacao);
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }

    // UPDATE: Atualiza os registros da tabela 'tb_fila' 
    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        // 1°..
        String sql = "UPDATE tb_fila SET nome = ?, idade = ?, areaSaude = ?, endereco = ?, dataVacinacao = ? WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getIdade());
            pst.setString(3, pessoa.getAreaSaude());
            pst.setString(4, pessoa.getEndereco());
            pst.setString(5, pessoa.getDataVacinacao());
            pst.setInt(6, pessoa.getId());

            // 5°..
            pst.execute();

        }
    }

    // DELETE:
    public void apagarPessoa(Pessoa pessoa) throws Exception {
        // 1°..
        String sql = "DELETE FROM tb_fila WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4°..
            pst.setInt(1, pessoa.getId());
        }
    }

    // Saber se existe determinado usuario e senha no banco de dados
    public boolean existePessoa(Pessoa pessoa) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "SELECT * FROM tb_fila WHERE nome = ? AND idade = ? AND areaSaude = ? AND endereco = ?";
        // Obtendo conexão com o banco de dados
        try (Connection con = ConexaoDB.getConexao();
                // pré-compilar o comando SQL (Segurança para seu banco de dados):
                PreparedStatement pst = con.prepareStatement(sql)) {

            // Preenchendo os '?':
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getIdade());

            // Executando o comando 'SELECT' e recebendo o retorno:
            ResultSet resultado = pst.executeQuery();

            // Tenta acessar os resultados:
            return resultado.next();
        }
    }
}
