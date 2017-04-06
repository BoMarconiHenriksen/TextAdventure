package TextAdventure;

/**
 * Klassen implementerer potions i spillet.
 * @since 2.0
 */
public class Potion extends Item{

    private int useEffect;

    public Potion(String name,int useEffect, int weight) {
        super(name,weight);
        this.useEffect = useEffect;
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

    public int getUseEffect() {
        return useEffect;
    }

    public void setUseEffect(int useEffect) {
        this.useEffect = useEffect;
    }
    
    @Override
    public String toString() {
        return "Potion{" + "Name=" + name + "weight=" + weight +'}';
    }
    
}
