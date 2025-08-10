package br.com.pocketbase.seguranca;

import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import java.util.Objects;
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
//        LoginRequest request = new LoginRequest();
//        request.setIdentity("api@teste.com");
//        request.setPassword("api#teste.com");

        String url = "http://localhost:8090";

        PocketbaseConfiguracao conf = new PocketbaseConfiguracao();
        conf.setServerURL(url);
        conf.setUsuario("api@teste.com");
        conf.setSenha("api#teste.com");

        PocketbaseCliente client = new PocketbaseCliente(conf);

        PocketbaseArmazenamentoCredencial instance = new PocketbaseArmazenamentoCredencial(client, conf);
        instance.autenticar();
        LoginResponse result = instance.getCredencias();
        Assertions.assertTrue(Objects.nonNull(result.getToken()));
    }

}
