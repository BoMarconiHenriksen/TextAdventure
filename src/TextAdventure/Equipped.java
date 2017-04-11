package TextAdventure;

/**
 * Klassen holder hvilket våben og armor som player og NPC har equipped.
 * @since 3.0
 */
public class Equipped implements java.io.Serializable{
    
    private Weapon activeWeapon = null;
    private Armor activeArmor = null;

    /**
     *
     * @param activeWeapon
     * @param activeArmor
     */
    public Equipped(Weapon activeWeapon, Armor activeArmor) {
        this.activeWeapon = activeWeapon;
        this.activeArmor = activeArmor;
    }

    /**
     *
     */
    public Equipped() {
    }

    public Weapon getActiveWeapon() {
        return activeWeapon;
    }

    public void setActiveWeapon(Weapon activeWeapon) {
        this.activeWeapon = activeWeapon;
    }

    public Armor getActiveArmor() {
        return activeArmor;
    }

    public void setActiveArmor(Armor activeArmor) {
        this.activeArmor = activeArmor;
    }
    
    
    
}
