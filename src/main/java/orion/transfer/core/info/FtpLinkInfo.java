package orion.transfer.core.info;

public class FtpLinkInfo extends DownloadLinkInfo {
    private String username;
    private String password;
    private String host;
    private int port;

    @Override
    public String getProtocol() {
        return super.getProtocol();
    }

    @Override
    public void setProtocol(String protocol) {
        super.setProtocol(protocol);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "FtpLinkInfo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
