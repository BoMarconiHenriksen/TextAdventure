
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
        
//        System.out.println(rc.startRoom.getRoomItemAmount(1));
//        System.out.println(player.getPlayerItemAmount(1));
//        player.takeItem(1, 50 ,player.getCurrRoom());
//        System.out.println(rc.startRoom.getRoomItemAmount(1));
//        System.out.println(player.getPlayerItemAmount(1));
        
        
//        display.welcome();
//        display.printCurrRoomDescr(player.getCurrRoom());
//        while(continue_) {
//            playerControl();
//        }
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
    

    /**
    *  This method starts the game.
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
    *  @since 1.0
    */ 

    public void playerControl(String[] command) throws Exceptions {

        switch(command[0]) {
            case "north": 
            case "n":
                north();
                break;
            case "south":
            case "s":
                south();
                break;
            case "east":
            case "e":
                east();
                break;
            case "west":
            case "w":
                west();
                break;
            case "look":
            case "l":
                display.printActionLook(player.getCurrRoom());
                break;
            case "take":
            case "t":
                if (command.length > 1){
                    itemChoice(command[1]);
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "place":
            case "p":
                if (command.length > 1){
                    itemChoice(command[1]);
                } else {
                    display.noSpecifiedItem();
                }
                break;
            case "inventory":
            case "i":
                display.printInventory(player);
                break;
            case "help":    
            case "h":
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
    
    // TJEKKER OM EXIT (i en bestemt retning) FINDES FOR NUVÆRENDE POSISTION
    /**
    *  Tjekker om exit for <b>nord</b> findes for nuværende position.
    *  @since 1.0
    */
    public boolean checkExitNorth () {
        return player.getCurrRoom().getExitNorth() != null;
    }
    /**
    *  Tjekker om exit for <b>sydd</b> findes for nuværende position.
    *  @since 1.0
    */
    public boolean checkExitSouth () {
        return player.getCurrRoom().getExitSouth() != null;
    }
    /**
    *  Tjekker om exit for <b>east</b> findes for nuværende position.
    *  @since 1.0
    */
    public boolean checkExitEast () {
        return player.getCurrRoom().getExitEast() != null;
    }
    /**
    *  Tjekker om exit for <b>west</b> findes for nuværende position.
    *  @since 1.0
    */
    public boolean checkExitWest () {
        return player.getCurrRoom().getExitWest() != null;
    }
    
    // Tester om player er kommet i slutrummet, og afslutter spil hvis player er det.
    /**
    *  Tjekker om player er kommet i slutrummet, og afslutter spil, hvis player er det.
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
    *  @since 1.0.
    */
    public void ifRoomContainsTrap(Player player){
        if (player.getCurrRoom().isTrapActive()) { //Tester om der er 
            player.getCurrRoom().springTrap(player);
            display.printActionSpringTrap();
            ifPlayerHealthZero(player);
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
    
    public void itemChoice(String itemChoice) throws Exceptions {
        switch(itemChoice) {
            case "gold":
                player.takeItem(0, display.itemAmountChoice());
                break;
            case "weapon":
                player.takeItem(1, display.itemAmountChoice());
                break;
            case "armor":
                player.takeItem(2, display.itemAmountChoice());
                break;
            case "potion":
                player.takeItem(3, display.itemAmountChoice());
                break;
            default:
                display.printInvalidInput();
                break;
        }
    }
    
}


