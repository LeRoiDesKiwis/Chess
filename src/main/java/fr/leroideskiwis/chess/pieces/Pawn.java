package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Pawn extends Piece {
    public Pawn(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public boolean canMove(Location dest) {
        return super.canMove(dest) && location.diff(dest)[0]==0 && Math.abs(location.diff(dest)[1]) == 1;
    }
}
