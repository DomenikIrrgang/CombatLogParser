package combatlogproject.filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Domenik Irrgang
 */
public class DamageDoneModule extends Module {

    private Map<Unit, Map<Unit, Map<String, Integer>>> damageDone;

    public DamageDoneModule() {
        super();
        events.put(CombatlogEvent.SPELL_DAMAGE, true);
        events.put(CombatlogEvent.SWING_DAMAGE, true);
        events.put(CombatlogEvent.ENVIRONMENTAL_DAMAGE, true);
        events.put(CombatlogEvent.RANGE_DAMAGE, true);
        events.put(CombatlogEvent.SPELL_PERIODIC_DAMAGE, true);
        damageDone = new HashMap<Unit, Map<Unit, Map<String, Integer>>>();
    }

    @Override
    public void processFileCallback(CombatlogEntry combatlogEntry) {
        if (events.get(combatlogEntry.getCombatlogEvent()) != null && events.get(combatlogEntry.getCombatlogEvent()) == true) {

            if (combatlogEntry.getCombatlogEvent().equals(CombatlogEvent.SPELL_DAMAGE)) {
                processEventValues(combatlogEntry.getArgs()[1], combatlogEntry.getArgs()[5], combatlogEntry.getArgs()[9], combatlogEntry.getArgs()[24]);
            }

            if (combatlogEntry.getCombatlogEvent().equals(CombatlogEvent.SWING_DAMAGE)) {
                processEventValues(combatlogEntry.getArgs()[1], combatlogEntry.getArgs()[5], "Melee", combatlogEntry.getArgs()[21]);
            }
            
            if (combatlogEntry.getCombatlogEvent().equals(CombatlogEvent.ENVIRONMENTAL_DAMAGE)) {
                processEventValues("Environment", combatlogEntry.getArgs()[5], combatlogEntry.getArgs()[21], combatlogEntry.getArgs()[22]);
            }
            
            if (combatlogEntry.getCombatlogEvent().equals(CombatlogEvent.RANGE_DAMAGE)) {
                processEventValues(combatlogEntry.getArgs()[1], combatlogEntry.getArgs()[5], combatlogEntry.getArgs()[9], combatlogEntry.getArgs()[24]);
            }
            
            if (combatlogEntry.getCombatlogEvent().equals(CombatlogEvent.SPELL_PERIODIC_DAMAGE)) {
                processEventValues(combatlogEntry.getArgs()[1], combatlogEntry.getArgs()[5], combatlogEntry.getArgs()[9], combatlogEntry.getArgs()[24]);
            }
        }
    }

    private void processEventValues(String source, String target, String spellname, String amount) {
        Unit sourceUnit = new Unit(source);
        checkSource(sourceUnit);
        Unit targetUnit = new Unit(target);
        checkTarget(sourceUnit, targetUnit);
        String targetSpellname = spellname;
        checkSpellname(sourceUnit, targetUnit, targetSpellname);
        int newAmount = Integer.valueOf(amount);
        int oldValue = damageDone.get(sourceUnit).get(targetUnit).get(targetSpellname);
        damageDone.get(sourceUnit).get(targetUnit).put(targetSpellname, oldValue + newAmount);
    }

    private void checkSpellname(Unit source, Unit target, String spellName) {
        if (damageDone.get(source).get(target).get(spellName) == null) {
            damageDone.get(source).get(target).put(spellName, 0);
        }
    }

    private void checkTarget(Unit source, Unit target) {
        if (damageDone.get(source).get(target) == null) {
            damageDone.get(source).put(target, new HashMap<String, Integer>());
        }
    }

    private void checkSource(Unit source) {
        if (damageDone.get(source) == null) {
            damageDone.put(source, new HashMap<Unit, Map<String, Integer>>());
        }
    }
    
    public List<Unit> getUnits() {
        List<Unit> result = new ArrayList<Unit>();
        for (Unit unit : damageDone.keySet()) {
            result.add(unit);
        }
        return result;
    }
    
    public List<Unit> getUnitTargets(Unit unit) {
        List<Unit> result = new ArrayList<Unit>();
        for (Unit target : damageDone.get(unit).keySet()) {
            result.add(target);
        }
        return result;
    }
    
    public List<String> getDamageSpellsByUnit(Unit unit) {
        List<String> result = new ArrayList<String>();
        for (Unit target : damageDone.get(unit).keySet()) {
            for (String spell : damageDone.get(unit).get(target).keySet()) {
                if (!result.contains(spell)) {
                    result.add(spell);
                }
            }
        }
        return result;
    }
    
    public int getDamageDoneToTarget(Unit source, Unit target) {
        int result = 0;
        for (Integer damage : damageDone.get(source).get(target).values()) {
            result += damage;
        }
        return result;
    }
    
    public int getDamageDoneByUnit(Unit unit) {
        int result = 0;
        for (Unit target : damageDone.get(unit).keySet()) {
            for (Integer damage : damageDone.get(unit).get(target).values()) {
                result += damage;
            }
        }
        return result;
    }
    
    public int getDamageDoneByUnitBySpell(Unit unit, String spell) {
        int result = 0;
        for (Unit target : damageDone.get(unit).keySet()) {
            if (damageDone.get(unit).get(target).get(spell) != null) {
                result += damageDone.get(unit).get(target).get(spell);
            }
        }
        return result;
    }
    
    public int getAllDamageDone() {
        int result = 0;
        for (Unit unit : damageDone.keySet()) {
            result += getDamageDoneByUnit(unit);
        }
        return result;
    }

}