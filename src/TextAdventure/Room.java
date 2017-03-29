package TextAdventure;


/**
 * Klassen 
 * @since 1.0
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
    
    // NYNYNYNYNYNYNY ***********************************************
    public Exit getSpecExit(String exit) {
        switch(exit){
            case "north":
                return this.north;
            case "south":
                return this.south;
            case "east":
                return this.east;
            case "west":
                return this.west;
            default:
                return null;
        }
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
    /**
    *  
    * @param player
    * @since 1.0
    */
    public void springTrap(Player player) {
        player.setPlayerHealth(player.getPlayerHealth()-50);
        this.trap = false;
    }

}
