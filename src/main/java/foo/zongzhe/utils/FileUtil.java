package foo.zongzhe.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUtil {
    public static void main(String[] args) {

    }

    public static ArrayList<String> readFile(String path) {
        ArrayList<String> fileContent = new ArrayList<>();
        File file = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found in " + path);
            e.printStackTrace();
        }
        InputStreamReader reader = new InputStreamReader(is);
        Scanner s = new Scanner(reader); //.useDelimiter("\t");
        while (s.hasNextLine()) {
            fileContent.add(s.nextLine());
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileContent;
    }
}
