package khahliso;

import khahliso.Commands.Commands;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private List<String> Cards = new ArrayList<>();
    private String status;
    public Player(String name){
        this.playerName = name;
        this.status = "Ready";
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public List<String> getCards(){
        return this.Cards;
    }

    public void setStartingCards(List<String> startingCards){
        this.Cards = startingCards;
    }

    public void removeCard(String card){
        this.Cards.remove(card);
    }

    public boolean handleCommand(Commands command, Cards cards) {
        return command.execute(this, cards);
    }
    public void setStatus(String status){
        this.status = status;
    }

    @Override
    public String toString() {
        return this.status;
    }

}
