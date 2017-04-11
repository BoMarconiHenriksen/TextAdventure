package TextAdventure;

/**
 * Interface som implementerer klasserne Armor, Gold, potion og weapon.
 * @since 2.0
 */
public abstract class Item implements java.io.Serializable {

    int weight;
    String name;

    /**
     *
     * @param name
     * @param weight
     */
    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    public abstract int getWeight();

    public abstract void setWeight(int weight);
    
    public abstract String getName();

    public abstract void setName(String name);
    
    
    
}
