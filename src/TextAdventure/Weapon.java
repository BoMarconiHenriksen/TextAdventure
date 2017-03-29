package TextAdventure;

/**
 * Klassen implementerer weapons i spillet.
 * @since 2.0
 */
public class Weapon implements Item {

    private int amount;

    public Weapon(int amount) {
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
