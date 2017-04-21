package Entities;

import Entities.ItemHolder;

/**
 * Abstract klasse samler det som en player og NPC skal have.
 * @since 3.0
 */
public abstract class Character extends ItemHolder {
    
    public String name;
    public Stats stats;
    public Equipped equipped;

    /**
     *
     * @param name
     * @param stats
     * @param equipped
     * @param inventory
     */
    

    public Character(String name, Stats stats, Equipped equipped, Inventory inventory) {
        super(inventory);
        this.name = name;
        this.stats = stats;
        this.equipped = equipped;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Stats getStats();

    public abstract void setStats(Stats stats);

    public abstract Equipped getEquipped();

    public abstract void setEquipped(Equipped equipped);

    /**
     *
     * @param character
     */
    public abstract void doAttack(Character character);
    
}
