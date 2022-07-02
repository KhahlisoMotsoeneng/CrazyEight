package khahliso;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Player> players = new ArrayList<>();

    public Game() {
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void appendPlayerList(Player player) {
        this.players.add(player);
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

}
