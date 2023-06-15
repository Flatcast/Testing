package Part1;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


public class Praktikum {
    public static void main(String[] args) {
        String path = "";
        for (int i = 1; i <= 3; i++) {
            path = "C:\\Users\\gavrilov.DE\\IdeaProjects\\Testing\\src\\Part1\\m.2023.0" + i + ".csv";

            String fileContent = readFile(path);
            assert fileContent != null;
            String[] lines = fileContent.split("\\r\\n");
            for (int j = 0; j < lines.length; j++) {
                String[] linesOut = lines[j].split(",");
                System.out.println(Arrays.toString(linesOut));
            }
        }
    }
        public static String readFile (String path){
            try {
                return Files.readString(Path.of(path));
            } catch (IOException e) {
                System.out.println("No file");
                return null;
            }
        }
    }




