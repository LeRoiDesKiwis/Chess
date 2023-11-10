package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public abstract class Piece {

    protected final Location location;
    protected final Player player;

    public Piece(Player player, Location location){
        this.location = location;
        this.player = player;
    }

    public Piece(Player player, int x, int y){
        this(player, new Location(x, y));
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

    @Override
    public String toString() {
        return String.valueOf(getClass().getSimpleName().charAt(0)).toUpperCase();
    }

    public boolean isPossessedBy(Player player) {
        return player.equals(this.player);
    }
}
