package Constructors;

/**
 * Klassen laver rum og ligger item og nps'er i rummet
 * @since 3.0
 */
public class DungeonConstructor{
    
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
      
        rc.room1.setNpc(npc.nmy1);
        rc.room4.setNpc(npc.nmy1);
        rc.room9.setNpc(npc.nmy2);
        rc.room12.setNpc(npc.nmy3);
        rc.room13.setNpc(npc.nmy4);
        
        // Adding items to NPCs
        
        npc.nmy1.equipped.setActiveArmor(ic.a1);
        npc.nmy1.inventory.getGoldList().get(0).setAmount(5);
        
        npc.nmy2.equipped.setActiveWeapon(ic.w1);
        npc.nmy2.inventory.addItem(3, ic.p1);
        
        npc.nmy3.equipped.setActiveWeapon(ic.w2);
        npc.nmy3.equipped.setActiveArmor(ic.a2);
        npc.nmy3.inventory.getGoldList().get(0).setAmount(10);
        
        npc.nmy4.equipped.setActiveArmor(ic.a4);
        npc.nmy4.equipped.setActiveWeapon(ic.w3);
        npc.nmy4.inventory.addItem(2, ic.a5);
        npc.nmy4.inventory.addItem(1, ic.w5);
        
        
        
    }
     
}
