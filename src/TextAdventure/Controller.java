
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
    
    boolean continue_ = true;
    

    public void test() {
        display = new Display();
        hs = new Highscore(display);
        dc = new DungeonConstructor();
        
        dc.createDungeon();
        
        player = new Player("Henrik",new Stats(100,10,10),new Equipped(),new Inventory()); 
        player.setCurrRoom(dc.rc.startRoom); 
        player.inventory.addSpecItem(1, dc.ic.w5);
        player.inventory.addSpecItem(1, dc.ic.w2);
        player.equipWeapon(0);
        
        
        
        while(continue_) {
            if (dc.npc.nmy1.stats.getHealth() <= 0) {
                System.out.println("NPC DIED");
                break;
            } 
            System.out.println("NPC HEALTH: "+dc.npc.nmy1.stats.getHealth());
            dc.npc.nmy1.doAttack(player);
            if (player.stats.getHealth() <= 0) {
                System.out.println("PLAYER DIED");
                break;
            } 
            System.out.println("PLAYER HEALTH: "+player.stats.getHealth());
            player.doAttack(dc.npc.nmy1);
        }
        
        
        
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
//        display.printExitMessage();
//        System.exit(0);


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

        switch(commandAliases(command[0])) {
            case "north": 
                allDirections(commandAliases(command[0]));
                break;
            case "south":
                allDirections(commandAliases(command[0]));
                break;
            case "east":
                allDirections(commandAliases(command[0]));
                break;
            case "west":
                allDirections(commandAliases(command[0]));
                break;
            case "look":
                display.printActionLook(player.getCurrRoom());
                break;
            case "take":
                if (command.length > 1){
                    itemChoice(command[1],0);
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "place":
                if (command.length > 1){
                    itemChoice(command[1],1);
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
    public boolean checkSpecExit (String exit) {
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
    
    public void allDirections(String exit) {
        if (checkSpecExit(exit) && player.getCurrRoom().getSpecExit(exit).unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getSpecExit(exit).getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsTrap(player);
            ifWinCondition(player);
        } else {
            if (!checkSpecExit(exit)) {
                display.printNoExit();
            } else {
                display.printNeedGoldExit(player);
            }
        }
    }
    
    public void itemChoice(String itemChoice, int takeOrPlace) {

        switch(itemChoice) {
            case "gold":
                itemChoiceAction(display.goldAmountChoice(),takeOrPlace);
                break;
            case "weapon":
                itemChoiceAction(1,display.indexRowChoice(),takeOrPlace);
                break;
            case "armor":
                itemChoiceAction(2,display.indexRowChoice(),takeOrPlace);
                break;
            case "potion":
                itemChoiceAction(3,display.indexRowChoice(),takeOrPlace);
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    /**
     * Checker hvor meget af en item player har i et pågældende index
     * @param index
     * @param amount
     * @return 
     */
    public boolean checkInvRangePlayer(int indexCol,int indexRow){
        try {
            player.getInventory().getSpecItem(indexCol, indexRow);
            return true;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("ERROR. DENNE BESKED SKAL PLACERES I DISPLAY");
            return false;
        }
    }
    /**
     * Checker hvor meget af en item Current room har i et pågældende index
     * @param index
     * @param amount
     * @return 
     */
    public boolean checkInvRangeRoom(int indexCol, int indexRow){
        try {
            player.getCurrRoom().getInventory().getSpecItem(indexCol, indexRow);
            return true;
        }
        catch(IndexOutOfBoundsException e) {
            System.out.println("ERROR. DENNE BESKED SKAL PLACERES I DISPLAY");
            return false;
        }
    }
    
    /**
     * Tager index, indexRow og om item skal placeres eller tages af player.
     * Derefter sker handlingen og printes til display.
     * Hvis der ikke er nok skrives 
     * @param itemIndex
     * @param indexRow
     * @param takeOrPlace 
     */
    public void itemChoiceAction(int itemIndex, int indexRow, int takeOrPlace) {
        if (takeOrPlace == 0) {
            if (checkInvRangeRoom(itemIndex,indexRow)) {
                player.takeItem(itemIndex, indexRow);
                display.takeItem(itemIndex,indexRow);
            } else {
                display.insufficientAmount();
            }
        } else {
            if (checkInvRangePlayer(itemIndex,indexRow)) {
                player.placeItem(itemIndex, indexRow);
                display.placeItem(itemIndex, indexRow);
            } else {
                display.insufficientAmount();
            }
        }
    }
    
    public void itemChoiceAction(int goldAmount, int takeOrPlace) {
        if (takeOrPlace == 0) {
            if (enoughGoldRoom(goldAmount)) {
                player.takeItem(goldAmount);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } else {
                display.insufficientAmount();
            }
        } else {
            if (enoughGoldPlayer(goldAmount)) {
                player.placeItem(goldAmount);
                System.out.println("TILFØJ DISPLAY METODE!!");
            } else {
                display.insufficientAmount();
            }
        }
    }
    
    public boolean enoughGoldRoom(int amount){
        return player.getCurrRoom().getInventory().getGoldList().get(0).getAmount() >= amount;
    }
    
    public boolean enoughGoldPlayer(int amount){
        return player.getInventory().getGoldList().get(0).getAmount() >= amount;
    }
    
    
    
}


