package TextAdventure;

/**
 *  Armor klassen implementer armor i spillet.
 *  @since 2.0
 */
public class Armor implements Item{

    private int amount;

    public Armor(int amount) {
        this.amount = amount;
    }
    
    
    @Override
    public void pickUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
