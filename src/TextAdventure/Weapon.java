package TextAdventure;

/**
 * Klassen implementerer weapons i spillet.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setWeight(int weight) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public String toString() {
        return "Weapon{" + "attack=" + attack + "Name=" + name + "weight=" + weight +'}';
    }
    
    

}