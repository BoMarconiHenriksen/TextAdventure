package Constructors;

import Entities.Armor;
import Entities.Potion;
import Entities.Weapon;

/**
 *  Klassen laver items. 
 *  @since 3.0
 */
public class ItemConstructor implements java.io.Serializable{
    
    public Weapon w1,w2,w3,w4,w5;
    public Armor a1,a2,a3,a4,a5;
    public Potion p1;
    // order is : Name,Attack(or defense or health),weight.

    /**
     *
     */
    public void createItems() {
        w1 = new Weapon("Shank made from a toothbrush",5,10);
        w2 = new Weapon("Baseball bat",8,30);
        w3 = new Weapon("Weeabo katana of the dark basement",10,20);
        w4 = new Weapon("Fist of fury-fisting",10,5);
        w5 = new Weapon("The Ban Hammer",12,50);
        a1 = new Armor("Leather vest from the 90's",2,15);
        a2 = new Armor("Chestpiece of invisible torso", 4, 30);
        a3 = new Armor("Cursed bone kilt from a slut", 6, 10);
        a4 = new Armor("Sandal of twisted hell", 8,5);
        a5 = new Armor("Undead wrap of darkness", 10, 25);
        p1 = new Potion("A mysterious Potion",5);
  
        
        
    
    }
    
}
