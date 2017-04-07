package TextAdventure;

/**
 * Klassen holder informatin om spilleren.
 * @since 2.0
 */
public class Player extends Character {

    private Room currRoom = null; //Nuværende rum player befinder sig i
    private int maxWeight=999999;

    /**
     *
     * @param name
     * @param stats
     * @param equipped
     * @param inventory
     */
    public Player(String name, Stats stats, Equipped equipped, Inventory inventory) {
        super(name,stats,equipped,inventory);
    }
 
     /* 
     * Tilføjer item til player inventory og fjerner den tilsvarende
     * item fra room inventory 
     * @param index
     * @param amount
     * @return 
     */

    /**
     *
     * @param indexCol
     * @param indexRow
     */

    public void takeItem(int indexCol, int indexRow) {
        Item temp = this.currRoom.getInventory().getSpecItem(indexCol, indexRow);
        this.currRoom.getInventory().removeSpecItem(indexCol, indexRow);
        this.getInventory().addSpecItem(indexCol, temp);
    }
    
    public void takeItem(int indexCol, int indexRow, ItemHolder takeFrom) {
        Item temp = takeFrom.getInventory().getSpecItem(indexCol, indexRow);
        takeFrom.getInventory().removeSpecItem(indexCol, indexRow);
        this.getInventory().addSpecItem(indexCol, temp);
    }
    
    /**
     *
     * @param goldAmount
     */
    public void takeItem(int goldAmount) {
        int temp = this.currRoom.getInventory().getGoldList().get(0).getAmount();
        this.currRoom.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }
    
    public void takeItem(int goldAmount, ItemHolder takeFrom) {
        int temp = takeFrom.getInventory().getGoldList().get(0).getAmount();
        takeFrom.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }

    
    /**
     * Tilføjer item til room inventory og fjerner den tilsvarende
     * item fra player inventory
     * @param indexCol
     * @param indexRow 
     */ 

    public void placeItem(int indexCol, int indexRow) {
        Item temp = this.getInventory().getSpecItem(indexCol, indexRow);
        this.getInventory().removeSpecItem(indexCol, indexRow);
        this.currRoom.getInventory().addSpecItem(indexCol, temp);
    }
    
    public void placeItem(int indexCol, int indexRow,ItemHolder placeTo) {
        Item temp = this.getInventory().getSpecItem(indexCol, indexRow);
        this.getInventory().removeSpecItem(indexCol, indexRow);
        placeTo.getInventory().addSpecItem(indexCol, temp);
    }
    
    /**
     *
     * @param goldAmount
     */
    public void placeItem(int goldAmount) {
        int temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.currRoom.getInventory().getGoldList().get(0).getAmount();
        this.currRoom.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }
    
    public void placeItem(int goldAmount, ItemHolder placeTo) {
        int temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = placeTo.getInventory().getGoldList().get(0).getAmount();
        placeTo.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }
    
    public Room getCurrRoom() {
        return currRoom;
    }

    public void setCurrRoom(Room currRoom) {
        this.currRoom = currRoom;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Stats getStats() {
        return stats;
    }

    @Override
    public void setStats(Stats stats) {
        this.stats = stats;
    }

    @Override
    public Equipped getEquipped() {
        return equipped;
    }

    @Override
    public void setEquipped(Equipped equipped) {
        this.equipped = equipped;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    /**
     *
     * @param indexRow
     */
    public void equipWeapon(int indexRow){
        if (this.equipped.getActiveWeapon() == null){
            this.equipped.setActiveWeapon(this.inventory.getWeaponList().get(indexRow));
            this.inventory.removeSpecItem(1, indexRow);
        } else {
            this.inventory.addSpecItem(1, this.equipped.getActiveWeapon());
            this.equipped.setActiveWeapon(this.inventory.getWeaponList().get(indexRow));
            this.inventory.removeSpecItem(1, indexRow);
        }
    }
    
    /**
     *
     * @param indexRow
     */
    public void equipArmor(int indexRow){
        if (this.equipped.getActiveArmor() == null){
            this.equipped.setActiveArmor(this.inventory.getArmorList().get(indexRow));
            this.inventory.removeSpecItem(2, indexRow);
        } else {
            this.inventory.addSpecItem(2, this.equipped.getActiveArmor());
            this.equipped.setActiveArmor(this.inventory.getArmorList().get(indexRow));
            this.inventory.removeSpecItem(2, indexRow);
        }
    }

    /**
     *
     * @param character
     */
    @Override
    public void doAttack(Character character) {
        int dmg = 0;
        
        if (this.equipped.getActiveWeapon()==null||this.equipped.getActiveWeapon().getAttack() <= character.stats.getTotalDefense
            (character)) {
            dmg = this.stats.getAttack();
        }
        else {
            dmg = this.stats.getTotalAttack(this) - character.stats.getTotalDefense(character);
        }
        character.stats.setHealth(character.stats.getHealth()-dmg);
    }
    
    
}

