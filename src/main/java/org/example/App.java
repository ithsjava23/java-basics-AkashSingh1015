package org.example;

import java.util.Scanner;
import java.util.Arrays;

public class App {
private static void exitWithLowerCaseE() {
    System.out.println("programmet avslutas");
    System.exit(0);
}
    private static void exitWithUpperrCaseE() {
        System.out.println("programmet avslutas");
        System.exit(0);
    }
    private static void printmenu() {
    }

    public static void main(String[] args){


    {

        int billigasteTimmar = 4;
        Scanner scanner = new Scanner(System.in);
        int[] elpriser = new int[24];
        while (true){
            printmenu();
        String menu = """
                Elpriser
                ========
                1.Inmatning
                2.Min, Max och Medel
                3.Sortera
                4.Bästa Laddningstid (4h)
                e. Avsluta
                """;

        System.out.print(menu);

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

            case "3":
            {
                skrivUtSorteradePriser(elpriser);
            }
            break;



            case "4":
                int billigasteTotalPris = Integer.MAX_VALUE;
                int startTimme = -1;

                for (int i = 0; i <= 24 - billigasteTimmar; i++) {
                    totalPris = 0;
                    for (int j = i; j < i + billigasteTimmar; j++) {
                        totalPris += elpriser[j];
                    }

                    if (totalPris < billigasteTotalPris) {
                        billigasteTotalPris = totalPris;
                        startTimme = i;
                    }
                }

                int slutTimme = startTimme + billigasteTimmar -0;

                System.out.println("Bästa laddningstid (4 h) med lägsta totalpris:");
                System.out.println("Från timme " + (startTimme + 0) + " till timme " + (slutTimme + 0));
                medelPris = (double) billigasteTotalPris / billigasteTimmar;
                System.out.println("Medelpris under dessa timmar: " + medelPris + " öre");
                break;

            case "e":
                exitWithLowerCaseE();
                exitWithUpperrCaseE();
                System.out.println("Programmet avslutas.");
                scanner.close();
                System.exit(0);
                break;
        }
        }


    }

    }private static void skrivUtSorteradePriser(int[] priser) {
        // Skapa en array med timmar och priser
        TimmePris[] timmePriser = new TimmePris[24];
        for (int i = 0; i < 24; i++) {
            timmePriser[i] = new TimmePris(i, priser[i]);
        }

        // Sortera arrayen efter pris i fallande ordning (dyrast till billigast)
        Arrays.sort(timmePriser, (a, b) -> Integer.compare(b.pris, a.pris));

        // Skriv ut sorterade priser med timmar
        System.out.println("Sorterade priser (dyrast till billigast):");
        for (TimmePris timmePris : timmePriser) {
            int currentHour = timmePris.timme;
            int nextHour = (timmePris.timme + 1) % 24;
            int pris = timmePris.pris;
            System.out.println(String.format("%02d-%02d %d öre", currentHour, nextHour, pris));
        }
    }

    // En inre klass för att hålla timme och pris tillsammans
    private static class TimmePris {
        int timme;
        int pris;

        public TimmePris(int timme, int pris) {
            this.timme = timme;
            this.pris = pris;
        }
    }
}