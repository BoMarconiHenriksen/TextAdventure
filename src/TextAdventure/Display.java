/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author bo_ma
 */
public class Display {

    Scanner sc;
    String name;

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
    public String nameInput() {
        sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + ".");
        return name;
    }

    // printer kommandolinjen og returnerer kommandoen fra player
    public String playerInput() {
        sc = new Scanner(System.in);
        System.out.print("> ");
        String input = sc.nextLine();
        return input.toLowerCase();
    }

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

    public void printActionPlayerTransit() {
        System.out.println("Walking...");
    }

    public void printNoExit() {
        System.out.println("You can't go this way...");
    }

    public void printInvalidInput() {
        System.out.println("Invalid input...");
    }

    // printer beskrivelsen af nuv�rende 'Room'
    public void printCurrRoomDescr(Room room) {
        System.out.println(room.getDescription());
    }

    // printer samt returnerer player svar p� som spillet skal afsluttes
    public String exitChoice() {
        sc = new Scanner(System.in);
        System.out.print("Are you sure you want to exit?: ");
        String choice = sc.nextLine();
        return choice;
    }

    // printer exit besked, inden spillet lukkes
    public void printExitMessage() {
        System.out.println("Farewell!");
    }

    // printer m�ngden af guld player kan se i nuv�rende 'Room'
    public void printActionLook(Room room) {
        if (room.getRoomItemAmount(0) != 0) {
            System.out.println("You spot " + room.getRoomItemAmount(0) + " gold!...");
        } else {
            System.out.println("You see nothing of value...");
        }
    }

    // printer m�ngden af guld player 'holder' samt m�ngden af HP player har
    public void printInventory(Player player) {
//        System.out.println("Your wallet contains " + player.getPlayerGold() + " gold...");
//        System.out.println("You have " + player.getPlayerHealth() + " health points...");
        for (Item i : player.getPlayerInventory().getItems()) {
            System.out.println(i);
        }
    }

    // printer besked med hvor meget guld der er opsamlet, eller at man intet kan samle op
    public void printActionTake(int amount) {
        if (amount != 0) {
            System.out.println("You have picked up " + amount + " gold...");
        } else {
            System.out.println("You picked up nothing...");
        }
    }

    // printer besked med m�ngden af guld player mangler for at l�se et 'Exit' op
    public void printNeedGoldExit(Player player) {
        System.out.println("You need " + (100 - player.getPlayerItemAmount(0)) + " gold to enter!");
    }

    // printer besked n�r player har gennemf�rt spillet
    public void printWinMessage(Player player) {
        System.out.println("Total amount of gold gathered: " + player.getPlayerItemAmount(0));
    }

    // printer besked hvis en f�lde udl�ses
    public void printActionSpringTrap() {
        System.out.println("You hit a trap in the room! You lost health...");
    }

    // printer besked n�r player d�r
    public void printActionDeath() {
        System.out.println("You have 0 health points, you die...");
    }
}
