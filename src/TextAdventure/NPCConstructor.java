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
        nmy1 = new NPC("Spooky Scary Skeleton",new Stats(30,5,5),new Equipped(),new Inventory());
        nmy2 = new NPC("Crazy maniac",new Stats(40,10,5),new Equipped(),new Inventory());
        nmy3 = new NPC("Giant ghost Snek",new Stats(60,5,10),new Equipped(),new Inventory());
        nmy4 = new NPC("Mysterious Gentleman",new Stats(80,10,5),new Equipped(),new Inventory());
        nmy5 = new NPC("The Guardian",new Stats(100,10,15),new Equipped(),new Inventory());
    }
    
}
