package fr.leroideskiwis.chess;

public class Rook extends Piece {

    public Rook(Player player, Location location) {
        super(player, location);
    }

    @Override
    public boolean canMove(Location dest) {
        return super.canMove(dest) && location.diff(dest)[1] == 0;
    }
}
