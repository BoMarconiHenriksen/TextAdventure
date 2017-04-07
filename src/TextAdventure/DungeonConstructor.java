package TextAdventure;

/**
 * Klassen laver rum og ligger item og nps'er i rummet
 * @since 3.0
 */
public class DungeonConstructor {
    
    ItemConstructor ic;
    RoomConstructor rc;
    NPCConstructor npc;
    
    /**
     *
     */
    public void createDungeon() {
        ic = new ItemConstructor();
        rc = new RoomConstructor();
        npc = new NPCConstructor();
        
        rc.createRooms();
        ic.createItems();
        npc.createNPCS();
        
        rc.startRoom.getInventory().addSpecItem(2, ic.a1);
        rc.startRoom.getInventory().addSpecItem(1, ic.w1);
        rc.startRoom.getInventory().addSpecItem(3, ic.p4);
        
        rc.startRoom.getInventory().getGoldList().get(0).setAmount(8);
        
    }
     
}
