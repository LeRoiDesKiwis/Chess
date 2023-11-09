package fr.leroideskiwis.chess;

public abstract class Piece {

    protected final Location location;
    private final Player player;

    public Piece(Player player, Location location){
        this.location = location;
        this.player = player;
    }

    public boolean isLocateAt(Location location) {
        return location.equals(this.location);
    }

    public void moveTo(Location dest){
        this.location.move(dest);
    }

    public boolean canMove(Location dest){
        return !location.equals(dest) && location.diff(dest)[1] > 0;
    }
}
