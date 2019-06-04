package ua.lpnuai.oop.petrov01;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static Scanner in;
	public static String[] lines;
	public static int midle_len = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

//		System.out.println("How much lines you want to insert? ");
//
        for (int i = 0; i < args.length; ++i)
        {
            if (args[i].equals("-h") || args[i].equals("-help"))
            {
                System.out.println("Author: \t Petrov Dmytro \n" +
                        "\t\t Student NLUP, first year\n" +
                        "Task:\n" +
                        " Ввести декілька рядків. Розбити на дві групи: рядки, довжина яких\n" +
                        "менша за середню; рядки, довжина яких не менше середньої. Вивести\n" +
                        "рядки та їх довжину по групах.\n" +
                        "__________________________________________________________________\n" +
                        "Commands\n" +
//                        "-help — typing information of the author and command list\n" +
//                        "-debug — output additional information\n" +
                        "-overview — print inputted data\n" +
                        "-start — begin the program\n" +
                        "-output — prints results\n");
            }

            if (args[i].equals("-d") || args[i].equals("-debug"))
            {
                DebugHelper.OnDebug();
            }
        }

		in = new Scanner(System.in);
		String console_input = "";
		while (console_input != "-exit")
		{
			console_input = in.next();

			switch (console_input){

//				case "-help":
//					System.out.println("Author: \t Petrov Dmytro \n" +
//							"\t\t Student NLUP, first year\n" +
//							"Task:\n" +
//							" Ввести декілька рядків. Розбити на дві групи: рядки, довжина яких\n" +
//							"менша за середню; рядки, довжина яких не менше середньої. Вивести\n" +
//							"рядки та їх довжину по групах.\n" +
//							"__________________________________________________________________\n" +
//							"Commands\n" +
//							"-help — typing information of the author and command list\n" +
//							"-debug — output additional information\n" +
//							"-overview — print inputted data\n" +
//							"-start — begin the program\n" +
//							"-output — prints results\n");
//					break;

//				case "-debug":
//					DebugHelper.OnDebug();
//					break;

				case "-overview":
					Input.PrintInputedData();
					break;

				case "-start":
				Input.WriteLines();
					break;

				case "-output":
				Output.LinesOutput();
					break;

				case "-exit":
					console_input = "-exit";
					break;

			}
		}



	}


}
