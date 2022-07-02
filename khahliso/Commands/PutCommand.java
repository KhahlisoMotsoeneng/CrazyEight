package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class PutCommand extends Commands{

    public PutCommand(String argument) {
        super("put", argument);
    }

    @Override
    public boolean execute(Player player, Cards cards) {
        String play = getArgument();
        String[] playerNumberShape = play.split("_");
        String[] tableNumberShape = cards.getTABLE().split("_");
        if (!player.getCards().contains(play)) {
            player.setStatus("You are trying to play a card you do not have\n" +
                                "Better Luck Next Time!");
        }
        else if(!(playerNumberShape[0].equalsIgnoreCase(tableNumberShape[0]) ||
                playerNumberShape[1].equalsIgnoreCase(tableNumberShape[1]))){
            if(!(playerNumberShape[0].equalsIgnoreCase("8") ||
                    playerNumberShape[0].equalsIgnoreCase("JOKER"))){
                player.setStatus("You tried playing a card that doesn't match the [TABLE]\n" +
                        "Two more random cards have been added to your [HAND] of cards for your careless mistake!!!");
            }
            else{
                player.removeCard(play);
                cards.updateTable(play);
                player.setStatus("You played: " + play + " and shot the next player with 6 CARDS!");
            }
        }
        else{
            player.removeCard(play);
            cards.updateTable(play);
            player.setStatus("You Played: " + play);
        }

        return false;
    }
}
