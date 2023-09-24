package fr.leroideskiwis.chess;

public class ChessMove {

    private final Location source;
    private final MovementType type;
    private final int distance;


    public ChessMove(Location source, MovementType type, int distance) {
        this.source = source;
        this.type = type;
        this.distance = distance;
    }


}
