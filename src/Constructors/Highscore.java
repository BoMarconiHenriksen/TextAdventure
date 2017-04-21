package Constructors;

import Entities.Player;
import TextAdventure.Display;
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
 * 
 */
public class Highscore {

    private final Display display;
    private final String FILENAME = "highscore.txt";
    private final File FILE = new File(FILENAME);

    /**
     *
     * @param display
     */
    public Highscore(Display display) {
        this.display = display;
    }

    /**
     * prints recorded highscores from "highscore.txt" to console.
     *
     */
    public void getHighscore() {
        System.out.println("\tHIGHSCORES:");
        System.out.println("#  GOLD   NAME\t  DATE");
        
        int posCounter = 1;
        try (Scanner sc = new Scanner(FILE)) {
        
            while (sc.hasNextLine()) {
                String line = posCounter + "  " + sc.nextLine();
                posCounter +=1;
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
     * Appends parameters "to highscore.txt" as newline. syntax "gold :
     * playername : timestamp"
     *
     * @param player
     */
//    public void setHighscore(String playerName, int gold) {
    public void setHighscore(Player player) {

        String timestamp = timestamp();
        String lineToAppend = player.getInventory().getGoldList().get(0).getAmount() + " " + player.getName() + " " + timestamp;

        try {
            FileWriter fw = new FileWriter(FILENAME, true);  //true = append
            PrintWriter pWriter = new PrintWriter(fw);
            pWriter.println(lineToAppend);
            pWriter.close();
            
        } catch (IOException e) {
            display.errorIOException();
        }
    }

    /**
     * Clear all highscores from highscore.txt
     *
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
     * Tilføjer linjer fra highscore.txt til arraylist
     * Sætter score syntax til 3 cifre for hver linje
     * Sender linjerne tilbage til arraylist
     * Sorterer arraylist efter højeste score (reverse)
     * Sletter teksten i highscore.txt
     * Skriver linjerne tilbage til textfilen
     */
    public void sortHighscore() {

        ArrayList<String> lineList = new ArrayList<>();

        try (Scanner sc = new Scanner(FILE)) {
            //add each line from highscore file to ArrayList
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                //appending "0" (zero) to score, if score <3 digits.
                String[] temp = line.split(" ");
                String temp2 = temp[0];
                String newString = "";

                int counter = temp2.length();
                while (counter < 3) {
                    newString += "0";
                    counter++;
                }
                newString += temp[0] + " " + temp[1] + " " + temp[2];
                line = newString;

                //adding line back to arraylist
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
