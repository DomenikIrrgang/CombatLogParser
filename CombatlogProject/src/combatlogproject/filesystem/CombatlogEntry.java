package combatlogproject.filesystem;

/**
 * A single entry of a combatlogfile.
 *
 * @author Domenik Irrgang
 */
public class CombatlogEntry {

    private final long timestamp;
    private final String[] args;
    private final CombatlogEvent combatlogEvent;

    public CombatlogEntry(CombatlogEvent combatlogEvent, String date, String time, String[] args) {
       this.timestamp=convertDateAndTimeToTimestamp(date,time);
        this.args = args;
        this.combatlogEvent = combatlogEvent;
    }
    
    private long convertDateAndTimeToTimestamp(String date, String time){
        return 0L;
                }

    public String[] getArgs() {
        return args;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public CombatlogEvent getCombatlogEvent() {
        return combatlogEvent;
    }
}
