package fr.leroideskiwis.chess;

import java.util.Optional;
import java.util.Scanner;

public class Game {

    private final Player[] players;
    private final Board board;

    private Player currentPlayer;

    private final Scanner scanner = new Scanner(System.in);

    public Game(Board board, Player... players){
        this.players = players;
        this.currentPlayer = players[0];
        this.board = board;
    }

    public void startGame(){
        while(!players[0].isCheckmate() && !players[1].isCheckmate()){
            tick();
            this.currentPlayer = currentPlayer.equals(players[0]) ? players[1] : players[0];
        }
    }

    private void tick() {
        board.display();
        System.out.printf("Au tour de %s%n", currentPlayer);
        Location from = null;
        Location to;
        do{
            if(from != null) System.out.println("Vous ne pouvez pas faire ça !");
            from = askLocation("From : ");
            to = askLocation("To : ");
        }while(!currentPlayer.play(board, from, to));
    }

    public Location askLocation(String question){
        Optional<Location> location;
        do {
            String value = ask(question);
            location = Location.parseString(value);
            if(location.isEmpty()) System.out.println("location incorrect !");
        }while(location.isEmpty());
        return location.get();
    }

    public String ask(String question){
        System.out.print(question);
        String answer = scanner.nextLine();
        System.out.println();
        return answer;
    }
}
