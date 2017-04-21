package Entities;

/**
 *
 * @since 3.0
 */
public abstract class ItemHolder{
    
    public Inventory inventory;

    public ItemHolder(Inventory inventory) {
        this.inventory = inventory;
    }

    public abstract Inventory getInventory();

    public abstract void setInventory(Inventory inventory);
    
}
