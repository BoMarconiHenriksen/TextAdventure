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
public class DungeonConstructor {
    
    ItemConstructor ic;
    RoomConstructor rc;
    NPCConstructor npc;
    
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
