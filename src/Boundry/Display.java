package Boundry;

import Entities.NPC;
import Entities.Item;
import Entities.Character;
import Entities.ItemHolder;
import Entities.Potion;
import Entities.Room;
import Entities.Weapon;
import Entities.Player;
import Entities.Armor;
import java.util.Scanner;

/**
 * Klassen Display kommuniker med spilleren.
 *
 * @since 1.0
 */
public class Display {

    Scanner sc;

    /**
     * Metoden giver en velkomst besked til spilleren, når spillet starter.
     *
     * @since 1.0
     */
    public void welcome() {
        System.out.println("+------------Text adventure game:------------+"
                + "\n+             Asylum of Horrors              +"
                + "\n+--------------------------------------------+");
        System.out.println("                Prolouge:                     "
                + "\nYou wake up in a padded cell. You do not know how you ended up here,"
                + " but you know you must escape. You hear fingers scraping against the outside of the walls,"
                + " and as the cell door slowly opens before you, it becomes clear to you that there is an evil"
                + " in this place. An evil that wants you dead...");
        System.out.println("               Objective:                 "
                + "\nEscape the Asylum of Horrors. Type 'help' to display a menu of actions you can perform."
                + "\nGood luck."
                + "\n");
    }

    /**
     * Returnerer player navn.
     *
     * @since 1.0
     */
    public String nameInput() {
        sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome, " + name + ".\n");
        return name;
    }

    /**
     * Printer kommandolinjen og returnerer kommandoen fra player.
     *
     * @since 1.0
     */
    public String playerInput() {
        sc = new Scanner(System.in);
        System.out.print("> ");
        String input = sc.nextLine();
        return input.toLowerCase();
    }

    /**
     * Printer hjælpemenuen.
     *
     * @since 1.0
     */
    public void helpMenu() {
        System.out.println("++++++++++++++++ HELP  MENU ++++++++++++++++++++++++++");
        System.out.println("+ \'help\' or \'h\' - Show Help-menu                     +");
        System.out.println("+ \'look\' or \'l\' - Search the room / NPC              +");
        System.out.println("+ \'take\' or \'t\' + \"Item Name\" - Take an item         +");
        System.out.println("+ \'place\' or \'p\' + \"Item Name\" - Place an item       +");
        System.out.println("+ \'inventory\' or \'i - Show inventory/health/equipped +");
        System.out.println("+ \'equip\' or \'q - Equip an item                      +");
        System.out.println("+ \'potion or \'d - Drink a potion                     +");
        System.out.println("+ \'north\' or \'n\' - Go north                          +");
        System.out.println("+ \'south\' or \'s\' - Go south                          +");
        System.out.println("+ \'east\' or \'e\' - Go east                            +");
        System.out.println("+ \'west\' or \'w\' - Go west                            +");
        System.out.println("+ \'exit\' or \'x\' - Exit game                          +");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        // System.out.println("+ \'use\' or \'u\' + Item Name - Use an Item  +");
    }

    /**
     * Printer når spilleren bevæger.
     *
     * @since 1.0
     */
    public void printActionPlayerTransit() {
        System.out.println("Walking...\n");
    }

    /**
     * Printer at spilleren ikke kan gå den vej fra sin nuværende position.
     *
     * @since 1.0
     */
    public void printNoExit() {
        System.out.println("You can't go this way...\n");
    }

    /**
     * Printer at spilleren har indtastet en forkert komando.
     *
     * @since 1.0
     */
    public void printInvalidInput() {
        System.out.println("Invalid input...\n");
    }

    // printer beskrivelsen af nuværende 'Room'
    /**
     * Printer beskrivelsen af nuværende <b>Room</b>.
     *
     * @param room Henter beskrivelsen fra room.
     * @since 1.0
     */
    public void printCurrRoomDescr(Room room) {
        System.out.println(room.getDescription() + "\n");
    }

    // printer samt returnerer player svar p� som spillet skal afsluttes
    /**
     * Printer samt returnerer player svar på som spillet skal afsluttes.
     *
     * @since 1.0
     */
    public String exitChoice() {
        sc = new Scanner(System.in);
        System.out.print("Are you sure you want to exit?: " + "\n");
        String choice = sc.nextLine();
        return choice;
    }

    /**
     * Printer exit besked, inden spillet lukkes.
     *
     * @since 1.0
     */
    public void printExitMessage() {
        System.out.println("Farewell!\n");
    }

