package phasetenscoringsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Method {
    private List<Player> players = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private int PHASE = 2;

    public Method() {
        this.players.add(new Player("Tiger"));
        this.players.add(new Player("Panther"));
    }

    public int getPHASE() {
        return PHASE;
    }

    public void setPHASE(int PHASE) {
        this.PHASE = PHASE;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    public void removePlayer() {

    }

    public void changePlayer() {

    }

    public void changeScore() {

    }


    public void settings() {
    }


    public int getTotalScore(Player player) {
        return player.getScore();
    }

    public int getCurrentPhase(Player player) {
        return player.getPhase();
    }

    public boolean isGameOver(boolean isPlaying, Player currentPlayer) {
        return currentPlayer.getPhase() < PHASE && isPlaying;
    }
}
