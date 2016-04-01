
package combatlogproject.filesystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Marc
 */
public abstract class Module {
    protected Map<CombatlogEvent, Boolean> events;
    
    public Module(){
events = new HashMap<CombatlogEvent,Boolean>();
}
   public abstract void processFileCallback(CombatlogEntry combatlogEntry) ;
   
   
  
    
          
}
    
    
    
    
    

