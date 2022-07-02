package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class Replay extends Commands{

    public Replay(){
        super("replay");
    }
    @Override
    public boolean execute(Player player, Cards cards) {
        player.setStatus("You are trying to play an invalid card, Please double check your spelling.\nReady...");
        return false;
    }
}
