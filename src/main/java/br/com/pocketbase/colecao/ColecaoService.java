package br.com.pocketbase.colecao;

import br.com.pocketbase.dto.PocketbasePage;
import br.com.pocketbase.generic.BaseService;
import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;

/**
 *
 * @author gilmario
 */
public class ColecaoService extends BaseService {

    private static final String BASE_URL = "/api/collections";

    public ColecaoService(PocketbaseCliente cliente, PocketbaseArmazenamentoCredencial credenciais) {
        super(cliente, credenciais);
    }

    public PocketbasePage<Colecao> getLista(ParametrosRequest paramsRequest) throws Exception {
        return cliente.autenticar(credenciais.getCredencias().getToken()).getJson(BASE_URL, paramsRequest, PocketbasePage.class, Colecao.class);
    }

    public boolean existe(String colecao) throws Exception {
        PocketbasePage<Colecao> resp = getLista(new ParametrosRequestBuilder().build());
        return resp.getItems()
                .stream()
                .filter(c -> c.getName().equals(colecao))
                .findFirst()
                .isPresent();
    }
}
