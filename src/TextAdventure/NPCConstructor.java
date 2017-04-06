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
public class NPCConstructor {
    
    NPC nmy1;
    
    /**
     *
     */
    public void createNPCS() {
        nmy1 = new NPC("Skeletor",new Stats(100,10,11),new Equipped(),new Inventory());
    }
    
}
