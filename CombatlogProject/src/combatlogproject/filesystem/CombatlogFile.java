package combatlogproject.filesystem;

import java.util.*;

/**
 * This class contains every information that a "World of Warcraft" combatlog
 * file would carry.
 *
 * @author Domenik Irrgang
 */
public class CombatlogFile {

    private List<CombatlogEntry> combatLogEntries;

    protected CombatlogFile() {
        combatLogEntries = new ArrayList<CombatlogEntry>();
    }

    public List<CombatlogEntry> getAllEntries() {
        return combatLogEntries;
    }

    public void addCombatlogEntry(CombatlogEntry combatlogEntry) {
        combatLogEntries.add(combatlogEntry);
    }

    public CombatlogEntry removeCombatlogEntry(CombatlogEntry combatlogEntry) {
        if (combatLogEntries.remove(combatlogEntry)) {
            return combatlogEntry;
        }
        return null;
    }
}
