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
                
                switch(display.combatMenu()){
                    case 1: 
                            player.doAttack(npc);
                            display.npcHealthStatus(npc);
                            break;
                    case 2:
                           if(player.inventory.getItem(3, 1)== null){
                               display.insufficientAmount();
                               
                           }else{
                               display.usePotion();
                               int potionEffect = potion.getRandomUseEffect();
                               
                               if(potionEffect => 0){
                                   player.stats.setHealth(player.stats.getHealth()+potionEffect);
                                   display.gainLife(potionEffect);
                                   
                               }else{
                                   player.stats.setHealth(player.stats.getHealth()+potionEffect);
                                   display.takeDamage(potionEffect, player);
                                   
                               }
                           }
                           display.playerHealthStatus(player);
                        break;
                        
                    case 3:
                           // player.run
                           // display.runattempt
                           // if succes, combatloop = false
                        break;
                   
                }
                
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
