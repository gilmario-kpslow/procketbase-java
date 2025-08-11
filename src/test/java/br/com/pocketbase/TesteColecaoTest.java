package br.com.pocketbase;

import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author gilmario
 */
public class TesteColecaoTest {

    public TesteColecaoTest() {
    }

    @Test
    public void testFiltro() throws Exception {
        System.out.println("testeFiltro");
        String url = "http://localhost:8090";
        PocketbaseConfiguracao configuracao = new PocketbaseConfiguracao();
        configuracao.setServerURL(url);
        configuracao.setUsuario("api@teste.com");
        configuracao.setSenha("api#teste.com");

        PocketbaseCliente cliente = new PocketbaseCliente(configuracao);

        PocketbaseArmazenamentoCredencial instance = new PocketbaseArmazenamentoCredencial(cliente, configuracao);

        instance.autenticarSuper();
        String caht = URLEncoder.encode("\'", "UTF-8");
        HttpResponse<String> resp = cliente.GET("/api/collections/cliente/records", new ParametrosRequestBuilder().addHeader("Authorization", instance.getCredenciasSuper().getToken()).filter("nome='TESTE'").build());
        System.out.println(resp.body());
        Assertions.assertTrue(resp.statusCode() == 200);
    }
}
