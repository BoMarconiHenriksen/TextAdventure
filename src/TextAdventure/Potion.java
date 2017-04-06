package TextAdventure;

/**
 * Klassen implementerer potions i spillet.
 * @since 2.0
 */
import java.util.Random;
public class Potion extends Item{
    Random r1 = new Random(5);
    Random r2 = new Random(5);
    private int useEffect;

    public Potion(String name,int weight) {
        super(name,weight);
        
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
        name = "A mysterious Potion";
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getUseEffect() {
        int dice1 = r1.nextInt()+1;
        int dice2 = r2.nextInt()+1;
        int diceresult = dice1 + dice2;
        switch(diceresult){
            case 2:
            case 12:
                useEffect = 100;
                break;
            case 3:
            case 11:
                useEffect = -30;
                break;
            case 4:
            case 10:
                useEffect = -10;
                break;
            case 5:
            case 9:
                useEffect = 50;
                break;
            case 6:
            case 7:
            case 8:
                useEffect = 20;
                break;
                }
        return useEffect;
    }

    public void setUseEffect(int useEffect) {
        this.useEffect = useEffect;
    }
    
    @Override
    public String toString() {
        return "Potion{" + "weight=" + weight +'}';
    }
    
}
