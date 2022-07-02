package khahliso.Commands;

import khahliso.Cards;
import khahliso.Game;
import khahliso.Player;

public class PullCommand extends Commands{
    public PullCommand() {
        super("pull");
    }

    @Override
    public boolean execute(Player player, Cards cards, Game game) {
        return false;
    }
}
