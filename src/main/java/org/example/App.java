package org.example;

import java.util.Scanner;

public class App {
private static void exitWithLowerCaseE() {
    System.out.println("programmet avslutas");
    System.exit(0);
}
    public static void main(String[] args){


    {
        Scanner scanner = new Scanner(System.in);
        int[] elpriser = new int[24];

        String menu = """
                Elpriser
                ========
                1.Inmatning
                2.Min, Max och Medel
                3.Sortera
                4.Bästa Laddningstid (4h)
                e. Avsluta
                """;
        System.out.println(menu);
        menu = scanner.nextLine();

        switch (menu) {
            case "1":
                elpriser = new int[24];
                for (int i = 0; i < 24; i++){
                    System.out.print("Skriv in elpriset för timme " + i + ": ");
                    elpriser[i]=scanner.nextInt();

                }
                System.out.println("Elpriser för dygnet:");
                for (int i = 0; i < 24; i++){
                    System.out.println("Timme " + i + ": " + elpriser[i] + " öre per kWh");
                }
                break;
            case "2":
                // Min, Max och Medel-alternativ
                int minPris = elpriser[0];
                int maxPris = elpriser[0];
                int totalPris = elpriser[0];
                int minTimme = 1;
                int maxTimme = 1;

                for (int i = 1; i < 24; i++) {
                    if (elpriser[i] < minPris) {
                        minPris = elpriser[i];
                        minTimme = i + 1;
                    }
                    if (elpriser[i] > maxPris) {
                        maxPris = elpriser[i];
                        maxTimme = i + 1;
                    }
                    totalPris += elpriser[i];
                }

                double medelPris = (double) totalPris / 24;

                System.out.println("Lägsta pris: " + minPris + " öre (Timme " + minTimme + ")");
                System.out.println("Högsta pris: " + maxPris + " öre (Timme " + maxTimme + ")");
                System.out.println("Dygnsmedelpris: " + medelPris + " öre");
                break;
            case "e":
            case "E":
                exitWithLowerCaseE();
                System.out.println("Programmet avslutas.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Ogiltigt val. Försök igen.");
        }
        }
    }
}
