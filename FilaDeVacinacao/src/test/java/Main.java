
public class Main {

    public static void main(String[] args) {

        // Testando conexão com o banco de dados:
        ConexaoDB con = new ConexaoDB();
        con.obtemConexao();

        // Teste do metodo 'existe()' da Usuario DAO
        UsuarioDAO uDAO = new UsuarioDAO();

        Usuario u = new Usuario("gabriel", "admin");

        System.out.println(uDAO.existe(u));
    }
}
