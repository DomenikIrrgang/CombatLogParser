/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package combatlogproject.filesystem;

/**
 *
 * @author Domenik Irrgang
 */
public class DamageDoneByUnitBySpellOutput extends Output {

    private String path;

    public DamageDoneByUnitBySpellOutput(String path) {
        this.path = path;
    }

    @Override
    public void outputModule(Module module) {
        String content = "";
        if (module instanceof DamageDoneModule) {
            DamageDoneModule damageDoneModule = (DamageDoneModule) module;
            content = "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head><body><table><tr><th>Unit</th><th>Spellname</th><th>Damage</th></tr>";
            for (Unit unit : damageDoneModule.getUnits()) {
                String name = unit.getName();
                content += "<tr><th>" + name + "</th><th></th><th></th></tr>";
                for (String spell : damageDoneModule.getDamageSpellsByUnit(unit)) {
                    int damage = damageDoneModule.getDamageDoneByUnitBySpell(unit, spell);
                    content += "<tr><td></td><td>" + spell + "</td><td>" + damage + "</td></tr>";
                }
            }
            content += "</table></body></html>";
            saveToFile(path, content);
        }
    }
}
