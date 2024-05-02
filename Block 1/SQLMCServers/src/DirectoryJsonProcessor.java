import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DirectoryJsonProcessor {
    private File directory;
    public DirectoryJsonProcessor(File directory) throws FileNotFoundException {
        if (!directory.isDirectory() || !directory.exists()) throw new FileNotFoundException("Directory Json Processor passed file is not directory or does not exist");
        this.directory = directory;
    }
    public DirectoryJsonProcessor(String filePath) throws FileNotFoundException {
        this(new File(filePath));
    }

    public List<IPRecordEntry> processAll() {
        System.out.println("Starting to read all files");
        List<RawIPRecord> rawRecords = getAllRaw();
        System.out.println("Read all files total of " + rawRecords.size());
        System.out.println("Converting files to records");
        List<IPRecordEntry> records = new ArrayList<>();
        for (RawIPRecord rawRecord : rawRecords) {
            records.add(rawIPRecordToRecord(rawRecord));
        }
        System.out.println("Converted all files to records");
        return records;
    }
    public IPRecordEntry rawIPRecordToRecord(RawIPRecord raw) {
        JsonHelper helper = new JsonHelper(raw.getJson());
        ipAddress address = raw.getAddress();
        System.out.println("Converting " + address.toString());
        String version;
        try {
            version = ((String) helper.getField(new String[]{"version", "name"})).replaceAll("'", "");
        } catch (JSONException | NullPointerException ex) {
            version = "";
        }

        int protocol;
        try {
            protocol = (int) helper.getField(new String[]{"version", "protocol"});
        } catch (NullPointerException ex) {
            protocol = -1;
        }
        boolean enforcedSecureChat;
        try {
            enforcedSecureChat = helper.getField(new String[]{"enforcesSecureChat"}).equals("true");
        } catch (NullPointerException ex) {
            enforcedSecureChat = false;
        }

        String motd;
        try {
            motd = ((String) helper.getField(new String[] {"description", "text"})).replaceAll("'", "");
        } catch (JSONException exception) {
            motd = ((String) helper.getField(new String[] {"description"})).replaceAll("'", "");
        } catch (NullPointerException ex) {
            motd = "";
        }
        int playerOnline;
        int playerMax;
        try {
            playerOnline = (int) helper.getField(new String[]{"players", "online"});
        } catch (NullPointerException ex) {
            playerOnline = -1;
        }
        try {
            playerMax = (int) helper.getField(new String[]{"players", "max"});
        } catch (NullPointerException ex) {
            playerMax = -1;
        }
        String samplePlayers;
        try {
            samplePlayers = (String) helper.getField(new String[]{"players", "sample"});
        } catch (Exception ex) {
            samplePlayers = null;
        }
        return new IPRecordEntry(address, motd, enforcedSecureChat, playerOnline, playerMax, version, protocol, null);
    }
    public String readAllFile(File file) {
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.exit(1);
            return null;
        }
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public List<RawIPRecord> getAllRaw() {
        List<RawIPRecord> rawReturns = new ArrayList<>();
        for (File dir : Objects.requireNonNull(directory.listFiles())) {
            if (!dir.isDirectory()) continue;
            ipAddress fileIP;
            try {
                fileIP = new ipAddress(dir.getName());
            } catch (IllegalArgumentException ex) {
                continue;
            }
            String content = getRecentFileContentFromDirectory(dir);
            if (content == null) continue;
            rawReturns.add(new RawIPRecord(fileIP, content));
        }
        return rawReturns;
    }
    public String getRecentFileContentFromDirectory(File dir) {
        long bestFileTime = 0;
        File bestFile = null;
        for (File file : Objects.requireNonNull(dir.listFiles())) {
            if (file.isDirectory()) continue;
            String fileName = file.getName().replace(".json", "");
            if (!Util.isNumerical(fileName)) continue;
            long fileTimestamp = Long.parseLong(fileName);
            if (fileTimestamp > bestFileTime) {
                bestFileTime = fileTimestamp;
                bestFile = file;
            }
        }
        return readAllFile(bestFile);
    }
}
