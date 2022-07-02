package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class PlayerCards extends Commands{

    public PlayerCards() {
        super("cards");
    }

    @Override
    public boolean execute(Player player, Cards cards) {
        return false;
    }
}
