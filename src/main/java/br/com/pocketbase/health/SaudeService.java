package br.com.pocketbase.health;

import br.com.pocketbase.generic.BaseService;
import br.com.pocketbase.http.PocketbaseClient;
import java.net.http.HttpResponse;

/**
 *
 * @author gilmario
 */
public class SaudeService extends BaseService {

    private static final String BASE_URL = "/api/health";

    public SaudeService(PocketbaseClient client) {
        super(client);
    }

    public boolean verificarSaude() throws Exception {
        HttpResponse<String> resposta = client.GET(BASE_URL);
        return resposta.statusCode() == 200;
    }

}
