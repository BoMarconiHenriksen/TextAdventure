package TextAdventure;

import java.util.ArrayList;

/**
 *  Klassen holder inventory for spilleren og for rummene.
 * @since 2.0
 */
public class Inventory {
    //private Item[] items = new Item[4];
    private ArrayList<ArrayList> items = new ArrayList<>();
    private ArrayList<Gold> gold = new ArrayList<>();
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<Potion> potions = new ArrayList<>();
    private ArrayList<Armor> armor = new ArrayList<>();
    
    //Filling inventory auto
    public Inventory() {
        items.add(this.gold);
        items.get(0).add(new Gold("Gold",0,1));
        items.add(weapons);
        items.add(armor);
        items.add(potions);
    }
    
    public ArrayList<ArrayList> getItemsList() {
        return items;
    }

    public ArrayList<Gold> getGoldList() {
        return gold;
    }

    public ArrayList<Weapon> getWeaponList() {
        return weapons;
    }

    public ArrayList<Potion> getPotionList() {
        return potions;
    }

    public ArrayList<Armor> getArmorList() {
        return armor;
    }

    public Item getSpecItem(int indexCol, int indexRow) {
        return (Item) items.get(indexCol).get(indexRow);
    }
    
    public void removeSpecItem(int indexCol, int indexRow) {
        items.get(indexCol).remove(indexRow);
    }

    public void addSpecItem(int indexCol, Item item) {
        items.get(indexCol).add(item);
    }
    
}

