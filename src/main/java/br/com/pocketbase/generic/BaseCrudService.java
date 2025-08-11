package br.com.pocketbase.generic;

import br.com.pocketbase.dto.PocketbasePage;
import br.com.pocketbase.http.ParametrosRequest;
import br.com.pocketbase.http.ParametrosRequestBuilder;
import br.com.pocketbase.http.PocketbaseCliente;
import br.com.pocketbase.registro.Registro;
import br.com.pocketbase.seguranca.PocketbaseArmazenamentoCredencial;
import br.com.pocketbase.util.JsonConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author gilmario
 * @param <T>
 */
public abstract class BaseCrudService<T extends Registro> extends BaseService {

    public BaseCrudService(PocketbaseCliente client, PocketbaseArmazenamentoCredencial segurancaService, String nomeColecao) {
        super(client, segurancaService, nomeColecao);
    }

    public abstract Class<T> getClassRegistro();

    public void preCriar(T t) {
    }

    public void preAtualizar(T t) {
    }

    public void preDeletar(T t) {
    }

    public List<T> listarTodos() throws IOException, InterruptedException, Exception {

        List<T> result = new ArrayList<>();

        PocketbasePage<T> resp = paginar(new ParametrosRequestBuilder().build());

        result.addAll(resp.getItems());

        return result;

    }

    public String getUrl() {
        return "/api/collections/".concat(nomeColecao).concat("/records");
    }

    public PocketbasePage<T> paginar(ParametrosRequest paramsRequest) throws Exception {
        return getCliente().autenticar(credenciais.getCredencias().getToken()).getJson(getUrl(), paramsRequest, PocketbasePage.class, getClassRegistro());
    }

    public T criarAtualizar(T t) throws Exception {
        if (Objects.nonNull(t.getId())) {
            return atualizar(t);
        }
        return criar(t);
    }

    public T criar(T t) throws Exception {
        preCriar(t);
        return getCliente().autenticar(credenciais.getCredencias().getToken()).postJson(getUrl(), JsonConverter.toJson(t), getClassRegistro());
    }

    public T atualizar(T t) throws Exception {
        preAtualizar(t);
        return getCliente().autenticar(credenciais.getCredencias().getToken()).patchJson(getUrl().concat("/").concat(t.getId()), JsonConverter.toJson(t), getClassRegistro());
    }

    public void deletar(T t) throws Exception {
        preDeletar(t);
        getCliente()
                .autenticar(credenciais.getCredencias().getToken())
                .deletar(getUrl().concat("/").concat(t.getId()));
    }

    public void deletar(String id) throws Exception {
//        preDeletar(t);
        getCliente()
                .autenticar(credenciais.getCredencias().getToken())
                .deletar(getUrl().concat("/").concat(id));
    }

    public T buscarPorId(String id) throws Exception {
        return getCliente()
                .autenticar(credenciais.getCredencias().getToken())
                .getJson(getUrl().concat("/").concat(id), getClassRegistro());
    }

}
