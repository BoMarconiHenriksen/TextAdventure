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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWeight(int weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