    /**
     * Printer om der er guld eller ingen guld i rummet.
     *
     * @param itemHolder Tjekker om der er guld fra RoomItemAmount.
     * @since 2.0
     */
    public void printActionLook(ItemHolder itemHolder) {
        boolean empty = true;

        if (!(itemHolder.getInventory().getGoldList().get(0).getAmount() == 0)) {
            System.out.println("Gold: " + itemHolder.getInventory().getGoldList().get(0).getAmount());
            empty = false;

        }
        if (!itemHolder.getInventory().getWeaponList().isEmpty()) {
            System.out.println("Weapons: ");
            for (Weapon i : itemHolder.getInventory().getWeaponList()) {
                System.out.println((itemHolder.getInventory().getWeaponList().indexOf(i) + 1) + ". " + i);
            }
            empty = false;

        }
        if (!itemHolder.getInventory().getArmorList().isEmpty()) {
            System.out.println("Armor: ");
            for (Armor i : itemHolder.getInventory().getArmorList()) {
                System.out.println((itemHolder.getInventory().getArmorList().indexOf(i) + 1) + ". " + i);
            }
            empty = false;

        }
        if (!itemHolder.getInventory().getPotionList().isEmpty()) {
            System.out.println("Potions: ");
            for (Potion i : itemHolder.getInventory().getPotionList()) {
                System.out.println((itemHolder.getInventory().getPotionList().indexOf(i) + 1) + ". " + i);
            }
            empty = false;
        }
        System.out.println();

        if (empty) {
            System.out.println("No item, there is nothing here!" + "\n");
        }

    }

    /**
     * Printer mængden af guld, våben, armor og potions player har. Printer
     * health.
     *
     * @param player Tjekker spillerens guld fra getPlayerGold, og får
     * spillerens health fra getPlayerHealth.
     * @since 2.0
     */
    public void printInventory(Player player) {

        System.out.println("-- Stats --");
        System.out.println("Health: "+player.stats.getHealth());
        System.out.println("Total attack: "+player.stats.getTotalAttack(player));
        System.out.println("Total defense: "+player.stats.getTotalDefense(player)+"\n");
        
        System.out.println("-- Eqipped --");
        System.out.print("Weapon: ");
        if (player.equipped.getActiveWeapon() == null) {
            System.out.println("Empty");
        } else {
            System.out.println(player.equipped.getActiveWeapon());
        }
        System.out.print("Armor: ");
        if (player.equipped.getActiveArmor() == null) {
            System.out.println("Empty");
        } else {
            System.out.println(player.equipped.getActiveArmor());
        }
        System.out.println();
        System.out.println("-- Your inventory contains --");
        System.out.println("Gold: " + player.getInventory().getGoldList().get(0).getAmount());

        if (!player.getInventory().getWeaponList().isEmpty()) {
            System.out.println("Weapons:");
            for (Item i : player.getInventory().getWeaponList()) {
                System.out.println((player.getInventory().getWeaponList().indexOf(i) + 1) + ". " + i);
            }
        }

        if (!player.getInventory().getArmorList().isEmpty()) {
            System.out.println("Armor:");
            for (Item i : player.getInventory().getArmorList()) {
                System.out.println((player.getInventory().getArmorList().indexOf(i) + 1) + ". " + i);
            }
        }

        if (!player.getInventory().getPotionList().isEmpty()) {
            System.out.println("Potions:");
            for (Item i : player.getInventory().getPotionList()) {
                System.out.println((player.getInventory().getPotionList().indexOf(i) + 1) + ". " + i);
            }
        }
        System.out.println();

    }

    /**
     * Printer besked med mængden af guld player mangler for at låse et
     * <b>Exit</b> op.
     *
     * @param player Spillerens totale mangde guld fra player.getItemAmount.
     * @since 2.0
     */
    public void printNeedGoldExit(Player player) {
        System.out.println("You need " + (100 - player.getInventory().getGoldList().get(0).getAmount()) + " gold to enter!" + "\n");
    }

    /**
     * Printer n�r player har gennemf�rt spillet.
     *
     * @param player Spillerens totale mangde guld fra player.getItemAmount.
     * @since 2.0
     */
    public void printFinalStats(Player player) {
        System.out.println(player.getName() + ", total amount of gold gathered: " + player.getInventory().getGoldList().get(0).getAmount() + "\n");

    }

    /**
     * Printer besked hvis en fælde udløses.
     *
     * @since 1.0
     */
    public void printActionSpringTrap() {
        System.out.println("You hit a trap in the room! You lost health..." + "\n");
    }

    /**
     * Printer besked når player dør.
     *
     * @since 1.0
     */
    public void printActionDeath() {
        System.out.println("You have 0 health points, you die..." + "\n");
    }

    /**
     * Hvis spilleren skriver "take x" spørges der hvor mange. Hvis spilleren
     * derefter giver en ugyldig værdi spørges der om han vil indtaste igen
     * eller bare fortsætte spillet.
     *
     * @return choice
     */
    public int goldAmountChoice() {
        sc = new Scanner(System.in);
        boolean _continue = true;
        int choice = 0;

        while (_continue) {
            System.out.print("How much?: ");
            String choiceStr = sc.nextLine();
            try {
                choice = Integer.parseInt(choiceStr);
                _continue = false;

            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Do you want to try again?: ");
                String check = sc.nextLine().toLowerCase();
                if (!check.equals("y") && !check.equals("yes")) {
                    _continue = false;
                }
            }
        }
        System.out.println();
        return choice;
    }

