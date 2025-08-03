package br.com.pocketbase.health;

/**
 *
 * @author gilmario
 */
public class SaudeResponse {

    private String message;
    private int code;
    private SaudeData data;

    public SaudeResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public SaudeData getData() {
        return data;
    }

    public void setData(SaudeData data) {
        this.data = data;
    }

}
