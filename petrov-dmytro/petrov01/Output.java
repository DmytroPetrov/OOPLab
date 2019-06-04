package ua.lpnuai.oop.petrov01;

//import java.util.Scanner;

//import static ua.lpnuai.oop.petrov01.Main.lines;
import static ua.lpnuai.oop.petrov01.Input.lines;
import static ua.lpnuai.oop.petrov01.Main.midle_len;


public class Output {
    public static void LinesOutput()
    {
//        Scanner in = new Scanner(System.in);
//        String check;
//        System.out.println("Press \'s\' to to print short lines \n" +
//                "\'l\' to print longer lines");
//        check = in.next();

        System.out.println("Strings less than middle length\n");

        for (int i = 0; i < lines.size(); i++)
        {
            if (lines.container[i].length() < midle_len)
            {
                System.out.println(lines.container[i] +" " +lines.container[i].length());
            }
        }

        System.out.println("________________________________________\n");

        System.out.println("Strings more than middle length\n");
        for (int i = 0; i < lines.size(); i++)
        {
            if (lines.container[i].length() >= midle_len) {
                System.out.println(lines.container[i] + " " + lines.container[i].length());
            }
        }

        System.out.println("________________________________________\n");

    }
}
