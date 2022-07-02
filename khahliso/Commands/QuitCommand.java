package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class QuitCommand extends Commands{

    public QuitCommand() {
        super("off");
    }

    @Override
    public boolean execute(Player player, Cards cards) {
        return false;
    }
}
