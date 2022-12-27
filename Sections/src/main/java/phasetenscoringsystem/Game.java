package phasetenscoringsystem;

import java.util.Scanner;

public class Game {
    static Scanner scanner = new Scanner(System.in);
    static Printout prints = new Printout();

    public static void main(String[] args) {
        while (true) {
            prints.selection();
        }
    }
}
