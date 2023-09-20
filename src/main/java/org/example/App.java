package org.example;

import java.util.Scanner;
import java.util.Arrays;

public class App {
    private static final int[] elpriser = new int[24];
    //
    private static void exitWithLowerCaseE() {
        System.out.println("programmet avslutas");
        System.exit(0);
    }

    private static void exitWithUpperrCaseE() {
        System.out.println("programmet avslutas");
        System.exit(0);
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String menu = """
                Elpriser
                ========
                1. Inmatning
                2. Min, Max och Medel
                3. Sortera
                4. Bästa Laddningstid (4h)
                e. Avsluta
                """;


            System.out.print(menu);
            menu = scanner.nextLine();

            switch (menu) {
                case "1" -> {
                    for (int i = 0; i < 24; i++) {
                        System.out.print("Skriv in elpriset för timme " + i + ": ");
                        elpriser[i] = scanner.nextInt();
                    }
                    System.out.println("Elpriser för dygnet:");
                    for (int i = 0; i < 24; i++) {
                        System.out.println("Timme " + i + ": " + elpriser[i] + " öre per kWh");
                    }
                }
                case "2" -> addingPricesThenCalculatingMinMaxAverage();
                case "3" -> printPricesSorted();
                case "4" -> cheapest4Hours();
                case "e" -> {
                    exitWithLowerCaseE();
                    exitWithUpperrCaseE();
                    System.out.println("Programmet avslutas.");
                    scanner.close();
                    System.exit(0);
                }
            }
        }
    }

    private static void cheapest4Hours() {
        int billigasteTotalPris = Integer.MAX_VALUE;
        int startTimme = -1;

        int billigasteTimmar = 4;
        for (int i = 0; i <= 24 - billigasteTimmar; i++) {
            int totalPris = 0;
            for (int j = i; j < i + billigasteTimmar; j++) {
                totalPris += elpriser[j];
            }

            if (totalPris < billigasteTotalPris) {
                billigasteTotalPris = totalPris;
                startTimme = i;
            }
        }

        int slutTimme = startTimme + billigasteTimmar;

        System.out.println("Bästa laddningstid (4 h) med lägsta totalpris:");
        System.out.println("Från timme " + (startTimme) + " till timme " + (slutTimme));
        double medelPris;
        medelPris = (double) billigasteTotalPris / billigasteTimmar;
        System.out.println("Medelpris under dessa timmar: " + medelPris + " öre");
    }

    private static void addingPricesThenCalculatingMinMaxAverage(){
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


}
    private static void  printPricesSorted() {
        TimmePris[] timmePriser = new TimmePris[24];
        for (int i = 0; i < 24; i++) {
            timmePriser[i] = new TimmePris(i, App.elpriser[i]);
        }

        Arrays.sort(timmePriser, (a, b) -> Integer.compare(b.pris, a.pris));
        System.out.println("Sorterade priser (dyrast till billigast):");
        for (TimmePris timmePris : timmePriser) {
            int currentHour = timmePris.timme;
            int nextHour = (timmePris.timme + 1) % 24;
            int pris = timmePris.pris;
            System.out.printf("%02d-%02d %d öre%n", currentHour, nextHour, pris);
        }
    }

    private static class TimmePris {
        int timme;
        int pris;

        public TimmePris(int timme, int pris) {
            this.timme = timme;
            this.pris = pris;
        }
    }
}
