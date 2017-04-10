
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
    
    boolean continue_ = true;
    

    public void test() {
        display = new Display();
        hs = new Highscore(display);
        dc = new DungeonConstructor();
        cbt = new Combat();
        
        dc.createDungeon();
        
        player = new Player("Henrik",new Stats(100,10,10),new Equipped(),new Inventory()); 
        player.setCurrRoom(dc.rc.startRoom); 
        player.inventory.addItem(1, dc.ic.w5);
        player.inventory.addItem(1, dc.ic.w2);
        player.equipWeapon(0);

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
                display.printActionLook(player.getCurrRoom());
                break;
            case "take":
                if (command.length > 1){
                    itemChoice(command[1],true,player.getCurrRoom());
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "place":
                if (command.length > 1){
                    itemChoice(command[1],false,player.getCurrRoom());
                } else {
                    display.noSpecifiedItem();
                }
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
            default:
                return input;
        }
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
    public void ifRoomContainsNpc(Player player){
        if(player.getCurrRoom().getNpc() != null && !(player.getCurrRoom().getNpc().stats.getHealth() <= 0)){
            cbt.combat(player.getCurrRoom().getNpc(), player,display);
            ifPlayerHealthZero(player);
        }
    }
    
    public void commandDirection(String exit) {
        if (checkExit(exit) && player.getCurrRoom().getSpecExit(exit).unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getSpecExit(exit).getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsNpc(player);
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
    
    public void itemChoice(String itemChoice, boolean take,ItemHolder itemHolder) {

        switch(itemChoice) {
            case "gold":
                itemChoiceAction(display.goldAmountChoice(),take, itemHolder);
                break;
            case "weapon":
                itemChoiceAction(1,display.indexRowChoice(),take, itemHolder);
                break;
            case "armor":
                itemChoiceAction(2,display.indexRowChoice(),take, itemHolder);
                break;
            case "potion":
                itemChoiceAction(3,display.indexRowChoice(),take, itemHolder);
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    
    /**
     * Checker hvor meget af en item Current ItemHolder har i et pågældende index
     * 
     * 
     * 
     * @param indexCol
     * @param indexRow
     */
    public boolean checkInvRange(int indexCol, int indexRow,ItemHolder itemholder){
        try {
            itemholder.getInventory().getItem(indexCol, indexRow);
            return true;
        }
        catch(IndexOutOfBoundsException e) {
            display.PrintOutOfBoundsInvRange();
            return false;
        }
    }
    
    /**
     * Tager index, indexRow og om item skal placeres eller tages af player.
     * Derefter sker handlingen og printes til display.
     * Hvis der ikke er nok skrives 
     * @param itemIndex
     * @param indexRow
     * @param take 
     */
    public void itemChoiceAction(int itemIndex, int indexRow, boolean take, ItemHolder itemHolder) {
        if (take) {
            if (checkInvRange(itemIndex,indexRow,itemHolder)) {
                player.takeItem(itemIndex, indexRow,itemHolder);
    //            display.takeItem(itemIndex,indexRow);
            } else {
                display.insufficientAmount();
            }
        } else {
            if (checkInvRange(itemIndex,indexRow,player)) {
                player.placeItem(itemIndex, indexRow,itemHolder);
 //               display.placeItem(itemIndex, indexRow);
            } else {
                display.insufficientAmount();
            }
        }
    }
    
    public void itemChoiceAction(int goldAmount, boolean take, ItemHolder itemHolder) {
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
    
}


