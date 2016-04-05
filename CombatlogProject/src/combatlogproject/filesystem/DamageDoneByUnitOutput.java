package combatlogproject.filesystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Domenik Irrgang
 */
public class DamageDoneByUnitOutput extends Output {
    
    private String path;

    public DamageDoneByUnitOutput(String path) {
        this.path = path;
    }
    
    @Override
    public void outputModule(Module module) {
        String content = "";
        if (module instanceof DamageDoneModule) {
            DamageDoneModule schinken = (DamageDoneModule) module;
            content = "<html><body><table><tr><th>UnitName</th><th>DamageDone</th></tr>";
            for (Unit unit : schinken.getUnits()) {
                String name = unit.getName();
                int damageDone = schinken.getDamageDoneByUnit(unit);   
                content += "<tr><td>" + name + "</td><td>" + String.valueOf(damageDone) + "</td></tr>";
            }
            content += "</table></body></html>";
            saveToFile(path, content);
        }
    }
    
}
