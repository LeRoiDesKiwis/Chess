package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class Rook extends Piece {

    public Rook(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public boolean canMove(Location dest) {
        return super.canMove(dest) && location.diff(dest)[1] == 0;
    }

    @Override
    public String toString() {
        return "R";
    }
}
