package br.com.pocketbase.http;

import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ParametrosRequest {

    private final int batch;
    private final int page;
    private final int perPage;
    private final boolean skipTotal;
    private final String expand;
    private final String filter;
    private final String sort;
    private final String fields;
    private final Map<String, String> query;
    private final Map<String, String> headers;

    public ParametrosRequest(int batch, int page, int perPage, boolean skipTotal, String expand, String filter, String sort, String fields, Map<String, String> query, Map<String, String> headers) {
        this.batch = batch;
        this.page = page;
        this.perPage = perPage;
        this.skipTotal = skipTotal;
        this.expand = expand;
        this.filter = filter;
        this.sort = sort;
        this.fields = fields;
        this.query = query;
        this.headers = headers;
    }

    public int getBatch() {
        return batch;
    }

    public String getExpand() {
        return expand;
    }

    public String getFilter() {
        return filter;
    }

    public String getSort() {
        return sort;
    }

    public String getFields() {
        return fields;
    }

    public Map<String, String> getQuery() {
        return query;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getPage() {
        return page;
    }

    public int getPerPage() {
        return perPage;
    }

    public boolean isSkipTotal() {
        return skipTotal;
    }

    @Override
    public String toString() {
        return "ParametrosRequest{" + "batch=" + batch + ", page=" + page + ", perPage=" + perPage + ", skipTotal=" + skipTotal + ", expand=" + expand + ", filter=" + filter + ", sort=" + sort + ", fields=" + fields + ", query=" + query + ", headers=" + headers + '}';
    }

}
