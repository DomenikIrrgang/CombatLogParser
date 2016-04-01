package combatlogproject.filesystem;

import java.util.List;
import java.util.ArrayList;


/**
 * A CombatlogFileFactory is able to get a World of Warcraft combatlog file from a source and transform it into a 
 * combatlogproject.filesystem.CombatlogFile.
 * 
 * @author Domenik Irrgang
 */
public abstract class CombatlogFileFactory {
   public abstract boolean processCombatlogFile();
   
     protected List<Module>modules  ;
     
     public CombatlogFileFactory (){
     modules = new ArrayList<Module>();
    }
     public void addModule(Module module){
       modules.add  (module);
          
     }
     
     
     
             
   }
    
    

