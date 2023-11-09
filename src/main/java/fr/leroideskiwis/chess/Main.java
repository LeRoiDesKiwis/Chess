package fr.leroideskiwis.chess;

public class Main {
    public static void main(String[] args) {
        Player[] players = new Player[]{new Player(), new Player()};
        Board board = new Board(players[0], players[1], 8);
        board.display();
    }
}