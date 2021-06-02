package Core;


import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDB {

    private static String host = "Localhost";
    private static String porta = "3306";
    private static String db = "banco_projeto";
    private static String usuario = "root";
    private static String senha = "159357";

    /**
     * Obter conexão com o banco de dados
     */
    public static Connection getConexao() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + db, usuario, senha);
            System.out.println("Conectado..");
            return con;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}
