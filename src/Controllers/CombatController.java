package Controllers;

import Entities.NPC;
import Entities.Room;
import Entities.Player;
import Boundry.Display;

/**
 *  Klassen der afvikler combat mellem player og npc.
 * @since 3.0
 */

public class CombatController {

    public void combat(NPC npc, Player player, Room playerPrevRoom, Display display) {
        
        boolean combatLoop = true;
        boolean npcTurn = true;
        boolean playerTurn = true;
        boolean fleeSucces = false;
       
        

        while (combatLoop) {
            while (npcTurn) {
                npc.doAttack(player);
                
                display.playerHealthStatus(player);
                npcTurn = false;
                if (player.stats.getHealth() <= 0) {
                    playerTurn = false;
                } else {
                    playerTurn = true;
                }
            }

            while (playerTurn) {
                
                switch(display.combatMenu()){
                    case 1: 
                            player.doAttack(npc);
                            display.npcHealthStatus(npc);
                            playerTurn = false;
                            break;
                    case 2:
                           if(player.inventory.getSpecItemList(3).isEmpty()){
                               display.insufficientAmount(true);
                           }else{
                               display.usePotion();
                               display.statusHealth(player.usePotion(), player);
                               playerTurn = false;
                           }
                           display.playerHealthStatus(player);
                        break;
                    case 3:
                        display.printInventory(player);
                        break;
                    case 4:
                            String choice = display.playerEquipChoice();
                            try{
                                if (choice.equals("weapon")){
                                    player.equipWeapon(display.indexRowChoice());
                                    display.equipItem(player.equipped.getActiveWeapon());
                                } else if (choice.equals("armor")){
                                    player.equipArmor(display.indexRowChoice());
                                    display.equipItem(player.equipped.getActiveArmor());
                                } else {
                                    display.printInvalidInput();
                                }
                            }
                            catch(IndexOutOfBoundsException e){
                                display.emptySlotMessage();
                               
                            }

                        break;
                    case 5:
                           player.setCurrRoom(playerPrevRoom);
                           playerTurn = false;
                           npcTurn = false;
                           fleeSucces = true;
                           display.playerFleeMessage();
                           display.printCurrRoomDescr(playerPrevRoom);
                        break;
                   
                }
                
                
                if (npc.stats.getHealth() <= 0) {
                    display.npcDied(npc);
                    npc.onDeath();
                    npcTurn = false;
                } else if (!(npc.stats.getHealth() <= 0) && !fleeSucces) {
                    npcTurn = true;
                } 
                if (player.stats.getHealth() <= 0) {
                    npcTurn = false;
                }
            }

            if (!npcTurn && !playerTurn) {
                combatLoop = false;
            }
        }

    }
}
