package br.com.pocketbase;

import br.com.pocketbase.generic.BaseService;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.http.PocketbaseConfiguracao;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;
import java.lang.reflect.InvocationTargetException;
import java.net.http.HttpClient;

/**
 *
 * @author gilmario
 */
public class PocketbaseLibProvider {

    private final PocketbaseCliente pocketbaseCliente;
    protected final PocketbaseArmazenamentoCredencial credenciais;

    public PocketbaseLibProvider(PocketbaseConfiguracao configuracao, HttpClient httpcliente) {
        pocketbaseCliente = new PocketbaseCliente(configuracao, httpcliente);
        credenciais = new PocketbaseArmazenamentoCredencial(pocketbaseCliente, configuracao);

    }

    public <S extends BaseService> S getServiceInstance(Class<S> classe, String colecao) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        return classe.getConstructor(PocketbaseCliente.class, PocketbaseArmazenamentoCredencial.class, String.class).newInstance(pocketbaseCliente, credenciais, colecao);
    }
}
