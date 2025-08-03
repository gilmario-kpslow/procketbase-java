/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.pocketbase.util;

import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class PocketbaseUtilTest {

    public PocketbaseUtilTest() {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testGetURL() {
        String entrada1 = "http://localhost";
        String entrada2 = "/teste/";
        String entrada3 = "parte3";
        String entrada4 = "parte4/";
        String entrada5 = "/parte5";

        String esperado = "http://localhost/teste/parte3/parte4/parte5";

        Assertions.assertEquals(PocketbaseUtil.getURL(entrada1, entrada2, entrada3, entrada4, entrada5), esperado);

    }

    @Test
    public void testGetURL2() {
        String entrada1 = "http://localhost/";
        String entrada2 = "/teste/";
        String entrada3 = "parte3";
        String entrada4 = "parte4/";
        String entrada5 = "/parte5";

        String esperado = "http://localhost/teste/parte3/parte4/parte5";

        Assertions.assertEquals(PocketbaseUtil.getURL(entrada1, entrada2, entrada3, entrada4, entrada5), esperado);

    }

    @Test
    public void testGetURL3() {
        String entrada1 = "http://localhost/";
        String entrada2 = "/teste/";
        String entrada3 = "/parte3/";
        String entrada4 = "/parte4/";
        String entrada5 = "/parte5/";

        String esperado = "http://localhost/teste/parte3/parte4/parte5";

        Assertions.assertEquals(PocketbaseUtil.getURL(entrada1, entrada2, entrada3, entrada4, entrada5), esperado);

    }

    @Test
    public void testGetURL5() {
        String entrada1 = "http://localhost/";
        String entrada2 = "/teste/";
        String entrada3 = "/parte3/ ";
        String entrada4 = "/parte4/";
        String entrada5 = "/parte5/";

        String esperado = "http://localhost/teste/parte3/parte4/parte5";

        Assertions.assertEquals(PocketbaseUtil.getURL(entrada1, entrada2, entrada3, entrada4, entrada5), esperado);

    }

    @Test
    public void testGetURL6() {
        String entrada1 = "http://localhost/";
        String entrada2 = "";
        String entrada3 = "/parte3/ ";
        String entrada4 = "/parte4/";
        String entrada5 = "/parte5/";

        String esperado = "http://localhost/parte3/parte4/parte5";

        Assertions.assertEquals(PocketbaseUtil.getURL(entrada1, entrada2, entrada3, entrada4, entrada5), esperado);

    }

    @Test
    public void testBuildQuery() {
        System.out.println("buildQuery");
        ParametrosRequest parametros = new ParametrosRequestBuilder().build();
        String expResult = "?expand=&fields=&batch=500&filter=&page=0&perPage=10&skipTotal=false&sort=";
        String result = PocketbaseUtil.buildQuery(parametros);
        Assertions.assertEquals(expResult, result);
    }

}
