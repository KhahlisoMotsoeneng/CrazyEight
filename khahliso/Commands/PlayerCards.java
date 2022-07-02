package khahliso.Commands;

import khahliso.Cards;
import khahliso.Game;
import khahliso.Player;

public class PlayerCards extends Commands{

    public PlayerCards() {
        super("cards");
    }

    @Override
    public boolean execute(Player player, Cards cards, Game game) {
        return false;
    }
}
