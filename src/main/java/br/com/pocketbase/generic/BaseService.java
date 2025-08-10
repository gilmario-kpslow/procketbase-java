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

    public BaseService(PocketbaseCliente cliente, PocketbaseArmazenamentoCredencial credenciais) {
        this.cliente = cliente;
        this.credenciais = credenciais;
    }

    public PocketbaseCliente getCliente() {
        return cliente;
    }

}
