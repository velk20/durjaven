package music;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
Съставете програма на избран от Вас език (C, C++, C#, Java, PHP) за въвеждане на следната
информация за песните в музикална картотека: номер на песен в картотеката (цяло число),
име на изпълнител (символен низ до 30 символа), име на композитор (символен низ до 30 символа),
жанр (символен низ до 15 символа), заглавие на песента (символен низ до 50 символа),
година на създаване (цяло число).
*/
record Song(int number, String performer,String composer,String genre, String title,int year){}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Song> songs = new ArrayList<>();

        while (true) {
            int songNumber = getIntInput(scanner, "Enter song number (integer): ");

            String performer = getStringInput(scanner, "Enter performer name (up to 30 characters): ", 30);

            String composer = getStringInput(scanner, "Enter composer name (up to 30 characters): ", 30);

            String genre = getStringInput(scanner, "Enter genre (up to 15 characters): ", 15);

            String title = getStringInput(scanner, "Enter song title (up to 50 characters): ", 50);

            int year = getIntInput(scanner, "Enter year of creation (integer): ");

            Song song = new Song(songNumber, performer, composer, genre, title, year);
            songs.add(song);

            System.out.print("Do you want to enter another song? (yes/no): ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }
        }

        System.out.println("\nMusic Library:");
        for (Song song : songs) {
            System.out.println(song);
        }

        scanner.close();
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return value;
    }

    private static String getStringInput(Scanner scanner, String prompt, int maxLength) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine();
            if (input.trim().isEmpty() || input.length() <= maxLength) {
                break;
            } else {
                System.out.println("Invalid input. Please enter a string with a maximum length of " + maxLength + " characters.");
            }
        }
        return input;
    }
}
