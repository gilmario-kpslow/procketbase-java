package br.com.pocketbase.http;

/**
 *
 * @author gilmario
 */
public class PocketbaseConfiguracao {

    private String serverURL;
    private String usuario;
    private String senha;

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
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

}
