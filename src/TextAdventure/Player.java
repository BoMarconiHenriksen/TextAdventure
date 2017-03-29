package TextAdventure;

/**
 * Klassen holder informatin om spilleren.
 * @since 2.0
 */
public class Player {
    
    private int health = 100;
    private String name;
    private Room currRoom = null; //Nuværende rum player befinder sig i
    private Inventory inventory;

    public Player() {}
    
    public Player(Inventory inventory, String name) {
        this.inventory = inventory;
        this.name = name;
    }
    
    public Inventory getPlayerInventory() {
        return inventory;
    }

    public void setPlayerInventory(Inventory playerInventory) {
        this.inventory = playerInventory;
    }
    
    public int getPlayerItemAmount(int index) {
        return inventory.getItemAmount(index);
    }

    public void setPlayerItemAmount(int index, int amount) {
        this.inventory.setItemAmount(index,amount);
    }
    
    // Tilføjer guld til player og tager guld fra rum

    /**
    *  
    *  @since 2.0
    */
    

    public int takeItem(int index, int amount) {

        inventory.setItemAmount(index, inventory.getItemAmount(index) + amount);
        this.getCurrRoom().setRoomItemAmount(index, this.getCurrRoom().getRoomItemAmount(index) - amount);
        return this.inventory.getItemAmount(index);
    }
    
    // Smider Items 

    /**
    *  
    *  @since 2.0
    */


    public int placeItem(int index, int amount) {
        this.getCurrRoom().setRoomItemAmount(index, this.getCurrRoom().getRoomItemAmount(index) + amount);
        inventory.setItemAmount(index, inventory.getItemAmount(index) - amount);
        return inventory.getItemAmount(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

    public int getPlayerHealth() {
        return health;
    }

    public void setPlayerHealth(int health) {
        this.health = health;
    }
    
}


