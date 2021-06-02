package Classe_Pessoa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Gabriel Piotto
 */
public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> pessoa;

    private String[] colunas = {"id", "nome", "endereco", "idade", "areaSaude"};

    public PessoaTableModel(Pessoa p) throws Exception {
        PessoaDAO pDAO = new PessoaDAO();
        this.pessoa = pDAO.buscarPessoa(p);
    }

    @Override
    public int getRowCount() {
        return pessoa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.pessoa.get(rowIndex).getId();
            case 1:
                return this.pessoa.get(rowIndex).getNome();
            case 2:
                return this.pessoa.get(rowIndex).getEndereco();
            case 3:
                return this.pessoa.get(rowIndex).getIdade();
            case 4:
                return this.pessoa.get(rowIndex).getAreaSaude();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
}
