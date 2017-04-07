/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author awha8
 */
public class Combat {


    public void combat(NPC npc, Player player) {
        
        boolean combatLoop = true;
        boolean npcTurn = true;
        boolean playerTurn = true;

        while (combatLoop) {
            while (npcTurn) {
                npc.doAttack(player);
                System.out.println("PLAYER HEALTH: " + player.stats.getHealth());
                npcTurn = false;
                if (player.stats.getHealth() <= 0) {
                    System.out.println("PLAYER DIED");
                    playerTurn = false;
                } else {
                    playerTurn = true;
                }
            }

            while (playerTurn) {
                player.doAttack(npc);
                System.out.println("NPC HEALTH: " + npc.stats.getHealth());
                playerTurn = false;
                if (npc.stats.getHealth() <= 0) {
                    System.out.println("NPC DIED");
                    npcTurn = false;
                } else {
                    npcTurn = true;
                }
            }

            if (!npcTurn && !playerTurn) {
                combatLoop = false;
            }
        }

    }
}
