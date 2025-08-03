/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.pocketbase.service;

import br.com.pocketbase.colecao.Registro;
import br.com.pocketbase.generic.BaseCrudService;
import br.com.pocketbase.http.PocketbaseClient;

/**
 *
 * @author gilmario
 */
public class RecordService extends BaseCrudService<Registro> {

    public RecordService(PocketbaseClient client) {
        super(client);
    }

    @Override
    public String getBaseUrl() {
        return "";
    }

}
