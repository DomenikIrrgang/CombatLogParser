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
public class CombatlogFileFromFileFactory extends CombatlogFileFactory {

    private final String filePath;

    public CombatlogFileFromFileFactory(String filePath) {
        super();
        this.filePath = filePath;
    }

    @Override
    public boolean processCombatlogFile() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String line;

            int endDate = 4;
            int endTime = 17;
            int firstComma;
            String date;
            String time;
            String allArgs;
            String[] args;
            String event;
            CombatlogEvent combatlogEvent;
            CombatlogEntry combatlogEntry;

            while ((line = bufferedReader.readLine()) != null) {
                date = line.substring(0, endDate);
                time = line.substring(endDate + 2, endTime);
                firstComma = line.indexOf(",");
                event = line.substring(endTime + 2, firstComma);
                allArgs = line.substring(firstComma + 1, line.length());
                args = allArgs.split(",");

                combatlogEvent = CombatlogEvent.valueOf(event);
                combatlogEntry = new CombatlogEntry(combatlogEvent, date, time, args);
                for (Module module : modules) {
                    module.processFileCallback(combatlogEntry);
                }
                combatlogEntry = null;
            }

            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        CombatlogFileFactory factory = new CombatlogFileFromFileFactory("C:\\Program Files\\WoW\\World of Warcraft\\Logs\\WoWCombatLog-split-2016-03-24T07-53-47.935Z.txt");
        Module damageDone = new DamageDoneModule();
        Output damageDoneOutput = new DamageDoneByUnitOutput("C:\\Users\\Domenik Irrgang\\Desktop\\CombatlogResult\\damagedone.html");
        factory.addModule(new DamageDoneModule());
        boolean success = factory.processCombatlogFile();
        damageDoneOutput.outputModule(damageDone);
    }

}
