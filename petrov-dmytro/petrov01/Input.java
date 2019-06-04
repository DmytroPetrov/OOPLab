package ua.lpnuai.oop.petrov01;

import ua.lpnuai.oop.petrov02.LabOneCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//import static ua.lpnuai.oop.petrov01.Main.lines;
import static ua.lpnuai.oop.petrov01.Main.midle_len;

public class Input {

    public static LabOneCollection lines = new LabOneCollection();

    public static void WriteLines(){

        System.out.println("How much lines you want to insert? ");

        Scanner in = new Scanner(System.in);
        int num_lines = in.nextInt();

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("print lines: ");

//        lines = new String[num_lines];

        for ( int i = 0; i < num_lines; i++)
        {
            try {
                lines.add(input.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            midle_len += lines.container[i].length();
        }

        midle_len /= num_lines;

        if(DebugHelper.IsDebuging()){
            System.out.println("midle length of lines:" +midle_len);
        }


        if(DebugHelper.IsDebuging()){
            System.out.println("First line :" +lines.container[0] +".");
        }

        System.out.println("________________________________________\n");

    }

    public static void PrintInputedData(){
        if (lines != null) {
            System.out.println("You printed lines:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.container[i]);
            }
        }else
            System.out.println("You didn't put data");
    }

}
