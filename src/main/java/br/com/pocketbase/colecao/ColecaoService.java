/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.colecao;

import br.com.pocketbase.JsonConverter;
import br.com.pocketbase.colecao.Colecao;
import br.com.pocketbase.generic.BaseCrudService;
import br.com.pocketbase.http.PocketbaseClient;
import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.service.ResultList;
import java.io.IOException;

/**
 *
 * @author gilmario
 */
public class ColecaoService extends BaseCrudService<Colecao> {

    private String baseCrudPath = "/api/collections";

    public ColecaoService(PocketbaseClient client) {
        super(client);
    }

    public ResultList<Colecao> getList(ParametrosRequest paramsRequest) throws IOException, InterruptedException {

        String obj = client.GET(baseCrudPath, paramsRequest).body();

        return JsonConverter.fromJson(obj, ResultList.class);
    }

    @Override
    public String getBaseUrl() {
        return baseCrudPath;
    }

    public boolean existe(String colecao) throws Exception {
        String resp = client.GET(colecao, new ParametrosRequestBuilder()
                .build())
                .body();
        return false;
    }
}
