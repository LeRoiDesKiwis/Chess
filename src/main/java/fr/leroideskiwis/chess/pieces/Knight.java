package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Knight extends Piece {
    public Knight(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public boolean canMove(Location dest) {
        int[] diff = location.diff(dest);
        int xDiff = diff[0];
        int yDiff = diff[1];
        return (Math.abs(xDiff) == 2 && Math.abs(yDiff) == 1) || (Math.abs(yDiff) == 2 && Math.abs(xDiff) == 1);
    }
}
