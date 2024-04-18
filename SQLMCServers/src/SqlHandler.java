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
        queryVoid("USING " + name);
    }
    private ResultSet query(String query) throws SQLException {
        return stmt.executeQuery(query);
    }
    private void queryVoid(String query) throws SQLException {
        discard(query(query));
    }
    public void addEntry(IPRecordEntry entry) {

    }
    public static void discard(Object obj) throws SQLException {
        if(obj instanceof Statement) ((Statement) obj).close();
        if(obj instanceof Connection) ((Connection) obj).close();
        if(obj instanceof ResultSet) ((ResultSet) obj).close();
    }
    public void closeCon() throws SQLException {
        con.close();
    }

}
