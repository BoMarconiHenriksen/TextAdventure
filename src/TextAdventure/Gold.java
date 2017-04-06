package TextAdventure;

/**
 *  Klassen implementerer guld i spillet.
 * @since 2.0
 */
public class Gold extends Item{
    
    private int amount;
    
    public Gold(String name,int amount, int weight) {
        super(name,weight);
        this.amount = amount;
        
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
    
}