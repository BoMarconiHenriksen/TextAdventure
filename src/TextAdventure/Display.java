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
        System.out.println("++++++++++++++++ HELP  MENU +++++++++++++++++");
        System.out.println("+ \'help\' or \'h\' - Show Help-menu            +");
        System.out.println("+ \'look\' or \'l\' - Look for gold             +");
        System.out.println("+ \'take\' or \'t\' - Take gold                 +");
        System.out.println("+ \'inventory\' or \'i - Show inventory/health +");
        System.out.println("+ \'exit\' or \'e\' - Exit game                 +");
        System.out.println("+ \'north\' or \'n\' - Go north                 +");
        System.out.println("+ \'south\' or \'s\' - Go south                 +");
        System.out.println("+ \'east\' or \'e\' - Go east                   +");
        System.out.println("+ \'east\' or \'w\' - Go west                   +");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
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
        if (room.getRoomItemAmount(0) != 0) {
            System.out.println("You spot " + room.getRoomItemAmount(0) + " gold!...");
        } else {
            System.out.println("You see nothing of value...");
        }
    }

    // printer m�ngden af guld player 'holder' samt m�ngden af HP player har
    /**
    *  Printer mængden af guld player 'holder' samt mængden af HP player har.
    *  @param player Tjekker spillerens guld fra getPlayerGold, og får spillerens health fra getPlayerHealth.
    *  @since 2.0
    */
    public void printInventory(Player player) {
//        System.out.println("Your wallet contains " + player.getPlayerGold() + " gold...");
//        System.out.println("You have " + player.getPlayerHealth() + " health points...");
        for (Item i : player.getPlayerInventory().getItems()) {
            System.out.println(i);
        }
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
    *  @param player Spillerens totale mangde guld fra player.getPlayerItemAmount.
    *  @since 2.0
    */
    public void printNeedGoldExit(Player player) {
        System.out.println("You need " + (100 - player.getPlayerItemAmount(0)) + " gold to enter!");
    }

    // printer besked n�r player har gennemf�rt spillet
    /**
    *  Printer n�r player har gennemf�rt spillet.
    *  @param player Spillerens totale mangde guld fra player.getPlayerItemAmount.
    *  @since 2.0
    */
    public void printWinMessage(Player player) {
        System.out.println("Total amount of gold gathered: " + player.getPlayerItemAmount(0));
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
}
