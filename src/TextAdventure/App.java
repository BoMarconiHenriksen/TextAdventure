package TextAdventure;

import Controllers.MainController;

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
        MainController controller = new MainController();
        controller.start();
        //controller.test();
    }
    
}
