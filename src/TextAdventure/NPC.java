package TextAdventure;

/**
 * Klassen holder oplysninger om NPC.
 *
 * @since 3.0
 */
public class NPC extends Character {

    /**
     *
     * @param name
     * @param stats
     * @param equipped
     * @param inventory
     */
    
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
     *
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
     *
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
    }

}
