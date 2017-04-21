
package Controllers;

import Entities.Inventory;
import Entities.Equipped;
import Entities.Stats;
import Entities.ItemHolder;
import Entities.Room;
import Entities.Player;
import Boundry.Display;


/**
 *  Klassen der styrer programmet.
 *  @since 1.0
 */
public class MainController {
    
    Display display;
    Player player;
    HighscoreController hs;
    DungeonConstructor dc;
    CombatController cbt;
    
    boolean continue_ = true;
    

    public void test() {
        display = new Display();
        hs = new HighscoreController(display);
        dc = new DungeonConstructor();
        cbt = new CombatController();
        
        dc.createDungeon();
        
        player = new Player("Henrik",new Stats(100,10,10),new Equipped(),new Inventory()); 
        player.setCurrRoom(dc.rc.startRoom); 
        player.inventory.addItem(1, dc.ic.w5);
        player.inventory.addItem(1, dc.ic.w2);

        player.inventory.addItem(3, dc.ic.p1);
        dc.npc.nmy2.equipped.setActiveWeapon(dc.ic.w3);
        
        
        
        while(continue_) {
            String commandStr = display.playerInput();
            String[] command = commandStr.split(" ");
            command[0] = commandAliases(command[0]);
            playerControl(command);
        }
        display.printExitMessage();
        System.exit(0);

    }
    
    
    /**
    *  This method starts the game.
    *  @since 1.0
    */
    public void start() {
        display = new Display();
        hs = new HighscoreController(display);
        dc = new DungeonConstructor();
        cbt = new CombatController();
        
        dc.createDungeon();
        
        player = new Player(display.nameInput(),new Stats(100,5,0),new Equipped(),new Inventory()); 
        player.setCurrRoom(dc.rc.startRoom); 
        
        display.welcome();
        System.out.println(player.getCurrRoom().getDescription());
        
        while(continue_) {
            String commandStr = display.playerInput();
            String[] command = commandStr.split(" ");
            command[0] = commandAliases(command[0]);
            playerControl(command);
        }
        
        display.printFinalStats(player);
        hs.setHighscore(player);
        hs.sortHighscore();
        hs.getHighscore();
        display.printExitMessage();
        System.exit(0);
    }
    
    

