import java.util.List;

public class IPRecordEntry {
    private ipAddress address;
    private String motd;
    private int playerOnline;
    private int playerMax;
    private String version;
    private int protocol;
    private List<String> samplePlayers;
    private boolean enforcesSecureChat;

    public IPRecordEntry(ipAddress address, String motd, boolean enforcesSecureChat, int playerOnline, int playerMax, String version, int protocol, List<String> samplePlayers) {
        this.address = address;
        this.motd = motd;
        this.enforcesSecureChat = enforcesSecureChat;
        this.playerOnline = playerOnline;
        this.playerMax = playerMax;
        this.version = version;
        this.protocol = protocol;
        this.samplePlayers = samplePlayers;
    }
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("address : ").append(address.toString()).append("\n");
        builder.append("enforcesSecurechat : ").append(enforcesSecureChat ? "true" : "false").append("\n");
        builder.append("playerOnline : ").append(playerOnline).append("\n");
        builder.append("playerMax : ").append(playerMax).append("\n");
        builder.append("protocol : ").append(protocol).append("\n");
        builder.append("version : ").append(version).append("\n");
        return builder.toString();
    }

    public ipAddress getAddress() {
        return address;
    }
    public boolean getEnforcesSecureChat() {
        return enforcesSecureChat;
    }

    public String getMotd() {
        return motd;
    }

    public int getPlayerOnline() {
        return playerOnline;
    }

    public int getPlayerMax() {
        return playerMax;
    }

    public String getVersion() {
        return version;
    }

    public int getProtocol() {
        return protocol;
    }

    public List<String> getSamplePlayers() {
        return samplePlayers;
    }

    public void setAddress(ipAddress address) {
        this.address = address;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    public void setPlayerOnline(int playerOnline) {
        this.playerOnline = playerOnline;
    }

    public void setPlayerMax(int playerMax) {
        this.playerMax = playerMax;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    public void setSamplePlayers(List<String> samplePlayers) {
        this.samplePlayers = samplePlayers;
    }

    public void setEnforcesSecureChat(boolean enforcesSecureChat) {
        this.enforcesSecureChat = enforcesSecureChat;
    }
}
