
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PessoaDAO {

    // CRUD Usuario:
    // CREATE: Insere novos registros na tabela 'tb_fila'
    public void cadastrarPessoa(Pessoa pessoa) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "INSERT INTO tb_pessoa (nome, endereco, idade, areaSaude) VALUES (?, ?, ?, ?)";

        // 2° passo: abrir uma conexão com o bancode dados:
        try (Connection con = ConexaoDB.getConexao();
                // 3° passo: pré compilar o comando SQL:
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setInt(3, pessoa.getIdade());
            pst.setString(4, pessoa.getAreaSaude());

            // 5° passo: executar
            pst.execute();
        }
    }

    // READ: Exibe todos os registros da tabela 'tb_fila'
    public void listarPessoa() throws Exception {

        // 1°..
        String sql = "SELECT * FROM tb_pessoa";

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
        String sql = "UPDATE tb_pessoa SET nome = ?, idade = ?, areaSaude = ?, endereco = ?, dataVacinacao = ? WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setInt(2, pessoa.getIdade());
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
        String sql = "DELETE FROM tb_pessoa WHERE id = ?";

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
        String sql = "SELECT * FROM tb_pessoa WHERE nome = ? AND idade = ? AND areaSaude = ? AND endereco = ?";
        // Obtendo conexão com o banco de dados
        try (Connection con = ConexaoDB.getConexao();
                // pré-compilar o comando SQL (Segurança para seu banco de dados):
                PreparedStatement pst = con.prepareStatement(sql)) {

            // Preenchendo os '?':
            pst.setString(1, pessoa.getNome());
            pst.setInt(2, pessoa.getIdade());

            // Executando o comando 'SELECT' e recebendo o retorno:
            ResultSet resultado = pst.executeQuery();

            // Tenta acessar os resultados:
            return resultado.next();
        }
    }

    public Pessoa[] getPessoa() throws Exception {
        String sql = "SELECT * FROM tb_pessoa";

        try (Connection con = ConexaoDB.getConexao();
                PreparedStatement pst = con.prepareStatement(sql,
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Indica que esse objeto é navegavel e não é sensivel a mudanças
                        ResultSet.CONCUR_READ_ONLY)) { // Não pode ser alterado enquanto estiver sendo usado
            ResultSet rs = pst.executeQuery();

            // Tem elementos na tabela ? se sim quero a linha que vc parou : senão devolve 0                
            int totalDePessoas = rs.last() ? rs.getRow() : 0;

            // Instanciando o vetor:
            Pessoa[] p = new Pessoa[totalDePessoas];

            // Volta pro inicio da tabela:
            rs.beforeFirst();

            // Buscando dados na tabela e armazenando nas variaveis locais:
            int contador = 0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                int idade = rs.getInt("idade");
                String areaSaude = rs.getString("areaSaude");
                p[contador] = new Pessoa(nome, endereco, idade, areaSaude);
                contador++;
            }
            // Retornar os dados buscados:
            return p;
        }
    }

    public List<Pessoa> buscarPessoa(Pessoa p) throws Exception {
        String sql = "SELECT id, nome, endereco, idade, areaSaude FROM tb_pessoa";

        List<Pessoa> pessoa = new ArrayList<>();

        try (Connection conexao = ConexaoDB.getConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, p.getId());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String endereco = rs.getString("endereco");
                    int idade = rs.getInt("idade");
                    String areaSaude = rs.getString("areaSaude");
                    pessoa.add(new Pessoa(nome, endereco, areaSaude, id, idade));
                }
            }
        }
        return pessoa;
    }
}
