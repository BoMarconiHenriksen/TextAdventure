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
        a1 = new Armor("Vest",50,15);
        p1 = new Potion("Redbull",2,2);
    
    }
    
}
