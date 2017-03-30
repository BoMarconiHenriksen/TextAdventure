
package TextAdventure;


/**
 *  Klassen der styrer programmet.
 *  @since 1.0
 */
public class Controller {
    
    Display display;
    Player player;
    RoomConstructor rc;
    Highscore hs;
//        hs.setHighscore(player.getName(), player.getPlayerItemAmount(0));
    
    boolean continue_ = true;
    
    public void test() throws Exceptions {
        display = new Display();
        hs = new Highscore(display);
        rc = new RoomConstructor();
        
        rc.createRooms();
        
        // TEMP PLAYERNAME
        player = new Player(new Inventory(),"Playername");
      //  player = new Player(0, display.nameInput()); // Opretter en player og får et navn som input
        player.setCurrRoom(rc.startRoom); // Placere player i et rum
        
        player.getInventory().setItemAmount(0, 5);
        
        while(continue_) {
            String[] command = new String[1];
            command[0] = display.playerInput();
            if (command[0].contains(" ")) {
                String[] command2 = command[0].split(" ");
                playerControl(command2);
            } else {
                playerControl(command);
            }
        }
        display.printFinalStats(player);
        hs.setHighscore(player.getName(), player.getItemAmount(0));
        hs.getHighscore();
        display.printExitMessage();
        System.exit(0);
        
    }
    

    /**
    *  This method starts the game.
     * @throws TextAdventure.Exceptions
    *  @since 1.0
    */
  

    public void start() throws Exceptions {

        display = new Display();
        rc = new RoomConstructor();
        
        rc.createRooms();
        
        // TEMP PLAYERNAME
        player = new Player(new Inventory(), "Playername");
      //  player = new Player(0, display.nameInput()); // Opretter en player og får et navn som input
        player.setCurrRoom(rc.startRoom); // Placere player i et rum

        display.welcome();
        display.printCurrRoomDescr(player.getCurrRoom());
        while(continue_) {
            String[] command = new String[1];
            command[0] = display.playerInput();
            if (command[0].contains(" ")) {
                String[] command2 = command[0].split(" ");
                playerControl(command2);
            } else {
                playerControl(command);
            }
        }
        hs.getHighscore();
        display.printExitMessage();
        System.exit(0);
    }
    
    // Switch case som tager imod en kommando fra player

    /**
    *  Switch case som tager imod en kommando fra player.
     * @param command
     * @throws TextAdventure.Exceptions
    *  @since 1.0
    */ 

    public void playerControl(String[] command) throws Exceptions {

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
    
    // NYNYNYNYNYNY ************************************************
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
    
    // NYNYNYNYNYNYNY ***********************************************
    public boolean checkSpecExit (String exit) {
        return player.getCurrRoom().getSpecExit(exit) != null;
    }
    
    // Tester om player er kommet i slutrummet, og afslutter spil hvis player er det.
    /**
    *  Tjekker om player er kommet i slutrummet, og afslutter spil, hvis player er det.
     * @param player
    *  @since 1.0
    */
    public void ifWinCondition(Player player) {
        if (player.getCurrRoom().equals(rc.slutRoom)) {
            continue_ = false;
        }
    }
    
    // Tester player HP - Giver output om at player er død og lukker spillet,
    // hvis HP er 0 eller mindre.
    /**
    *  Tester player HP - Giver output om at player er død og lukker spillet,
    *  hvis HP er 0 eller mindre.
     * @param player
    *  @since 1.0
    */
    public void ifPlayerHealthZero(Player player) {
        if (player.getPlayerHealth() <= 0) {
            display.printActionDeath();
            continue_ = false;
        }
    }
    
    // Metoder der fjerner HP fra player hvis der er en fælde i rummet
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
    
    // NYNYNYNYNYNYNY ***********************************************
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
    
    // ÆNDRING FORSLAG: 
    public void itemChoice(String itemChoice, int takeOrPlace) throws Exceptions {
        int amount;
        switch(itemChoice) {
            case "gold":
                amount = display.itemAmountChoice();
                itemChoiceAction(0,amount,takeOrPlace);
                break;
            case "weapon":
                amount = display.itemAmountChoice();
                itemChoiceAction(1,amount,takeOrPlace);
                break;
            case "armor":
                amount = display.itemAmountChoice();
                itemChoiceAction(2,amount,takeOrPlace);
                break;
            case "potion":
                amount = display.itemAmountChoice();
                itemChoiceAction(3,amount,takeOrPlace);
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    
    // ÆNDRING FORSLAG: playerCheckAmount()
    public boolean checkInventoryAmountPlayer(int index,int amount){
        return player.getItemAmount(index) >= amount;
    }
    
    // ÆNDRING FORSLAG: roomCheckAmount()
    public boolean checkInventoryAmountRoom(int index,int amount){
        return player.getCurrRoom().getItemAmount(index) >= amount;
    }
    
    // ÆNDRING FORSLAG: itemTakeOrPlace()
    public void itemChoiceAction(int itemIndex, int amount, int takeOrPlace) {
        if (takeOrPlace == 0) {
            if (checkInventoryAmountRoom(itemIndex,amount)) {
                player.takeItem(itemIndex, amount);
                display.takeItem(itemIndex,amount);
            } else {
                display.insufficientAmount();
            }
        } else {
            if (checkInventoryAmountPlayer(itemIndex,amount)) {
                player.placeItem(itemIndex, amount);
                display.placeItem(itemIndex, amount);
            } else {
                display.insufficientAmount();
            }
        }
    }
    
}


