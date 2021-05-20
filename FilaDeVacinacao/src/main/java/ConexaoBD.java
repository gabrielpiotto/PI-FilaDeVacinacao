

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexaoBD {

    private static String host = "localhost";
    private static String porta = "3306";
    private static String bd = "Teste";
    private static String usuario = "root";
    private static String senha = "";

    public static Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd,
                    usuario,
                    senha
            );
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
