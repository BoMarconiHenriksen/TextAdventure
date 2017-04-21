package Entities;

/**
 * Class hold stats for Player and NPC
 *  @since 3.0
 */
public class Stats{
    
    private int health;
    private int attack;
    private int defense;

    public Stats(int health, int attack, int defense) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    
    /**
     * calculate total attack damage for character
     * @param character
     * @return 
     */
    public int getTotalAttack(Character character) {
        if (character.equipped.getActiveWeapon()!=null) {
            return this.attack + character.equipped.getActiveWeapon().getAttack();
        } else {
            return this.attack;
        }
    }
    
    /**
     * calculate total defense for character
     * @param character
     * @return 
     */
    public int getTotalDefense(Character character) {
        if (character.equipped.getActiveArmor()!=null) {
            return this.defense + character.equipped.getActiveArmor().getDefense();
        } else {
            return this.defense;
        }
    }
    
}
