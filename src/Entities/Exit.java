package Entities;

/**
 *  Klassen definerer om en exit (dør) er åben, lukket og hvor den fører hen.
 *  @since 1.0
 */
public class Exit{
    
    private Room nextRoom; // Hvilket rum exited fører til.
    private boolean open = true; // Om exited er åbent
    
    public Exit(Room nextRoom, boolean open) {
        this.nextRoom = nextRoom;
        this.open = open;
    }
    

    public Exit(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    /**
    * Går fra nuværende rum til det nye rum.
    * @param nextRoom Dette er det næste rum.
    * @since 1.0
    */
    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    /**
    *  Exit (døren) er åben.
     * @return 
    *  @since 1.0
    */
    public boolean isOpen() {
        return open;
    }

    /**
    * Sætter døren til at være åben.
    * @param open Exit (døren) er åben.
    * @since 1.0
    */
    public void setOpen(boolean open) {
        this.open = open;
    }
     
    /**
    *  Returnerer true hvis Exit er åbent - returnerer true hvis player har 100+ guld, samt sætter Exit til at være åbent.
    * @param player player.getItemAmount
     * @return 
    * @since 1.0
    */
    public boolean unlockExitCondition(Player player) {
        if (this.open != true) {
            if (player.getInventory().getGoldList().get(0).getAmount() >= 100) {
                this.open = true;
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    
}
