package TextAdventure;

/**
 *  Klassen der afvikler combat mellem player og npc.
 * @since 3.0
 */
public class Combat {


    public void combat(NPC npc, Player player, Display display) {
        
        boolean combatLoop = true;
        boolean npcTurn = true;
        boolean playerTurn = true;

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
                player.doAttack(npc);
                display.npcHealthStatus(npc);
                playerTurn = false;
                if (npc.stats.getHealth() <= 0) {
                    display.npcDied();
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
