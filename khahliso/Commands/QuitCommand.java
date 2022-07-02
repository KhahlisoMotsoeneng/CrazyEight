package khahliso.Commands;

import khahliso.Cards;
import khahliso.Game;
import khahliso.Player;

public class QuitCommand extends Commands{

    public QuitCommand() {
        super("quit");
    }

    @Override
    public boolean execute(Player player, Cards cards, Game game) {
        for(int i=0;i<player.getCards().size();i++){
            cards.updateDishes(player.getCards().get(i));
        }

        if(game.getPlayers().size()==2){
            player.setStatus("Aw! You just made your opponent win... Bye!");
        }

        game.removePlayer(player);
        player.setStatus("Awww!! Bye");
        return false;
    }
}
