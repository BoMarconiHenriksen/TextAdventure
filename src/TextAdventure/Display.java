package TextAdventure;

import java.util.Scanner;

/**
 *  Klassen Display kommuniker med spilleren.
 * @since 1.0
 */
public class Display {

    Scanner sc;
    
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

    // printer beskrivelsen af nuværende 'Room'
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

    
    /**
    *  Printer exit besked, inden spillet lukkes.
    *  @since 1.0
    */
    public void printExitMessage() {
        System.out.println("Farewell!");
    }


    
    /**
    *  Printer om der er guld eller ingen guld i rummet.
    *  @param room Tjekker om der er guld fra RoomItemAmount.
    *  @since 2.0
    */
    public void printActionLook(Room room) {

        System.out.print("You see: ");
        if (!(room.getInventory().getGoldList().get(0).getAmount() == 0)){
            System.out.println("Gold: "+room.getInventory().getGoldList().get(0).getAmount());
            
        } if (!room.getInventory().getWeaponList().isEmpty()) {
            System.out.println("Weapons: ");
            for (Weapon i : room.getInventory().getWeaponList()) {
                System.out.println((room.getInventory().getWeaponList().indexOf(i) + 1) +". "+i);
            }

        } if (!room.getInventory().getArmorList().isEmpty()){
            System.out.println("Armor: ");
            for (Armor i : room.getInventory().getArmorList()) {
                System.out.println((room.getInventory().getArmorList().indexOf(i) + 1) +". "+i);
            }

        } if (!room.getInventory().getPotionList().isEmpty()){
          System.out.println("Potions: ");
            for (Potion i : room.getInventory().getPotionList()) {
                System.out.println((room.getInventory().getPotionList().indexOf(i) + 1) +". "+i);
            }
            
        }

    }


    /**
    *  Printer mængden af guld, våben, armor og potions player har. Printer health.
    *  @param player Tjekker spillerens guld fra getPlayerGold, og får spillerens health fra getPlayerHealth.
    *  @since 2.0
    */
    public void printInventory(Player player) {

        System.out.println("Your inventory contains: ");
        System.out.println("Gold: "+player.getInventory().getGoldList().get(0).getAmount());
        System.out.println("Weapons:");
        for (Item i : player.getInventory().getWeaponList()){
            System.out.println((player.getInventory().getWeaponList().indexOf(i) + 1) +". "+i);
        }
        System.out.println("Armor:");
        for (Item i : player.getInventory().getArmorList()){
            System.out.println((player.getInventory().getArmorList().indexOf(i) + 1) +". "+i);
        }    
        System.out.println("Potions:");
        for (Item i : player.getInventory().getPotionList()){
            System.out.println((player.getInventory().getPotionList().indexOf(i) + 1) +". "+i);
        }    
              
    }

    

    
    /**
    *  Printer hvor meget guld du tager eller om du ikke tager noget guld op.
     * @param index
    *  @param amount Hvor meget guld der er.
    *  @since 1.0
    */
    public void takeItem(int index,int amount) {
        amount = Math.abs(amount);
        switch(index) {
            case 0:
                System.out.println("You have picked up " + amount + " gold...");
                break;
            case 1:
                System.out.println("You have picked up " + amount + " weapon...");
                break;
            case 2:
                System.out.println("You have picked up " + amount + " armor...");
                break;
            case 3:
                System.out.println("You have picked up " + amount + " potion...");
                break;
        }
    }
    /**
     * Tager item fra inventory position + amount og placerer det pågældende i current room.
     * Printer hvad og hvor meget der er blevet placeret.
     * @param index
     * @param amount 
     */
    
    public void placeItem(int index,int amount) {
        amount = Math.abs(amount);
        switch(index) {
            case 0:
                System.out.println("You have placed " + amount + " gold...");
                break;
            case 1:
                System.out.println("You have placed " + amount + " weapon...");
                break;
            case 2:
                System.out.println("You have placed " + amount + " armor...");
                break;
            case 3:
                System.out.println("You have placed " + amount + " potion...");
                break;
        }
    }

  
    /**
    *  Printer besked med mængden af guld player mangler for at låse et <b>Exit</b> op.
    *  @param player Spillerens totale mangde guld fra player.getItemAmount.
    *  @since 2.0
    */
    public void printNeedGoldExit(Player player) {
        System.out.println("You need " + (100 - player.getInventory().getGoldList().get(0).getAmount()) + " gold to enter!");
    }

    
    /**
    *  Printer n�r player har gennemf�rt spillet.
    *  @param player Spillerens totale mangde guld fra player.getItemAmount.
    *  @since 2.0
    */
    public void printFinalStats(Player player) {
        System.out.println(player.getName()+", total amount of gold gathered: " + player.getInventory().getGoldList().get(0).getAmount());
        
    }

    
    /**
    *  Printer besked hvis en fælde udløses.
    *  @since 1.0
    */
    public void printActionSpringTrap() {
        System.out.println("You hit a trap in the room! You lost health...");
    }

    
    /**
    *  Printer besked når player dør.
    *  @since 1.0
    */
    public void printActionDeath() {
        System.out.println("You have 0 health points, you die...");
    }
    
    /**
     * Hvis spilleren skriver "take x" spørges der hvor mange. Hvis spilleren 
     * derefter giver en ugyldig værdi spørges der om han vil indtaste igen
     * eller bare fortsætte spillet.
     * @return choice
     */ 
    public int itemAmountChoice() {
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
    /**
     * Errormessage hvis spiller skriver commando uden henvisning til item
     */
    public void noSpecifiedItem() {
        System.out.println("Please specify an item...");
    }
    /**
     * Errormessage hvis highscore.txt ikke kan findes af programmet
     */
    public void errorFileNotFound() {
        System.out.println("File not found");
    }
    /**
     * Errormessage hvis programmet ikke kan skrive til highscore.txt
     */
    public void errorIOException() {
        System.out.println("Unable to write to file - File might be protected.");
    }
    /**
     * Errormessage hvis den indtastede mængde ikke matcher den 
     * tilgængelige mængde i inventory
     */
    public void insufficientAmount() {
        System.out.println("Insufficient amount");
    }
    
}