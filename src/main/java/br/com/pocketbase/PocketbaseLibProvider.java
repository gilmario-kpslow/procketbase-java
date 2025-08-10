package br.com.pocketbase;

import br.com.pocketbase.generic.BaseService;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import java.lang.reflect.InvocationTargetException;
import java.net.http.HttpClient;

/**
 *
 * @author gilmario
 */
public class PocketbaseLibProvider {

    private final PocketbaseCliente pocketbaseCliente;

    public PocketbaseLibProvider(PocketbaseConfiguracao configuracao, HttpClient httpcliente) {
        pocketbaseCliente = new PocketbaseCliente(configuracao, httpcliente);
    }

    public <S extends BaseService> S getServiceInstance(Class<S> classe) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return classe.getConstructor(PocketbaseCliente.class).newInstance(pocketbaseCliente);
    }
}
