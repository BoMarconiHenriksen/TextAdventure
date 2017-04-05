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
    
     /* 
     * Tilføjer item til player inventory og fjerner den tilsvarende
     * item fra room inventory 
     * @param index
     * @param amount
     * @return 
     */
    public void takeItem(int indexCol, int indexRow) {
        Item temp = this.currRoom.getInventory().getSpecItem(indexCol, indexRow);
        this.currRoom.getInventory().removeSpecItem(indexCol, indexRow);
        this.getInventory().addSpecItem(indexCol, temp);
    }
    
    public void takeItem(int goldAmount) {
        int temp = this.currRoom.getInventory().getGoldList().get(0).getAmount();
        this.currRoom.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }

    
    /**
     * Tilføjer item til room inventory og fjerner den tilsvarende
     * item fra player inventory
     * @param indexCol
     * @param indexRow
     * @param index
     * @param amount
     * @return 
     */ 

    public void placeItem(int indexCol, int indexRow) {
        Item temp = this.getInventory().getSpecItem(indexCol, indexRow);
        this.getInventory().removeSpecItem(indexCol, indexRow);
        this.currRoom.getInventory().addSpecItem(indexCol, temp);
    }
    
    public void placeItem(int goldAmount) {
        int temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.currRoom.getInventory().getGoldList().get(0).getAmount();
        this.currRoom.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
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


