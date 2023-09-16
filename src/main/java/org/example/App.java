package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

            String menu= """
                    Elpriser
                    ========
                    1. Inmatning
                    2. Min, Max och Medel
                    3. Sortera
                    4. Bästa Laddningstid (4h)
                    e. Avsluta
                    """;
            System.out.print(menu);{
            String choice= scanner.nextLine();

            if (choice.equals("1"));
            int[] elpriser=new int [24];
            for (int i=0; i<24; i++){
                System.out.print("Skriv in elpriset för en timme)"+i+":");
                elpriser[i]=scanner.nextInt();

            }
            System.out.println("Elpriser för dygnet:");
            for (int i=0; i<24; i++){
                System.out.println("Timme" + i+":"+elpriser[i]+"öre per kwh")
            }







        }
    }
