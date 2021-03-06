package edu.wctc;
import java.lang.invoke.LambdaConversionException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Enter Album release date of The Joshua Tree\n");
        LocalDate releaseDate = getDate();

        int choice;

        do {
            choice = doMenu();

            switch (choice) {
                case 1:
                    calculateReleaseDate(releaseDate);
                    break;
                case 2:
                    System.out.println("Enter the release date of the Rattle and Hum album");
                    LocalDate secondReleaseDate = getDate();
                    calculateDifference(releaseDate, secondReleaseDate);
                    break;
                case 3:
                    periodDifference();
                    break;

            }

        } while (choice != 4);



    }


    public static int doMenu() {
        System.out.println("1. Calculate The Joshua Tree release date");
        System.out.println("2. Calculate time between The Joshua Terr and Rattle and Hum");
        System.out.println("3. Calculate the time between Rattle and Hum and third Album");
        System.out.println("4. Exit");

        System.out.print("Enter choice:");
        int choice = Integer.parseInt(keyboard.nextLine());

        return choice;

    }

    public static void calculateReleaseDate(LocalDate releaseDate) {

        LocalDate now = LocalDate.now();

        Period periodUntilNow = Period.between(releaseDate, now);

        System.out.printf("The Album was release was %d years %d months, %d days ago.%n",
                periodUntilNow.getYears(),
                periodUntilNow.getMonths(),
                periodUntilNow.getDays());


    }

    public static LocalDate getDate() {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter month: ");
        int month = Integer.parseInt(keyboard.nextLine());

        System.out.print("Enter day: ");
        int day = Integer.parseInt(keyboard.nextLine());

        LocalDate date = LocalDate.of(year, month, day);
        return date;


    }

    public static void calculateDifference(LocalDate firstAlbum, LocalDate nextAlbum) {
        String formatString;
        Period difference;


        formatString = "The album Rattle and Hum was released %d year/s %d months %d day/s after The Joshua Tree album.\n";
        difference = Period.between(firstAlbum, nextAlbum);
        System.out.printf(formatString, difference.getYears(), difference.getMonths(), difference.getDays());

    }

    public static void periodDifference(){
        String outPut;
        Period difference;

        LocalDate firstAlbum = LocalDate.of(1987,03,9);
        LocalDate secondAlbum = LocalDate.of(1988,10,10);
        difference = Period.between(firstAlbum, secondAlbum);

        outPut = "The third album was released on: ";
        LocalDate thirdAlbumRelease = secondAlbum.plusYears(difference.getYears()).plusMonths(difference.getMonths()).plusDays(difference.getDays());

        System.out.println( outPut + thirdAlbumRelease);

    }

}