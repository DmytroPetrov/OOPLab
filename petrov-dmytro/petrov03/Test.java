package ua.lpnuai.oop.petrov03;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args){
//        Test tf = new Test();
//        tf.ls("E:/");4
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null, fileName;
        System.out.print("\nDir: ");
        try {
            filePath = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Test.ls(filePath);
    }

    public static void ls(String folderName) {
        if (Files.exists(Paths.get(folderName))) {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();

            System.out.println(folder.getAbsolutePath());

            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles[i].getName());
            }
        }else
            System.out.println("There is no such directory");
    }
}
