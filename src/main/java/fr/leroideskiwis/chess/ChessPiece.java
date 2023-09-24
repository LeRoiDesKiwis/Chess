package fr.leroideskiwis.chess;

public class ChessPiece {

    private final Location location;

    public ChessPiece(Location location){
        this.location = location;
    }

    public boolean isLocateAt(Location location) {
        return location.equals(this.location);
    }

    public void move(MovementType movementType, int tiles) {
        this.location.move(movementType, tiles);
    }
}
