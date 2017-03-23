/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure01;

/**
 *
 * @author bo_ma
 */
public class Player {
    
    private int gold;
    private int health = 100;
    private String name;
    private Room currRoom = null; //Nuværende rum player befinder sig i

    
    public Player(int gold, String name) {
        this.gold = gold;
        this.name = name;
    }

    public Player() {}

    public int getPlayerGold() {
        return gold;
    }

    public void setPlayerGold(int gold) {
        this.gold = gold;
    }
    
    // Tilføjer guld til player og tager guld fra rum
    public int takeGold(Room room) {
        int temp = this.gold;
        this.gold += room.getRoomGold();
        room.setRoomGold(0);
        return this.gold - temp;
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


