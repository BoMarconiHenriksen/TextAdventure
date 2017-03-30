package TextAdventure;

import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * Simple highscore history, written to a .txt file.
 *
 * @author awha8
 */
public class Highscore {

    private final Display display;
    private final String FILENAME = "highscore.txt";
    private final File FILE = new File(FILENAME);

    public Highscore(Display display){
        this.display = display;
    }
    
    /**
     * prints recorded highscores from "highscore.txt" to console.
     *
     * @throws Exceptions for FileNotFoundException
     */
    public void getHighscore() {
        System.out.println("Highscore:");
        try (Scanner sc = new Scanner(FILE)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
            //Exception handling
        } catch (java.io.FileNotFoundException e) {
            display.errorFileNotFound();
        }
    }

    /**
     *
     * @return current timestamp
     */
    public String timestamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    //[if none found] CREATE NEW HIGHSCORE FILE & APPEND ENTRY
    /**
     * Appends parameters "to highscore.txt" as newline - syntax "gold :
     * playername : timestamp"
     *
     * @param playerName
     * @param gold
     */
    public void setHighscore(String playerName, int gold) {

        String timestamp = timestamp();
        String lineToAppend = gold + " | " + playerName + " | " + timestamp;

        try {
            FileWriter fw = new FileWriter(FILENAME, true);  //true = append
            PrintWriter pWriter = new PrintWriter(fw);
            pWriter.println(lineToAppend);
            pWriter.close();
            this.sortHighscore();
            //Exception handling
        } catch (IOException e) {
            display.errorIOException();
        }
    }

    /**
     * Clear all highscores from highscore.txt
     *
     * @throws Exceptions for IOExceptions
     */
    public void clearHighscore() {
        try {
            FileWriter fw = new FileWriter(FILENAME);
            fw.write("");
            fw.close();
            //Exception handling
        } catch (IOException e) {
            display.errorIOException();
        }

    }

    /**
     * DESCRIPTION HERE
     *
     * @param FILE
     * @throws Exceptions
     */
    public void sortHighscore() {

        ArrayList<String> lineList = new ArrayList<>();

        try (Scanner sc = new Scanner(FILE)) {
            //add each line from highscore file to ArrayList
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineList.add(line);
            }
        } catch (FileNotFoundException e) {
            display.errorFileNotFound();
        }
        //sort ArrayList in reverse order (high to low).
        Collections.sort(lineList, Collections.reverseOrder());

        //write ArrayList to highscore file
        try {
            FileWriter fw = new FileWriter(FILENAME, true);  //true = append
            PrintWriter pWriter = new PrintWriter(fw);
            //clear highscore.txt from old entries
            clearHighscore();
            //write new entries to highscore.txt
            for (String string : lineList) {
                pWriter.println(string);
            }
            pWriter.close();

        } catch (IOException e) {
            display.errorIOException();
        }
    }

}
