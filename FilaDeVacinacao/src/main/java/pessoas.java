
public class pessoas {

    
    private String nome;
    private int idade;
    private boolean saude;
    private String endereco;
    private String data;

    //set
    public void setNome(String nome) {
        this.nome = nome;

    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSaude(boolean saude) {
        this.saude = saude;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;

    }

    public void setData(String data) {
        this.data = data;
    }

    //get
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean getSaude() {
        return saude;
    }

    public String endeco() {
        return endereco;
    }

    public String getData() {
        return data;
    }
}
