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
    
    public void createDungeon() {
        ic = new ItemConstructor();
        rc = new RoomConstructor();
        
        rc.startRoom.addItemRoom(2, ic.a1);
        
    }
     
}
