
package Classe_Pessoa;




public class FiltroPessoa {
    
    private String dataInicio;
    private String dataFinal;
    private int[] idade;

    public FiltroPessoa(String dataInicio, String dataFinal, int[] idade) {
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.idade = idade;
    }

    public FiltroPessoa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public int[] getIdade() {
        return idade;
    }

    public void setIdade(int[] idade) {
        this.idade = idade;
    }
 
    
}
