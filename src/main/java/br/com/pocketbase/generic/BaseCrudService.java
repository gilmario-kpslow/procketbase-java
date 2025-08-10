package br.com.pocketbase.generic;

import br.com.pocketbase.dto.PocketbasePage;
import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.registro.Registro;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class BaseCrudService<T extends Registro> extends BaseService {

    public BaseCrudService(PocketbaseCliente client, PocketbaseArmazenamentoCredencial segurancaService) {
        super(client, segurancaService);
    }

    public abstract String getBaseUrl();

    public abstract Class getClassRegistro();

    public List<T> getFullList() throws IOException, InterruptedException, Exception {

        List<T> result = new ArrayList<>();

        PocketbasePage<T> resp = getList(new ParametrosRequestBuilder().build());

        result.addAll(resp.getItems());

        return result;

    }

    PocketbasePage<T> getList(ParametrosRequest paramsRequest) throws Exception {
        return getCliente().autenticar(credenciais.getCredencias().getToken()).getJson(getBaseUrl(), paramsRequest, PocketbasePage.class, getClassRegistro());
    }

    public T criar(T t) {
//        return
        return null;
    }

}
