package br.com.pocketbase.http;

import br.com.pocketbase.util.JsonConverter;
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
public class PocketbaseCliente {

    private final PocketbaseConfiguracao configuracao;
    private final HttpClient client;
    private String token;

    public PocketbaseCliente(PocketbaseConfiguracao configuracao) {
        this.configuracao = configuracao;
        this.client = HttpClient.newHttpClient();

    }

    public PocketbaseCliente(PocketbaseConfiguracao configuracao, HttpClient client) {
        this.configuracao = configuracao;
        this.client = client;
    }

    public HttpResponse<String> GET(String url, ParametrosRequest parametros) throws IOException, InterruptedException {
        HttpRequest req = request(url, parametros)
                .GET()
                .build();
        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public <R> R getJson(String url, ParametrosRequest parametros, Class<R> container, Class... classe) throws IOException, InterruptedException {
        parametros.getHeaders().put("Content-Type", "application/json");
        parametros.getHeaders().put("Accept", "application/json");
        HttpResponse<String> resp = GET(url, parametros);

        return JsonConverter.fromJson(resp.body(), container, classe);
    }

    public <R> R getJson(String url, Class<R> container, Class... classe) throws IOException, InterruptedException {
        ParametrosRequest parametros = new ParametrosRequestBuilder().build();
        parametros.getHeaders().put("Content-Type", "application/json");
        parametros.getHeaders().put("Accept", "application/json");
        return getJson(url, parametros, container, classe);
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

    public <R> R postJson(String url, ParametrosRequest parametros, String body, Class<R> container, Class... classe) throws IOException, InterruptedException {
        parametros.getHeaders().put("Content-Type", "application/json");
        parametros.getHeaders().put("Accept", "application/json");

        HttpResponse<String> resp = this.POST(url, parametros, body);

        if (resp.statusCode() > 204 || resp.statusCode() < 200) {
            throw new RuntimeException("Erro na requisição: " + resp.statusCode() + " resp: " + resp.body());
        }

        return JsonConverter.fromJson(resp.body(), container, classe);
    }

    public <R> R postJson(String url, String body, Class<R> container, Class... classe) throws IOException, InterruptedException {
        ParametrosRequest parametros = new ParametrosRequestBuilder().build();
        parametros.getHeaders().put("Content-Type", "application/json");
        parametros.getHeaders().put("Accept", "application/json");
        return this.postJson(url, parametros, body, container, classe);
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

        if (Objects.nonNull(token)) {
            builder.header("Authorization", token);
        }

        return builder;
    }

    public PocketbaseCliente autenticar(String token) {
        this.token = token;
        return this;
    }

}
