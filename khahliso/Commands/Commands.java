package khahliso.Commands;

import khahliso.Cards;
import khahliso.Game;
import khahliso.Player;

import java.util.Locale;

public abstract class Commands {

    private final String name;
    private String argument;

    public Commands(String name, String argument) {
        this.name = name.trim().toLowerCase();
        this.argument = argument.trim();
    }

    public abstract boolean execute(Player player, Cards cards, Game game);

    public Commands(String name){
        this.name = name.trim().toLowerCase();
        this.argument = "";
    }

    public String getName(){return name;}
    public String  getArgument(){return this.argument;}

    public static Commands create(String instruction, Cards cards){
        String[] args = instruction.toUpperCase(Locale.ROOT).trim().split(" ");

        if(args.length>1){
            if(!cards.getAllCards().contains(args[1])){
                return new Replay();
            }
        }


        switch (args[0]){
            case "QUIT":
                return new QuitCommand();
            case "HELP":
                return new HelpCommand();
            case "DESCRIPTION":
                return new ViewDescription();
            case "CARDS":
                return new PlayerCards();
            case "PULL":
                return new PullCommand();
            case "PUT":
                if(args.length>2){
                    String arg = args[1]+" "+args[2];
                    return new RequestCommand(arg);
                }
                return new PutCommand(args[1]);
            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}
