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
    
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory playerInventory) {
        this.inventory = playerInventory;
    }
    
    public int getItemAmount(int index) {
        //return inventory.getItemAmount(index);
        return 0;
    }

    public void setItemAmount(int index, int amount) {
        // this.inventory.setItemAmount(index,amount);

    }
    
    


     /* 
     * Tilføjer item til player inventory og fjerner den tilsvarende
     * item fra room inventory 
     * @param index
     * @param amount
     * @return 
     */
    public int takeItem(int index, int amount) {
//        inventory.setItemAmount(index, inventory.getItemAmount(index) + Math.abs(amount));
//        this.getCurrRoom().setItemAmount(index, this.getCurrRoom().getItemAmount(index) - Math.abs(amount));
//        return this.inventory.getItemAmount(index);
        return 0;
    }
    
    /**
     * Tilføjer item til room inventory og fjerner den tilsvarende
     * item fra player inventory
     * @param index
     * @param amount
     * @return 
     */ 

        public int placeItem(int index, int amount) {
//        this.getCurrRoom().setItemAmount(index, this.getCurrRoom().getItemAmount(index) + Math.abs(amount));
//        inventory.setItemAmount(index, inventory.getItemAmount(index) - Math.abs(amount));
//        return inventory.getItemAmount(index);
        return 0;
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
    
    public void addItemPlayer(int index, Item item) {
        inventory.getItemsList().get(index).add(item);
    }
    
}


