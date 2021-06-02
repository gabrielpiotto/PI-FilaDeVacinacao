
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuarioTableModel extends AbstractTableModel {

    private List<Usuario> usuario;

    private String[] colunas = {"ID", "Usuario", "Senha", "Nivel Acesso"};

    public UsuarioTableModel(Usuario u) throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        this.usuario = uDAO.buscarUsuario(u);
    }

    @Override
    public int getRowCount() {
        return usuario.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.usuario.get(rowIndex).getId();
            case 1:
                return this.usuario.get(rowIndex).getUsuario();
            case 2:
                return this.usuario.get(rowIndex).getSenha();
            case 3:
                return this.usuario.get(rowIndex).getNivelAcesso();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
}
