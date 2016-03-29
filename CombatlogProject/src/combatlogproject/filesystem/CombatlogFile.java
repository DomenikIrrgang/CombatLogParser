package combatlogproject.filesystem;

/**
 * This class contains every information that a "World of Warcraft" combatlog file would carry.
 *
 * @author Domenik Irrgang
 */
import java.util.*;
public class CombatlogFile {
    
    private List <CombatlogEntry> combatLogEntries ;
    protected CombatlogFile(){};
    
    public List <CombatlogEntry> getAllEntries(){
    return combatLogEntries;
    }
    
    public void addCombatlogEntry(CombatlogEntry combatlogEntry){
        combatLogEntries.add(combatlogEntry);
        
    }
    
    public CombatlogEntry removeCombatlogEntry(CombatlogEntry combatlogEntry){
    if (combatLogEntries.remove(combatlogEntry)){
return combatlogEntry;
}
    return null;
    }
      
    
}
