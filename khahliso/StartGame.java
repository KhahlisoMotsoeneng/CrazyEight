package khahliso;

import khahliso.Commands.Commands;

import java.util.*;

public class StartGame {

    private static String gameDescription;
    private static Game game = new Game();
    Scanner scan = new Scanner(System.in);

    Random rand = new Random();

    private static Cards cards = new Cards();
    private static Player player;
    public StartGame() {

        gameDescription = "Welcome to CrazyEight!!! In this game " +
                "the aim is for each player to get rid of all the cards in their hands.\n" +
                "When the GAME starts each player will receive 6 random cards.\n" +
                "A random card named[TABLE] will be displayed to start the game.\n" +
                "The game will rotate according to how the names were inserted.\n" +
                "As a player, from your selection of cards, you need to play a card that matches the TABLE,\n" +
                "And it should either match by the same shape[HEART] or number[5].\n" +
                "If you play a matching card, The TABLE will be replaced with the card you played,\n" +
                "And the card will be removed from your CARDS.\n" +
                "If you don't have a matching card, you need to [PULL] one card unknown from HIDDEN_CARDS.\n" +
                "When You pull a card, the next players have to play and while you await your turn.\n" +
                "Eventually one of the players will finish first and will be considered the winner of the GAME!!\n" +
                "Some of the cards have special properties:\n If forgotten use [DESCRIPTION] command to get a display\n" +
                "\nCard Description\n" +
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
                "      - When played, the previous player will have to play and the game will continue in opposite rotation\n";
    }

    public void getPlayers(){

        System.out.println("Please Enter number of players: ");
        int players = scan.nextInt();
        while (players < 2 || players > 6){
            System.out.println("You need at least two players and this game can only take 6 players!" +
                    "\nPlease Enter number of players: ");
            players = scan.nextInt();
        }

        for(int i=1; i<=players; i++){
            String name = "";
            while (name.equals("")){
                System.out.println("Player "+i+", Please Enter Your Name: ");
                name = scan.next();
            }
            Player player = new Player(name);
            game.appendPlayerList(player);
        }
        distributeCards();
    }

    public void distributeCards(){
        cards.generateCards();
        cards.setAllCards();
        cards.shuffleCards();
        cards.setShapes();
        cards.setSpecialCards();


        //For every player,
        for(int p=0; p<game.getPlayers().size();p++){
            List<String> startingCards = new ArrayList<>();
            player = game.getPlayers().get(p);
            System.out.println("\n\n"+player.getPlayerName() + ", We are setting your cards...\n");
            for(int x=0; x<6;x++){
                int index = rand.nextInt(cards.getCurrentCards().size());
                String randomCard = cards.getCurrentCards().get(index);
                while(startingCards.contains(randomCard)){
                    index = rand.nextInt(cards.getCurrentCards().size());
                    randomCard = cards.getCurrentCards().get(index);
                }
                startingCards.add(randomCard);
                cards.removeCard(randomCard);
            }
            player.setStartingCards(startingCards);
        }
        cards.setTABLE();
    }

    public String displayTABLE(){
        return cards.getTABLE();
    }

    public static void main(String[] args) {
        StartGame startGame = new StartGame();
        Commands commands;
        System.out.println("Welcome To CRAZY_8! Would you like a Game Description? ");
        Scanner scanner = new Scanner(System.in);
        String gameDesc = scanner.nextLine();

        while(gameDesc.equalsIgnoreCase("")||gameDesc.equalsIgnoreCase("Yes") ||gameDesc.equalsIgnoreCase("Y")){
            System.out.println(gameDescription);
            System.out.println("Welcome To CRAZY_8! Would you like a Game Description? ");
            gameDesc = scanner.nextLine();
        }
        startGame.getPlayers();
        System.out.println(cards.getCurrentCards().size());
        System.out.println(player.toString());
        while (true){
            if(game.getPlayers().size() == 0){
                System.out.println("No Players Left In The Game. Bye!");
                break;
            }
            for (int i=0; i<game.getPlayers().size();i++){
                String command = "";
                while (command.equalsIgnoreCase("") || command.equalsIgnoreCase("help") ||
                        command.equalsIgnoreCase("description") || player.toString().contains("Ready")){
                    System.out.println("***"+game.getPlayers().get(i).getPlayerName() + "***\n" +
                            "Your Cards are: \n"+player.getCards()+
                            "\nThe Current Card on the TABLE is: " + startGame.displayTABLE()+"\n" +
                            "What would you like to do? Type help to see available commands.");

                    command = scanner.nextLine();
                    commands =Commands.create(command, cards);
                    player.handleCommand(commands, cards, game);
                    System.out.println(player);

                }
            }
        }


    }

}
