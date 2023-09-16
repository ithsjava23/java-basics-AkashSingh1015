package org.example;

import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
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
                System.out.print("Skriv in elpriset för timme "+i+":");
                elpriser[i]=scanner.nextInt();

            }
            System.out.println("Elpriser för dygnet:");
            for (int i=0; i<24; i++){
                System.out.println("Timme" + i+":"+elpriser[i]+"öre per kwh");

                if (choice.equals("2"));
                int lägstaPris= elpriser[0];
                int lägstaTimme= 0;
                for (i = 1; i < 24; i++){
                    if(elpriser[i]<lägstaPris){
                        lägstaPris=elpriser[i];
                        lägstaTimme=i;
                    }
                }

                int högstaPris=elpriser[0];
                int högstaTimme=0;
                for (i = 1; i<24; i++){
                    högstaPris=elpriser [i];
                    högstaTimme=i;
                }
            }
        int totalPris=0;
        for (int i=0; i<24; i++){
            totalPris+= elpriser[i];
                }
        int medelPris = (int) totalPris/24;
        System.out.println("Elpriser för dygnet:");
        for (int i=0; i<24;i++){
            System.out.println("Timme"+i +":"+ elpriser[i] +"öre perKWh");
        }
        if (choice.equals(2));
        int minpris =elpriser[0];
        int maxPris= elpriser[0];
        int totalpris= elpriser[0];

        for (int i =0; i<24; i++){
            if(elpriser[i] < minpris){
                minpris=elpriser[i];
            }
            if (elpriser[i]>maxPris){
                maxPris+=elpriser[i];
            }
            totalpris+=elpriser[i];
        }

        int medelpris=(int) totalPris/24;

        System.out.println("Lägsta priset: " + minpris+ "öre per kWh");
        System.out.println("Högsta priset:"+maxPris+"öre per kHw");
        System.out.println("Dygnets medelpris:"+medelPris+"öre per kHw");


        }
    }
}