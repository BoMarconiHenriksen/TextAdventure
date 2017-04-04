/**
* <h1>Text Adventure Game</h1>
* Analysis, design and implementation of a textual adventure game (TAG). A TAG
* is a dungeon described in text only.
* 
* <h2>Single player dungeon</h2>
* We have designed and implement an application that create a small dungeon, 
* single player dungeon game. There is no graphics handling.
* 
* <h2>The game</h2>
* The player can walk and some places portal through the dungeon by issuing 
* text commands. Its possible to find gold, items, potions and armor, and you 
* can encounter traps in the rooms.
* 
* <h2>Version</h2>
* Version 1.0 = milestone 1.
* Version 2.0 = milestone 2.
* Version 3.0 = milestone 3.
* 
* @author Alexander W. Hørsted-Andersen
* @author Anders Hedegaard Christiansen
* @author Mikkel Emil Larsen
* @author Bo Henriksen
* 
* @version 2.0
* 
*/
package TextAdventure;

/**
 * App initierer start i controlleren.
 * @since 1.0
 */
public class App {

    /**
     * @param args the command line arguments
     * @since 1.0
     */
    public static void main(String[] args) {
        Controller controller = new Controller();
        //controller.start();
        controller.test();
    }
    
}
