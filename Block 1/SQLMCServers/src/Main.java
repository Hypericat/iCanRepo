import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


//Sorry for not commenting anything :(
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {
        SqlHandler handler = new SqlHandler();
        handler.initCon("root", "", "127.0.0.1", "3306");
        //handler.useDB("IP");

        String path = "DatabaseSample";

        DirectoryJsonProcessor jsonProcessor = new DirectoryJsonProcessor(path);
        List<IPRecordEntry> records = jsonProcessor.processAll();

        for (IPRecordEntry entry : records) {
            System.out.println(entry.toString());
        }

        handler.useDB("IP");
        handler.clearTable();
        System.out.println("Adding all " + records.size() + " entries to database");
        for (IPRecordEntry entry : records) {
            handler.addEntry(entry);
        }
        System.out.println("Finished adding all entries...");
        System.out.println("Terminal Activated");
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (!input.equalsIgnoreCase("exit")) {
            try {
                System.out.println("Enter sql query : ");
                input = scanner.nextLine();
                handler.execute(input);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

}