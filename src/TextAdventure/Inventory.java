package TextAdventure;

import java.util.ArrayList;

/**
 *  Klassen holder inventory for spilleren og for rummene.
 * @since 2.0
 */
public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();
    
    //Filling inventory auto
    public Inventory() {
        items.add(new Gold(0));
        items.add(new Weapon(0));
        items.add(new Armor(0));
        items.add(new Potion(0));
    }
    
    //Filling inventory auto, but gold manually
    public Inventory(int goldAmount) {
        items.add(new Gold(goldAmount));
        items.add(new Weapon(0));
        items.add(new Armor(0));
        items.add(new Potion(0));
    }
    
    //Filling inventory manually
    public Inventory(int goldAmount, int weaponAmount, int armorAmount, int potionAmount) {
        items.add(new Gold(goldAmount));
        items.add(new Weapon(0));
        items.add(new Armor(0));
        items.add(new Potion(0));
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        this.items.add(item);
    }
    
//    public void removeItem(String str) {
//        for (Item i : items) {
//            if (i.getType().equals(str)) {
//                items.remove(i);
//            }
//        }
//    }

    public int getItemAmount(int index) {
        return items.get(index).getAmount();
    }
    
    public void setItemAmount(int index ,int amount) {
        items.get(index).setAmount(amount);
    }
    
}

