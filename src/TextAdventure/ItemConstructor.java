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
    Potion p1,p2,p3,p4;
    
    public void createItems() {
        w1 = new Weapon("Shank made from a toothbrush",100,10);
        w2 = new Weapon("Mace of Rekt",150,30);
        w3 = new Weapon("Long-ass sword of Stibby-Stabby",130,20);
        w4 = new Weapon("Fist of fury-fisting",60,5);
        w5 = new Weapon("The Legendary Sword of Fable and Myth",200,50);
        a1 = new Armor("Leather vest from the 90's",50,15);
        a2 = new Armor("Chestpiece of invisible torso", 10, 2);
        a3 = new Armor("Cursed bone kilt from a slut", 100, 20);
        a4 = new Armor("Sandal of twisted hell", 40,40);
        a5 = new Armor("Undead wrap of darkness", 60, 10);
        p1 = new Potion("Redbull",2,2);
        p2 = new Potion("Brew of better java writing",10, 50);
        p3 = new Potion("Potion of burning hot chocolate",-10,4);
        p4 = new Potion("A vial of whiskey tornado", 40, 5);
        
        
    
    }
    
}
