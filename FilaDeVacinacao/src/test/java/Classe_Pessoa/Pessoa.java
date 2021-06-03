package Classe_Pessoa;


public class Pessoa {

    // Atributos
    private String nome;
    private String endereco;
    private String dataVacinacao;
    private String areaSaude;
    private int id;
    private int idade;
    private int nivelPrioridade;

    // Métodos
    /**
     * Constroi um objeto do tipo Pessoa vazio
     */
    public Pessoa() {
    }

    public Pessoa(int id) {
        this.id = id;
    }

    public Pessoa(int id ,String nome, String endereco, int idade, String areaSaude, int nivelPrioridade) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.id = id;
        this.idade = idade;
        this.nivelPrioridade = nivelPrioridade;
    }
    
    public Pessoa(int id ,String nome, String endereco, int idade, String areaSaude, String dataVacinacao, int nivelPrioridade) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.id = id;
        this.idade = idade;
        this.dataVacinacao = dataVacinacao;
        this.nivelPrioridade = nivelPrioridade;
    }

    /**
     * Constroi um objeto do tipo pessoa com valores iniciais
     *
     * @param nome
     * @param endereco
     * @param idade
     * @param areaSaude
     * @param nivelPrioridade
     */
    public Pessoa(String nome, String endereco, int idade, String areaSaude, int nivelPrioridade) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.idade = idade;
        this.dataVacinacao = null;
        this.nivelPrioridade = nivelPrioridade;
    }

    /**
     * Constroi um objeto do tipo pessoa com valores iniciais
     *
     * @param nome
     * @param endereco
     * @param idade
     * @param areaSaude
     * @param dataVacinacao
     * @param nivelPrioridade
     */
    public Pessoa(String nome, String endereco, int idade, String areaSaude, String dataVacinacao, int nivelPrioridade) {
        this.nome = nome;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.idade = idade;
        this.dataVacinacao = dataVacinacao;
        this.nivelPrioridade = nivelPrioridade;
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

    public String getAreaSaude() {
        return areaSaude;
    }

    public void setAreaSaude(String areaSaude) {
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
    
    public int getNivelPrioridade  (){
        return nivelPrioridade;
    }
    
    public void setNivelPrioridade (int nivelPrioridade){
        this.nivelPrioridade = nivelPrioridade;
    }

    @Override
    public String toString() {
        return "|ID: " + id + " | Nome: " + nome + " | Idade: " + idade + " |";
    }

}
