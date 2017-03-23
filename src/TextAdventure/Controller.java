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
    Room startRoom;
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room slutRoom;
    Room trapRoom1;
    Room trapRoom2;
    
    boolean continue_ = true;
    
    void start() {
        display = new Display();
        
        // Opretter rum uden fælder
        startRoom = new Room(20,"Start room");
        room1 = new Room(0,"room1");
        room2 = new Room(15,"room2");
        room3 = new Room(0,"room3");
        room4 = new Room(35,"room4");
        room5 = new Room(0,"room5");
        room6 = new Room(0,"room6");
        room7 = new Room(25,"room7");
        room8 = new Room(0,"room8");
        slutRoom = new Room(0,"Slut room");
        // Opretter rum med fælder 
        trapRoom1 = new Room(5,"Trap room1",true);
        trapRoom2 = new Room(0,"Trap room2",true);
        
        //Opretter Exits start room
        startRoom.setExitNorth(new Exit(room3));
        startRoom.setExitEast(new Exit(room1));
        startRoom.setExitSouth(new Exit(trapRoom2));

        //Opretter Exits room1
        room1.setExitWest(new Exit(startRoom));
        room1.setExitEast(new Exit(room5));
        room1.setExitSouth(new Exit(trapRoom1));
        
        //Opretter Exits room2
        room2.setExitEast(new Exit(room3));
        room2.setExitWest(new Exit(room8));

        //Opretter Exits room3
        room3.setExitWest(new Exit(room2));
        room3.setExitSouth(new Exit(startRoom));
        room3.setExitNorth(new Exit(room6));
        
        //Opretter Exits room4
        room4.setExitEast(new Exit(room5));
        
        //Opretter Exits room5
        room5.setExitWest(new Exit(room4));
        room5.setExitSouth(new Exit(room1));
        
        //Opretter Exits room6
        room6.setExitSouth(new Exit(room3));
        room6.setExitNorth(new Exit(room7));
        
        //Opretter Exits room7
        room7.setExitSouth(new Exit(room6));
        room7.setExitWest(new Exit(room8));
        
        //Opretter Exits room8
        room8.setExitEast(new Exit(slutRoom));
        room8.setExitWest(new Exit(startRoom));
        //Opretter Lås for Exit mod øst
        room8.getExitEast().setOpen(false);
        
        //Opretter Exits trap room1
        trapRoom1.setExitNorth(new Exit(room1));
        
        //Opretter Exits trap room2
        trapRoom2.setExitNorth(new Exit(startRoom));
        
        //player = new Player(0, display.nameInput());
        player = new Player(0, "slutty");
        player.setCurrRoom(startRoom);
        
        
        display.welcome();
        while(continue_) {
            display.printCurrRoomDescr(player.getCurrRoom());
            playerControl();
        }
        
        
    }
    
    // Switch case som tager imod en kommando fra player
    public void playerControl() {
        switch(display.playerInput()) {
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
                display.printActionTake(player.takeGold(player.getCurrRoom()));
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
                    display.printExitMessage();
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
        if (player.getCurrRoom().equals(slutRoom)) {
            display.printWinMessage(player);
            display.printExitMessage();
            continue_ = false;
        }
    }
    
    // Tester player HP - Giver output om at player er død og lukker spillet,
    // hvis HP er 0 eller mindre.
    public void ifPlayerHealthZero(Player player) {
        if (player.getPlayerHealth() <= 0) {
            display.printActionDeath();
            display.printExitMessage();
            continue_ = false;
        }
    }
    
    // NY NY NY
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


