package Entities;

/**
 * Klassen holder oplysninger om NPC.
 *
 * @since 3.0
 */
public class NPC extends Character {
    
    public NPC(String name, Stats stats, Equipped equipped, Inventory inventory) {
        super(name, stats, equipped, inventory);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Stats getStats() {
        return stats;
    }

    @Override
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public Equipped getEquipped() {
        return equipped;
    }

    @Override
    public void setEquipped(Equipped equipped) {
        this.equipped = equipped;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     *[on death] remove weapon and armor form Equipped and move to Inventory.
     */
    public void onDeath() {
        if (!(this.equipped.getActiveWeapon() == null)) {
            Weapon temp = this.equipped.getActiveWeapon();
            this.equipped.setActiveWeapon(null);
            this.inventory.addItem(1, temp);
        }
        if (!(this.equipped.getActiveArmor() == null)) {
            Armor temp = this.equipped.getActiveArmor();
            this.equipped.setActiveArmor(null);
            this.inventory.addItem(2, temp);
        }
    }

    /**
     *calculate attack damage: if equipped weapon dmg > total armor of reciever = deal base dmg + (weapon attack damage - total armor) 
     * @param character
     */
    @Override
    public void doAttack(Character character) {
        int dmg = 0;

        if (this.equipped.getActiveWeapon() == null || this.equipped.getActiveWeapon().getAttack() <= character.stats.getTotalDefense(character)) {
            dmg = this.stats.getAttack();
        } else {
            dmg = this.stats.getTotalAttack(this) - character.stats.getTotalDefense(character);
        }
        character.stats.setHealth(character.stats.getHealth() - dmg);
        System.out.println(character.getName() + " Takes " + dmg + " damage!");
    }

}
