package Constructors;

/**
 * Klassen laver rum og ligger item og nps'er i rummet
 * @since 3.0
 */
public class DungeonConstructor implements java.io.Serializable{
    
    public ItemConstructor ic;
    public RoomConstructor rc;
    public NPCConstructor npc;
    
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
        
        // Adding items to rooms
        
        rc.startRoom.getInventory().addItem(2, ic.a1);
        rc.startRoom.getInventory().addItem(1, ic.w1);
        rc.startRoom.getInventory().addItem(3, ic.p1);
        rc.startRoom.getInventory().getGoldList().get(0).setAmount(8);
        //-------------------------------------------------------------------
        
        rc.room1.getInventory().getGoldList().get(0).setAmount(15);
        
        
        rc.room2.getInventory().addItem(2, ic.a1);
        
        
        rc.room3.getInventory().addItem(1, ic.w1);
        
        
        rc.room4.getInventory().addItem(3, ic.p1);
        
        
        rc.trapRoom1.getInventory().getGoldList().get(0).setAmount(10);
        
        
        rc.room6.getInventory().addItem(3, ic.p1);
        
       
        rc.room7.getInventory().addItem(1, ic.w2);
        
        
        rc.room8.getInventory().getGoldList().get(0).setAmount(10);
        
        
        rc.room9.getInventory().getGoldList().get(0).setAmount(20);
        rc.room9.getInventory().addItem(3, ic.p1);
        
        
        rc.trapRoom2.getInventory().getGoldList().get(0).setAmount(20);
        rc.trapRoom2.getInventory().addItem(1, ic.w4);
        
        
        rc.room11.getInventory().addItem(2, ic.a3);
        
        
        rc.room12.getInventory().getGoldList().get(0).setAmount(10);
        
        
        rc.room13.getInventory().getGoldList().get(0).setAmount(15);
        
        
        
        
        
        
        
        // Adding NPCs to rooms
        rc.startRoom.setNpc(npc.nmy1);
        
        
        rc.room3.setNpc(npc.nmy2);
        
    }
     
}
