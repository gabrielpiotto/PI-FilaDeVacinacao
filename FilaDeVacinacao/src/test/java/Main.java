
public class Main {

    public static void main(String[] args) {
        
        // Testes unitarios:
        
        // Tentando conexão com o banco de dados:
        ConexaoDB con = new ConexaoDB();
        con.getConexao();
        // ok
        
        // Existe?
        Usuario p = new Usuario("admin", "admin0");
        UsuarioDAO u = new UsuarioDAO();
        u.existeUsuario(p);
        
    }
}
