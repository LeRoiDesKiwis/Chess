package fr.leroideskiwis.chess;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[]{new Player(0), new Player(1)};
        Board board = new Board(players[0], players[1], 8);
        Game game = new Game(board, players);
        game.startGame();

    }
}