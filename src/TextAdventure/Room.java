package TextAdventure;


/**
 * Klassen holder information om pågældende rum
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

    /**
     *
     * @param inventory
     * @param description
     * @param trap
     */
    public Room(Inventory inventory, String description, boolean trap) {
        this.description = description;
        this.inventory = inventory;
        this.trap = trap;
    }
    
    /**
     *
     * @param inventory
     * @param description
     */
    public Room(Inventory inventory, String description) {
        this.inventory = inventory;
        this.description = description;
    }
    
    /**
     *
     * @param description
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     *
     */
    public Room() {}
    
    public Inventory getInventory(){
        return this.inventory;
    }
    
//    public int getItemAmount(int index) {
//        return inventory.getItemAmount(index);
//    }
//
//    public void setItemAmount(int index, int amount) {
//        this.inventory.setItemAmount(index,amount);
//    }

    public String getDescription() {
        return description;
    }
    
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
    
    
    /**
    * Fjerner 50 hp fra player og fjerner trap  
    * @param player a
    * @since 1.0
    */
    public void springTrap(Player player) {
        player.stats.setHealth(player.stats.getHealth()-50);
        this.trap = false;
    }

}
