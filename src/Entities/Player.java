package Entities;

/**
 * Klassen holder informatin om spilleren.
 * @since 2.0
 */
public class Player extends Character {

    private Room currRoom = null; //Nuværende rum player befinder sig i
    private int maxWeight=999999;


    public Player(String name, Stats stats, Equipped equipped, Inventory inventory) {
        super(name,stats,equipped,inventory);
    }
 
     /* 
     * add item to inventory from itemholder, and removes it from itenmholder
     * @param index
     * @param amount
     * @return 
     */
    public void takeItem(int indexCol, int indexRow, ItemHolder takeFrom) {
        Item temp = takeFrom.getInventory().getItem(indexCol, indexRow);
        takeFrom.getInventory().removeItem(indexCol, indexRow);
        this.getInventory().addItem(indexCol, temp);
    }
    
    /**
     * Add gold to inventory from itemholder, and removes gold from itemholder
     * @param goldAmount
     * @param takeFrom
     */
    public void takeItem(int goldAmount, ItemHolder takeFrom) {
        int temp = takeFrom.getInventory().getGoldList().get(0).getAmount();
        takeFrom.getInventory().getGoldList().get(0).setAmount(temp - goldAmount);
        temp = this.getInventory().getGoldList().get(0).getAmount();
        this.getInventory().getGoldList().get(0).setAmount(goldAmount+temp);
    }

    
    /**
     * Add item to itemholder from inventory, and remove it from inventory.
     * @param indexCol
     * @param indexRow 
     * @param placeTo 
     */ 
    public void placeItem(int indexCol, int indexRow,ItemHolder placeTo) {
        Item temp = this.getInventory().getItem(indexCol, indexRow);
        this.getInventory().removeItem(indexCol, indexRow);
        placeTo.getInventory().addItem(indexCol, temp);
    }
    
    /**
     * Add gold to itemholder from inventory, and remove it from inventory.
     * @param goldAmount
     * @param placeTo
     */
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
     *equip weapon if no active weapon, else replace weapon with the one being equipped.
     * @param indexRow
     */
    public void equipWeapon(int indexRow){
        if (this.equipped.getActiveWeapon() == null){
            this.equipped.setActiveWeapon(this.inventory.getWeaponList().get(indexRow));
            this.inventory.removeItem(1, indexRow);
        } else {
            this.inventory.addItem(1, this.equipped.getActiveWeapon());
            this.equipped.setActiveWeapon(this.inventory.getWeaponList().get(indexRow));
            this.inventory.removeItem(1, indexRow);
        }
    }
    
    /**
     *equip armor if no active armor, else replace armor with the one being equipped.
     * @param indexRow
     */
    public void equipArmor(int indexRow){
        if (this.equipped.getActiveArmor() == null){
            this.equipped.setActiveArmor(this.inventory.getArmorList().get(indexRow));
            this.inventory.removeItem(2, indexRow);
        } else {
            this.inventory.addItem(2, this.equipped.getActiveArmor());
            this.equipped.setActiveArmor(this.inventory.getArmorList().get(indexRow));
            this.inventory.removeItem(2, indexRow);
        }
    }

    /**
     **calculate attack damage: if equipped weapon dmg > total armor of reciever = deal base dmg + (weapon attack damage - total armor) 
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
        
        System.out.println(character.getName() + " Takes " + dmg + " damage!");

    }

}

