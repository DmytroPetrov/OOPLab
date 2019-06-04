package ua.lpnuai.oop.petrov03;

import com.sun.source.tree.IfTree;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static ArrayList<PersonInfo> personInfo = new ArrayList<>();
    public static ArrayList<PersonInfo> testPersonInfo = new ArrayList<>();
    public static int num =0;
    public static String path = "BeanArchive.xml";
    static  String DEFAULT_DIR = "C:\\Users\\PC\\Dropbox\\Семестр 2\\OOP\\Java\\petrov-dmytro\\src";

    public static void main(String[] args) throws IOException, ParseException {

        Scanner in = new Scanner(System.in);
        String consoleInput = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String filePath ="", fileName = "";

        while (!consoleInput.equals("exit")){
            consoleInput = in.next();

            switch (consoleInput){

                case "help":
                    System.out.println("dir — set path\n" +
                            "save — save .xml file\n" +
                            "load — load .xml file\n" +
                            "help — print all commands\n" +
                            "add — add new element\n");
                    break;

                case "add":
                    add();
                    break;

                case "dir":
                    System.out.print("\nDir: ");
                    filePath = input.readLine();
                    if (filePath.isEmpty())
                        Test.ls(path);
                    else
                        Test.ls(filePath);
                    break;

                case "save":
                    System.out.print("\nFile name: ");
                    fileName = input.readLine();
                    if (Files.exists(Paths.get(filePath +"\\"+ fileName))) {
                        XMLencoder(filePath +"\\"+ fileName);
                    }else
                        System.out.println("There is no such file/directory");
                    break;

                case "load":
                    System.out.print("\nFile name: ");
                    fileName = input.readLine();
                    if (Files.exists(Paths.get(filePath + fileName))) {
                        XMLDecoder(filePath + fileName);
                    }else {
                        System.out.println("File was not found");
                        XMLDecoder(path);
                    }
                    break;

                case "print":
                    for (int i = 0; i < personInfo.size(); i++) {
                        personInfo.get(i).print();
                    }
                    break;

                case "cl":
                    personInfo.clear();
                    break;

                case "addf":
                    if(filePath.isEmpty() || filePath == "")
                            filePath = DEFAULT_DIR;
                    System.out.println("Name of your file is:");
                    fileName = input.readLine();
                    createFile(filePath+"\\"+fileName);
                    System.out.println("Was Saved to " + filePath);

                break;

            }
        }

//
    }

    public static void XMLencoder (String filePath) throws FileNotFoundException {
        System.out.println(filePath);
        XMLEncoder encoder = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream(filePath)
                )
        );
        encoder.writeObject(personInfo);
        encoder.close();
    }

    public static void XMLDecoder(String filePath) throws FileNotFoundException {

        System.out.println(filePath);
        XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(filePath)
                )
        );
        personInfo = (ArrayList<PersonInfo>) decoder.readObject();

        decoder.close();
//        for (int i = 0; i < personInfo.size(); i++) {
//            personInfo.get(i).print();
//        }
    }

    public static void add() throws IOException, ParseException {
        PersonInfo onePerson = new PersonInfo();
        String[] name = new String[3];
        Vector<String> phoneNumber = new Vector<>();
        String address;
        Date birthDate;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        num++;

        System.out.println("Filling the person info");
        System.out.print("\nYour name: ");
        for (int i = 0; i < 3; i++) {
            if (i == 1)
                System.out.print("\nYour subname: ");
            if (i == 2)
                System.out.print("\nYour last name: ");
            name[i] = input.readLine();
        }

        System.out.print("Your birth date dd-MM-yyyy : ");
        String stringDate = input.readLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        birthDate = format.parse(stringDate);

        System.out.print("\nYour address: ");
        address = input.readLine();

        System.out.println("Your phone numbers:");
        for (int i = 0, n = 1; i < n; i++) {

            int chek;
            phoneNumber.add(i, input.readLine());
            System.out.println(phoneNumber.get(i));
            if (phoneNumber.get(i).length() != 10)
            {
                System.out.println("Number length is not correct");
                phoneNumber.remove(i);
                i--;

            }
            else{
                System.out.println("1 — add number" +
                        "\n2— end adding numbers");
                chek = Integer.parseInt(input.readLine());
                if (chek == 1)
                    ++n;
            }
        }

        onePerson.fill(name, birthDate, phoneNumber, address);
        personInfo.add(onePerson);
    }

    public static void createFile(String filePath){
        try {
            System.out.println(filePath);
            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(
                            new FileOutputStream(filePath)
                    )
            );
            encoder.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();

        }
    }
}