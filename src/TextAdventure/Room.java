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
public class Room {
    
    private Inventory inventory;
    private String description;
    private boolean trap = false;
    
    private Exit north = null;
    private Exit south = null;
    private Exit west = null;
    private Exit east = null;

    public Room(Inventory inventory, String description, boolean trap) {
        this.description = description;
    }
    
    public Room(Inventory inventory, String description) {
        this.inventory = inventory;
        this.description = description;
    }
    
    public Room(String description) {
        this.description = description;
    }

    public Room() {}
    
    public Inventory getInventory(){
        return this.inventory;
    }
    
    public int getRoomItemAmount(int index) {
        return inventory.getItemAmount(index);
    }

    public void setRoomItemAmount(int index, int amount) {
        this.inventory.setItemAmount(index,amount);
    }

    public String getDescription() {
        return description;
    }

    public Exit getExitNorth() {
        return north;
    }

    public void setExitNorth(Exit north) {
        this.north = north;
    }

    public Exit getExitSouth() {
        return south;
    }

    public void setExitSouth(Exit south) {
        this.south = south;
    }

    public Exit getExitWest() {
        return west;
    }

    public void setExitWest(Exit west) {
        this.west = west;
    }

    public Exit getExitEast() {
        return east;
    }

    public void setExitEast(Exit east) {
        this.east = east;
    }

    public boolean isTrapActive() {
        return trap;
    }

    public void setTrap(boolean trap) {
        this.trap = trap;
    }
    
    // Tager 50 HP fra player og deaktiverer fælden. 
    public void springTrap(Player player) {
        player.setPlayerHealth(player.getPlayerHealth()-50);
        this.trap = false;
    }

}
