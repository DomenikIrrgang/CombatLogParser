package combatlogproject.filesystem;

/**
 * A single entry of a combatlogfile.
 *
 * @author Domenik Irrgang
 */
public class CombatlogEntry {

    private final long timestamp;
    private final String[] args;
    private final CombatlogEvent CombatlogEvent;

    public CombatlogEntry(CombatlogEvent combatlogEvent, long timestamp, String[] args) {
        this.timestamp = timestamp;
        this.args = args;
        this.CombatlogEvent = combatlogEvent;
    }

    public String[] getArgs() {
        return args;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public CombatlogEvent getCombatlogEvent() {
        return CombatlogEvent;
    }
}
