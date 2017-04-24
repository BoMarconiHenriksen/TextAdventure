package Entities;

/**
 * Abstract class extended by Armor, Gold, Potion and Weapon.
 * @since 2.0
 */
public abstract class Item {

    public int weight;
    public String name;

    public Item(String name, int weight){
        this.name = name;
        this.weight = weight;
    }
    
    public abstract int getWeight();

    public abstract void setWeight(int weight);
    
    public abstract String getName();

    public abstract void setName(String name);
    
    
    
}
