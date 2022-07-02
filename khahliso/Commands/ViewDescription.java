package khahliso.Commands;

import khahliso.Cards;
import khahliso.Player;

public class ViewDescription extends Commands{

    public ViewDescription() {
        super("description");
    }

    @Override
    public boolean execute(Player player, Cards cards) {
        player.setStatus("Card Description\n" +
                "JOKER BLACK/RED - If you play this card, the next player in the game will be shot with 6 cards\n" +
                "                - This card is played with color, a JOKER_RED can be played if table card is HEART/DIAMOND\n" +
                "2_ANY - Any 2 card will shoot the next play with 2 cards\n" +
                "      - Can be played if the shape matches card on the table or there is another two on the table\n" +
                "      - If played and the next player shoots another two, the player next in line will be double shot[4 cards]\n" +
                "7_ANY - This card forfeits the next player from player\n" +
                "8_ANY - This card can play on any table card\n" +
                "      - This card is a request card, to change the shape of the table card\n" +
                "      - When played, the next player will have to play any card of requested shape going forward\n" +
                "J_ANY - This card reverses the rotation of the game\n" +
                "      - When played, the previous player will have to play and the game will continue in opposite rotation\n");
        return false;
    }
}
