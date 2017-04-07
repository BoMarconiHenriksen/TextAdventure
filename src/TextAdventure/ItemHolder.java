/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author ML
 */
public abstract class ItemHolder {
    
    Inventory inventory;

    public ItemHolder(Inventory inventory) {
        this.inventory = inventory;
    }

    public abstract Inventory getInventory();

    public abstract void setInventory(Inventory inventory);
    
    
    
}
