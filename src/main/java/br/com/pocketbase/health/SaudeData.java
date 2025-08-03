package br.com.pocketbase.health;

/**
 *
 * @author gilmario
 */
public class SaudeData {

    private boolean canBackup;
    private String possibleProxyHeader;
    private String realIP;

    public SaudeData() {
    }

    public boolean isCanBackup() {
        return canBackup;
    }

    public void setCanBackup(boolean canBackup) {
        this.canBackup = canBackup;
    }

    public String getPossibleProxyHeader() {
        return possibleProxyHeader;
    }

    public void setPossibleProxyHeader(String possibleProxyHeader) {
        this.possibleProxyHeader = possibleProxyHeader;
    }

    public String getRealIP() {
        return realIP;
    }

    public void setRealIP(String realIP) {
        this.realIP = realIP;
    }

}
