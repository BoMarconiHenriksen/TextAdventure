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
    
    public Armor () {}
    
    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
    
}