    /**
    *  Switch case som tager imod en kommando fra player.
     * @param command
    *  @since 1.0
    */ 
    public void playerControl(String[] command) {

        switch(command[0]) {
            case "north": 
                commandDirection(command[0]);
                break;
            case "south":
                commandDirection(command[0]);
                break;
            case "east":
                commandDirection(command[0]);
                break;
            case "west":
                commandDirection(command[0]);
                break;
            case "look":
                commandLook();
                break;
            case "take":
                commandTake(command);
                break;
            case "place":
                commandPlace(command);
                break;
            case "equip":
                commandEquip(command);
                break;
            case "potion":
                commandPotion();
                break;
            case "inventory":
                display.printInventory(player);
                break;
            case "help":    
                display.helpMenu();
                break;
            case "exit":
                String choice = display.exitChoice();
                if (choice.equals("yes") || choice.equals("y")) {
                    continue_ = false;
                }
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    /**
     * Alias'er til input fra player i command
     * @param input
     * @return 
     */
    public String commandAliases(String input) {
        switch(input){
            case "q":
                return "equip";
            case "n":
                return "north";
            case "s":
                return "south";
            case "e":
                return "east";
            case "w":
                return "west";
            case "l":
                return "look";
            case "t":
                return "take";
            case "p":
                return "place";
            case "i":
                return "inventory";
            case "h":
                return "help";
            case "x":
                return "exit";
            case "d":
                return "potion";
            default:
                return input;
        }
    }
    
    
    public void commandDirection(String exit) {
        if (checkExit(exit) && player.getCurrRoom().getSpecExit(exit).unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            Room prevRoom = player.getCurrRoom();
            player.setCurrRoom(player.getCurrRoom().getSpecExit(exit).getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsNpc(player,prevRoom);
            ifRoomContainsTrap(player);
            ifPlayerHealthZero(player);
            ifWinCondition(player);
        } else {
            if (!checkExit(exit)) {
                display.printNoExit();
            } else {
                display.printNeedGoldExit(player);
            }
        }
    }
    
    public void commandTake(String[] command){
        if (command.length > 1){
            //itemHolderChoice();
            itemChoice(command[1],true);
        } else {
            display.noSpecifiedItem();
        }
    }
    
    public void commandPlace(String [] command) {
        if (command.length > 1){
            //itemHolderChoice();
            itemChoice(command[1],false);
        } else {
            display.noSpecifiedItem();
        }
    }
    
    public void commandEquip(String[] command){
        if (command.length > 1){
            try{
                switch (command[1]) {
                    case "weapon":
                    case "w":
                        player.equipWeapon(display.indexRowChoice());
                        display.equipItem(player.equipped.getActiveWeapon());
                        break;
                    case "armor":
                    case "a":
                        player.equipArmor(display.indexRowChoice());
                        display.equipItem(player.equipped.getActiveArmor());
                        break;
                    default:
                        display.printInvalidInput();
                        break;
                }
            }
            catch(IndexOutOfBoundsException e){
                display.emptySlotMessage();
            }
        } else {
            display.noSpecifiedItem();
        }
    }

    public void commandLook(){
        ItemHolder ih = display.itemHolderChoice(player);
        display.printActionLook(ih);
        if (ih.equals(player.getCurrRoom())) {
            display.lookDeadNpc(player.getCurrRoom());
        } 
    }
    
    public void commandPotion(){
    if(player.inventory.getPotionList().isEmpty()){
            display.insufficientAmount(true);
        }else{
            display.usePotion();
            int potionEffect = player.inventory.getPotionList().get(0).getRandomUseEffect();
            if(potionEffect > 0){
                player.stats.setHealth(player.stats.getHealth()+potionEffect);
                display.gainLife(potionEffect);
                player.inventory.removeItem(3, 0);
            }else{
                player.stats.setHealth(player.stats.getHealth()+potionEffect);
                display.takeDamage(potionEffect, player);
                player.inventory.removeItem(3, 0);
            }
        }
        display.playerHealthStatus(player);
    }
    
    public void itemChoice(String itemChoice, boolean take) {
        
        ItemHolder ih;
        
        switch(itemChoice) {
            case "gold":
            case "g":
                ih = display.itemHolderChoice(player);
                if (ih == null) {
                    display.printInvalidInput();
                    break;
                } else {
                    itemChoiceAction(ih,display.goldAmountChoice(),take);
                }
                break;
            case "weapon":
            case "w":
                ih = display.itemHolderChoice(player);
                if (ih == null) {
                    display.printInvalidInput();
                    break;
                } else {
                    itemChoiceAction(1,ih,display.indexRowChoice(), take);
                }
                break;
            case "armor":
            case "a":
                ih = display.itemHolderChoice(player);
                if (ih == null) {
                    display.printInvalidInput();
                    break;
                } else {
                    itemChoiceAction(2,ih,display.indexRowChoice(), take);
                }
                break;
            case "potion":
            case "p":    
                ih = display.itemHolderChoice(player);
                if (ih == null) {
                    display.printInvalidInput();
                    break;
                } else {
                    itemChoiceAction(3,ih,display.indexRowChoice(), take);
                }
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    
    public void itemChoiceAction(int indexCol, ItemHolder itemHolder, int indexRow, boolean take) {
        if (take){
            try {
                display.takeItem(itemHolder.inventory.getItem(indexCol, indexRow));
                player.takeItem(indexCol, indexRow,itemHolder);
            } catch (IndexOutOfBoundsException e) {
                display.emptySlotMessage();
            }
        } else {
            try {
                display.placeItem(player.inventory.getItem(indexCol, indexRow));
                player.placeItem(indexCol, indexRow, player.getCurrRoom());
            } catch (IndexOutOfBoundsException e) {
                display.emptySlotMessage();
            }
        }
    }
    
    public void itemChoiceAction(ItemHolder itemHolder,int goldAmount,  boolean take) {
        if (take) {
            if (enoughGold(goldAmount,itemHolder)) {
                display.takeGold(goldAmount);
                player.takeItem(goldAmount,itemHolder);
            } else {
                display.insufficientAmount(false);
            }
        } else {
            if (enoughGold(goldAmount,player)) {
                display.placeGold(goldAmount);
                player.placeItem(goldAmount,player.getCurrRoom());
            } else {
                display.insufficientAmount(true);
            }
        }
    }
    
    public boolean enoughGold(int amount, ItemHolder itemHolder){
        return itemHolder.getInventory().getGoldList().get(0).getAmount() >= amount;
    }
    
    /**
     * Checker om det pågældende rum har en exit for den indtastede retning
     * @param exit
     * @return 
     */
    public boolean checkExit (String exit) {
        return player.getCurrRoom().getSpecExit(exit) != null;
    }
    
    
    /**
    *  Tjekker om player er kommet i slutrummet, og afslutter spil, hvis player er det.
     * @param player
    *  @since 1.0
    */
    public void ifWinCondition(Player player) {
        if (player.getCurrRoom().equals(dc.rc.slutRoom)) {
            continue_ = false;
        }
    }
    
    
    /**
    *  Tester player HP - Giver output om at player er død og lukker spillet,
    *  hvis HP er 0 eller mindre.
     * @param player
    *  @since 1.0
    */
    public void ifPlayerHealthZero(Player player) {
        if (player.stats.getHealth()<= 0) {
            display.printActionDeath();
            continue_ = false;
        }
    }
    
    /**
    *  Metoder der fjerner HP fra player hvis der er en fælde i rummet
     * @param player
    *  @since 1.0.
    */
    public void ifRoomContainsTrap(Player player){
        if (player.getCurrRoom().isTrapActive()) { //Tester om der er 
            player.getCurrRoom().springTrap(player);
            display.printActionSpringTrap();
        }
    }
    
    // Trigger ikke når NPC har 0HP. Kører metode der tester Player HP og slutter spillet hvis Player HP er 0 efter combat.
    public void ifRoomContainsNpc(Player player,Room playerPrevRoom){
        if(player.getCurrRoom().getNpc() != null && !(player.getCurrRoom().getNpc().stats.getHealth() <= 0)){
            display.npcAggro(player.getCurrRoom().getNpc());
            cbt.combat(player.getCurrRoom().getNpc(), player, playerPrevRoom, display);
        }
    }
    
    public ItemHolder loopItemHolder(){
        ItemHolder ih = display.itemHolderChoice(player);
        if (ih==null) {
            display.printInvalidInput();
            return ih;
        } else {
            return ih;
        }
        
    }

}


