package br.com.pocketbase.http;

import br.com.pocketbase.service.ParametrosRequest;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author gilmario
 */
public class PocketbaseClient {

    private String token;
    private HttpClient client;

    public PocketbaseClient() {
//        this.client;
    }

    public HttpResponse<String> GET(String url, ParametrosRequest parametos) throws IOException, InterruptedException {

        HttpRequest req = request(url, Optional.ofNullable(parametos.getHeaders()), Optional.ofNullable(parametos.getQuery()))
                .GET()
                .build();

        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    public HttpResponse<String> POST(String url, Map<String, String> header, Map<String, String> query, String body) throws IOException, InterruptedException {

        HttpRequest req = request(url, Optional.ofNullable(header), Optional.ofNullable(query))
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        return client.send(req, HttpResponse.BodyHandlers.ofString());
    }

    private HttpRequest.Builder request(String url, Optional<Map<String, String>> header, Optional<Map<String, String>> query) {

        HttpRequest.Builder builder = HttpRequest.newBuilder();
        builder.uri(URI.create(url.concat(buildQuery(query))));

        header.ifPresent((m) -> {
            m.forEach((c, v) -> {
                builder.header(c, v);
            });
        });

        return builder;
    }

    private String buildQuery(Optional<Map<String, String>> query) {
        StringBuilder builder = new StringBuilder();
        query.ifPresent((m) -> {
            builder.append("?");
            m.forEach((c, v) -> {
                builder.append(c).append("=").append(v).append("&");
            });
        });

        return builder.toString();
    }

//    private Object send(String metodo, String url, Map<String, String> header, Map<String, String> query, String body) {
//        HttpRequest request = HttpRequest
//                .newBuilder()
//                .header("Content-Type", APPLICATION_JSON)
//                .header("Accept", APPLICATION_JSON)
//                .uri(getURL("", "", ""))
//                .header("Authorization", getToken())
//                .POST(HttpRequest.BodyPublishers.ofString(JsonConverter.toJson(t)))
//                .build();
//
//        return request;
//
//    }
    public String getToken() {
        return token;
    }

//    private void login() {
//        HttpRequest request = HttpRequest
//                .newBuilder()
//                .header("Content-Type", APPLICATION_JSON)
//                .header("Accept", APPLICATION_JSON)
//                .uri(getURL("", "", ""))
//                .POST(HttpRequest.BodyPublishers.ofString(JsonConverter.toJson(t)))
//                .build();
//    }
//
//    private URI getURL(String paths, String base, String entity) {
//
//        return URI.create(new StringBuilder(baseUrl).append(base).append(entity).append(paths).toString());
//    }
}
