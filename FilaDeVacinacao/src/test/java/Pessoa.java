
public class Pessoa {

    // Atributos
    private String nome;
    private String endereco;
    private String dataVacinacao;
    private boolean areaSaude;
    private int id;
    private int idade;

    // Métodos
    /**
     * Constroi um objeto do tipo Pessoa vazio
     */
    public Pessoa() {
    }

    /**
     * Constroi um objeto do tipo pessoa com valores iniciais
     *
     * @param nome
     * @param endereco
     * @param idade
     * @param areaSaude
     */
    public Pessoa(String nome, String endereco, int idade, boolean areaSaude) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.idade = idade;
        this.dataVacinacao = null;
    }

    /**
     * Constroi um objeto do tipo pessoa com valores iniciais
     *
     * @param nome
     * @param endereco
     * @param idade
     * @param areaSaude
     * @param dataVacinacao
     */
    public Pessoa(String nome, String endereco, int idade, boolean areaSaude, String dataVacinacao) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.idade = idade;
        this.dataVacinacao = dataVacinacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isAreaSaude() {
        return areaSaude;
    }

    public void setAreaSaude(boolean areaSaude) {
        this.areaSaude = areaSaude;
    }

    public String getDataVacinacao() {
        return dataVacinacao;
    }

    public void setDataVacinacao(String dataVacinacao) {
        this.dataVacinacao = dataVacinacao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

}
