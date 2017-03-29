/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author awha8
 */
public class Main {

    public static void main(String[] args) throws Exceptions {

        Highscore hs = new Highscore();
        
        //METODER
        
        //sethighscore
        //hs.setHighscore(player.getName(), player.getPlayerItemAmount(0));
        hs.setHighscore("test", 100);
        
        
        //boolean check
        hs.highscoreExist();
        
        //
        hs.getHighscore();
        
    }

}
