package br.com.pocketbase.seguranca;

import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import br.com.pocketbase.util.JsonConverter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author gilmario
 */
public class PocketbaseArmazenamentoCredencial {

    private static final String BASE_URL = "/api/collections/_superusers";
    private static final String LOGIN = "auth-with-password";
    private final PocketbaseCliente cliente;
    private final PocketbaseConfiguracao configuracao;
    private LoginResponse credencias;

    public PocketbaseArmazenamentoCredencial(PocketbaseCliente cliente, PocketbaseConfiguracao configuracao) {
        this.cliente = cliente;
        this.configuracao = configuracao;
    }

    public void autenticar() throws Exception {
        credencias = cliente.postJson(BASE_URL.concat("/").concat(LOGIN), JsonConverter.toJson(new LoginRequest(configuracao.getUsuario(), configuracao.getSenha())), LoginResponse.class);
    }

    public boolean isAutenticado() throws IOException {
        return tokenIsValido();
    }

    public boolean tokenIsValido() throws IOException {
        if (Objects.isNull(credencias)) {
            return false;
        }

        if (Objects.isNull(credencias.getToken())) {
            return false;
        }
        String[] partes = credencias.getToken().split("\\.");

        String dadosAuth = new String(Base64.getDecoder().decode(partes[1]));

        Token token = JsonConverter.fromJson(dadosAuth, Token.class);

        Date data = new Date(token.getExp() * 1000);

        LocalDateTime validade = LocalDateTime.ofInstant(data.toInstant(), ZoneId.systemDefault());

        return LocalDateTime.now().isBefore(validade);
    }

    public LoginResponse getCredencias() throws Exception {
        if (Objects.isNull(credencias) || Objects.isNull(credencias.getToken())) {
            autenticar();
        }
        return credencias;
    }

}
