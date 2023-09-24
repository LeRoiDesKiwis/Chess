package fr.leroideskiwis.chess;

public abstract class ChessPiece {

    private final Location location;

    public ChessPiece(Location location){
        this.location = location;
    }

    public boolean isLocateAt(Location location) {
        return location.equals(this.location);
    }

    public abstract ChessPiece moveTo(Location dest);

    public abstract boolean canMove(Location dest);
}
