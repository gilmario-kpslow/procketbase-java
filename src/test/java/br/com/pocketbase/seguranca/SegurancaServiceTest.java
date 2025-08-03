/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.pocketbase.seguranca;

import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseClient;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class SegurancaServiceTest {

    public SegurancaServiceTest() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        LoginRequest request = new LoginRequest();
        request.setIdentity("api@teste.com");
        request.setPassword("api#teste.com");

        String url = "http://localhost:8090";
        ParametrosRequest parametos = new ParametrosRequestBuilder()
                .build();

        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);

        PocketbaseClient client = new PocketbaseClient(conf);

        SegurancaService instance = new SegurancaService(client);
        LoginResponse expResult = null;
        LoginResponse result = instance.login(request);
        Assertions.assertEquals(expResult, result);
    }

}
