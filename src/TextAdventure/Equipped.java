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
public class Equipped {
    
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
