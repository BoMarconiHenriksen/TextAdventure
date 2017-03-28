/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;


/**
 *
 * @author bo_ma
 */
public class Controller {
    
    Display display;
    Player player;
    RoomConstructor rc;
    
    boolean continue_ = true;
    
    public void test() {
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
    
    public void start() {
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
    public void playerControl(String[] command) {
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
                //display.printActionTake(player.takeGold(player.getCurrRoom()));
                if (command.length > 1){
                    System.out.println(command[1]);
                } else {
                    System.out.println("Kun modtaget ét ord");
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
    public boolean checkExitNorth () {
        return player.getCurrRoom().getExitNorth() != null;
    }
    public boolean checkExitSouth () {
        return player.getCurrRoom().getExitSouth() != null;
    }
    public boolean checkExitEast () {
        return player.getCurrRoom().getExitEast() != null;
    }
    public boolean checkExitWest () {
        return player.getCurrRoom().getExitWest() != null;
    }
    
    // Tester om player er kommet i slutrummet, og afslutter spil hvis player er det.
    public void ifWinCondition(Player player) {
        if (player.getCurrRoom().equals(rc.slutRoom)) {
            display.printWinMessage(player);
            continue_ = false;
        }
    }
    
    // Tester player HP - Giver output om at player er død og lukker spillet,
    // hvis HP er 0 eller mindre.
    public void ifPlayerHealthZero(Player player) {
        if (player.getPlayerHealth() <= 0) {
            display.printActionDeath();
            continue_ = false;
        }
    }
    
    // Metoder der fjerner HP fra player hvis der er en fælde i rummet
    public void ifRoomContainsTrap(Player player){
        if (player.getCurrRoom().isTrapActive()) { //Tester om der er 
            player.getCurrRoom().springTrap(player);
            display.printActionSpringTrap();
            ifPlayerHealthZero(player);
        }
    }
    
    // Metode for 'west' kommando fra player
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
    
    
    
}


