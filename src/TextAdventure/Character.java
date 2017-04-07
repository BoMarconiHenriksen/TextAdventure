package TextAdventure;

/**
 * Abstract klasse samler det som en player og NPC skal have.
 * @since 3.0
 */
public abstract class Character {
    
    String name;
    Stats stats;
    Equipped equipped;
    Inventory inventory;

    /**
     *
     * @param name
     * @param stats
     * @param equipped
     * @param inventory
     */
    
    public Character(){
        
    }
    
    public Character(String name, Stats stats, Equipped equipped, Inventory inventory) {
        this.name = name;
        this.stats = stats;
        this.equipped = equipped;
        this.inventory = inventory;
    }

    public abstract String getName();

    public abstract void setName(String name);

    public abstract Stats getStats();

    public abstract void setStats(Stats stats);

    public abstract Equipped getEquipped();

    public abstract void setEquipped(Equipped equipped);

    public abstract Inventory getInventory();

    public abstract void setInventory(Inventory inventory);

    /**
     *
     * @param character
     */
    public abstract void doAttack(Character character);
    
}
