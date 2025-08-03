package br.com.pocketbase.seguranca;

import br.com.pocketbase.JsonConverter;
import br.com.pocketbase.generic.BaseService;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseClient;
import java.net.http.HttpResponse;

/**
 *
 * @author gilmario
 */
public class SegurancaService extends BaseService {

    private static final String BASE_URL = "_superusers";
    private static final String LOGIN = "auth-with-password";

    public SegurancaService(PocketbaseClient client) {
        super(client);
    }

    public LoginResponse login(LoginRequest request) throws Exception {
        new ParametrosRequestBuilder().build();
        HttpResponse<String> response = client.POST(BASE_URL.concat("/").concat(LOGIN), JsonConverter.toJson(request));
        return JsonConverter.fromJson(response.body(), LoginResponse.class);
    }

}
