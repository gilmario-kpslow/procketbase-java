package br.com.pocketbase.generic;

import br.com.pocketbase.http.PocketbaseClient;

/**
 *
 * @author gilmario
 */
public abstract class BaseService {

    protected final PocketbaseClient client;

    public BaseService(PocketbaseClient client) {
        this.client = client;
    }

    public PocketbaseClient getClient() {
        return client;
    }

}
