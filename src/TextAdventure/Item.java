/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author Mellem
 */
public interface Item {

    @Override
    public String toString();
    
    public void pickUp();
    public String getType();
    

    public void setAmount(int amount);
    public int getAmount();
    
}