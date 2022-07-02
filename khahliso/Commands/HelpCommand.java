package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class HelpCommand extends Commands{

    public HelpCommand(){
        super("help");
    }

    @Override
    public boolean execute(Player player, Cards cards) {
        System.out.println("Don't Worry, You Got This!");
        player.setStatus("I can understand these commands:\n"+
                "PULL - If you don't have a matching card to put on the table, \n" +
                "this will add one random card to your existing set of cards.\n"+
                "PUT 2_SPADE - This will replace the card on table with you [Argument] card '2_SPADE' and removed from you cards.\n" +
                "PUT 8_HEART FLOWER - This will play an 8 and request that a FLOWER shape be played going forward.\n"+
                "CARDS - This will display your current cards.\n"+
                "DESCRIPTION - This will display the properties of the card.\n"+
                "QUIT - This will remove you from the game.\n");
        return true;
    }
}
