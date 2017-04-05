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
public class ItemConstructor {
    
    Weapon w1,w2,w3,w4,w5;
    Armor a1,a2,a3,a4,a5;
    Potion p1,p2,p3,p4,p5;
    // order is : Name,Attack(or defense or health),weight.
    public void createItems() {
        w1 = new Weapon("Shank made from a toothbrush",4,10);
        w2 = new Weapon("Mace of Rekt",6,30);
        w3 = new Weapon("Long-ass sword of Stibby-Stabby",8,20);
        w4 = new Weapon("Fist of fury-fisting",5,5);
        w5 = new Weapon("The Legendary Sword of Fable and Myth",12,50);
        a1 = new Armor("Leather vest from the 90's",2,15);
        a2 = new Armor("Chestpiece of invisible torso", 4, 30);
        a3 = new Armor("Cursed bone kilt from a slut", 5, 10);
        a4 = new Armor("Sandal of twisted hell", 6,5);
        a5 = new Armor("Undead wrap of darkness", 8, 25);
        p1 = new Potion("Small health potion",20,5);
        p2 = new Potion("Large health potion",50,5);
        p3 = new Potion("Small death potion",-10,5);
        p4 = new Potion("Large death potion",-30,5);
        p5 = new Potion("Divine potion",100,5);
        
        
    
    }
    
}
