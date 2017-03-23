/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure01;

/**
 *
 * @author Mellem
 */
public class Exit {
    
    private Room nextRoom; // Hvilket rum exited fører til.
    private boolean open = true; // Om exited er åbent

    public Exit(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room nextRoom) {
        this.nextRoom = nextRoom;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
    
    // Returnerer true hvis Exit er åbent - returnerer true hvis player har 100+ guld, samt sætter Exit til at være åbent
    public boolean unlockExitCondition(Player player) {
        if (this.open != true) {
            if (player.getPlayerGold() >= 100) {
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
