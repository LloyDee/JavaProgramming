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
            case "4" -> method.settings();
            case "x" -> quit();
        }
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

    public void goPlay() {
        boolean isPlaying = true;
        while (isPlaying) {
            System.out.println("Enter score for round : " + round);
            isPlaying = gameOn(true);
            System.out.println("---------------------------");
            round++;
        }
        getWinner(winner);
        getScoreboard();
    }

    private boolean gameOn(boolean isPlaying) {
        Player currentPlayer;

        int minVal = Integer.MAX_VALUE;
        for (Player player : method.getPlayers()) {
            currentPlayer = player;
            System.out.print(currentPlayer.getName() + ": ");
            player.setScore(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Score: " + method.getTotalScore(currentPlayer) + " | Phase: " + method.getCurrentPhase(currentPlayer));
            System.out.println();

            isPlaying = method.isGameOver(isPlaying, currentPlayer);
            if (player.getPhase()==method.getPHASE()&&player.getScore()<minVal){
                minVal = player.getScore();
                winner = player;
            }
        }
        return isPlaying;
    }

    private void getWinner(Player winner) {
        System.out.println("Winner is "+ winner.getName()+" with a score of "+winner.getScore()+ " all the way to phase "+winner.getPhase());
    }
    private void getScoreboard(){
        System.out.println("Name\tPhase\trounds\tScore");
        for (Player players: method.getPlayers()){
            System.out.println(players.getName() + "\t"+players.getPhase()+"\t\t"+round + "\t\t"+players.getScore());
        }
    }
}
