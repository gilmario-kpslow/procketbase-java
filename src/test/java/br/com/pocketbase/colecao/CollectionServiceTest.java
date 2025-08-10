/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.com.pocketbase.colecao;

import br.com.pocketbase.colecao.ColecaoService;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;
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
public class CollectionServiceTest {

//    private ColecaoService collectionService;
    public CollectionServiceTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testExiste() throws Exception {
        System.out.println("existe");
        String url = "http://localhost:8090";

        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);
        conf.setUsuario("api@teste.com");
        conf.setSenha("api#teste.com");

        PocketbaseCliente client = new PocketbaseCliente(conf);

        PocketbaseArmazenamentoCredencial credenciais = new PocketbaseArmazenamentoCredencial(client, conf);

        ColecaoService instance = new ColecaoService(client, credenciais);
        boolean result = instance.existe("_superusers");
        Assertions.assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testeList() {

    }

}
