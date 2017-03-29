package TextAdventure;

/**
 * Interface som implementerer klasserne Armor, Gold, potion og weapon.
 * @since 2.0
 */
public interface Item {

    @Override
    public String toString();
    
    public void pickUp();
    public String getType();
    

    public void setAmount(int amount);
    public int getAmount();
    
}
