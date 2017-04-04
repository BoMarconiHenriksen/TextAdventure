package TextAdventure;

/**
 *  Armor klassen implementer armor i spillet.
 *  @since 2.0
 */
public class Armor extends Item{

    private int defense;

    public Armor(String name,int defense, int weight) {
        super(name,weight);
        this.defense = defense;
        
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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int amount) {
        this.defense = amount;
    }
    
    @Override
    public String toString() {
        return "Armor{" + "defense=" + defense + "Name=" + name + "weight=" + weight +'}';
    }
    
}
