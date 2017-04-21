package Constructors;

import Entities.Equipped;
import Entities.Inventory;
import Entities.NPC;
import Entities.Stats;

/**
 *  Klassen laver NPC'erne. 
 *  @since 3.0
 */
public class NPCConstructor{
 
    public NPC nmy1, nmy2, nmy3, nmy4;

    /**
     *
     */
    public void createNPCS() {
        nmy1 = new NPC("Spooky Scary Skeleton",new Stats(30,5,5),new Equipped(),new Inventory());
        nmy2 = new NPC("Crazy maniac",new Stats(40,8,5),new Equipped(),new Inventory());
        nmy3 = new NPC("Mysterious Gentleman",new Stats(80,10,5),new Equipped(),new Inventory());
        nmy4 = new NPC("The Guardian",new Stats(100,15,15),new Equipped(),new Inventory());
    }
    
}
