package br.com.pocketbase.generic;

import br.com.pocketbase.http.PocketbaseClient;
import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.service.ResultList;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class BaseCrudService<T> extends BaseService {

    public BaseCrudService(PocketbaseClient client) {
        super(client);
    }

    public abstract String getBaseUrl();

    public List<T> getFullList() throws IOException, InterruptedException {

        List<T> result = new ArrayList<>();

        ResultList<T> resp = getList(new ParametrosRequestBuilder().build());

        result.addAll(resp.getItems());

        return result;

    }

    ResultList<T> getList(ParametrosRequest paramsRequest) throws IOException, InterruptedException {

        HttpResponse response = getClient().GET(getBaseUrl(), paramsRequest);

        return null;
    }
}
