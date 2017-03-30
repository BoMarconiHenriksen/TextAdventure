package TextAdventure;

/**
 * Klassen implementerer potions i spillet.
 * @since 2.0
 */
public class Potion implements Item{

    private int amount;

    public Potion() {}
    
    public Potion(int amount) {
        this.amount = amount;
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
