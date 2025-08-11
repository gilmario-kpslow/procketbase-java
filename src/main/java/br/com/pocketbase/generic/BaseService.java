package br.com.pocketbase.generic;

import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;

/**
 *
 * @author gilmario
 */
public abstract class BaseService {

    protected final PocketbaseCliente cliente;
    protected final PocketbaseArmazenamentoCredencial credenciais;
    protected final String nomeColecao;

    public BaseService(PocketbaseCliente cliente, PocketbaseArmazenamentoCredencial credenciais, String colecao) {
        this.cliente = cliente;
        this.credenciais = credenciais;
        this.nomeColecao = colecao;
    }

    public PocketbaseCliente getCliente() {
        return cliente;
    }

}
