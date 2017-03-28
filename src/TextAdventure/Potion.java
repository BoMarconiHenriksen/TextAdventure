package TextAdventure;

/**
 * Klassen implementerer potions i spillet.
 * @since 2.0
 */
public class Potion implements Item{

    private String type;
    private int amount;

    public Potion() {}
    
    public Potion(int amount) {
        this.amount = amount;
    }
    
    @Override
    public void pickUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
    
}
