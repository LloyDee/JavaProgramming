package phasetenscoringsystem;

import java.util.Scanner;

public class Printout {
    public Method method = new Method();
    Player winner = null;
    int round = 1;
    Scanner scanner = new Scanner(System.in);

    public String options() {
        System.out.println("Select an option:");
        System.out.println("1\t Add Player");
        System.out.println("2\t Play");
        System.out.println("3\t Display All Players");
        System.out.println("4\t Settings");
        return scanner.nextLine();
    }

    public void selection() {
        switch (options()) {
            case "1" -> addAPlayer();
            case "2" -> goPlay();
            case "3" -> displayAllPlayers();
            case "4" -> settingSelection();
            case "x" -> quit();
        }
    }

    public void settingSelection() {
        switch (changeSettings()) {
            case "1" -> removeAPlayer();
            case "2" -> changeAPlayer();
            case "3" -> changeAScore();
            case "4" -> changeThePhase();
            case "x" -> quit();
        }
    }

    private void removeAPlayer() {
        System.out.println("Enter a player to be remove");
        displayAllPlayers();
        String name = scanner.nextLine();
        method.removePlayer(name);
    }

    private void changeAPlayer() {
    }


    private void changeThePhase() {
    }

    private void changeAScore() {
        System.out.println("Select a player");
        displayAllPlayers();
        String player = scanner.nextLine();
        System.out.println("Change score to");
        int score = scanner.nextInt();
        scanner.nextLine();
        method.changeScore(score, player);
    }


    private String changeSettings() {
        System.out.println("Select an option");
        System.out.println("1\tRemove Player");
        System.out.println("2\tChange Player");
        System.out.println("3\tChange Score");
        System.out.println("4\tChange Phase");
        return scanner.nextLine();
    }

    private void quit() {
        System.out.println("GoodBye!");
    }

    public void addAPlayer() {
        System.out.print("Enter new player's name: ");
        String name = scanner.nextLine();
        method.addPlayer(name);
    }

    public void displayAllPlayers() {
        System.out.println("Players");
        for (int i = 0; i < method.getPlayers().size(); i++) {
            System.out.println((i + 1) + ". " + method.getPlayers().get(i).getName());
        }
    }
    private boolean haveEnoughPlayers(){
        return method.getPlayers().size()>1;
    }
    public void goPlay() {
        boolean isPlaying = true;
        if (haveEnoughPlayers()){
            while (isPlaying) {
                System.out.println("Enter score for round : " + round);
                isPlaying = gameOn(true);
                System.out.println("---------------------------");
                round++;
            }
            getWinner(winner);
            getScoreboard();
        }else {
            System.out.println("Not enough players. Needed atleast 2 to play. Please add players first.");
        }

    }

    private boolean gameOn(boolean isPlaying) {
        Player currentPlayer;

        int minVal = Integer.MAX_VALUE;
        for (Player player : method.getPlayers()) {
            currentPlayer = player;
            System.out.print(currentPlayer.getName() + ": ");
            if(scanner.hasNextInt()){
                player.setScore(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Score: " + method.getTotalScore(currentPlayer) + " | Phase: " + method.getCurrentPhase(currentPlayer));
                System.out.println();

                isPlaying = method.isGameOver(isPlaying, currentPlayer);
                if (player.getPhase() == method.getPHASE() && player.getScore() < minVal) {
                    minVal = player.getScore();
                    winner = player;
                }
            }
           else {
                changeSettings();
                scanner.nextLine();
            }
        }
        return isPlaying;
    }

    private void getWinner(Player winner) {
        System.out.println("Winner is " + winner.getName() + " with a score of " + winner.getScore() + " all the way to phase " + winner.getPhase());
    }

    private void getScoreboard() {
        System.out.println("Name\tPhase\trounds\tScore");
        for (Player players : method.getPlayers()) {
            System.out.println(players.getName() + "\t" + players.getPhase() + "\t\t" + round + "\t\t" + players.getScore());
        }
    }
}
