package ua.lpnuai.oop.petrov02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    static LabOneCollection collector = new LabOneCollection();

    public static void main (String[] args) throws IOException {
        LabOneCollection testVariable = new LabOneCollection();
        Scanner in = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String consoleInput = "";
        String containsTest;
        int num;

        while (!consoleInput.equals("-exit")){

            consoleInput = in.next();

            switch (consoleInput){
                case "-input":
                    inputTest();
                    break;
                case  ".clear":
                    collector.clear();
                break;
                case ".toString":
                    System.out.println(collector.toString());
                break;
                case ".contains":
                    System.out.println("Type the string you want to check");
                    containsTest = input.readLine();
                    System.out.println("The collection contains \""+containsTest +"\" is " +collector.contains(containsTest));
                break;

                case ".size":
                    System.out.println(collector.size());
                break;

                case ".remove":
                    System.out.println("Type the string you want to remove");
                    containsTest = input.readLine();
                    System.out.println(containsTest);
                    System.out.println(collector.remove(containsTest));
                break;

                case ".containsAll":
                    System.out.println("How big collection you want to type to check");
                    num = in.nextInt();
                    System.out.println("Print collection");
                    for (int i = 0; i < num; i++) {
                        testVariable.add(input.readLine());
                    }
                    System.out.println("Is it contains the collection =" +collector.containsAll(testVariable));
                break;

                case "-forEach":
                    collector.forEach(System.out::println);
                break;

                case ".toArray":
                    Object[] arrayTest = collector.toArray();
                    for (int i = 0; i < arrayTest.length; i++) {
                        System.out.println(arrayTest[i]);
                    }
                break;

                case ".save":
                    collector.save();
                break;

                case ".load":
                    collector.load();
                break;

                case"-help":
                    System.out.println("-input\n" +
                            ".clear\n" +
                            ".toString\n" +
                            ".contains\n" +
                            ".size\n" +
                            ".remove\n" +
                            ".containsAll\n" +
                            "-forEach\n" +
                            ".toArray\n" +
                            ".save\n" +
                            ".load\n" +
                            "-exit\n");

            }
        }








//        collector.clear();
//
//        System.out.println("After .clear \n"+collector.toString());
//
//        collector.add("Hello");
//        collector.add("None at all");
//        collector.add("Make");
//        collector.add("The first 2");
//        collector.add("Here is 22 ");
//        collector.add("Lought ");
//
//        System.out.println("contains(\"Make\") = "+collector.contains("Make"));
//
//        System.out.println("Size of the collection =" +collector.size());

//       collector.remove("Hello");
//
//      System.out.println("After removing \"Hello\""+collector.toString());

//        for (int i = 0; i < collector.size(); i++) {
//            test.add(collector.container[i], );
//        }

//        collector.clear();
//        collector.add("Hello");
//        collector.add("None at all");
//        collector.add("Make");
//        collector.add("The first 2");
//        collector.add("Here is 22");
//        collector.add("Lought");


//        testVariable.add("Hello");
//        testVariable.add("None at all");
//        testVariable.add("Make");
//        testVariable.add("The first 2");
//        testVariable.add("Here is 22");
//        testVariable.add("Lought");

//System.out.println(collector.containsAll(testVariable));
//String jojo = "jojo";
//String jo = "jo";
//
//System.out.println("Here is "+jojo.contains(jo));
//System.out.println("So " +collector.containsAll(testVariable));


    }

    static void inputTest() throws IOException {
        Scanner in = new Scanner(System.in);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num;
        System.out.println("Input the number of lines");

        num = in.nextInt();

        for (int i = 0; i < num; i++) {
            collector.add(input.readLine());
        }
    }

}
