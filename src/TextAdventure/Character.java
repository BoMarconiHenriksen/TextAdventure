/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author Mellem
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
