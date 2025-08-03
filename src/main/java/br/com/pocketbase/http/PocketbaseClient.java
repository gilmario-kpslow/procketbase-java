package br.com.pocketbase.http;

import br.com.pocketbase.util.PocketbaseUtil;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author gilmario
 */
public class PocketbaseClient {

    private String token;
    private final PocketbaseConfiguracao configuracao;
    private final HttpClient client;

    public PocketbaseClient(PocketbaseConfiguracao configuracao) {
        this.configuracao = configuracao;
        this.client = HttpClient.newHttpClient();

    }

    public PocketbaseClient(PocketbaseConfiguracao configuracao, HttpClient client) {
        this.configuracao = configuracao;
        this.client = client;
    }

    public HttpResponse<String> GET(String url, ParametrosRequest parametros) throws IOException, InterruptedException {
        HttpRequest req = request(url, parametros)
                .GET()
                .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> GET(String url) throws IOException, InterruptedException {
        return this.GET(url, null);
    }

    public HttpResponse<String> POST(String url, ParametrosRequest parametos, String body) throws IOException, InterruptedException {
        HttpRequest req = request(url, parametos)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> POST(String url, String body) throws IOException, InterruptedException {
        return POST(url, null, body);
    }

    private HttpRequest.Builder request(String url, ParametrosRequest parametros) {
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(PocketbaseUtil.getURL(configuracao.getServerURL(), url, PocketbaseUtil.buildQuery(parametros))));
        if (Objects.nonNull(parametros)) {
            Optional.ofNullable(parametros.getHeaders()).ifPresent((m) -> {
                m.forEach((c, v) -> {
                    builder.header(c, v);
                });
            });
        }
        return builder;
    }

    private HttpRequest.Builder request(String url) {
        return this.request(url, null);
    }

    public String getToken() {
        return token;
    }

}
