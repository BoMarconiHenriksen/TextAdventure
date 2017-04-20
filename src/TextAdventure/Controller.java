
package TextAdventure;


/**
 *  Klassen der styrer programmet.
 *  @since 1.0
 */
public class Controller {
    
    Display display;
    Player player;
    Highscore hs;
    DungeonConstructor dc;
    Combat cbt;
    Savegame save;
    
    boolean continue_ = true;
    

    public void test() {
        display = new Display();
        hs = new Highscore(display);
        dc = new DungeonConstructor();
        cbt = new Combat();
        save = new Savegame();
        
        dc.createDungeon();
        
        player = new Player("Henrik",new Stats(100,10,10),new Equipped(),new Inventory()); 
        player.setCurrRoom(dc.rc.startRoom); 
        player.inventory.addItem(1, dc.ic.w5);
        player.inventory.addItem(1, dc.ic.w2);

        player.inventory.addItem(3, dc.ic.p1);
        
        
        
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
//    public void start() {
//        display = new Display();
//        hs = new Highscore(display);
//        rc = new RoomConstructor();
//        
//        /**
//         * Opretter rum
//         */
//        rc.createRooms();
//        
//        player = new Player(new Inventory(), display.nameInput()); 
//        player.setCurrRoom(rc.startRoom); 
//        
//        display.welcome();
//        System.out.println(player.getCurrRoom().getDescription());
//        
//        while(continue_) {
//            String[] command = new String[1];
//            command[0] = display.playerInput();
//            if (command[0].contains(" ")) {
//                String[] command2 = command[0].split(" ");
//                playerControl(command2);
//            } else {
//                playerControl(command);
//            }
//        }
//        display.printFinalStats(player);
//        hs.setHighscore(player);
//        hs.sortHighscore();
//        hs.getHighscore();
//        display.printExitMessage();
//        System.exit(0);
//    }
    
    

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
            itemChoice(command[1],true,display.itemHolderChoice(player));
        } else {
            display.noSpecifiedItem();
        }
    }
    
    public void commandPlace(String [] command) {
        if (command.length > 1){
            //itemHolderChoice();
            itemChoice(command[1],false,player.getCurrRoom());
        } else {
            display.noSpecifiedItem();
        }
    }
    
    public void commandEquip(String[] command){
        if (command.length > 1){
            try{
                if (command[1].equals("weapon")){
                    player.equipWeapon(display.indexRowChoice());
                    display.equipItem(player.equipped.getActiveWeapon());
                } else if (command[1].equals("armor")){
                    player.equipArmor(display.indexRowChoice());
                    display.equipItem(player.equipped.getActiveArmor());
                } else {
                    display.printInvalidInput();
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
    
    public void itemChoice(String itemChoice, boolean take,ItemHolder itemHolder) {
        switch(itemChoice) {
            case "gold":
                itemChoiceAction(display.goldAmountChoice(),itemHolder,take);
                break;
            case "weapon":
                itemChoiceAction(1,display.indexRowChoice(),itemHolder, take);
                break;
            case "armor":
                itemChoiceAction(2,display.indexRowChoice(),itemHolder, take);
                break;
            case "potion":
                itemChoiceAction(3,display.indexRowChoice(), itemHolder, take);
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    
    public void itemChoiceAction(int itemIndex, int indexRow, ItemHolder itemHolder, boolean take) {
        if (take){
            try {
                player.takeItem(itemIndex, indexRow,itemHolder);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } catch (IndexOutOfBoundsException e) {
                display.emptySlotMessage();
            }
        } else {
            try {
                player.placeItem(itemIndex, indexRow, itemHolder);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } catch (IndexOutOfBoundsException e) {
                display.emptySlotMessage();
            }
        }
    }
    
    public void itemChoiceAction(int goldAmount, ItemHolder itemHolder, boolean take) {
        if (take) {
            if (enoughGold(goldAmount,itemHolder)) {
                player.takeItem(goldAmount,itemHolder);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } else {
                display.insufficientAmount();
            }
        } else {
            if (enoughGold(goldAmount,player)) {
                player.placeItem(goldAmount,itemHolder);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } else {
                display.insufficientAmount();
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
            ifPlayerHealthZero(player);
        }
    }
    
    // Trigger ikke når NPC har 0HP. Kører metode der tester Player HP og slutter spillet hvis Player HP er 0 efter combat.
    public void ifRoomContainsNpc(Player player,Room playerPrevRoom){
        if(player.getCurrRoom().getNpc() != null && !(player.getCurrRoom().getNpc().stats.getHealth() <= 0)){
            display.npcAggro(player.getCurrRoom().getNpc());
            cbt.combat(player.getCurrRoom().getNpc(), player, playerPrevRoom, display);
            ifPlayerHealthZero(player);
        }
    }

}


