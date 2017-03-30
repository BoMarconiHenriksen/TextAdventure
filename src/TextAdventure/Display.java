package TextAdventure;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  Klassen Display kommuniker med spilleren.
 * @since 1.0
 */
public class Display {

    Scanner sc;
    String name;
    
    /**
    *  Metoden giver en velkomst besked til spilleren, når spillet starter.
    *  @since 1.0
    */
    public void welcome() {
        System.out.println("\nWelcome to the Dungeon of Mysteries!\n\n"
                + "Finally you found it - the narrow passage in the mountains, just where the strange, old man from the village said it would be!  "
                + "\nAs you squeeze through the narrow opening, you are reminded of the old mans tale, of the long forgotten treasures of the mountain.  "
                + "\n\n"
                + "As you move  hastily through the dank tunnel, you hear a loud *click* and a hidden trapdoor opens under you, and you fall into the darkness below.."
                + "\n\n"
                + ".. You open your eyes, unharmed. "
                + "\nUnable to reach the trapdoor way above, you must find another way out of the dungeon.\n"
                + "\n"
                + "If you feel scared and alone in the dungeon just shout help or even better try to write help on the dusty floor in a room.\n");
    }

    // returnerer player navn
    /**
    *  Returnerer player navn.
    *  @since 1.0
    */
    public String nameInput() {
        sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + ".");
        return name;
    }

    // printer kommandolinjen og returnerer kommandoen fra player
    /**
    *  Printer kommandolinjen og returnerer kommandoen fra player.
    *  @since 1.0
    */
    public String playerInput() {
        sc = new Scanner(System.in);
        System.out.print("> ");
        String input = sc.nextLine();
        return input.toLowerCase();
    }
    
    /**
    *  Printer hjælpemenuen.
    *  @since 1.0
    */
    public void helpMenu() {
        System.out.println("++++++++++++++++ HELP  MENU ++++++++++++++++++++++");
        System.out.println("+ \'help\' or \'h\' - Show Help-menu                 +");
        System.out.println("+ \'look\' or \'l\' - Search the room                +");
        System.out.println("+ \'take\' or \'t\' + \"Item Name\" - Take an item     +");
        System.out.println("+ \'place\' or \'p\' + \"Item Name\" - Place an item   +");
        System.out.println("+ \'inventory\' or \'i - Show inventory/health      +");
        System.out.println("+ \'north\' or \'n\' - Go north                      +");
        System.out.println("+ \'south\' or \'s\' - Go south                      +");
        System.out.println("+ \'east\' or \'e\' - Go east                        +");
        System.out.println("+ \'west\' or \'w\' - Go west                        +");
        System.out.println("+ \'exit\' or \'x\' - Exit game                      +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
        // System.out.println("+ \'use\' or \'u\' + Item Name - Use an Item  +");
    }
    
    /**
    *  Printer når spilleren bevæger.
    *  @since 1.0
    */
    public void printActionPlayerTransit() {
        System.out.println("Walking...");
    }
    
    /**
    *  Printer at spilleren ikke kan gå den vej fra sin nuværende position.
    *  @since 1.0
    */
    public void printNoExit() {
        System.out.println("You can't go this way...");
    }
    
    /**
    *  Printer at spilleren har indtastet en forkert komando.
    *  @since 1.0
    */
    public void printInvalidInput() {
        System.out.println("Invalid input...");
    }

    // printer beskrivelsen af nuv�rende 'Room'
    /**
    *  Printer beskrivelsen af nuværende <b>Room</b>.
    *  @param room Henter beskrivelsen fra room.
    *  @since 1.0
    */
    public void printCurrRoomDescr(Room room) {
        System.out.println(room.getDescription());
    }

    // printer samt returnerer player svar p� som spillet skal afsluttes
    /**
    *  Printer samt returnerer player svar på som spillet skal afsluttes.
    *  @since 1.0
    */
    public String exitChoice() {
        sc = new Scanner(System.in);
        System.out.print("Are you sure you want to exit?: ");
        String choice = sc.nextLine();
        return choice;
    }

    // printer exit besked, inden spillet lukkes
    /**
    *  Printer exit besked, inden spillet lukkes.
    *  @since 1.0
    */
    public void printExitMessage() {
        System.out.println("Farewell!");
    }

    // printer m�ngden af guld player kan se i nuv�rende 'Room'
    /**
    *  Printer mængden af guld player kan se i nuværende <b>Room</b>.
    *  @since 1.0
    */
    
    /**
    *  Printer om der er guld eller ingen guld i rummet.
    *  @param room Tjekker om der er guld fra RoomItemAmount.
    *  @since 2.0
    */
    public void printActionLook(Room room) {
        boolean hasItem = false;

        System.out.print("You see: ");
        if (room.getInventory().getItemAmount(0) > 0){
            System.out.print("\n"+room.getInventory().getItemAmount(0) + " Gold");
            hasItem = true;
        } if (room.getInventory().getItemAmount(1) > 0) {
            System.out.print("\n"+room.getInventory().getItemAmount(1) + " Weapons");
            hasItem = true;
        } if (room.getInventory().getItemAmount(2) > 0){
            System.out.print("\n"+room.getInventory().getItemAmount(2) + " Armors");
            hasItem = true;
        } if (room.getInventory().getItemAmount(3) > 0){
            System.out.print("\n"+room.getInventory().getItemAmount(3) + " Potions");
            hasItem = true;
        }
        
        if (!hasItem) {
            System.out.print("Nothing...");
        }
        System.out.println();
              //Type potioninfo, armorinfo or weaponinfo for information on specific items??
    }

    // printer m�ngden af guld player 'holder' samt m�ngden af HP player har
    /**
    *  Printer mængden af guld player 'holder' samt mængden af HP player har.
    *  @param player Tjekker spillerens guld fra getPlayerGold, og får spillerens health fra getPlayerHealth.
    *  @since 2.0
    */
   
        
    public void printInventory(Player player) {
        boolean hasItem = false;
        
        System.out.println("You have " + player.getPlayerHealth() + " health points...");
        System.out.print("Your inventory contains: ");
        if (player.getInventory().getItemAmount(0) > 0){
            System.out.print("\n"+player.getInventory().getItemAmount(0) + " Gold");
            hasItem = true;
        } if (player.getInventory().getItemAmount(1) > 0) {
            System.out.print("\n"+player.getInventory().getItemAmount(1) + " Weapons");
            hasItem = true;
        } if (player.getInventory().getItemAmount(2) > 0){
            System.out.print("\n"+player.getInventory().getItemAmount(2) + " Armors");
            hasItem = true;
        } if (player.getInventory().getItemAmount(3) > 0){
            System.out.print("\n"+player.getInventory().getItemAmount(3) + " Potions");
            hasItem = true;
        }
        
        if (!hasItem) {
            System.out.print("Nothing...");
        }
        System.out.println();
              //Type potioninfo, armorinfo or weaponinfo for information on specific items??
    }

    

    // printer besked med hvor meget guld der er opsamlet, eller at man intet kan samle op
    /**
    *  Printer hvor meget guld du tager eller om du ikke tager noget guld op.
    *  @param amount Hvor meget guld der er.
    *  @since 1.0
    */
    public void printActionTake(int amount) {
        if (amount != 0) {
            System.out.println("You have picked up " + amount + " gold...");
        } else {
            System.out.println("You picked up nothing...");
        }
    }

    // printer besked med m�ngden af guld player mangler for at l�se et 'Exit' op
    /**
    *  Printer besked med mængden af guld player mangler for at låse et <b>Exit</b> op.
    *  @param player Spillerens totale mangde guld fra player.getItemAmount.
    *  @since 2.0
    */
    public void printNeedGoldExit(Player player) {
        System.out.println("You need " + (100 - player.getItemAmount(0)) + " gold to enter!");
    }

    // printer besked n�r player har gennemf�rt spillet
    /**
    *  Printer n�r player har gennemf�rt spillet.
    *  @param player Spillerens totale mangde guld fra player.getItemAmount.
    *  @since 2.0
    */
    public void printWinMessage(Player player) {
        System.out.println("Total amount of gold gathered: " + player.getItemAmount(0));
    }

    // printer besked hvis en f�lde udl�ses
    /**
    *  Printer besked hvis en fælde udløses.
    *  @since 1.0
    */
    public void printActionSpringTrap() {
        System.out.println("You hit a trap in the room! You lost health...");
    }

    // printer besked n�r player d�r
    /**
    *  Printer besked når player dør.
    *  @since 1.0
    */
    public void printActionDeath() {
        System.out.println("You have 0 health points, you die...");
    }
    
    // Hvis spilleren skriver "take x" spørges der hvor mange. Hvis spilleren 
    // derefter giver en ugyldig værdi spørges der om han vil indtaste igen 
    // eller bare fortsætte spillet.
    public int itemAmountChoice() throws Exceptions {
        sc = new Scanner (System.in);
        boolean _continue = true;
        int choice=0;
        
        while(_continue) {
            System.out.print("How many?: ");
            String choiceStr = sc.nextLine();
            try {
                choice = Integer.parseInt(choiceStr);
                _continue = false;

            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Do you want to try again?: ");
                String check = sc.nextLine().toLowerCase();
                if (!check.equals("y") && !check.equals("yes")){
                    _continue = false;
                }
            }
        }
        return choice;
    }
    
    public void noSpecifiedItem() {
        System.out.println("Please specify an item...");
    }
    
}