    public int indexRowChoice() {
        sc = new Scanner(System.in);
        boolean _continue = true;
        int choice = 0;

        while (_continue) {
            System.out.print("What slot?: ");
            String choiceStr = sc.nextLine();
            if (choiceStr.isEmpty()) {
                return 999; //on no input = too high index is returned
            }
            try {
                choice = Integer.parseInt(choiceStr) - 1;
                _continue = false;

                
            } catch (NumberFormatException e) {
                System.out.print("Invalid number. Do you want to try again?: ");
                String check = sc.nextLine().toLowerCase();
                if (!check.equals("y") && !check.equals("yes")) {
                    _continue = false;
                }
            }
        }

        System.out.println();
        return choice;
    }

    /**
     * Errormessage hvis spiller skriver commando uden henvisning til item
     */
    public void noSpecifiedItem() {
        System.out.println("Please write a command followed by an item category"
                + "\n Examples : equip weapon , take armor " + "\n");
    }

    /**
     * Errormessage hvis highscore.txt ikke kan findes af programmet
     */
    public void errorFileNotFound() {
        System.out.println("File not found" + "\n");
    }

    /**
     * Errormessage hvis programmet ikke kan skrive til highscore.txt
     */
    public void errorIOException() {
        System.out.println("Unable to write to file - File might be protected." + "\n");
    }

    /**
     * Errormessage hvis den indtastede mængde ikke matcher den tilgængelige
     * mængde i inventory
     * @param player
     */
    public void insufficientAmount(boolean player) {
        if (player){
            System.out.println("You reach in your pocket, but there is nothing!" + "\n");
        } else {
            System.out.println("The amount chosen was too high!" + "\n");
        }
    }

    public void emptySlotMessage() {
        System.out.println("The slot is empty!" + "\n");
    }

    //++++++++++++++++++++++ Nye Display Metoder ++++++++++++++++++++++++++++++
    public int combatMenu() {
        sc = new Scanner(System.in);
        int choice = 0;
        boolean _continue;

        System.out.println("What will you do?"
                + "\n1.Attack"
                + "\n2.Use Potion"
                + "\n3.Show Inventory"
                + "\n4.Change Armor or Weapon"
                + "\n5.Run");
        System.out.print("> ");

        String choiceStr = sc.nextLine();
        try {
            choice = Integer.parseInt(choiceStr);
            _continue = false;

        } catch (NumberFormatException e) {
            System.out.print("Invalid number." + "\n");
        }
        return choice;
    }

    public void attack(Character character) {
        System.out.println(character.getName() + " attacks!" + "\n");

    }

    public void takeDamage(int amount, Character character) {
        System.out.println(character.getName() + " takes " + amount + " damage! " + "\n");

    }

    public void gainLife(int amount) {
        System.out.println("You gained " + amount + " health!" + "\n");
    }

    public void usePotion() {
        System.out.println("You drank a mysterious potion" + "\n");
    }

    public void takeItem(Item item) {
        System.out.println("You picked up: " + item.getName() + "\n");
    }

    public void takeGold(int amount) {
        System.out.println("You picked up " + amount + " gold" + "\n");
    }

    public void placeGold(int amount) {
        System.out.println("You dropped " + amount + " gold" + "\n");
    }

    public void placeItem(Item item) {
        System.out.println("You dropped " + item.getName() + "\n");
    }

    public void equipItem(Item item) {
        System.out.println("You equipped " + item.getName() + "\n");
    }

    public void unequipItem(Item item) {
        System.out.println("You put " + item.getName() + " into your bag" + "\n");
    }

    //Display metoder fra combat klassen
    public void playerHealthStatus(Player player) {
        System.out.println("You are now at: " + player.stats.getHealth() + " health." + "\n");
    }

    public void npcAggro(NPC npc) {
        System.out.println(npc.getName() + " Attacks you!" + "\n");
    }

    public void npcHealthStatus(NPC npc) {
        System.out.println(npc.getName() + "is now at " + npc.stats.getHealth() + " health" + "\n");
    }

    public void npcDied(NPC npc) {
        System.out.println(npc.getName() + " DIED!" + "\n");
    }

    public ItemHolder itemHolderChoice(Player player,boolean take) {
        sc = new Scanner(System.in);
        String choice = "room";

        if (!(player.getCurrRoom().getNpc() == null) && take) {
            System.out.print("What to interact with (Room or NPC): ");
            choice = sc.nextLine().toLowerCase();
            System.out.println();
        }
        switch (choice) {
            case "room":
                return player.getCurrRoom();
            case "npc":
                return player.getCurrRoom().getNpc();
            default:
                return null;
        }
    }

    public void playerFleeMessage() {
        System.out.println("You run back to the previous room!" + "\n");
    }

    public String playerEquipChoice() {
        sc = new Scanner(System.in);
        boolean continue_ = true;
        String choice = "";

        while (continue_) {

            System.out.print("What do you want to equip?: ");
            choice = sc.nextLine().toLowerCase();
            System.out.println();
            switch (choice) {
                case "weapon":
                case "w":
                    continue_ = false;
                    return "weapon";
                case "armor":
                case "a":
                    continue_ = false;
                    return "armor";
                default:
                    System.out.println("Not a valid choice!" + "\n");
            }

        }
        return choice;
    }

    public void lookDeadNpc(Room room) {
        if (room.getNpc() != null) {
            System.out.println("There is dead " + room.getNpc().getName() + " on the floor..." + "\n");
        }
    }

}
