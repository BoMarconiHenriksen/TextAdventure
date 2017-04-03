package TextAdventure;

/**
 *  Klassen implementerer guld i spillet.
 * @since 2.0
 */
public class Gold implements Item{
    
    private int amount;

    public Gold(int amount) {
        this.amount = amount;
    }
    
    public Gold () {}

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return this.amount;
    }
    
}
