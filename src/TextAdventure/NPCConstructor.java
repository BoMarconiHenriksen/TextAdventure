package TextAdventure;

/**
 *  Klassen laver NPC'erne. 
 *  @since 3.0
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
