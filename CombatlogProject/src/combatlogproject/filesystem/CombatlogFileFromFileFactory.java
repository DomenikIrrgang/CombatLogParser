package combatlogproject.filesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets a "World of Warcraft" combatlogfile from the local computer and converts
 * it into a combatlogproject.filesystem.CombatlogFile.
 *
 * @author Domenik Irrgang
 */
public class CombatlogFileFromFileFactory implements CombatlogFileFactory {

    private final String filePath;

    public CombatlogFileFromFileFactory(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public CombatlogFile createCombatlogfile() {

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            CombatlogFile combatlogFile = new CombatlogFile();
            String line;

            int endDate = 4;
            int endTime = 17;
            while ((line = bufferedReader.readLine()) != null) {
                String date = line.substring(0, endDate);
                String time = line.substring(endDate + 2, endTime);
                int firstComma = line.indexOf(",");
                String event = line.substring(endTime + 2, firstComma);
                String allArgs = line.substring(firstComma + 1, line.length());
                String[] args = allArgs.split(",");
                long timestamp = createTimestamp(date, time);
                CombatlogEvent combatlogEvent = CombatlogEvent.valueOf(event);
                CombatlogEntry combatlogEntry = new CombatlogEntry(combatlogEvent, timestamp, args);
                combatlogFile.addCombatlogEntry(combatlogEntry);
            }

            return combatlogFile;
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        }
    }

    private long createTimestamp(String date, String time) {
        return 0L;
    }

    public static void main(String[] args) {
        CombatlogFileFactory factory = new CombatlogFileFromFileFactory("C:\\Program Files (x86)\\World of Warcraft\\Logs\\warcraftlogsarchive\\WoWCombatLog-archive-2016-02-21T04-02-48.614Z.txt");
        CombatlogFile combatlogFile = factory.createCombatlogfile();
    }
}
