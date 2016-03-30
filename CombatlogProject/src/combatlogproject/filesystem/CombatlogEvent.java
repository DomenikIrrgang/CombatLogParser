package combatlogproject.filesystem;

/**
 * Every event that can occur in a "World of Warcraft" combatlog file.
 *
 * @author Domenik Irrgang
 */
public enum CombatlogEvent {
    SWING_DAMAGE,
    SWING_DAMAGE_LANDED,
    SPELL_HEAL,
    SPELL_ENERGIZE,
    SPELL_CAST_SUCCESS,
    SPELL_AURA_REMOVED,
    SPELL_SUMMON,
    SPELL_AURA_APPLIED,
    SPELL_AURA_REFRESH,
    SPELL_CAST_FAILED,
    SWING_MISSED,
    ENVIRONMENTAL_DAMAGE,
    SPELL_ABSORBED,
    SPELL_PERIODIC_DAMAGE,
    SPELL_DAMAGE,
    SPELL_CAST_START,
    SPELL_AURA_APPLIED_DOSE,
    SPELL_PERIODIC_MISSED,
    SPELL_MISSED,
    ENCOUNTER_START,
    PARTY_KILL,
    UNIT_DIED,
    ENCOUNTER_END;
}
