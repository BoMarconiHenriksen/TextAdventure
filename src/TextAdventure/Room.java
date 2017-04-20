package TextAdventure;

/**
 * Klassen holder information om pågældende rum.
 *
 * @since 1.0
 */
public class Room extends ItemHolder{

    private String description;
    private boolean trap = false;
    private NPC npc;

    private Exit north = null;
    private Exit south = null;
    private Exit west = null;
    private Exit east = null;

    public Room(Inventory inventory, String description, boolean trap, NPC npc,
            Exit north, Exit south, Exit west, Exit east) {
        super(inventory);
        this.description = description;
        this.trap = trap;
        this.npc = npc;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }
    
    public Room(Inventory inventory, String description, NPC npc,
            Exit north, Exit south, Exit west, Exit east) {
        super(inventory);
        this.description = description;
        this.npc = npc;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }
    
    public Room(Inventory inventory, String description,
            Exit north, Exit south, Exit west, Exit east) {
        super(inventory);
        this.description = description;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
    }
    
    /**
     *
     * @param inventory
     * @param description
     * @param trap
     * @param npc
     */
    public Room(Inventory inventory, String description, boolean trap, NPC npc) {
        super(inventory);
        this.description = description;
        this.trap = trap;
        this.npc = npc;
    }

    public Room(Inventory inventory, String description, boolean trap) {
        super(inventory);
        this.description = description;
        this.trap = trap;
    }

    /**
     *
     * @param inventory
     * @param description
     */
    public Room(Inventory inventory, String description) {
        super(inventory);
        this.description = description;
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }
    
    @Override
    public void setInventory(Inventory inventory) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDescription() {
        return description;
    }

    public Exit getSpecExit(String exit) {
        switch (exit) {
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
     *
     * @param player a
     * @since 1.0
     */
    public void springTrap(Player player) {
        player.stats.setHealth(player.stats.getHealth() - 50);
        this.trap = false;
    }

    public NPC getNpc() {
        return npc;
    }

    public void setNpc(NPC npc) {
        this.npc = npc;
    }
    
}
