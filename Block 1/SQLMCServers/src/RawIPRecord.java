public class RawIPRecord {
    private ipAddress address;
    private String json;

    public RawIPRecord(ipAddress address, String json) {
        this.address = address;
        this.json = json;
    }

    public ipAddress getAddress() {
        return address;
    }

    public String getJson() {
        return json;
    }

    public void setAddress(ipAddress address) {
        this.address = address;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
