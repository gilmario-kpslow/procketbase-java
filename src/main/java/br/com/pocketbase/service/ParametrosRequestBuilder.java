/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.service;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gilmario
 */
public class ParametrosRequestBuilder {

    private int batch;
    private int page;
    private int perPage;
    private boolean skipTotal;
    private String expand;
    private String filter;
    private String sort;
    private String fields;
    private final Map<String, String> query;
    private final Map<String, String> headers;

    public ParametrosRequestBuilder() {
        this.batch = 500;
        page = 0;
        perPage = 10;
        skipTotal = false;
        this.expand = "";
        this.filter = "";
        this.sort = "";
        this.fields = "";
        this.query = new HashMap<>();
        this.headers = new HashMap<>();
    }

    public ParametrosRequestBuilder batch(int batch) {
        this.batch = batch;
        return this;
    }

    public ParametrosRequestBuilder page(int page) {
        this.page = page;
        return this;
    }

    public ParametrosRequestBuilder perPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public ParametrosRequestBuilder skipTotal(boolean skipTotal) {
        this.skipTotal = skipTotal;
        return this;
    }

    public ParametrosRequestBuilder expand(String expand) {
        this.expand = expand;
        return this;
    }

    public ParametrosRequestBuilder filter(String filter) {
        this.filter = filter;
        return this;
    }

    public ParametrosRequestBuilder sort(String sort) {
        this.sort = sort;
        return this;
    }

    public ParametrosRequestBuilder fields(String fields) {
        this.fields = fields;
        return this;
    }

    public ParametrosRequestBuilder addQuery(String chave, String value) {
        this.query.put(chave, value);
        return this;
    }

    public ParametrosRequestBuilder addHeader(String chave, String value) {
        this.headers.put(chave, value);
        return this;
    }

    public ParametrosRequest build() {
        return new ParametrosRequest(batch, page, perPage, skipTotal, expand, filter, sort, fields, query, headers);
    }
}
