package br.com.pocketbase.seguranca;

import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import java.io.IOException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class PocketbaseArmazenamentoCredencialTest {

    public PocketbaseArmazenamentoCredencialTest() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String url = "http://localhost:8090";
        PocketbaseConfiguracao configuracao = new PocketbaseConfiguracao();
        configuracao.setServerURL(url);
        configuracao.setUsuario("chatintegracao@email.com");
        configuracao.setSenha("chatintegracao@email.com");

        PocketbaseCliente cliente = new PocketbaseCliente(configuracao);

        PocketbaseArmazenamentoCredencial instance = new PocketbaseArmazenamentoCredencial(cliente, configuracao);
        LoginResponse result = instance.getCredencias();
        Assertions.assertNotNull(result);
    }

    @Test
    public void testIsAutenticado() throws IOException, Exception {
        System.out.println("isAutenticado");
        String url = "http://localhost:8090";
        PocketbaseConfiguracao configuracao = new PocketbaseConfiguracao();
        configuracao.setServerURL(url);
        configuracao.setUsuario("api@teste.com");
        configuracao.setSenha("api#teste.com");

        PocketbaseCliente cliente = new PocketbaseCliente(configuracao);

        PocketbaseArmazenamentoCredencial instance = new PocketbaseArmazenamentoCredencial(cliente, configuracao);
        instance.autenticarSuper();
        boolean expResult = true;
        boolean result = instance.isAutenticadoSuper();
        Assertions.assertEquals(expResult, result);
    }

    @Test
    public void testTokenIsValido() throws IOException, Exception {
        System.out.println("tokenIsValido");
        String url = "http://localhost:8090";
        PocketbaseConfiguracao configuracao = new PocketbaseConfiguracao();
        configuracao.setServerURL(url);
        configuracao.setUsuario("api@teste.com");
        configuracao.setSenha("api#teste.com");

        PocketbaseCliente cliente = new PocketbaseCliente(configuracao);

        PocketbaseArmazenamentoCredencial instance = new PocketbaseArmazenamentoCredencial(cliente, configuracao);
        instance.autenticarSuper();
        boolean result = instance.tokenIsValidoSuper();
        Assertions.assertTrue(result);
//        fail("The test case is a prototype.");
    }

}
