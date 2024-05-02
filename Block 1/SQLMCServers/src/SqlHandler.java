import java.sql.*;
import java.util.Properties;

public class SqlHandler {
    private Connection con;
    private Statement stmt;
    public void initCon(String username, String password, String serverName, String portNumber) throws SQLException, ClassNotFoundException {
        Properties conProps = new Properties();
        conProps.put("user", username);
        conProps.put("password", password);
        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:" + "mysql" + "://" + serverName + ":" + portNumber + "/" + "IP?characterEncoding=latin1&useConfigs=maxPerformance", conProps);
        stmt = con.createStatement();
        System.out.println("Connected to database");
    }
    public void useDB(String name) throws SQLException {
        queryVoid("USE " + name);
        System.out.println("Using Database " + name);
    }
    public void initTable() {
        try {
            execute("CREATE TABLE IPADDRESS(" +
                    "addressID INT PRIMARY KEY AUTO_INCREMENT," +
                    "ipAddress TEXT NOT NULL," +
                    "version TEXT," +
                    "protocol INT," +
                    "enforcesSecureChat BOOL," +
                    "motd TEXT," +
                    "playerMax INT," +
                    "playerOnline INT" +
                    ");");
        } catch (SQLException ex) {
            System.out.println("Error or table already initialized");
            return;
        }
        System.out.println("Initialized table");
    }
    public void dropTable() {
        try {
            execute("DROP TABLE IPADDRESS");
            System.out.println("Successfully dropped table!");
        } catch (SQLException e) {
            System.out.println("Failed to drop table, most likely does not exist");
        }
    }
    public void clearTable() {
        dropTable();
        initTable();
    }
    public boolean execute(String query) throws SQLException {
        return stmt.execute(query);
    }
    public ResultSet query(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
    public void queryVoid(String query) throws SQLException {
        discard(query(query));
    }
    public void addEntry(IPRecordEntry entry) throws SQLException {
        String query = "VALUES ('" + entry.getAddress().toString() + "','" + entry.getVersion() + "'," + entry.getProtocol() + "," + (entry.getEnforcesSecureChat() ? "true" : "false") + ",'" + entry.getMotd() + "'," + entry.getPlayerMax() + "," + entry.getPlayerOnline() + ")";
        execute("INSERT INTO IPADDRESS (ipAddress,version,protocol,enforcesSecureChat,motd,playerMax,PlayerOnline) " + query);
    }
    public static void discard(Object obj) throws SQLException {
        if(obj instanceof Statement) ((Statement) obj).close();
        if(obj instanceof Connection) ((Connection) obj).close();
        if(obj instanceof ResultSet) ((ResultSet) obj).close();
    }
    public void closeCon() throws SQLException {
        stmt.close();
        con.close();
    }

}
