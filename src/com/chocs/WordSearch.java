package com.chocs;

import java.io.*;
import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\ADM\\IdeaProjects\\word-search\\txts-folder"); //where the files will be
        File[] fileArray = folder.listFiles();

        String search = "a";
        String line = "";

        if (fileArray == null) {
            System.out.println("There are no files in folder");
            System.exit(69);
        }

        for (File file : fileArray) {
            System.out.println();

            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr))
            {
                for (int countLine = 1; (line = br.readLine()) != null; countLine += 1)
                {
                    if(Arrays.asList(line.split(" ")).contains(search)) {
                        System.out.println(file.getName() + " contains '" + search + "' at line " + countLine);
                    }
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}