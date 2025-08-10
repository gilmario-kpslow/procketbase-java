package br.com.pocketbase.http;

import br.com.pocketbase.teste.HttpserveUtil;
import java.io.IOException;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class PocketbaseClientTest {

    public PocketbaseClientTest() throws IOException {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() throws IOException {

    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGET() throws Exception {
        System.out.println("GET");
        HttpserveUtil.startServerGET(10000);
        String url = "http://localhost:10000";
        ParametrosRequest parametos = new ParametrosRequestBuilder()
                .build();

        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);

        PocketbaseCliente instance = new PocketbaseCliente(conf);
        HttpResponse<String> result = instance.GET("/", parametos);
        String express = "expand=&fields=&batch=500&filter=&page=0&perPage=10&skipTotal=false&sort=";
        Assertions.assertEquals(express, result.body());
        HttpserveUtil.stop();
    }

    @Test
    public void testPOST() throws Exception {
        System.out.println("POST");
        HttpserveUtil.startServerPOST(10000);
        String url = "http://localhost:10000";
        String expected = "expectedvalue";
        ParametrosRequest parametos = new ParametrosRequestBuilder()
                .build();
        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);

        PocketbaseCliente instance = new PocketbaseCliente(conf);
        HttpResponse<String> result = instance.POST("", parametos, "expectedvalue");
        Assertions.assertEquals(200, result.statusCode());
        Assertions.assertEquals(expected, result.body());
        HttpserveUtil.stop();
    }

}
