package Entities;

/**
 * Class extends Item and implements weapon objects
 * @since 2.0
 */
public class Weapon extends Item {

    private int attack;

    public Weapon(String name,int attack, int weight) {
        super(name,weight);
        this.attack = attack;
        
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

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return name + " Attack:" + attack + " Weight: " + weight;
    }
    
    

}