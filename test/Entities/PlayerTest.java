/*
JUNIT TESTING 
 */
package Entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player player;
    Room room;
    NPC npc;
    Weapon wTest1;
    Weapon wTest2;
    Armor aTest1;
    Armor aTest2;
    
    
    public PlayerTest() {
    }
    
    @Before
    public void setUp() {
        
        wTest1 = new Weapon("TestWeapon1",20,5);
        wTest2 = new Weapon("TestWeapon2",10,5);
        aTest1 = new Armor("TestArmor1",20,5);
        aTest2 = new Armor("TestArmor2",20,5);
        
        player = new Player("TestPlayer",new Stats(100,10,10),new Equipped(),new Inventory(100));
        player.getInventory().addItem(1, wTest1);
        player.getInventory().addItem(2, aTest2);
        
        room = new Room(new Inventory(100),"test",false);
        room.getInventory().addItem(1, wTest2);
        
        npc = new NPC("Test Monster",new Stats(50,5,5),new Equipped(),new Inventory(100));
        npc.inventory.addItem(2, aTest1);
        
    }

    @Test
    public void testTakeItem_3args() {
        System.out.println("takeItem");
        int indexCol = 1;
        int indexRow = 0;
        ItemHolder takeFrom = room;
        Player instance = player;
        Weapon expResult = wTest2;
        instance.takeItem(indexCol, indexRow, takeFrom);
        Weapon result = (Weapon)player.inventory.getItem(1, 1);
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testTakeItem_int_ItemHolder() {
        System.out.println("takeItem'Gold'");
        int goldAmount = 50;
        ItemHolder takeFrom = room;
        Player instance = player;
        instance.takeItem(goldAmount, room);
        int expResult = 150;
        int result = instance.inventory.getGoldList().get(0).getAmount();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testPlaceItem_3args() {
        System.out.println("placeItem");
        int indexCol = 1;
        int indexRow = 0;
        ItemHolder placeTo = room;
        Player instance = player;
        Weapon expResult = wTest1;
        instance.placeItem(indexCol, indexRow, placeTo);
        Weapon result = (Weapon)room.inventory.getItem(1, 1);
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testPlaceItem_int_ItemHolder() {
        System.out.println("placeItem'gold'");
        int goldAmount = 50;
        ItemHolder takeFrom = room;
        Player instance = player;
        instance.placeItem(goldAmount, room);
        int expResult = 150;
        int result = room.inventory.getGoldList().get(0).getAmount();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testEquipWeapon() {
        System.out.println("equipWeapon");
        int indexRow = 0;
        Player instance = player;
        instance.equipWeapon(indexRow);
        Weapon expResult = wTest1;
        Weapon result = instance.equipped.getActiveWeapon();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testEquipArmor() {
        System.out.println("equipArmor");
        int indexRow = 0;
        Player instance = player;
        instance.equipArmor(indexRow);
        Armor expResult = aTest2;
        Armor result = instance.equipped.getActiveArmor();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }

    @Test
    public void testDoAttack() {
        System.out.println("doAttack'NMY no armor'");
        Character character = npc;
        Player instance = player;
        instance.equipWeapon(0);
        instance.doAttack(character);
        int expResult = 25;
        int result = npc.getStats().getHealth();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
        
        System.out.println("doAttack'NMY armor");
        npc.equipped.setActiveArmor(aTest1);
        instance.doAttack(character);
        expResult = 15;
        result = npc.getStats().getHealth();
        assertEquals(expResult,result);
        //fail("The test case is a prototype.");
    }
    
}
