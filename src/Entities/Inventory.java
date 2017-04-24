package Entities;

import java.util.ArrayList;

/**
 * Class contains Inventory of Player and Room
 * @since 2.0
 */
public class Inventory{
    private ArrayList<ArrayList> items = new ArrayList<>();
    private ArrayList<Gold> gold = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Potion> potions = new ArrayList<>();
    private ArrayList<Armor> armor = new ArrayList<>();
    
    /**
     *Creates empty inventory with empty "gold" object
     */
    public Inventory() {
        items.add(this.gold);
        items.get(0).add(new Gold("Gold",0,1));
        items.add(weapons);
        items.add(armor);
        items.add(potions);
    }
    
    /**
     * for JUnit testing
     */
    public Inventory(int goldAmount) {
        items.add(this.gold);
        items.get(0).add(new Gold("Gold",goldAmount,1));
        items.add(weapons);
        items.add(armor);
        items.add(potions);
    }
    
    public ArrayList<ArrayList> getItemsList() {
        return items;
    }
    
    public ArrayList<Item> getSpecItemList(int indexCol) {
        return items.get(indexCol);
    }

    public ArrayList<Weapon> getWeaponList(){
        return items.get(1);
    }
    
    public ArrayList<Armor> getArmorList(){
        return items.get(2);
    }
    
    public ArrayList<Potion> getPotionList(){
        return items.get(3);
    }
    
    /**
     * Gets item at object specific paramterer location
     * @param indexCol
     * @param indexRow
     * @return 
     */
    public Item getItem(int indexCol, int indexRow) {
        return (Item) items.get(indexCol).get(indexRow);
    }
    
    /**
     *remove item object at specific parameter location
     * @param indexCol
     * @param indexRow
     */
    public void removeItem(int indexCol, int indexRow) {
        items.get(indexCol).remove(indexRow);
    }

    /**
     * Add item object at specific paramterer location
     * @param indexCol
     * @param item
     */
    public void addItem(int indexCol, Item item) {
        items.get(indexCol).add(item);
    }
    /**
     * Total weight of all inventory items
     * @return 
     */
    public int getTotalWeight() {
        int weightCounter = 0;
        weightCounter = gold.get(0).getAmount() * gold.get(0).getWeight();
        
        if (!(weapons.isEmpty())) {
            for (Weapon i : weapons) {
               weightCounter += i.getWeight();
            }
        }
        if (!(armor.isEmpty())) {
            for (Armor i : armor) {
               weightCounter += i.getWeight();
            }
        }
        if (!(potions.isEmpty())) {
            for (Potion i : potions) {
               weightCounter += i.getWeight();
            }
        }
        
        return weightCounter;
    }
    
    public Gold getGold() {
        return gold.get(0);
    }

    public Weapon getWeapon(int indexRow) {
        return weapons.get(indexRow);
    }

    public Potion getPotion(int indexRow) {
        return potions.get(indexRow);
    }

    public Armor getArmor(int indexRow) {
        return armor.get(indexRow);
    }
    
}

