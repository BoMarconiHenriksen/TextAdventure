package Entities;

/**
 *  Armor klassen implementer armor i spillet.
 *  @since 2.0
 */
public class Armor extends Item {

    private int defense;

    /**
     *
     * @param name
     * @param defense
     * @param weight
     */
    public Armor(String name,int defense, int weight) {
        super(name,weight);
        this.defense = defense;
        
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int amount) {
        this.defense = amount;
    }
    
    @Override
    public String toString() {
        return name + "Defense=" + defense + "Weight=" + weight;
    }
    
}
