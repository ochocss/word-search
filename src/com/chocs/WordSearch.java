package com.chocs;

import java.io.*;

public class WordSearch {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\ADM\\IdeaProjects\\word-search\\txts-folder"); //where the files will be
        File[] fileArray = folder.listFiles();

        String search = "a";
        String line = "";

        if(fileArray != null) {
            for (int i = 0; i < fileArray.length; i++) {
                int countLine = 0;

                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileArray[i]));

                    try {
                        while ((line = br.readLine()) != null) {
                            String[] words = line.split(" ");
                            countLine++;

                            for (String word : words) {
                                if (word.equals(search)) {
                                    System.out.println(fileArray[i].getName() + " contains " + word + " at line " + countLine);
                                }
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Error reading file");
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File not found");
                    throw new RuntimeException(e);
                }
            }
        } else {
            System.out.println("There are no files in folder");
        }

    }
}