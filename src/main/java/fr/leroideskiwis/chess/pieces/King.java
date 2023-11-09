package fr.leroideskiwis.chess.pieces;

import fr.leroideskiwis.chess.Location;
import fr.leroideskiwis.chess.Player;

public class King extends Piece {
    public King(Player player, int x, int y) {
        super(player, x, y);
    }

    @Override
    public boolean canMove(Location dest) {
        return super.canMove(dest) && new Bishop(player, location).canMove(dest) || new Rook(player, location).canMove(dest);
    }
}
