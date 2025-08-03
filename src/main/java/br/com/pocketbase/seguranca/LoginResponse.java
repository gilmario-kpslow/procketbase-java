package br.com.pocketbase.seguranca;

/**
 *
 * @author gilmario
 */
public class LoginResponse {

    private RecordAutenticado record;
    private String token;

    public LoginResponse() {
    }

    public RecordAutenticado getRecord() {
        return record;
    }

    public void setRecord(RecordAutenticado record) {
        this.record = record;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
