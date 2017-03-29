package TextAdventure;

import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Simple highscore history, written to a .txt file.
 *
 * @author awha8
 */
public class Highscore {

    private final String FILENAME = "highscore.txt";
    private final File FILE = new File(FILENAME);

    //CHECK IF HIGHSCORE FILE EXIST
    /**
     * Check if "highscore.txt" exists.
     *
     * @return true if so.
     */
    public boolean highscoreExist() {
        return FILE.exists();
    }

    //READ HIGHSCORE
    /**
     * prints recorded highscores from "highscore.txt" to console.
     *
     * @throws Exceptions for FileNotFoundException
     */
    public void getHighscore() throws Exceptions {
        try (Scanner sc = new Scanner(FILE)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            //Exception handling
        } catch (java.io.FileNotFoundException e) {
            throw new Exceptions("Highscore.txt file not found");
        }
    }

/**
 * 
 * @return current timestamp
 */
    public String timestamp() {
        //time stamp
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(date);
        return formattedDate; // 12/01/2011 4:48:16 PM

    }
    //[if none found] CREATE NEW HIGHSCORE FILE & APPEND ENTRY
    /**
     * Appends parameters "to highscore.txt" as newline - syntax "playerName :
     * gold"
     *
     * @param playerName
     * @param gold
     * @throws Exceptions for IOExceptions
     */
    public void setHighscore(String playerName, int gold) throws Exceptions {

        String timestamp = timestamp();  
        String lineToAppend = playerName+ " : " +gold+ " : " +timestamp;

        try {
            FileWriter fw = new FileWriter(FILENAME, true);  //true = append
            PrintWriter pWriter = new PrintWriter(fw);
            pWriter.println(lineToAppend);
            pWriter.close();

            //Exception handling
        } catch (IOException e) {
            throw new Exceptions("Error writing highstore to file. File might be protected..");

        }
    }
 public void clearHighscore() throws Exceptions {
        try {
            FileWriter fw = new FileWriter(FILENAME);
            fw.write("");
            fw.close();
            //Exception handling
        } catch (IOException e) {
            throw new Exceptions("Error writing highscore to file. File might be protected..");
        }

    }
}
