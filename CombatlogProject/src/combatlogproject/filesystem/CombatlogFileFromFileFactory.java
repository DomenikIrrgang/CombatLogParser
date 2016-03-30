package combatlogproject.filesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Gets a "World of Warcraft" combatlogfile from the local computer and converts it into a combatlogproject.filesystem.CombatlogFile.
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
            
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitBySpace = line.split(" ");
                long timestamp = createTimestamp(splitBySpace[0], splitBySpace[1]);
                String[] splitForEvent = splitBySpace[2].split(",");
                CombatlogEvent combatlogEvent = CombatlogEvent.valueOf(splitForEvent[0]);
                String[] args = line.substring(line.indexOf(",")).split(",");
                CombatlogEntry combatlogEntry = new CombatlogEntry(combatlogEvent, timestamp, args);
                combatlogFile.addCombatlogEntry(combatlogEntry);
                System.out.println(splitForEvent[0]);
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
