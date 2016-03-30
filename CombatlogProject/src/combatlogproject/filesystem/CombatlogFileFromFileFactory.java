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
            int firstComma = 0;
            String date;
            String time;
            String allArgs;
            String[] args;
            long timestamp;
            String event;
            CombatlogEvent combatlogEvent;
            CombatlogEntry combatlogEntry;

            while ((line = bufferedReader.readLine()) != null) {

                date = line.substring(0, endDate);
                time = line.substring(endDate + 2, endTime);
                firstComma = line.indexOf(",");
                event = line.substring(endTime + 2, firstComma);
                allArgs = line.substring(firstComma + 1, line.length());
                //args = allArgs.split(",");
                int lastPosition = allArgs.indexOf(',');
                int[] commaPosition = new int[33];
                int positionCounter = 0;
                while (lastPosition != -1) {
                    lastPosition = allArgs.indexOf(',', lastPosition + 1);
                    commaPosition[positionCounter] = lastPosition;
                    positionCounter++;                    
                }
                timestamp = createTimestamp(date, time);
                combatlogEvent = CombatlogEvent.valueOf(event);
                combatlogEntry = new CombatlogEntry(combatlogEvent, timestamp, null);
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
