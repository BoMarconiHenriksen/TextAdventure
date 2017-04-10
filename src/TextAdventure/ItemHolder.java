package TextAdventure;

/**
 *
 * @since 3.0
 */
public abstract class ItemHolder {
    
    Inventory inventory;

    public ItemHolder(Inventory inventory) {
        this.inventory = inventory;
    }

    public abstract Inventory getInventory();

    public abstract void setInventory(Inventory inventory);
    
}
