package cs.sdsu.edu;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {

    protected static void search(String path) {
        File root = new File(path);
        File [] list = root.listFiles();

        if (list == null) return;

        for (File f : list){
            if(f.isDirectory()){
                search(f.getAbsolutePath());
            }
            else{
                if (f.getName().endsWith(".txt") || (f.getName().endsWith(".java") && !f.getName().endsWith(".stats"))){
                    System.out.println(f.getAbsoluteFile());
                }
            }

        }
    }
    public static List<String> readFileInList (String fileName){
        List<String> lines = Collections.emptyList();
        try{
            lines = Files.readAllLines(Paths.get(fileName));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return lines;
    }
    public static void main(String[] args) throws IOException {
        App search = new App();
        App.search("/Users/");
    }
}
