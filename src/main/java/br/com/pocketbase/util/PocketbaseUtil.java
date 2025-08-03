package br.com.pocketbase.util;

import br.com.pocketbase.http.ParametrosRequest;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author gilmario
 */
public class PocketbaseUtil {

    public static String buildQuery(ParametrosRequest parametros) {
        if (Objects.isNull(parametros)) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("?")
                .append("expand=").append(parametros.getExpand()).append("&")
                .append("fields=").append(parametros.getFields()).append("&")
                .append("batch=").append(parametros.getBatch()).append("&")
                .append("filter=").append(parametros.getFilter()).append("&")
                .append("page=").append(parametros.getPage()).append("&")
                .append("perPage=").append(parametros.getPerPage()).append("&")
                .append("skipTotal=").append(parametros.isSkipTotal()).append("&")
                .append("sort=").append(parametros.getSort());

        Optional.ofNullable(parametros.getQuery()).ifPresent((m) -> {
            if (m.isEmpty()) {
                return;
            }
            builder.append("&");
            m.forEach((c, v) -> {
                builder.append(c).append("=").append(v).append("&");
            });
        });

        return builder.toString();
    }

    public static String getURL(String... params) {
        if (Objects.isNull(params)) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        for (String j : params) {
            if (Objects.isNull(j)) {
                continue;
            }
            String i = j.trim();
            if ("".equals(i)) {
                continue;
            }

            if (i.toLowerCase().startsWith("http://") || i.toLowerCase().startsWith("https://")) {
                if (i.charAt(i.length() - 1) == '/') {
                    builder.append(i.substring(0, i.length() - 1));
                } else {
                    builder.append(i);
                }
                continue;
            }
            if (i.charAt(0) != '/') {
                builder.append("/");
            }
            if (i.charAt(i.length() - 1) == '/') {
                builder.append(i.substring(0, i.length() - 1));
            } else {
                builder.append(i);
            }
        }

        return builder.toString();
    }
}
