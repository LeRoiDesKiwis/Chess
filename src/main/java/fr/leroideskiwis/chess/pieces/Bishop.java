package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Bishop extends Piece {

    public Bishop(Player player, int x, int y) {
        super(player, x, y);
    }

    public Bishop(Player player, Location location) {
        super(player, location);
    }

    @Override
    public boolean canMove(Location dest) {
        int[] xy = location.diff(dest);
        return super.canMove(dest) && xy[0] == xy[1];
    }

}
