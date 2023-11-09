package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Queen extends Piece {
    public Queen(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public boolean canMove(Location dest) {
        int[] diff = location.diff(dest);
        return super.canMove(dest) && diff[1] < 2 && diff[2] < 2;
    }
}
