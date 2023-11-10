package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Rook extends Piece {

    public Rook(Player player, int x, int y) {
        super(player, x, y);
    }

    public Rook(Player player, Location location) {
        super(player, location);
    }

    @Override
    public boolean canMove(Location dest) {
        int[] diff = location.diff(dest);
        return super.canMove(dest) && !(diff[1] != 0 && diff[0] != 0);

    }
}
