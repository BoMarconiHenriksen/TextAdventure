package Constructors;

import Entities.NPC;
import Entities.Room;
import Entities.Player;
import TextAdventure.Display;

/**
 *  Klassen der afvikler combat mellem player og npc.
 * @since 3.0
 */

public class Combat {

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
                           if(player.inventory.getPotionList().isEmpty()){
                               display.insufficientAmount();
                           }else{
                               display.usePotion();
                               int potionEffect = player.inventory.getPotionList().get(0).getRandomUseEffect();
                               if(potionEffect > 0){
                                   player.stats.setHealth(player.stats.getHealth()+potionEffect);
                                   display.gainLife(potionEffect);
                                   player.inventory.removeItem(3, 0);
                                   playerTurn = false;
                               }else{
                                   player.stats.setHealth(player.stats.getHealth()+potionEffect);
                                   display.takeDamage(potionEffect, player);
                                   player.inventory.removeItem(3, 0);
                                   playerTurn = false;
                               }
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
                                System.out.println("EXCEPTION: Index out of bounds");
                                System.out.println("/\\ TILFØJ METODE TIL DISPLAY /\\");
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
            }

            if (!npcTurn && !playerTurn) {
                combatLoop = false;
            }
        }

    }
}
