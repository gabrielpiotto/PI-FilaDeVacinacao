
public class Pessoa {

    private String usuario;
    private String senha;
    private String nome;
    private String endereco;
    private String dataVacinacao;
    private int idade;
    private boolean areaSaude;

    public Pessoa() {
    }

    /**
     * Construtor para Usuarios
     *
     * @param usuario
     * @param senha
     */
    public Pessoa(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Construtor para Pessoas
     *
     * @param nome
     * @param endereco
     * @param idade
     * @param areaSaude
     */
    public Pessoa(String nome, String endereco, int idade, boolean areaSaude) {
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.areaSaude = areaSaude;
        this.dataVacinacao = null;
    }

    // Getters e Setters:
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public boolean isAreaSaude() {
        return areaSaude;
    }

    public void setAreaSaude(boolean areaSaude) {
        this.areaSaude = areaSaude;
    }

}
