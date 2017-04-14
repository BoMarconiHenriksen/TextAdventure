package TextAdventure;
import java.io.*;

/**
 *  Klassen gemmer dit spil.
 * @since 3.0
 */
public class Savegame {

    private Player player;
    private DungeonConstructor dc;

    /**
     *
     * @param player
     * @param dc
     */
    public void save(Player player, DungeonConstructor dc) {
        try {
            FileOutputStream fileOut = new FileOutputStream("save.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.writeObject(dc);
            out.close();
            fileOut.close();
            System.out.println("Game is saved in save.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void getSaveData() {
        Player player;
        DungeonConstructor dc;
        try {
            FileInputStream fileIn = new FileInputStream("save.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.player = (Player) in.readObject();
            this.dc = (DungeonConstructor) in.readObject();
            in.close();
            fileIn.close();

            //sætter klassens objekter til de de i metoden fundne..
            setTempPlayer(this.player);
            setTempDc(this.dc);

        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Data class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized " + getPlayer().toString() + " AND " + getDc().toString() + " succesfully!");

    }

    public Player getPlayer() {
        return player;
    }

    public void setTempPlayer(Player tempPlayer) {
        this.player = tempPlayer;
    }

    public DungeonConstructor getDc() {
        return dc;
    }

    public void setTempDc(DungeonConstructor tempDc) {
        this.dc = tempDc;
    }

}
