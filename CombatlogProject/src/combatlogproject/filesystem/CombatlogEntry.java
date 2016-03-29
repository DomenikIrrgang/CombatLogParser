package combatlogproject.filesystem;

/**
 * A single entry of a combatlogfile.
 *
 * @author Domenik Irrgang
 */
public class CombatlogEntry {
    private long timestamp;
    private String[] args;
    private CombatlogEvent CombatlogEvent;
    
    
   public CombatlogEntry (long timestamp, String[] args)
   {
       this.timestamp=timestamp;
       this.args=args;
       
   }
   public String[] getArgs(){
       return args;
   }
   
   public long getTimestamp(){
       return timestamp;
   }
   
   public CombatlogEvent getCombatlogEvent(){
       return CombatlogEvent;
   }
   }
   
   

