package ua.lpnuai.oop.petrov06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadsTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            arrayList.add((int) (Math.random()*10));
        }


        Thread threadSearch = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) > 5){
                        counter ++;
                    }
                }

                System.out.println("In the database is "+ counter +" num more than 5.");
            }
        });

        Thread threadSum = new Thread(new Runnable() {
            @Override
            public void run() {
                long sum = 0;

                for (int i = 0; i < arrayList.size(); i++) {
                    sum += arrayList.get(i);
                }

                System.out.println("The sum of array is "+ sum);
            }
        });

        Thread threadMult = new Thread(new Runnable() {
            @Override
            public void run() {
                long mult = 1;

                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) % 2 == 0){
                        mult *= arrayList.get(i);
                    }
                }

                System.out.println("Threads mult is "+ mult);
            }
        });

        Thread threadisTen = new Thread(new Runnable() {
            @Override
            public void run() {
                String answ = "-0-";
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) == 9){
                        answ += arrayList.get(i)+ " ";
                    }
                }

                System.out.println("And here is "+ answ);
            }
        });

        /******************** FOR PARALEL ******************/
        Thread threadSearchP = new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) > 5){
                        counter ++;
                    }
                }

                System.out.println("In the database is for P "+ counter +" num more than 5.");
            }
        });

        Thread threadSumP = new Thread(new Runnable() {
            @Override
            public void run() {
                long sum = 0;

                for (int i = 0; i < arrayList.size(); i++) {
                    sum += arrayList.get(i);
                }

                System.out.println("The sum of array is for P "+ sum);
            }
        });

        Thread threadMultP = new Thread(new Runnable() {
            @Override
            public void run() {
                long mult = 1;

                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) % 2 == 0){
                        mult *= arrayList.get(i);
                    }
                }

                System.out.println("Threads mult is for P "+ mult);
            }
        });

        Thread threadisTenP = new Thread(new Runnable() {
            @Override
            public void run() {
                String answ = "-0- for P ";
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i) == 9){
                        answ += arrayList.get(i)+ " ";
                    }
                }

                System.out.println("And here is for P"+ answ);
            }
        });
        /****************************************************/

        /** Timer input**/
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        long timer = in.nextInt();
        long startTime = System.currentTimeMillis();
        long timespend = 0;

        /** Stepic threads **/
        startTime = System.currentTimeMillis();
        timespend = 0;


        if (timer == 0){
            threadSearch.start();
            threadSearch.join();

            threadSum.start();
            threadSum.join();

            threadMult.start();
            threadMult.join();

            threadisTen.start();
            threadisTen.join();

            timespend = System.currentTimeMillis() - startTime;
            System.out.println("Time = "+ timespend);
        }else{


            threadSearch.start();
            threadSearch.join(timer * 100 / 4);
            threadSearch.interrupt();


            threadSum.start();
            threadSum.join(timer * 100 / 4);
            threadSum.interrupt();

            threadMult.start();
            threadMult.join(timer * 100 / 4);
            threadMult.interrupt();

            threadisTen.start();
            threadisTen.join(timer * 100 / 4);
            threadisTen.interrupt();
//
//            if (threadSearch.isAlive() ||
//                    threadSum.isAlive() ||
//                    threadMult.isAlive() ||
//                    threadisTen.isAlive()){

//                threadSearch.interrupt();
//                threadSum.interrupt();
//                threadMult.interrupt();
//                threadisTen.interrupt();
//            }

            timespend = System.currentTimeMillis() - startTime;
            System.out.println("Time = "+ timespend);
        }


        /** Paralel threads **/

        System.out.println("\nParalel Threads\n");

        /*threadSearch.interrupt();
        threadSum.interrupt();
        threadMult.interrupt();
        threadisTen.interrupt();
*/
        startTime = System.currentTimeMillis();
        timespend = 0;

        if (timer == 0){
            threadSearchP.start();
            threadSumP.start();
            threadMultP.start();
            threadisTenP.start();

            while (threadSearchP.isAlive() ||
                    threadSumP.isAlive() ||
                    threadMultP.isAlive() ||
                    threadisTenP.isAlive())

            timespend = System.currentTimeMillis() - startTime;
            System.out.println("\nTime = "+ timespend);
        }else{
            threadSearchP.start();
            threadSumP.start();
            threadMultP.start();
            threadisTenP.start();

//            Thread.sleep(timer*100);
            while ( System.currentTimeMillis() < startTime + timer * 100 && (threadSearchP.isAlive() ||
                    threadSumP.isAlive() ||
                    threadMultP.isAlive() ||
                    threadisTenP.isAlive()))

            if (threadSearchP.isAlive() ||
                    threadSumP.isAlive() ||
                    threadMultP.isAlive() ||
                    threadisTenP.isAlive()){

                threadSearchP.interrupt();
                threadSumP.interrupt();
                threadMultP.interrupt();
                threadisTenP.interrupt();
            }

            timespend = System.currentTimeMillis() - startTime;
            System.out.println("Time = "+ timespend);
        }

        System.out.println("------- End -------");
    }
}
