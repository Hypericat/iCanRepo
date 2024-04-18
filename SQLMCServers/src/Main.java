import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


//Sorry for not commenting anything :(
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        SqlHandler handler = new SqlHandler();
        handler.initCon("root", "", "127.0.0.1", "3306");
        //handler.useDB("IP");

        String path = "C:\\Users\\Hypericats\\Desktop\\Nadeau\\DBFiles\\logs";

        DirectoryJsonProcessor jsonProcessor = new DirectoryJsonProcessor(path);
        List<IPRecordEntry> records = jsonProcessor.processAll();

        for (IPRecordEntry entry : records) {
            System.out.println(entry.toString());
        }
        
    }

}