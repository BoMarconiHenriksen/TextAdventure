package TextAdventure;

/**
 * Interface som implementerer klasserne Armor, Gold, potion og weapon.
 * @since 2.0
 */
public abstract class Item {

    int weight;
    String name;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    public abstract int getWeight();

    public abstract void setWeight(int weight);
    
    public abstract String getName();

    public abstract void setName(String name);
    
    
    
}
