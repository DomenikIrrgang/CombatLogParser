package combatlogproject.filesystem;

/**
 * Filters a combatlogproject.filesystem.CombatlogFile.
 *
 * @author Domenik Irrgang
 */
public interface CombatlogFilter {

    /**
     * Filters a CombatlogFile and returns the filtered file.
     *
     * @param combatlogFile The CombatlogFile that will get filtered.
     * @return The filtered CombatlogFile.
     */
    CombatlogFile filter(CombatlogFile combatlogFile);
}
