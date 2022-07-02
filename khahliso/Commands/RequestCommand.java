package khahliso.Commands;

import khahliso.Cards;
import khahliso.Game;
import khahliso.Player;

public class RequestCommand extends Commands{

    public RequestCommand(String argument) {
        super("put", argument);
    }

    @Override
    public boolean execute(Player player, Cards cards, Game game) {
        return false;
    }
}
