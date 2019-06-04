package ua.lpnuai.oop.petrov04;

import ua.lpnuai.oop.petrov03.PersonInfo;
import ua.lpnuai.oop.petrov05.RegExp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        LinkedList<PersonInfo> personInfoLinkedList = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        String consoleInput = "";
        String path = "";
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-auto")){
                path = "C:\\Users\\PC\\Dropbox\\Семестр 2\\OOP\\Java\\petrov-dmytro\\src\\ua\\lpnuai\\oop\\petrov04\\src\\test.xml";
                personInfoLinkedList = (LinkedList<PersonInfo>) Serialization.XMLDecoder(path);
                PersonInfo delete = (PersonInfo) personInfoLinkedList.getHead().data;




                System.out.println("_________ForEach____________");

                personInfoLinkedList.forEach(System.out::println);

                System.out.println("*********Deleting***********");
                
                personInfoLinkedList.delete(delete);

                System.out.println(personInfoLinkedList.toString());

                personInfoLinkedList.clear();
                System.out.println("________________That's clearing___________________________");
                personInfoLinkedList.print();
                System.out.println("_______________Here should be nothing______________________");

                personInfoLinkedList = (LinkedList<PersonInfo>) Serialization.XMLDecoder(path);

                Object[] objects = new Object[personInfoLinkedList.getSize()];
                objects = personInfoLinkedList.toArray();
                for (int y = 0; y < objects.length; y++) {
                    System.out.println("=======================================");
                    System.out.println(objects[y]);
                }

                return;
            }
        }

        while (!consoleInput.equals("exit")){
            consoleInput = in.next();

            switch (consoleInput){
                case "add":
                    personInfoLinkedList.Insert(add());
                break;

                case "forEach":
                    personInfoLinkedList.forEach(System.out::println);
                break;

                case "xmle":
                    path = input.readLine();
                    Serialization.XMLEncoder(personInfoLinkedList, path);
                break;

                case "xmld":
                    path = input.readLine();
                    personInfoLinkedList = (LinkedList<PersonInfo>) Serialization.XMLDecoder(path);
                break;

                case "save":
                    path = input.readLine();
                    Serialization.saveFile(path, personInfoLinkedList);
                break;

                case "load":
                    path = input.readLine();
                    personInfoLinkedList = (LinkedList<PersonInfo>) Serialization.loadFile(path);
                break;

                case "delete":
                    String name = "";
                    PersonInfo delete;
                    Object[] array = personInfoLinkedList.toArray();

                    System.out.println("Filling the person info");
                    System.out.print("\nYour name: ");
                    for (int i = 0; i < 3; i++) {
                        if (i == 1)
                            System.out.print("\nYour subname: ");
                        if (i == 2)
                            System.out.print("\nYour last name: ");
                        name += input.readLine();
                        if (i != 2)
                            name += "\t";
                    }

                    System.out.println(name);

                    for (int i = 0; i < array.length; i++) {
                        if (array[i].toString().contains(name))
                            personInfoLinkedList.delete((PersonInfo) array[i]);
                    }
                    
                    //personInfoLinkedList.delete(delete);
                break;

                case "cl":
                    personInfoLinkedList.clear();
                    System.out.println("List was cleared");
                break;

                case "toarray":
                    Object[] objects = new Object[personInfoLinkedList.getSize()];
                    objects = personInfoLinkedList.toArray();
                    for (int i = 0; i < objects.length; i++) {
                        System.out.println("=======================================");
                        System.out.println(objects[i]);
                    }

                break;

                case "tostr":
                    System.out.println(personInfoLinkedList.toString());
                break;

                case "find":
                    PersonInfo search = add();

                    System.out.println("This object here is "+ personInfoLinkedList.find(search));
                break;

                case "addf":
                    path = input.readLine();
                    Serialization.createFile(path);
                break;

                case "test":
                    /*PersonInfo personInfo = add();
                    Serialization.XMLEncoder(personInfo, "C:\\Users\\PC\\Dropbox\\Семестр 2\\OOP\\Java\\petrov-dmytro\\src\\ua\\lpnuai\\oop\\petrov04\\src\\onePers.xml");*/
                    String regTest = input.readLine();
                    System.out.println(RegExp.isBirthDate(regTest));
                break;
            }
        }


        System.out.println("____________________________Test________________________________________");


//        ua.lpnuai.oop.petrov03.Main.createFile(path);
//        Serialization.createFile(path);
//

//        System.out.println(personInfoLinkedList.toString());



System.out.println("________________________________________________________________________");
        /*for (int i = 0; i < personInfos.length; i++) {
            personInfos[i].print();
        }*/
//        for (LinkedList:list) {
//            System.out.println(list);
//        }

    }

    public static PersonInfo add() throws IOException, ParseException {
        PersonInfo onePerson = new PersonInfo();
        String[] name = new String[3];
        Vector<String> phoneNumber = new Vector<>();
        String address;
        Date birthDate;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

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
        String stringDate = "";
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; !RegExp.isBirthDate(stringDate); i++) {
            if (i != 0)
                System.out.println("The wrong Date format");
            stringDate = input.readLine();
        }
        birthDate = format.parse(stringDate);

        System.out.print("\nYour address: ");
        address = input.readLine();

        System.out.println("Your phone numbers:");

        for (int i = 0, n = 1; i < n; i++) {

            int check;
            String numTest = "";
            for (int y = 0; !RegExp.isNumber(numTest); y++) {
                if (y != 0)
                    System.out.println("The number length is incorrect.");

                numTest = input.readLine();
            }
            phoneNumber.add(i, numTest);

            System.out.println("1 — add number" +
                    "\n2— end adding numbers");
            check = Integer.parseInt(input.readLine());
            if (check == 1)
                ++n;

        }

        onePerson.fill(name, birthDate, phoneNumber, address);

        return onePerson;
    }

}
