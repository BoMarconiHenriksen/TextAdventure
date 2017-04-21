package Entities;


import java.util.Random;

/**
 * Klassen implementerer potions i spillet.
 * @since 2.0
 */
public class Potion extends Item{
    Random r1 = new Random();
    Random r2 = new Random();
    private int useEffect;

    /**
     *
     * @param name
     * @param useEffect
     * @param weight
     */
    public Potion(String name, int weight) {
        super(name,weight);
        this.useEffect = this.getRandomUseEffect();
        
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
        return "Mystery Potion";
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getUseEffect() {
        return this.useEffect;
    }

    public void setUseEffect() {
        this.useEffect = this.getRandomUseEffect();
    }
    
    public final int getRandomUseEffect(){
        int dice1 = r1.nextInt(5)+1;
        int dice2 = r2.nextInt(5)+1;
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
    
    @Override
    public String toString() {
        return name + " weight:" + weight;
    }
    
}
