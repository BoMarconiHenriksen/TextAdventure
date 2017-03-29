
package TextAdventure;


/**
 *  Klassen der styrer programmet.
 *  @since 1.0
 */
public class Controller {
    
    Display display;
    Player player;
    RoomConstructor rc;
    
    boolean continue_ = true;
    
    public void test() throws Exceptions {
        display = new Display();
        rc = new RoomConstructor();
        
        rc.createRooms();
        
        // TEMP PLAYERNAME
        player = new Player(new Inventory(),"Playername");
      //  player = new Player(0, display.nameInput()); // Opretter en player og får et navn som input
        player.setCurrRoom(rc.startRoom); // Placere player i et rum
        
        rc.startRoom.setRoomItemAmount(1,10);
        
        String test = "hh";
        System.out.println(commandAliases(test));

        /* SAT I KOMMENTAR PGA DEBUGGING ***********************************
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
        display.printExitMessage();
        System.exit(0);
        
        */
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

        switch(command[0]) {
            case "north": 
            case "n": //KAN FJERNES PGA commandAliases() ********************************
                north();
                // allDirections("north"); NYNYNYNYNYNY **************************
                break;
            case "south":
            case "s": //KAN FJERNES PGA commandAliases() ********************************
                south();
                // allDirections("south"); NYNYNYNYNYNY **************************
                break;
            case "east":
            case "e": //KAN FJERNES PGA commandAliases() ********************************
                east();
                // allDirections("east"); NYNYNYNYNYNY **************************
                break;
            case "west":
            case "w": //KAN FJERNES PGA commandAliases() ********************************
                west();
                // allDirections("west"); NYNYNYNYNYNY **************************
                break;
            case "look":
            case "l": //KAN FJERNES PGA commandAliases() ********************************
                display.printActionLook(player.getCurrRoom());
                break;
            case "take":
            case "t": //KAN FJERNES PGA commandAliases() ********************************
                if (command.length > 1){
                    itemChoice(command[1],0);
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "place":
            case "p": //KAN FJERNES PGA commandAliases() ********************************
                if (command.length > 1){
                    itemChoice(command[1],1);
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "inventory":
            case "i": //KAN FJERNES PGA commandAliases() ********************************
                display.printInventory(player);
                break;
            case "help":    
            case "h": //KAN FJERNES PGA commandAliases() ********************************
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
            default:
                return input;
        }
    }
    
    // NYNYNYNYNYNYNY ***********************************************
    public boolean checkSpecExit (String exit) {
        return player.getCurrRoom().getSpecExit(exit) != null;
    }
    
    // TJEKKER OM EXIT (i en bestemt retning) FINDES FOR NUVÆRENDE POSISTION
    /**
    *  Tjekker om exit for <b>nord</b> findes for nuværende position.
     * @return 
    *  @since 1.0
    */
    public boolean checkExitNorth () {
        return player.getCurrRoom().getExitNorth() != null;
    }
    /**
    *  Tjekker om exit for <b>sydd</b> findes for nuværende position.
     * @return 
    *  @since 1.0
    */
    public boolean checkExitSouth () {
        return player.getCurrRoom().getExitSouth() != null;
    }
    /**
    *  Tjekker om exit for <b>east</b> findes for nuværende position.
     * @return 
    *  @since 1.0
    */
    public boolean checkExitEast () {
        return player.getCurrRoom().getExitEast() != null;
    }
    /**
    *  Tjekker om exit for <b>west</b> findes for nuværende position.
     * @return 
    *  @since 1.0
    */
    public boolean checkExitWest () {
        return player.getCurrRoom().getExitWest() != null;
    }
    
    // Tester om player er kommet i slutrummet, og afslutter spil hvis player er det.
    /**
    *  Tjekker om player er kommet i slutrummet, og afslutter spil, hvis player er det.
     * @param player
    *  @since 1.0
    */
    public void ifWinCondition(Player player) {
        if (player.getCurrRoom().equals(rc.slutRoom)) {
            display.printWinMessage(player);
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
    
    // Metode for 'west' kommando fra player
    /**
    *  Metode for <b>west</b> kommando fra player.
    *  @since 1.0
    */
    public void west() {
        if (checkExitWest() && player.getCurrRoom().getExitWest().unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getExitWest().getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsTrap(player);
            ifWinCondition(player);
        } else {
            if (!checkExitWest()) {
                display.printNoExit();
            } else {
                display.printNeedGoldExit(player);
            }
        }
    }
    
    // Metode for 'east' kommando fra plyer
    /**
    *  Metode for <b>east</b> kommando fra player.
    *  @since 1.0
    */
    public void east() {
        if (checkExitEast() && player.getCurrRoom().getExitEast().unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getExitEast().getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsTrap(player);
            ifWinCondition(player);
        } else {
            if (!checkExitEast()) {
                display.printNoExit();
            } else {
                display.printNeedGoldExit(player);
            }
        }
    }
    
    // Metode for 'south' kommando fra player
    /**
    *  Metode for <b>south</b> kommando fra player.
    *  @since 1.0
    */
    public void south() {
        if (checkExitSouth() && player.getCurrRoom().getExitSouth().unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getExitSouth().getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsTrap(player);
            ifWinCondition(player);
        } else {
            if (!checkExitSouth()) {
                display.printNoExit();
            } else {
                display.printNeedGoldExit(player);
            }
        }
    }
    
    // Metode for 'north' kommando fra player
    /**
    *  Metode for <b>north</b> kommando fra player.
    *  @since 1.0
    */
    public void north() {
        if (checkExitNorth() && player.getCurrRoom().getExitNorth().unlockExitCondition(player)){ //Tjekker om der er et exit mod vest og om exit er åben
            player.setCurrRoom(player.getCurrRoom().getExitNorth().getNextRoom()); //Flytter player til nyt rum
            display.printActionPlayerTransit();
            display.printCurrRoomDescr(player.getCurrRoom());
            ifRoomContainsTrap(player);
            ifWinCondition(player);
        } else {
            if (!checkExitNorth()) {
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
        return player.getPlayerItemAmount(index) >= amount;
    }
    
    // ÆNDRING FORSLAG: roomCheckAmount()
    public boolean checkInventoryAmountRoom(int index,int amount){
        return player.getCurrRoom().getRoomItemAmount(index) >= amount;
    }
    
    // ÆNDRING FORSLAG: itemTakeOrPlace()
    public void itemChoiceAction(int itemIndex, int amount, int takeOrPlace) {
        if (takeOrPlace == 0) {
            if (checkInventoryAmountRoom(0,amount)) {
                player.takeItem(0, amount);
            } else {
                System.out.println("ERROR"); // DEBUGGING
            }
        } else {
            if (checkInventoryAmountPlayer(0,amount)) {
                player.placeItem(0, amount);
            } else {
                System.out.println("ERROR"); // DEBUGGING
            }
        }
    }
    
    
}


