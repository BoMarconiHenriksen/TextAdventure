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
    
    Weapon w1;
    Armor a1;
    Potion p1;
    
    public void createItems() {
        w1 = new Weapon("Dagger",100,10);
        a1 = new Armor("Leather vest from the 90's",50,15);
        a1 = new Armor("Chestpiece of invisible torso", 10, 2);
        a1 = new Armor("Cursed bone kilt from a slut", 100, 20);
        a1 = new Armor("Sandal of twisted hell", 40,40);
        a1 = new Armor("Unded wrap of darkness", 60, 10);
        p1 = new Potion("Redbull",2,2);
        p1 = new Potion("Brew of better java writing",10, 50);
        p1 = new Potion("Potion of burning hot chocolate",-10,4);
        p1 = new Potion("A viel of whiskey tornado", 40, 5);
        
    
    }
    
}
