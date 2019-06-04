package sample;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Serialization {

    public static void XMLEncoder (Object file, File filePath) throws FileNotFoundException {

        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)
                )
        );
        encoder.writeObject(file);
        encoder.close();
        System.out.println("Object was saved to file in "+ filePath);
    }

    public static Object XMLDecoder(File filePath) throws FileNotFoundException {

        System.out.println(filePath);
        XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(filePath)
                )
        );
        Object output = decoder.readObject();
        decoder.close();
        System.out.println("File was read from "+ filePath);
        return output;
    }

    public static void createFile(String filePath){
        try {
            System.out.println(filePath);
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nFile name with type: ");
            String fileName = input.readLine();
            if (fileName.isEmpty() || fileName == "")
                fileName = "test.xml";
           // if (filePath[filePath.length() -1] != "")
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath + fileName)
                    )
            );
            encoder.close();
            System.out.println("File was created in" + filePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ls(String folderName) {
        if (Files.exists(Paths.get(folderName))) {
            File folder = new File(folderName);
            File[] listOfFiles = folder.listFiles();

            System.out.println("\t"+ folder.getAbsolutePath());

            for (int i = 0; i < listOfFiles.length; i++) {
                System.out.println(listOfFiles[i].getName());
            }
        }else
            System.out.println("There is no such directory");
    }

    public static void dir(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String filePath = null, fileName;
        System.out.print("\nDir: ");
        try {
            filePath = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Serialization.ls(filePath);
    }

    public static void saveFile(String filePath, Object object){
        try {
            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("There is no such directory");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(object);
            outputStream.flush();
            outputStream.close();
            fileOutputStream.close();

            System.out.println("File was saved to "+ filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object loadFile(String filePath){
        try {
            if (!Files.exists(Paths.get(filePath))) {
                System.out.println("There is no such directory");
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object readObject = objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("Object was read from "+ filePath);
            return readObject;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
