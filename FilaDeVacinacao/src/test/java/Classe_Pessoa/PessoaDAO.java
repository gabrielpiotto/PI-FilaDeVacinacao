package Classe_Pessoa;

import Core.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class PessoaDAO {

    // CRUD Usuario:
    // CREATE: Insere novos registros na tabela 'tb_fila'
    public void cadastrarPessoa(Pessoa pessoa) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "INSERT INTO tb_pessoa (nome, endereco, idade, areaSaude, nivelPrioridade) VALUES (?, ?, ?, ?, ?)";

        // 2° passo: abrir uma conexão com o bancode dados:
        try (Connection con = ConexaoDB.getConexao();
                // 3° passo: pré compilar o comando SQL:
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getEndereco());
            pst.setInt(3, pessoa.getIdade());
            pst.setString(4, pessoa.getAreaSaude());
            pst.setInt(5, pessoa.getNivelPrioridade());

            // 5° passo: executar
            System.out.println("Cadastrando..");
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
                Date dataVacinacao = rs.getDate("dataVacinacao");
                int nivelPrioridade = rs.getInt("nivelPrioridade");

                // Formatantdp para exibição:
                String s = String.format("ID: $d\nNome: %d\nIdade: %d\nEndereço: %s\nArea Saude: %d"
                        + "\nData de vacinação: %s\nNivelPrioridade: %d", id, nome, idade, endereco, areaSaude, dataVacinacao, nivelPrioridade);
                JOptionPane.showMessageDialog(null, s);
            }
        }
    }

    // UPDATE: Atualiza os registros da tabela 'tb_fila' 
    public void atualizarPessoa(Pessoa pessoa) throws Exception {
        // 1°..
        String sql = "UPDATE tb_pessoa SET nome = ?, idade = ?, areaSaude = ?, endereco = ?, dataVacinacao = ?, nivelPrioridade = ? WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4° passo: preencher todas as interrogações:
            pst.setString(1, pessoa.getNome());
            pst.setInt(2, pessoa.getIdade());
            pst.setString(3, pessoa.getAreaSaude());
            pst.setString(4, pessoa.getEndereco());
            pst.setDate(5, (Date) pessoa.getDataVacinacao());
            pst.setInt(6, pessoa.getId());
            pst.setInt(7, pessoa.getNivelPrioridade());

            // 5°..
            pst.execute();
            System.out.println("Atualizando..");
        }
    }

    // DELETE:
    public void apagarPessoa(Pessoa p) throws Exception {
        // 1°..
        //String sql = "DELETE FROM tb_pessoa WHERE id = ?";

        // 2°..
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement("DELETE FROM tb_pessoa WHERE id = ?")) {

            // 4°..
            pst.setInt(1, p.getId());
            
            pst.execute();
            System.out.println("Deletando..");
        }
    }

    // Saber se existe determinado usuario e senha no banco de dados
    public boolean existePessoa(Pessoa pessoa) throws Exception {

        // 1° passo: criar comando SQL:
        String sql = "SELECT * FROM tb_pessoa WHERE nome = ? AND idade = ? AND areaSaude = ? AND endereco = ? AND nivelPrioridade = ?";
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
    public void vacinarPessoa(Integer id) throws Exception {
    
        String sql = "UPDATE tb_pessoa SET nivelPrioridade = null, dataVacinacao = ? WHERE id = ? ";
        try (Connection con = ConexaoDB.getConexao();
                   // pré-compilar o comando SQL (Segurança para seu banco de dados):
                   PreparedStatement pst = con.prepareStatement(sql)) {

               // Preenchendo os '?':
                Calendar calendar = Calendar.getInstance();
                Date hoje = new Date(calendar.getTime().getTime());
    
               pst.setDate(1, hoje);
               pst.setInt(2,id); 
               pst.executeUpdate();

        }

    }
    
    
     public List<Pessoa> filtrarPessoas(FiltroPessoa fp) throws Exception {
       
         String sql = "SELECT * FROM tb_pessoa WHERE idade BETWEEN ? AND ? AND dataVacinacao BETWEEN ? AND ?";
         
        try (Connection con = ConexaoDB.getConexao();
                // 3°..
                PreparedStatement pst = con.prepareStatement(sql)) {

            // 4°..
            pst.setInt(1, fp.getIdade()[0]);
            pst.setInt(2, fp.getIdade()[1]);
            
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date date = sdf1.parse(fp.getDataInicio());
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            
            pst.setDate(3, sqlStartDate);

            java.util.Date date1 = sdf1.parse(fp.getDataFinal());
            java.sql.Date sqlFinalDate = new java.sql.Date(date1.getTime());
            
            pst.setDate(4, sqlFinalDate);
          
            List<Pessoa> pessoa = new ArrayList<>();
            System.out.println(pst);
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Pessoa p = new Pessoa();

                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setIdade(rs.getInt("idade"));
                    p.setAreaSaude(rs.getString("areaSaude"));
                    p.setDataVacinacao(rs.getDate("dataVacinacao"));
                    p.setNivelPrioridade(rs.getInt("nivelPrioridade"));
                    pessoa.add(p);
                }
            }
        return pessoa;
        }
    }
    
    
    public List<Pessoa> read() throws Exception {

        String sql = "SELECT * FROM tb_pessoa ORDER BY -nivelPrioridade DESC";

        List<Pessoa> pessoa = new ArrayList<>();

        try (Connection con = ConexaoDB.getConexao();
                PreparedStatement pst = con.prepareStatement(sql)) {

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    Pessoa p = new Pessoa();

                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEndereco(rs.getString("endereco"));
                    p.setIdade(rs.getInt("idade"));
                    p.setAreaSaude(rs.getString("areaSaude"));
                    p.setDataVacinacao(rs.getDate("dataVacinacao"));
                    p.setNivelPrioridade(rs.getInt("nivelPrioridade"));
                    pessoa.add(p);
                }
            }
        }
        return pessoa;
    }
}
