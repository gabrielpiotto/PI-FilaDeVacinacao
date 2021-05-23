
public class Usuario {

    // Atributos:
    private int id;
    private String usuario;
    private String senha;
    private String nivelAcesso;

    // Métodos:
    /**
     * Constroi um objeto do tipo Usuario vazio.
     */
    public Usuario() {
    }

    /**
     * Constroi um objeto do tipo Usuario com valores iniciais
     *
     * @param usuario
     * @param senha
     */
    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Constroi um objeto do tipo Usuario com valores iniciais
     *
     * @param usuario
     * @param senha
     * @param nivelAcesso
     */
    public Usuario(String usuario, String senha, String nivelAcesso) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    /**
     * Constroi um objeto do tipo Usuario com valores iniciais
     *
     * @param id
     * @param usuario
     * @param senha
     * @param nivelAcesso
     */
    public Usuario(int id, String usuario, String senha, String nivelAcesso) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    // Getters e Setters:
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}
