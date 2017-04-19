package TextAdventure;

/**
 *  Klassen laver NPC'erne. 
 *  @since 3.0
 */
public class NPCConstructor implements java.io.Serializable{
 
    NPC nmy1;
    NPC nmy2;
    NPC nmy3;
    NPC nmy4;
    NPC nmy5;
    
    /**
     *
     */
    public void createNPCS() {
        nmy1 = new NPC("Spooky Scary Skeleton",new Stats(30,10,3),new Equipped(),new Inventory());
        nmy2 = new NPC("Fat Goblin",new Stats(40,4,5),new Equipped(),new Inventory());
        nmy3 = new NPC("Giant Snek",new Stats(60,8,10),new Equipped(),new Inventory());
        nmy4 = new NPC("Mysterious Gentleman",new Stats(80,15,5),new Equipped(),new Inventory());
        nmy5 = new NPC("The Guardian",new Stats(100,15,15),new Equipped(),new Inventory());
    }
    
}
