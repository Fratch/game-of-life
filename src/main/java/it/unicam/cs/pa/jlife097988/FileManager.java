package it.unicam.cs.pa.jlife097988;

import it.unicam.cs.pa.jlife097988.Model.Board;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileManager {

    /**
     * @param content stringa da salvare
     * @param file    file nel quale scrivere la stringa
     */
    public void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    /**
     * @param table board contenente le cellule da salvare nel file.
     * @return stringa che indica le cellule da salvare.
     */
    public String cellToTxt(Board table) {
        StringBuilder coords = new StringBuilder();
        for (int c = 0; c < table.getBoardWidth(); c++) {
            for (int r = 0; r < table.getBoardHeight(); r++) {
                if (table.getCell(c, r).isAlive()) {
                    coords.append("<x").append(c).append(">")
                            .append("<y").append(r).append(">")
                            .append(System.lineSeparator())
                            .toString();
                }
            }
        }
        return coords.toString();
    }

    /**
     * Applica alla board le cellule indicate nel file
     *
     * @param file dal quale leggere una serie di coordinate di cellule
     */
    public void ReadFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {

                    int posX = Integer.parseInt(coordXReader(line));
                    int posY = Integer.parseInt(coordYReader(line));

                    Main.board.getCell(posX, posY).setNewState(true);

                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @param line Stringa contenente le coordinate di una cellula
     * @return result coordinata posX in stringa
     */
    public String coordXReader(String line) {
        Pattern p = Pattern.compile("(?<=<x)(\\d+)(?=>)");
        Matcher m = p.matcher(line);
        String result = "";
        if (m.find()) {
            result = m.group();
        }
        return result;
    }


    /**
     * @param line Stringa contenente le coordinate di una cellula
     * @return result coordinata posY in stringa
     */
    public String coordYReader(String line) {
        Pattern p = Pattern.compile("(?<=<y)(\\d+)(?=>)");
        Matcher m = p.matcher(line);
        String result = "";
        if (m.find()) {
            result = m.group();
        }
        return result;
    }

}
