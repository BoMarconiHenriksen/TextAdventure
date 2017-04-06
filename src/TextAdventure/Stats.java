/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author Mellem
 */
public class Stats {
    
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
    
    public int getTotalAttack(Character character) {
        if (character.equipped.getActiveWeapon()!=null) {
            return this.attack + character.equipped.getActiveWeapon().getAttack();
        } else {
            return this.attack;
        }
    }
    
    public int getTotalDefense(Character character) {
        if (character.equipped.getActiveArmor()!=null) {
            return this.defense + character.equipped.getActiveArmor().getDefense();
        } else {
            return this.defense;
        }
    }
    
}
